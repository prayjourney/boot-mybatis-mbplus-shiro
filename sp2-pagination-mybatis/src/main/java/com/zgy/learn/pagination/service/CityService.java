package com.zgy.learn.pagination.service;

import com.zgy.learn.pagination.mapper.CityMapper;
import com.zgy.learn.pagination.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: pray-journey.io
 * @description:
 * @date: created in 2021-04-03
 * @modified:
 */
@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public City getById(Integer ctId) {
        return cityMapper.getById(ctId);
    }

    public List<City> getAllCities() {
        return cityMapper.getAllCities();
    }
}
