package com.example.proyectoapirest.controladores;

import com.example.proyectoapirest.modelo.EnfermeraClass;
import com.example.proyectoapirest.modelo.IEnfermeraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-rest/enfermera")
public class ControladorEnfermera {
    @Autowired
    private IEnfermeraDAO enfermeraDAO;

    @GetMapping
    public List<EnfermeraClass> mostrarEnfermeras() {
        return (List<EnfermeraClass>) enfermeraDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeraClass> mostrarEnfermeraPorId(@PathVariable(value = "id") int id) {
        Optional<EnfermeraClass> enfermera = enfermeraDAO.findById(id);

        if (enfermera.isPresent()) {
            return ResponseEntity.ok().body(enfermera.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EnfermeraClass insertarEnfermera(@Validated @RequestBody EnfermeraClass enfermera) {
        return enfermeraDAO.save(enfermera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEnfermera(@PathVariable(value = "id") int id) {
        Optional<EnfermeraClass> enfermera = enfermeraDAO.findById(id);

        if (enfermera.isPresent()) {
            enfermeraDAO.deleteById(id);
            return ResponseEntity.ok().body("Enfermera borrada.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEnfermera(
            @PathVariable(value = "id") int id, @Validated @RequestBody EnfermeraClass enfemeraModificada) {
        Optional<EnfermeraClass> enfermera = enfermeraDAO.findById(id);

        if (enfermera.isPresent()) {
            enfermeraDAO.save(enfemeraModificada);
            return ResponseEntity.ok().body(enfemeraModificada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
