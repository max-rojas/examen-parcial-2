package com.cenfotec.segundoexamenparcial.repositories;

import com.cenfotec.segundoexamenparcial.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
