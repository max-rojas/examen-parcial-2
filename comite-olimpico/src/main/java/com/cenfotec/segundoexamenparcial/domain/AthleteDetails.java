package com.cenfotec.segundoexamenparcial.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class AthleteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sport;
    private Double height;
    private Double weight;
    private String gender;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="athleteDetails")
    private List<BodyMassIndex> bodyMassIndexArrayList;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "athleteDetails")
    private Athlete athlete;

    public AthleteDetails(){}

    public AthleteDetails(String sport, Double height, Double weight, String gender) {
        this.sport = sport;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<BodyMassIndex> getBodyMassIndexArrayList() {
        return bodyMassIndexArrayList;
    }

    public void addBodyMassIndexMeasurement(BodyMassIndex newBodyMassIndex) {
        this.bodyMassIndexArrayList.add(newBodyMassIndex);
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }


    @Override
    public String toString() {
        return "AthleteDetails{" +
                "id=" + id +
                ", sport='" + sport + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", bodyMassIndexArrayList=" + bodyMassIndexArrayList +
                '}';
    }
}
