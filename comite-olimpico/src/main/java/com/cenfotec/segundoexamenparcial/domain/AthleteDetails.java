package com.cenfotec.segundoexamenparcial.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class AthleteDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sport;
    private Long height;
    private Long weight;
    private String gender;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="athleteDetails")
    private List<BodyMassIndex> bodyMassIndexArrayList;

    public AthleteDetails(){}

    public AthleteDetails(String sport, Long height, Long weight, String gender, List<BodyMassIndex> bodyMassIndexArrayList) {
        this.sport = sport;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.bodyMassIndexArrayList = bodyMassIndexArrayList;
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

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
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

    public void setBodyMassIndexArrayList(List<BodyMassIndex> bodyMassIndexArrayList) {
        this.bodyMassIndexArrayList = bodyMassIndexArrayList;
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
