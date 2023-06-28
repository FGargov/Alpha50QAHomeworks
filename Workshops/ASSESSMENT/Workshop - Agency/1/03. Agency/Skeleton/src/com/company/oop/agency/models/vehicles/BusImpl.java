package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleBase implements Bus {

    private static final int BUS_PASSENGER_MIN_VALUE = 10;
    private static final int BUS_PASSENGER_MAX_VALUE = 50;
    private static final double BUS_PRICE_MIN_VALUE = 0.1;
    private static final double BUS_PRICE_MAX_VALUE = 2.5;

    private static final String BUS_PASSENGER_CAPACITY_ERROR = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers.",
            BUS_PASSENGER_MIN_VALUE, BUS_PASSENGER_MAX_VALUE);
    private static final String BUS_PRICE_VALUE_ERROR = String.format(
            "A bus with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            BUS_PRICE_MIN_VALUE, BUS_PRICE_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
        validate(passengerCapacity, pricePerKilometer);
        setVehicleType(VehicleType.LAND);
    }

    @Override
    protected void validate(int passengerCapacity, double pricePerKilometer) {
        validatePassengerCapacity(passengerCapacity);
        validatePricePerKilometer(pricePerKilometer);
    }

    private static void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < BUS_PRICE_MIN_VALUE || pricePerKilometer > BUS_PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(BUS_PRICE_VALUE_ERROR);
        }
    }

    private static void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < BUS_PASSENGER_MIN_VALUE || passengerCapacity > BUS_PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(BUS_PASSENGER_CAPACITY_ERROR);
        }
    }

}