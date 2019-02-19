package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @Id
    @Column(name = "id", nullable = false, updatable = false, length = 32)
    private Long id;

    @Column(name = "last_active", nullable = false, precision = 3)
    private LocalDateTime lastActive;

    User(){
        //only for framework purpose//
    }

    User(Long id){
        this.id = id;
        this.lastActive = LocalDateTime.now();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastActive() {
        return lastActive;
    }

    public void setLastActive(LocalDateTime lastActive) {
        this.lastActive = lastActive;
    }
}
