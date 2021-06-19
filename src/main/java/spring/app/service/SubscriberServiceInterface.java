package spring.app.service;

import spring.app.model.Subscriber;

import java.time.LocalDate;
import java.util.List;

public interface SubscriberServiceInterface {
    List<Subscriber> getAllSubscribers();
    void saveSubscriber(Subscriber subscriber);
    Subscriber getSubscriberById(Long id);
    void deleteSubscriberById(Long id);
    public void updateSubscriber(Long subscriberId, String firstName, String lastName, String gender, String email, LocalDate start, LocalDate expire);
}
