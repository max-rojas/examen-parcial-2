package com.cenfotec.segundoexamenparcial.repositories;

import com.cenfotec.segundoexamenparcial.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    public List<Athlete> findByFullNameOrLastNameContaining(String name, String lastName);
}
