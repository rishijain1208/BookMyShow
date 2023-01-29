package com.example.bookmyshow.services;

import com.example.bookmyshow.models.City;
import com.example.bookmyshow.repositories.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    public City addCity(String name)
    {
        City newCity = new City();
        newCity.setName(name);
        return this.cityRepository.save(newCity);
    }
}
