package com.example.bloodbankmanagement.entity;


import javax.persistence.*;


@Entity
@Table(name = "house")
public class BloodHouse {
    @Id
    @Enumerated(EnumType.STRING)
    private BloodType type;
    private int unit;

    public BloodHouse() {
    }

    public BloodHouse(BloodType type, int unit) {
        this.type = type;
        this.unit = unit;
    }

    public BloodType getType() {
        return type;
    }

    public void setType(BloodType bloodType) {
        this.type = bloodType;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "BloodHouse{" +
                "bloodType=" + type +
                ", unit=" + unit +
                '}';
    }
}
