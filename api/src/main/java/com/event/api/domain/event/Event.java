package com.event.api.domain.event;

import java.sql.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="event")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private Date date;
    private boolean remote;
    private String img_url;
    private String event_url;


}   