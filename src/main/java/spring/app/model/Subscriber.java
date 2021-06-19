package spring.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Subscriber {
    @Id
    @SequenceGenerator(
            name = "subscriber_sequence",
            sequenceName = "subscriber_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscriber_sequence"
    )
    private Long idSubscriber;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate start;
    private LocalDate expire;

    @OneToMany(mappedBy = "subscriber")
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Subscriber() {
    }

    public Subscriber(String firstName, String lastName, String gender, String email, LocalDate start, LocalDate expire) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.start = start;
        this.expire = expire;
    }

    public Subscriber(Long idSubscriber, String firstName, String lastName, String gender, String email, LocalDate start, LocalDate expire, List<Course> courses) {
        this.idSubscriber = idSubscriber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.start = start;
        this.expire = expire;
        this.courses = courses;
    }

    public Subscriber(Long idSubscriber, String firstName, String lastName, String gender, String email, LocalDate start, LocalDate expire) {
        this.idSubscriber = idSubscriber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.start = start;
        this.expire = expire;
    }

    public Long getSubriberId() {
        return idSubscriber;
    }

    public void setSubriberId(Long subriberId) {
        this.idSubscriber = subriberId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }


    @Override
    public String toString() {
        return "Subscriber{" +
                "idSubscriber=" + idSubscriber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", start=" + start +
                ", expire=" + expire +
                '}';
    }
}
