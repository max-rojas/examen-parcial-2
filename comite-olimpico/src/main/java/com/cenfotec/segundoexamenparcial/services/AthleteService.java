package com.cenfotec.segundoexamenparcial.services;

import com.cenfotec.segundoexamenparcial.domain.Athlete;
import com.cenfotec.segundoexamenparcial.domain.AthleteDetails;
import com.cenfotec.segundoexamenparcial.domain.BodyMassIndex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AthleteService {

    public void save(Athlete athlete);
    public void saveAthleteDetails(AthleteDetails athleteDetails, Long idAthlete);
    public Athlete getAthleteById(Long id);
    public List<Athlete> getAll();
    public List<Athlete> find(String name, String lastName);
    public AthleteDetails getAthleteDetails(Long athleteId);
    public void updateAthleteDetails(AthleteDetails athleteDetails, Long athleteId);
    public List<BodyMassIndex> findAllBmiByAthleteDetails_Id(Long athleteDetailsId);
}
