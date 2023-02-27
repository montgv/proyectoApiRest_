package com.example.proyectoapirest.modelo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface IHospitalDAO extends CrudRepository<HospitalClass, Integer> {
}
