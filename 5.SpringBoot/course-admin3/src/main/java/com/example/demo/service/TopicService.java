package com.example.demo.service;

import com.example.demo.entity.Topic;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.TopicRequest;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Page<Topic> getAll(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return topicRepository.findAll(pageRequest);
    }

    public Topic createTopic(TopicRequest request) {
        String topicName = request.getName();
        Topic existingTopic = topicRepository.findByName(topicName);
        if (existingTopic != null) {
            throw new IllegalArgumentException("Topic already exists");
        }

        Topic topic = new Topic();
        topic.setName(topicName);
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Integer id, TopicRequest request) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Topic not found with ID: " + id));
        String newTopicName = request.getName();
        if (!topic.getName().equals(newTopicName)) {
            Topic existingTopic = topicRepository.findByName(newTopicName);
            if (existingTopic != null) {
                throw new IllegalArgumentException("Topic already exists");
            }
        }

        topic.setName(newTopicName);
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Topic not found with ID: " + id));
        topicRepository.delete(topic);;

    }
}
