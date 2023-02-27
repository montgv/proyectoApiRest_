package com.example.proyectoapirest.controladores;

import com.example.proyectoapirest.modelo.HospitalClass;
import com.example.proyectoapirest.modelo.IHospitalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-rest/hospital")
public class ControladorHospital {
    @Autowired
    private IHospitalDAO hospitalDAO;

    @GetMapping
    public List<HospitalClass> mostrarHospitales() {
        return (List<HospitalClass>) hospitalDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalClass> mostrarHospitalPorId(@PathVariable(value = "id") int id) {
        Optional<HospitalClass> hospital = hospitalDAO.findById(id);

        if (hospital.isPresent()) {
            return ResponseEntity.ok().body(hospital.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public HospitalClass insertarHospital(@Validated @RequestBody HospitalClass hospital) {
        return hospitalDAO.save(hospital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarHospital(@PathVariable(value = "id") int id) {
        Optional<HospitalClass> hospital = hospitalDAO.findById(id);

        if (hospital.isPresent()) {
            hospitalDAO.deleteById(id);
            return ResponseEntity.ok().body("Hospital borrado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarHospital(
            @PathVariable(value = "id") int id, @Validated @RequestBody HospitalClass hospitalModificado) {
        Optional<HospitalClass> hospital = hospitalDAO.findById(id);

        if (hospital.isPresent()) {
            hospitalDAO.save(hospitalModificado);
            return ResponseEntity.ok().body(hospitalModificado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
