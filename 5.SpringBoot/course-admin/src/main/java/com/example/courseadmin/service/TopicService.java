package com.example.courseadmin.service;

import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }
}
