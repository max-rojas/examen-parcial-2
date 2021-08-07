package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.Address;

public interface AddressBuilder {

    Address build();
    AddressBuilderImpl province(String province);
    AddressBuilderImpl city(String city);
    AddressBuilderImpl district(String district);
}
