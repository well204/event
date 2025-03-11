package com.event.api.service;

import java.util.Date;
import java.util.UUID;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.event.api.domain.event.Event;
import com.event.api.domain.event.EventRequestDTO;

@Service
public class EventService {
    public Event createEvent(EventRequestDTO data){
        private final AmazonS3 s3Client;

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

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartfilefile) {
        String imgName = UUID.randomUUID() + "-" + multipartfilefile.getOriginalFilename();

        try {
            File file = this.corvertMultipartFile(multipartfilefile);
        } catch(Exception e){}
        return " ";
    }

    private File corvertMultipartFile(MultipartFile multipartFile) throws IOException {
        File conFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(conFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return conFile;
    }
}
