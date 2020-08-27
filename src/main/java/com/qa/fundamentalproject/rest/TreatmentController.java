package com.qa.fundamentalproject.rest;
import com.qa.fundamentalproject.domain.Treatment;
import com.qa.fundamentalproject.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TreatmentController {
    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/getAllTreatment")
    public List<Treatment> getAllTreatment(){
        return this.treatmentService.readAllTreatment();
    }

    @PostMapping("/createTreatment")
    public Treatment createTreatment(@RequestBody Treatment treatment){
        return this.treatmentService.createTreatment(treatment);

    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTreatment(@PathVariable Long id){
        return this.treatmentService.deleteTreatmentById(id);
    }

    @GetMapping("/getTreatmentById/{id}")
    public Treatment getTreatmentById(@PathVariable Long id){
        return this.treatmentService.findTreatmentById(id);
    }

    @PutMapping("/updateTreatment/{id}")
    public Treatment updateTreatment(@PathVariable Long id, @RequestBody Treatment treatment){
        return this.treatmentService.updateTreatment(id, treatment);
    }

}
