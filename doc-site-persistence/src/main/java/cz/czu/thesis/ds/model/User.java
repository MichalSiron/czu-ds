package cz.czu.thesis.ds.model;

import cz.czu.thesis.ds.base.BaseEntity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"})})
public class User extends BaseEntity<Long> {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false, length = 32)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "last_active", nullable = false, precision = 3)
    private LocalDateTime lastActive;

    User(){
        //only for framework purpose//
    }

    public User(Long id, Person person){
        this.id = id;
        this.person = person;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastActive=" + lastActive +
                '}';
    }
}
