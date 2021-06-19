package spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.app.model.Subscriber;
import spring.app.service.SubscriberService;

import java.time.LocalDate;
import java.util.List;

@Controller
@CrossOrigin("*")

@RestController
@RequestMapping()
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService)
    {
        this.subscriberService = subscriberService;
    }

    @GetMapping("getAllSubscriber")
    public List<Subscriber> getAllSubscribers() {

        return subscriberService.getAllSubscribers();
    }

    @PostMapping(path = "saveSubscriber")
    public void saveSubscriber(@RequestBody Subscriber subscriber){
        subscriberService.saveSubscriber(subscriber);
        System.out.println("Subscriber saved");
    }

    @DeleteMapping(path = "deleteSubscriber{subscriberId}")
    public void deleteSubscriberById(
            @PathVariable(value = "subscriberId") Long subscriberId){
                subscriberService.deleteSubscriberById(subscriberId);
                System.out.println("Coach deleted");
    }

    @PutMapping(path = "updateSubscriber{subscriberId}")
    public void updateSubscriber(
            @PathVariable("subscriberId") Long subscriberId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate expire
            ){
        subscriberService.updateSubscriber(subscriberId,firstName,lastName,gender,email,start,expire);
    }
}
