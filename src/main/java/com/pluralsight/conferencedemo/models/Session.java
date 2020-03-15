package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

@Entity(name="sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_id")
    private Long sessionId;

    @Column(name="session_name")
    private String sessionName;

    @Column(name="session_description")
    private String sessionDescription;

    @Column(name="session_length")
    private Integer sessionLength;

    @ManyToMany
    @JoinTable(name="session_speaker",
            joinColumns = @JoinColumn(name="session_id"),
            inverseJoinColumns = @JoinColumn(name="speaker_id"))
    List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Session() {

    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }
}
