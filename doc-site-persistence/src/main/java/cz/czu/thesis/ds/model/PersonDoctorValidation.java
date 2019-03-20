package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person_doctor_validation")
public class PersonDoctorValidation extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "validation_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @Column(name = "validated", nullable = false)
    private boolean isValidated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    @Override
    public String toString() {
        return "PersonDoctorValidation{" +
                "id=" + id +
                '}';
    }
}
