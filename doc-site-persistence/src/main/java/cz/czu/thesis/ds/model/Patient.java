package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"patient_id"})
})
@SequenceGenerator(name = "patient_patient_id_seq", sequenceName = "patient_patient_id_seq", allocationSize = 1)
public class Patient extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_patient_id_seq")
    @Column(name = "patient_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<Doctor> doctors;;

    Patient(){
        //only for framework purpose//
    }

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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
