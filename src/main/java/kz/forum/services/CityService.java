package kz.forum.services;

import kz.forum.models.City;

import java.util.*;

public interface CityService {

    List<City> allCities();

    City addCity(City c);

    City updateCity(City c);

    City getCity(Long id);

    void deleteCity(Long id);

}
