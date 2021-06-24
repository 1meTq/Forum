package kz.forum.services.impl;

import kz.forum.models.City;
import kz.forum.repos.CityRepository;
import kz.forum.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> allCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addCity(City c) {
        return cityRepository.save(c);
    }

    @Override
    public City updateCity(City c) {
        return cityRepository.save(c);
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
