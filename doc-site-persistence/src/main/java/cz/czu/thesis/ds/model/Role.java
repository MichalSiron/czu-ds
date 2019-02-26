package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @Column(name = "value")
    private String role;

    public Role() {
        // just for the purpose of framework
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
