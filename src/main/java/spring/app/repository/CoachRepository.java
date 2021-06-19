package spring.app.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.app.model.Coach;

import java.util.Optional;

@Configuration
@Repository
public interface CoachRepository
        extends JpaRepository<Coach,Long> {
    public Optional<Coach> findByFirstNameAndLastName(@Param("firstName") String firstname ,
                                                      @Param("lastName")String lastname);
}