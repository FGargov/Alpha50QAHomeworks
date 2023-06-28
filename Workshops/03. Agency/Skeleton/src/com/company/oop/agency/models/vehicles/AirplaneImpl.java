package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class AirplaneImpl extends Vehicle implements Airplane {

    private boolean hasFreeFood;



    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
        setHasFreeFood(hasFreeFood);
        setPassengerCapacity(passengerCapacity);
    }

    private void setHasFreeFood(Boolean hasFreeFood) {
        if (hasFreeFood != null) {
            this.hasFreeFood = hasFreeFood;
        } else {
            throw new IllegalArgumentException("Invalid value for 'hasFreeFood'.");
        }
    }

   /* @Override
    public VehicleType getType() { // пропуснал съм да го Override-на.
        return VehicleType.AIR;
    }*/
    @Override
    public boolean hasFreeFood() {
        return this.hasFreeFood;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----\n%s\nHas free food: %s\n", super.getAsString(), hasFreeFood() ? "true" : "false");
    }
}