package spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.app.model.Subscriber;
import spring.app.repository.SubscriberRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
@Service
public class SubscriberService
        implements SubscriberServiceInterface  {
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public List<Subscriber> getAllSubscribers() {

        return subscriberRepository.findAll();
    }

    @Override
    public void saveSubscriber(Subscriber subscriber) {

        Optional<Subscriber> subscriberOptional = subscriberRepository
                .findByFirstNameAndLastName(subscriber.getFirstName(),subscriber.getLastName());
        if(subscriberOptional.isPresent())
        {
            throw new IllegalStateException("Subscriber Already exists");
        }
        subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber getSubscriberById(Long id) {
        Optional<Subscriber> optionalSubscriber = subscriberRepository.findById(id);
        Subscriber subscriber  = null ;
        if (optionalSubscriber.isPresent()) {
            subscriber = optionalSubscriber.get();
        }else{
            throw new RuntimeException("Subscriber with id " + id +" not found ");
        }
        return subscriber;
    }

    @Override
    public void deleteSubscriberById(Long id) {

        this.subscriberRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateSubscriber(Long subscriberId,
                                 String firstName,
                                 String lastName,
                                 String gender,
                                 String email,
                                 LocalDate start,
                                 LocalDate expire) {
    Subscriber subscriber = subscriberRepository.findById(subscriberId).orElseThrow(()->new IllegalStateException("Subscriber with id " + subscriberId + "not found"));
    if ( firstName != null && subscriber.getFirstName() != firstName) {
        subscriber.setFirstName(firstName);
    }
    if ( lastName != null && subscriber.getLastName() != lastName) {
        subscriber.setFirstName(lastName);
    }
    if ( gender != null && subscriber.getGender() != gender) {
        subscriber.setGender(gender);
    }
    if ( email != null && subscriber.getEmail() != email) {
        subscriber.setEmail(email);
    }
    if ( start != null && subscriber.getStart() != start) {
        subscriber.setStart(start);
    }
    if ( expire != null && subscriber.getExpire() != expire) {
        subscriber.setExpire(expire);
    }
    }
}
