package spring.app.service;

import spring.app.model.Coach;

import java.time.LocalDate;
import java.util.List;

public interface CoachServiceInterface {
    List<Coach> getAllCoach();
    void saveCoach(Coach coach);
    Coach getCoachById(Long id);
    void deleteCoachById(Long id);
    public void updateCoach(Long coachId,String firstName, String lastName, LocalDate dob, Long course);

}
