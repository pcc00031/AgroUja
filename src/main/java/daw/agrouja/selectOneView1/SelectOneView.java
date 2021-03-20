/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.selectOneView1;

import daw.agrouja.country1.Country;
import daw.agrouja.country1.CountryService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named
@RequestScoped
public class SelectOneView {

    private String option;
    private Country country;
    private List<Country> countries;

    @Inject
    private CountryService service;

    @PostConstruct
    public void init() {
        countries = service.getCountries();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void setService(CountryService service) {
        this.service = service;
    }
}
