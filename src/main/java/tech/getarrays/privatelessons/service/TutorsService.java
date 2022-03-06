package tech.getarrays.privatelessons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.privatelessons.exception.UserNotFoundException;
import tech.getarrays.privatelessons.model.Tutors;
import tech.getarrays.privatelessons.repo.TutorsRepo;

import java.util.List;
import java.util.UUID;

@Service
public class TutorsService {
    private final TutorsRepo tutorsRepo;

    @Autowired
    public TutorsService(TutorsRepo tutorsRepo) {
        this.tutorsRepo = tutorsRepo;
    }

    public Tutors addTutors(Tutors tutors){
        tutors.setTutorCode(UUID.randomUUID().toString());
        return tutorsRepo.save(tutors);
    }

    public List<Tutors> findAllTutors(){
        return tutorsRepo.findAll();
    }

    public Tutors updateTutors(Tutors tutors){
        return tutorsRepo.save(tutors);
    }

    public Tutors findTutorsById(Long id){
        return tutorsRepo.findTutorsById(id).orElseThrow(() -> new UserNotFoundException("Nie znaleziono użytkownika o numerze ID " + id));
    }

    public void deleteTutors(Long id){
        tutorsRepo.deleteTutorsById(id);
    }

}
