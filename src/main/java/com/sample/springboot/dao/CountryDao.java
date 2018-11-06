package com.sample.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sample.springboot.dao.model.Country;


@Repository
public interface CountryDao  extends CrudRepository<Country,Long> {

}
