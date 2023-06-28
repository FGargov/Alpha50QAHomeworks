package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleBase implements Airplane {

    private static final int AIRPLANE_PASSENGER_MIN_VALUE = 1;
    private static final int AIRPLANE_PASSENGER_MAX_VALUE = 800;
    private static final double AIRPLANE_PRICE_MIN_VALUE = 0.1;
    private static final double AIRPLANE_PRICE_MAX_VALUE = 2.5;
    private static final String AIRPLANE_PASSENGER_CAPACITY_ERROR = String.format(
            "An airplane cannot have less than %d passengers or more than %d passengers.",
            AIRPLANE_PASSENGER_MIN_VALUE, AIRPLANE_PASSENGER_MAX_VALUE);
    private static final String AIRPLANE_PRICE_VALUE_ERROR = String.format(
            "An airplane with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            AIRPLANE_PRICE_MIN_VALUE, AIRPLANE_PRICE_MAX_VALUE);
    private final boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer);
        validate(passengerCapacity, pricePerKilometer);
        setVehicleType(VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    protected void validate(int passengerCapacity, double pricePerKilometer) {
        validatePassengerCapacity(passengerCapacity);
        validatePricePerKilometer(pricePerKilometer);
    }

    @Override
    public String getAsString() {
        return super.getAsString() + String.format("Has free food: %b\n", hasFreeFood);
    }

    @Override
    public boolean hasFreeFood() {
        return this.hasFreeFood;
    }

    private static void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < AIRPLANE_PRICE_MIN_VALUE || pricePerKilometer > AIRPLANE_PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(AIRPLANE_PRICE_VALUE_ERROR);
        }
    }

    private static void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < AIRPLANE_PASSENGER_MIN_VALUE || passengerCapacity > AIRPLANE_PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(AIRPLANE_PASSENGER_CAPACITY_ERROR);
        }
    }
}