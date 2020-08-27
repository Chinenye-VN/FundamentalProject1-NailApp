package com.qa.fundamentalproject.service;

import com.qa.fundamentalproject.domain.Treatment;
import com.qa.fundamentalproject.repo.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.fundamentalproject.exceptions.TreatmentNotFoundException;
import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository repo;

    @Autowired
    public TreatmentService(TreatmentRepository repo) {
        this.repo = repo;
    }

    public List<Treatment> readAllTreatment(){
        return this.repo.findAll();
    }

    public Treatment createTreatment(Treatment treatment){

        return this.repo.save(treatment);
    }

    public Treatment findTreatmentById(Long id){
        return this.repo.findById(id).orElseThrow(TreatmentNotFoundException::new);
    }

    public Treatment updateTreatment(Long id, Treatment treatment){
        Treatment update = findTreatmentById(id);
        update.setNailSet(treatment.getNailSet());
        update.setTimeTaken(treatment.getTimeTaken());
        update.setPrice(treatment.getPrice());
        return this.repo.save(update);
    }

    public Boolean deleteTreatmentById(Long id){
        if(!this.repo.existsById(id)){
            throw new TreatmentNotFoundException(); //if the id doesnt exist return the exception "this treatment isn't found"
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
