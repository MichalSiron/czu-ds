package cz.czu.thesis.ds.payload;

import cz.czu.thesis.ds.model.Address;
import cz.czu.thesis.ds.model.Name;

public class DoctorResponse {

    private Long id;
    private Name name;
    private Address address;

    public DoctorResponse(Long id, Name name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
