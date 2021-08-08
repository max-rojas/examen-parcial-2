package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.BodyMassIndex;

import java.util.List;

public interface AthleteDetailsBuilder {

    AthleteDetailsBuilderImpl sport(String sport);
    AthleteDetailsBuilderImpl height(Double height);
    AthleteDetailsBuilderImpl weight(Long weight);
    AthleteDetailsBuilderImpl gender(String gender);
    AthleteDetailsBuilderImpl  bodyMassIndexArrayList (List<BodyMassIndex> bodyMassIndexArrayList);
    AthleteDetailsBuilderImpl build();
}
