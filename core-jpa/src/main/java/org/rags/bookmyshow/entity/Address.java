package org.rags.bookmyshow.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@Builder
public class Address {

    @Column(name = "street_name")
    private String street;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "state_name")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country_name")
    private String country;

    public Address() {
    }

    public Address(String street, String cityName, String state, String pincode, String country) {
        this.street = street;
        this.cityName = cityName;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
    }
}
