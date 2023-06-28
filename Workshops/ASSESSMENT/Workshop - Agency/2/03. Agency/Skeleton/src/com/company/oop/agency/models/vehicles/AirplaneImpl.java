package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    private boolean hasFreeFood;

    protected AirplaneImpl(int passengerCapacity, VehicleType type, double pricePerKilometer) {
        super(passengerCapacity, type, pricePerKilometer);
    }

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        this(passengerCapacity, VehicleType.AIR, pricePerKilometer);
        this.id = id;
        this.hasFreeFood=hasFreeFood;
    }

    @Override
    public boolean hasFreeFood() {
        return this.hasFreeFood;
    }

    @Override
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Airplane ----%n"));
        stringBuilder.append(super.getAsString());
        stringBuilder.append(String.format("Has free food: true%n"));
        return stringBuilder.toString();
    }
}