package com.example.bloodbankmanagement.api;


import com.example.bloodbankmanagement.entity.BloodHouse;
import com.example.bloodbankmanagement.entity.BloodType;
import com.example.bloodbankmanagement.repository.BloodHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bank")
public class BloodHouseController {
    private final BloodHouseRepository bloodHouseRepository;
    @Autowired
    public BloodHouseController(BloodHouseRepository bloodHouseRepository){
        this.bloodHouseRepository = bloodHouseRepository;
    }

    @GetMapping("findAll")
    public List<BloodHouse> findAll(){
        return (List<BloodHouse>) bloodHouseRepository.findAll();
    }

    @GetMapping("findUnit/{bloodType}")
    public BloodHouse findByBloodType(@PathVariable BloodType bloodType){
        Optional<BloodHouse> result = bloodHouseRepository.findById(bloodType);
        if(result.isPresent()){
            return result.get();
        }else{
            System.out.println("Not exist bloodType in bank for now");
            return new BloodHouse(null,0);
        }
    }

    @PostMapping("add")
    public BloodHouse addInformation(@RequestBody BloodHouse bloodHouse){
        bloodHouseRepository.save(bloodHouse);
        return bloodHouse;
    }

    @PutMapping("update")
    public BloodHouse updateInformation(@RequestBody BloodHouse bloodHouse){
        bloodHouseRepository.save(bloodHouse);
        return bloodHouse;
    }

    @PatchMapping("addUnit/{id}/{count}")
    public BloodHouse addUnit(@PathVariable int count, @PathVariable BloodType id){
        Optional<BloodHouse> bloodHouse = bloodHouseRepository.findById(id);
        if(bloodHouse.isPresent()){
            BloodHouse mid = bloodHouse.get();
            mid.setUnit(mid.getUnit()+count);
            bloodHouseRepository.save(mid);
            return mid;
        }else {
            System.out.println("not exist id");
            return new BloodHouse(null, -1);
        }
    }

    @PatchMapping("minusUnit/{id}/{count}")
    public BloodHouse minusUnit(@PathVariable BloodType id, @PathVariable int count){
        Optional<BloodHouse> bloodHouse = bloodHouseRepository.findById(id);
        if(bloodHouse.isPresent()){
            BloodHouse mid = bloodHouse.get();

            if(mid.getUnit()>=count){
                mid.setUnit(mid.getUnit()-count);
                bloodHouseRepository.save(mid);
                return mid;
            }else{
                System.out.println("Unit is not enough");
                return new BloodHouse(null, 0);
            }
        }else{
            return new BloodHouse(null, -1);
        }
    }
}
