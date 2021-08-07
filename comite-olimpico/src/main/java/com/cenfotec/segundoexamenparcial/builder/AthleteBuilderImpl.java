package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.Address;
import com.cenfotec.segundoexamenparcial.domain.Athlete;

import java.time.LocalDate;

public class AthleteBuilderImpl implements AthleteBuilder{

    private String fullName;
    private String lastName;
    private String secondLastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    private Address address;

    @Override
    public AthleteBuilderImpl fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public AthleteBuilderImpl lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public AthleteBuilderImpl secondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
        return this;
    }

    @Override
    public AthleteBuilderImpl dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public AthleteBuilderImpl phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public AthleteBuilderImpl email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public AthleteBuilderImpl address(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public Athlete build() {
        Athlete athlete = new Athlete();
        athlete.setFullName(this.fullName);
        athlete.setLastName(this.lastName);
        athlete.setSecondLastName(this.secondLastName);
        athlete.setDateOfBirth(this.dateOfBirth);
        athlete.setPhoneNumber(this.phoneNumber);
        athlete.setEmail(this.email);
        return null;
    }
}
