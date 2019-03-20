package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "name", uniqueConstraints = {@UniqueConstraint(columnNames = {"name_id"})})
@SequenceGenerator(name = "name_name_id_seq", sequenceName = "name_name_id_seq", allocationSize = 1)
public class Name extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_name_id_seq")
    @Column(name = "name_id", nullable = false, updatable = false, length = 32)
    private Long nameId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    Name(){}

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Long getId() {
        return nameId;
    }

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
