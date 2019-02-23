package cz.czu.thesis.ds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "name", uniqueConstraints = {@UniqueConstraint(columnNames = {"name_id"})})
public class Name extends BaseEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "name_id", nullable = false, updatable = false, length = 32)
    private Long nameId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "name")
    @JsonIgnore
    private Person person;

    Name(){}

    public Name(Long id, String firstName, String lastName) {
        this.nameId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Long getId() {
        return nameId;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + nameId +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}
