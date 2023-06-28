package com.company.oop.agency.models.vehicles.contracts;

import com.company.oop.agency.models.vehicles.enums.VehicleType;

public interface Bus extends Vehicle {
    int getPassengerCapacity();
    double getPricePerKilometer();
    VehicleType getType();
}