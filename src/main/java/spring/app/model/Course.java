package spring.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Course implements Serializable {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long idCourse;
    private String name;
    private Double nbrHours;
    private Double tarifHour;
    private Integer capacity;

    @OneToMany(mappedBy = "course")
    private List<Coach> coachs;

    @ManyToOne
    private Subscriber subscriber;

    public Course() {
    }

    public Course(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Course(Long idCourse, String name, Double nbrHours, Double tarifHour, Integer capacity, List<Coach> coachs, Subscriber subscriber) {
        this.idCourse = idCourse;
        this.name = name;
        this.nbrHours = nbrHours;
        this.tarifHour = tarifHour;
        this.capacity = capacity;
        this.coachs = coachs;
        this.subscriber = subscriber;
    }

    public void setNbrHours(Double nbrHours) {
        this.nbrHours = nbrHours;
    }

    public void setTarifHour(Double tarifHour) {
        this.tarifHour = tarifHour;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

    public void setCoachs(List<Coach> coachs) {
        this.coachs = coachs;
    }

    public Course(Long idCourse, String name, Double nbrHours, Double tarifHour, Integer capacity, List<Coach> coachs) {
        this.idCourse = idCourse;
        this.name = name;
        this.nbrHours = nbrHours;
        this.tarifHour = tarifHour;
        this.capacity = capacity;
        this.coachs = coachs;
    }

    public Course(String name, Double nbrHours, Double tarifHour, Integer capacity) {
        this.name = name;
        this.nbrHours = nbrHours;
        this.tarifHour = tarifHour;
        this.capacity = capacity;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNbrHours() {
        return nbrHours;
    }


    public double getTarifHour() {
        return tarifHour;
    }


    public int getCapacity() {
        return capacity;
    }


    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", name='" + name + '\'' +
                ", nbrHours=" + nbrHours +
                ", tarifHour=" + tarifHour +
                ", capacity=" + capacity +
                ", coachs=" + coachs +
                '}';
    }
}
