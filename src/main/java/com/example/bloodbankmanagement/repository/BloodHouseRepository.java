package com.example.bloodbankmanagement.repository;

import com.example.bloodbankmanagement.entity.BloodHouse;
import com.example.bloodbankmanagement.entity.BloodType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodHouseRepository extends CrudRepository<BloodHouse, BloodType> {
}
