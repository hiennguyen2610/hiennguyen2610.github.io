package com.example.tiny_task_management.service;

import com.example.tiny_task_management.model.response.TaskStatusResponse;
import com.example.tiny_task_management.statics.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class StatusService {
    public Object getStatus() {
        List<TaskStatusResponse> dto = new ArrayList<>();
        dto.add(new TaskStatusResponse(TaskStatus.TODO.toString(), TaskStatus.TODO.name));
        dto.add(new TaskStatusResponse(TaskStatus.IN_PROGRESS.toString(), TaskStatus.IN_PROGRESS.name));
        dto.add(new TaskStatusResponse(TaskStatus.REVIEWING.toString(), TaskStatus.REVIEWING.name));
        dto.add(new TaskStatusResponse(TaskStatus.COMPLETED.toString(), TaskStatus.COMPLETED.name));
        return dto;
    }
}
