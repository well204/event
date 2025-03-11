package com.event.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.event.api.domain.event.Event;
import com.event.api.domain.event.EventRequestDTO;
import com.event.api.repositories.EventRepository;

@Service
public class EventService {

    @Value("${aws.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    public EventService(AmazonS3 s3Client) {  
        this.s3Client = s3Client;
    }

    public Event createEvent(EventRequestDTO data) {
        String imageUrl = null;

        if (data.image() != null) {
            imageUrl = this.uploadImg(data.image()); 
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setDate(new Date(data.date()));
        newEvent.setEvent_url(data.eventUrl());
        newEvent.setImg_url(imageUrl);
        newEvent.setRemote(data.remote());

        eventRepository.save(newEvent);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile) {
        String imgName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
    
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(multipartFile.getSize());
            metadata.setContentType(multipartFile.getContentType()); // Set content type
    
            s3Client.putObject(bucketName, imgName, multipartFile.getInputStream(), metadata);
    
            return s3Client.getUrl(bucketName, imgName).toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image to S3", e); // Throw a custom exception
        }
    }
}
