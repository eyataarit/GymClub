package spring.app.model;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Coach implements Serializable {
    @Id
    @SequenceGenerator(
            name = "coach_sequence",
            sequenceName = "coach_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coach_sequence"
    )
    private long idCoach;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    @Transient
    private int age;

    @ManyToOne
    private Course course;

    public Coach(long idCoach, String firstName, String lastName, LocalDate dob, int age, Course course) {
        this.idCoach = idCoach;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.course = course;
    }

    public Coach() {
    }

    public Coach(long idCoach, String firstName, String lastName, LocalDate dob, Course course) {
        this.idCoach = idCoach;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.course= course;
    }

    public Coach(String firstName, String lastName, LocalDate dob, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.course=course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(long idCoach) {
        this.idCoach = idCoach;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "coach{" +
                "idCoach=" + idCoach +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
