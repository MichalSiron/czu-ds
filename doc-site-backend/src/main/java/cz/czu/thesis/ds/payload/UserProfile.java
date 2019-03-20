package cz.czu.thesis.ds.payload;

import java.time.LocalDateTime;

public class UserProfile {
    private Long id;
    private String username;
    private String name;
    private LocalDateTime joinedAt;
    private Long validatedDoctorsCount;
    private Long invalidatedDoctorsCount;

    public UserProfile(Long id, String username, String name, LocalDateTime joinedAt, Long validDoctors, Long invalidDoctors) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.joinedAt = joinedAt;
        this.validatedDoctorsCount = validDoctors;
        this.invalidatedDoctorsCount = invalidDoctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public Long getValidatedDoctorsCount() {
        return validatedDoctorsCount;
    }

    public void setValidatedDoctorsCount(Long validatedDoctorsCount) {
        this.validatedDoctorsCount = validatedDoctorsCount;
    }

    public Long getInvalidatedDoctorsCount() {
        return invalidatedDoctorsCount;
    }

    public void setInvalidatedDoctorsCount(Long invalidatedDoctorsCount) {
        this.invalidatedDoctorsCount = invalidatedDoctorsCount;
    }
}
