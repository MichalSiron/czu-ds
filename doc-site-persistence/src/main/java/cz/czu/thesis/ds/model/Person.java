package cz.czu.thesis.ds.model;

import com.fasterxml.jackson.annotation.*;
import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id"})})
public class Person extends BaseEntity<Long> {

    @Id
    @Column(name = "person_id", nullable = false, updatable = false, length = 32)
    private Long personId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id")
    private Name name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @Override
    public Long getId() {
        return personId;
    }

    Person(){}

    public Person(Long id, Name name, Address address) {
        this.personId = id;
        this.name = name;
        this.address = address;
    }


    public void setId(Long id) {
        this.personId = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPersonId() {
        return getId();
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + personId +
//                ", name=" + name +
//                ", address=" + address +
                '}';
    }
}
