package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseEntity<Long> {

    @Id
    @Column(name = "role_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @Column(name = "value", length = 60)
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    public Role() {
        // just for the purpose of framework
    }

    public Role(RoleName name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public RoleName getName() {
        return name;
    }

    public void setRole(RoleName role) {
        this.name = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + name + '\'' +
                '}';
    }
}
