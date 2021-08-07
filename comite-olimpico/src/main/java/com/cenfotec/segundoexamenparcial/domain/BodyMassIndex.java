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

    private Long value;
    private LocalDate measurementDate;

    @ManyToOne
    private AthleteDetails athleteDetails;

    public BodyMassIndex(){}

    public BodyMassIndex(Long value, LocalDate measurementDate) {
        this.value = value;
        this.measurementDate = measurementDate;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
    }

    @Override
    public String toString() {
        return "BodyMassIndex{" +
                "value=" + value +
                ", measurementDate=" + measurementDate +
                '}';
    }
}
