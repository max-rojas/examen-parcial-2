package com.cenfotec.segundoexamenparcial.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class BodyMassIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double bmiValue;
    private LocalDate measurementDate;

    @ManyToOne
    private AthleteDetails athleteDetails;

    public BodyMassIndex(){}

    public BodyMassIndex(Double bmiValue, LocalDate measurementDate) {
        this.bmiValue = bmiValue;
        this.measurementDate = measurementDate;
    }

    public Double getBmiValue() {
        return bmiValue;
    }

    public void setBmiValue(Double value) {
        this.bmiValue = value;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    public AthleteDetails getAthleteDetails() {
        return athleteDetails;
    }

    public void setAthleteDetails(AthleteDetails athleteDetails) {
        this.athleteDetails = athleteDetails;
    }

    @Override
    public String toString() {
        return "BodyMassIndex{" +
                "id=" + id +
                ", bmiValue=" + bmiValue +
                ", measurementDate=" + measurementDate +
                ", athleteDetails=" + athleteDetails +
                '}';
    }
}
