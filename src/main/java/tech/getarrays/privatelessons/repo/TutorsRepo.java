package tech.getarrays.privatelessons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.privatelessons.model.Tutors;

import java.util.Optional;

public interface TutorsRepo extends JpaRepository<Tutors, Long> {
    void deleteTutorsById(Long id);

    Optional<Tutors> findTutorsById(Long id);
}
