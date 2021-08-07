package com.cenfotec.segundoexamenparcial.builder;

import com.cenfotec.segundoexamenparcial.domain.Address;

public class AddressBuilderImpl implements AddressBuilder {

    private String province;
    private String city;
    private String district;

    @Override
    public AddressBuilderImpl province(String province) {
        this.province = province;
        return this;
    }

    @Override
    public AddressBuilderImpl city(String city) {
        this.city = city;
        return this;
    }

    @Override
    public AddressBuilderImpl district(String district) {
        this.district = district;
        return this;
    }

    @Override
    public Address build() {
        Address address = new Address();
        address.setProvince(this.province);
        address.setCity(this.city);
        address.setDistrict(this.district);
        return address;
    }
}
