package tech.getarrays.privatelessons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.privatelessons.model.Tutors;
import tech.getarrays.privatelessons.repo.TutorsRepo;
import tech.getarrays.privatelessons.service.TutorsService;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorResource {
    private final TutorsService tutorService;

    public TutorResource(TutorsService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tutors>> getAllTutors(){
        List<Tutors> tutors = tutorService.findAllTutors();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tutors> getTutorById(@PathVariable("id") Long id){
        Tutors tutor = tutorService.findTutorsById(id);
        return new ResponseEntity<>(tutor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tutors> addTutor(@RequestBody Tutors tutor){
        Tutors newTutor = tutorService.addTutors(tutor);
        return new ResponseEntity<>(newTutor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tutors> updateTutor(@RequestBody Tutors tutor) {
        Tutors updateTutor = tutorService.updateTutors(tutor);
        return new ResponseEntity<>(updateTutor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTutor(@PathVariable("id") Long id){
        tutorService.deleteTutors(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
