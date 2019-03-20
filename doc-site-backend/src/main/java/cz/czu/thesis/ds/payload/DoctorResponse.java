package cz.czu.thesis.ds.payload;

import cz.czu.thesis.ds.model.Address;
import cz.czu.thesis.ds.model.Name;

import java.time.LocalDateTime;

public class DoctorResponse {

    private Long id;
    private String username;
    private Name name;
    private Address address;
    private LocalDateTime created;

    public DoctorResponse(Long id, String username, Name name, Address address, LocalDateTime created) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "DoctorResponse{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}
