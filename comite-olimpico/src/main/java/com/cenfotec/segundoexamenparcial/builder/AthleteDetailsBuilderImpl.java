package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.AthleteDetails;
import com.cenfotec.segundoexamenparcial.domain.BodyMassIndex;

import java.util.List;

public class AthleteDetailsBuilderImpl implements AthleteDetailsBuilder {

    private String sport;
    private Long height;
    private Long weight;
    private String gender;
    private List<BodyMassIndex> bodyMassIndexArrayList;

    @Override
    public AthleteDetailsBuilderImpl sport(String sport) {
        this.sport = sport;
        return this;
    }

    @Override
    public AthleteDetailsBuilderImpl height(Long height) {
        this.height = height;
        return this;
    }

    @Override
    public AthleteDetailsBuilderImpl weight(Long weight) {
        this.height = height;
        return this;
    }

    @Override
    public AthleteDetailsBuilderImpl gender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public AthleteDetailsBuilderImpl  bodyMassIndexArrayList(List<BodyMassIndex> bodyMassIndexArrayList) {
        this.bodyMassIndexArrayList = bodyMassIndexArrayList;
        return this;
    }

    @Override
    public AthleteDetailsBuilderImpl build() {
        AthleteDetails athleteDetails = new AthleteDetails();
        athleteDetails.setSport(this.sport);
        athleteDetails.setHeight(this.height);
        athleteDetails.setWeight(this.weight);
        athleteDetails.setGender(this.gender);
        athleteDetails.setBodyMassIndexArrayList(this.bodyMassIndexArrayList);
        return null;
    }
}
