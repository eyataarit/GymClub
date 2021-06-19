package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.app.model.Coach;
import spring.app.repository.CoachRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Configuration
@Service
public class CoachService
        implements CoachServiceInterface {

    @Autowired
   private CoachRepository coachRepository;

    @Override
    public List<Coach> getAllCoach() {

        return coachRepository.findAll();
    }

    @Override
    public void saveCoach(Coach coach) {
        Optional<Coach> coachOptional = coachRepository
                .findByFirstNameAndLastName(coach.getFirstName(),coach.getLastName());
        if(coachOptional.isPresent())
        {
            throw new IllegalStateException("Coach Already exists");
        }
        coachRepository.save(coach);
    }

    @Override
    public Coach getCoachById(Long id) {
        Optional<Coach> optional = coachRepository.findById(id);
        Coach coach = null ;
        if (optional.isPresent()) {
            coach = optional.get();
        }else{
            throw new RuntimeException("Coach with id " + id + " is not found");
        }
        return coach ;
    }

    @Override
    public void deleteCoachById(Long id)
    {
        boolean exists = coachRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "coach with id "+ id + " doesn't exists ");
        }
        coachRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCoach(Long coachId,
                            String firstName,
                            String lastName,
                            LocalDate dob,
                            Long course) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(() -> new IllegalStateException("Coach wih id "+ coachId + "doesn't exists"));
        if (firstName!= null && firstName.length() > 0 && !Objects.equals(coach.getFirstName(), firstName))
        {
            coach.setFirstName(firstName);
        }
        if (lastName!= null && lastName.length() > 0 && !Objects.equals(coach.getLastName(), lastName))
        {
            coach.setLastName(lastName);
        }
        if (course!= null && course != coach.getCourse().getIdCourse())
        {
            coach.getCourse().setIdCourse(course);
        }

    }
}