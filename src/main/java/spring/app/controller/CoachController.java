package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.app.model.Coach;

import java.time.LocalDate;
import java.util.List;

@Controller
@CrossOrigin("*")

@RestController
@RequestMapping()
public class CoachController {

    @Autowired
    private spring.app.service.CoachService CoachService;

    public CoachController(spring.app.service.CoachService coachService) {

        CoachService = coachService;
    }

    @GetMapping(value = "getAllCoach")
    public List<Coach> getAllCoach(){

        return CoachService.getAllCoach();
    }

    @PostMapping(value = "saveCoach")
    public void saveCoach(@RequestBody Coach coach){
        CoachService.saveCoach(coach);
        System.out.println("Coach saved");
    }

    @DeleteMapping(path = "deleteCoach{coachId}")
    public void deleteCoachById(
        @PathVariable(value="coachId") Long coachId) {
        CoachService.deleteCoachById(coachId);
        System.out.println("Coach deleted");
    }
    @PutMapping(path = "updateCoach{coachId}")
    public void updateCoach(
            @PathVariable("coachId") Long coachId,
            @RequestParam(required = false) String firstName ,
            @RequestParam(required = false) String lastName ,
            @RequestParam(required = false)LocalDate dob,
            @RequestParam (required = false) Long course)
    {
        CoachService.updateCoach(coachId,firstName,lastName,dob,course);
    }
}