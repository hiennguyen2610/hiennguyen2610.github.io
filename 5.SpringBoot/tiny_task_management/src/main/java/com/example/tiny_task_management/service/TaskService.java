package com.example.tiny_task_management.service;

import com.example.tiny_task_management.entity.Task;
import com.example.tiny_task_management.model.request.TaskRequest;
import com.example.tiny_task_management.model.response.TaskDetailResponse;
import com.example.tiny_task_management.model.response.TaskResponse;
import com.example.tiny_task_management.repository.TaskRepository;
import com.example.tiny_task_management.statics.TaskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class TaskService {
    ObjectMapper objectMapper;

    TaskRepository taskRepository;

    public List<TaskResponse> getAll() {
        List<Task> tasks = taskRepository.getAll();
        List<TaskDetailResponse> tempData = tasks.stream().map(t -> objectMapper.convertValue(t, TaskDetailResponse.class)).collect(Collectors.toList());
        List<TaskStatus> taskStatuses = Arrays.asList(TaskStatus.values());

        return taskStatuses.stream().map(status -> {
            List<TaskDetailResponse> taskDetailResponses = tempData.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
            return new TaskResponse(status, taskDetailResponses);
        }).collect(Collectors.toList());
    }

    public void saveTask(TaskRequest request) {
        Task task = objectMapper.convertValue(request, Task.class);

        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDateTime(now);
        task.setOverdue(task.getExpectedEndTime().isBefore(now));

        if (request.getId() != null) {
            taskRepository.update(task);
        } else {
            taskRepository.add(task);
        }
    }

    public Object getDetail(Integer id) {
        Task task = taskRepository.getOne(id);
        return objectMapper.convertValue(task, TaskDetailResponse.class);
    }

    public void delete(Integer id) {
        taskRepository.delete(id);
    }

    public void updateStatus(Integer id, String statusId) {
        Task task = taskRepository.getOne(id);
        if (ObjectUtils.isEmpty(task)) {
            return;
        }
        task.setStatus(TaskStatus.valueOf(statusId));
        taskRepository.update(task);
    }
}
