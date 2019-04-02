package cz.czu.thesis.ds.dto;

public class UserDto {

    private final String username;
    private final boolean expired;
    private final boolean locked;

    public UserDto(String username, boolean expired, boolean locked) {
        this.username = username;
        this.expired = expired;
        this.locked = locked;
    }

    public String getUsername() {
        return username;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean isLocked() {
        return locked;
    }
}
