package cz.czu.thesis.ds.model;

import com.fasterxml.jackson.annotation.*;
import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "address", uniqueConstraints = {@UniqueConstraint(columnNames = {"address_id"})})
public class Address extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "address_id", nullable = false, updatable = false, length = 32)
    private Long addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "psc")
    private Integer psc;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Person person;

    public Address(){}

    public Address(Long id, String street, String city, Integer psc) {
        this.addressId = id;
        this.street = street;
        this.city = city;
        this.psc = psc;
    }

    @Override
    public Long getId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", psc=" + psc +
                '}';
    }
}
