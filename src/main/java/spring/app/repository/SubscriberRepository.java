package spring.app.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.app.model.Subscriber;

import java.util.Optional;

@Configuration
@Repository
public interface SubscriberRepository
        extends JpaRepository<Subscriber,Long> {
            public Optional<Subscriber> findByFirstNameAndLastName(@Param("firstName") String firstname ,
                                                              @Param("lastName")String lastname);

}
