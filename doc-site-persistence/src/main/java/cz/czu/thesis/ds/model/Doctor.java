package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "patient_id"))
    private Set<Patient> patients;

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

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", person=" + person +
                ", surgery=" + surgery +
                '}';
    }
}
