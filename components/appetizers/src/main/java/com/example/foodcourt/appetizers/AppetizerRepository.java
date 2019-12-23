package com.example.foodcourt.appetizers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppetizerRepository extends CrudRepository<Appetizer, Long> {

    Optional<Appetizer> findById(Long id);



    //Object getUrl();
}
