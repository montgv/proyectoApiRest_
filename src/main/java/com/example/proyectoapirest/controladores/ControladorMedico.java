package com.example.proyectoapirest.controladores;

import com.example.proyectoapirest.modelo.HospitalClass;
import com.example.proyectoapirest.modelo.IMedicoDAO;
import com.example.proyectoapirest.modelo.MedicoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-rest/medico")
public class ControladorMedico {
    @Autowired
    private IMedicoDAO medicoDAO;

    @GetMapping
    public List<MedicoClass> mostrarMedicos() {
        return (List<MedicoClass>) medicoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoClass> mostrarMedicoPorId(@PathVariable(value = "id") int id) {
        Optional<MedicoClass> medico = medicoDAO.findById(id);

        if (medico.isPresent()) {
            return ResponseEntity.ok().body(medico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MedicoClass insertarMedico(@Validated @RequestBody MedicoClass medico) {
        return medicoDAO.save(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarMedico(@PathVariable(value = "id") int id) {
        Optional<MedicoClass> medico = medicoDAO.findById(id);

        if (medico.isPresent()) {
            medicoDAO.deleteById(id);
            return ResponseEntity.ok().body("Médico borrado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarMedico(
            @PathVariable(value = "id") int id, @Validated @RequestBody MedicoClass medicoModificado) {
        Optional<MedicoClass> medico = medicoDAO.findById(id);

        if (medico.isPresent()) {
            medicoDAO.save(medicoModificado);
            return ResponseEntity.ok().body(medicoModificado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
