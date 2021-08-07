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
}
