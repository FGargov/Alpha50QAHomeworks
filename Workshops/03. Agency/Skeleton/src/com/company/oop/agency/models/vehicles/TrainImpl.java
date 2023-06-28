package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class TrainImpl extends Vehicle implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final String PASSENGER_ERROR_MSG = String.format(
            "A train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;

    private static final String CARTS_ERROR_MSG = String.format(
            "A train cannot have less than %d cart or more than %d carts.", CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setPassengerCapacity(passengerCapacity);
        setCarts(carts);
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_ERROR_MSG);
        }
        super.setPassengerCapacity(passengerCapacity);
    }

    public void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(CARTS_ERROR_MSG);
        }
        this.carts = carts;
    }

    @Override
    public int getCarts() {
        return this.carts;
    }

    @Override
    public String getAsString() {
        return super.getAsString() + System.lineSeparator() + "Carts amount: " + getCarts() + System.lineSeparator();
    }
}