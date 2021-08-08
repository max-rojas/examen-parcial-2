package com.cenfotec.segundoexamenparcial.services;

import com.cenfotec.segundoexamenparcial.domain.Athlete;
import com.cenfotec.segundoexamenparcial.domain.AthleteDetails;
import com.cenfotec.segundoexamenparcial.domain.BodyMassIndex;
import com.cenfotec.segundoexamenparcial.repositories.AthleteDetailsRepository;
import com.cenfotec.segundoexamenparcial.repositories.AthleteRepository;
import com.cenfotec.segundoexamenparcial.repositories.BodyMassIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.round;

@Service
public class AthleteServiceImpl implements AthleteService {

    private static final int SECOND_POWER = 2;

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    AthleteDetailsRepository athleteDetailsRepository;

    @Autowired
    BodyMassIndexRepository bodyMassIndexRepository;

    @Override
    public void save(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    @Override
    public void saveAthleteDetails(AthleteDetails athleteDetails, Long athleteId) {
        Athlete athlete = athleteRepository.getById(athleteId);
        athleteDetails.setAthlete(athlete);
        athleteDetailsRepository.save(athleteDetails);
    }

    @Override
    public void updateAthleteDetails(AthleteDetails athleteDetails, Long athleteId) {
        Athlete athlete = athleteRepository.getById(athleteId);
        AthleteDetails athleteDetailsFromDB = athlete.getAthleteDetails();
        athleteDetailsFromDB.setSport(athleteDetails.getSport());
        athleteDetailsFromDB.setHeight(athleteDetails.getHeight());
        athleteDetailsFromDB.setWeight(athleteDetails.getWeight());
        athleteDetailsFromDB.setGender(athleteDetails.getGender());

        BodyMassIndex newBodyMassIndex = calculateBodyMassIndex(athleteDetails.getWeight(), athleteDetails.getHeight());

        athleteDetailsFromDB.addBodyMassIndexMeasurement(newBodyMassIndex);
        newBodyMassIndex.setAthleteDetails(athleteDetailsFromDB);

        bodyMassIndexRepository.save(newBodyMassIndex);
        athleteDetailsRepository.save(athleteDetailsFromDB);
    }

    @Override
    public AthleteDetails getAthleteDetails(Long athleteId) {
        Athlete athlete = athleteRepository.getById(athleteId);
        return athlete.getAthleteDetails();
    }

    @Override
    public Athlete getAthleteById(Long athleteId) {
        Optional<Athlete> athlete = athleteRepository.findById(athleteId);
        if(!athlete.isPresent()) {
            return new Athlete();
        }
        return athlete.get();
    }

    @Override
    public List<Athlete> getAll() {
        return athleteRepository.findAll();
    }

    @Override
    public List<Athlete> find(String name, String lastName) {
        return athleteRepository.findByFullNameOrLastNameContaining(name, lastName);
    }

    @Override
    public List<BodyMassIndex> findAllBmiByAthleteDetails_Id(Long athleteDetailsId) {
        return bodyMassIndexRepository.findAllByAthleteDetails_Id(athleteDetailsId);
    }

    private BodyMassIndex calculateBodyMassIndex(Double weight, Double height) {
        Double calculatedBodyMassIndex =  round((weight * 100) / Math.pow(height, SECOND_POWER), 2);
        BodyMassIndex newBodyMassIndex = new BodyMassIndex(calculatedBodyMassIndex, LocalDate.now());
        return newBodyMassIndex;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
