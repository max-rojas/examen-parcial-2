package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.Address;
import com.cenfotec.segundoexamenparcial.domain.Athlete;

import java.time.LocalDate;

public interface AthleteBuilder {

    AthleteBuilderImpl fullName(String fullName);
    AthleteBuilderImpl lastName(String lastName);
    AthleteBuilderImpl secondLastName(String secondLastName);
    AthleteBuilderImpl dateOfBirth(LocalDate dateOfBirth);
    AthleteBuilderImpl phoneNumber(String phoneNumber);
    AthleteBuilderImpl email(String email);
    AthleteBuilderImpl address(Address address);
    Athlete build();
}
