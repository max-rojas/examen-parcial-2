package com.cenfotec.segundoexamenparcial.repositories;

import com.cenfotec.segundoexamenparcial.domain.BodyMassIndex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyMassIndexRepository extends JpaRepository<BodyMassIndex, Long> {
    List<BodyMassIndex> findAllByAthleteDetails_Id(Long athleteDetailsId);
}
