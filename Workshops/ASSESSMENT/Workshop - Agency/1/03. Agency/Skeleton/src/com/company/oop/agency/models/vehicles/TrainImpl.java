package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleBase implements Train {

    private static final int TRAIN_PASSENGER_MIN_VALUE = 30;
    private static final int TRAIN_PASSENGER_MAX_VALUE = 150;
    private static final double TRAIN_PRICE_MIN_VALUE = 0.1;
    private static final double TRAIN_PRICE_MAX_VALUE = 2.5;
    private static final String TRAIN_PASSENGER_CAPACITY_ERROR = String.format(
            "A train cannot have less than %d passengers or more than %d passengers.",
            TRAIN_PASSENGER_MIN_VALUE, TRAIN_PASSENGER_MAX_VALUE);
    private static final String TRAIN_PRICE_VALUE_ERROR = String.format(
            "A train with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            TRAIN_PRICE_MIN_VALUE, TRAIN_PRICE_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final String CARTS_COUNT_ERROR = String.format(
            "A train cannot have less than %d cart or more than %d carts.", CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        validate(passengerCapacity, pricePerKilometer);
        setVehicleType(VehicleType.LAND);
        setCarts(carts);
    }

    private void setCarts(int carts) {
        validateCarts(carts);
        this.carts = carts;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    protected void validate(int passengerCapacity, double pricePerKilometer) {
        if (passengerCapacity < TRAIN_PASSENGER_MIN_VALUE || passengerCapacity > TRAIN_PASSENGER_MAX_VALUE) {
            throw new InvalidUserInputException(TRAIN_PASSENGER_CAPACITY_ERROR);
        }
        if (pricePerKilometer < TRAIN_PRICE_MIN_VALUE || pricePerKilometer > TRAIN_PRICE_MAX_VALUE) {
            throw new InvalidUserInputException(TRAIN_PRICE_VALUE_ERROR);
        }
    }

    @Override
    public String getAsString() {
        return super.getAsString() + String.format("Carts amount: %d\n", this.carts);
    }

    private static void validateCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(CARTS_COUNT_ERROR);
        }
    }

}