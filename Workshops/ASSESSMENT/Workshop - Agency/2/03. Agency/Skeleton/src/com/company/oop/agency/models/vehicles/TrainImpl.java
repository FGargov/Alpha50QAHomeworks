package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Train {


    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    private static final String INVALID_PASSENGER_ERROR_MESSAGE = String.format("A bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    private static final String INVALID_CARTS_ERROR_MESSAGE = String.format("A train cannot have less than %d cart or more than %d carts.", CARTS_MIN_VALUE, CARTS_MAX_VALUE);

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        this(passengerCapacity, VehicleType.LAND, pricePerKilometer);
        setCarts(carts);
        this.id = id;
    }

    protected TrainImpl(int passengerCapacity, VehicleType type, double pricePerKilometer) {
        super(passengerCapacity, type, pricePerKilometer);
    }

    @Override
    protected void setPassengerCapacity(int value) {
        ValidationHelper.validateValueInRange(value, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_PASSENGER_ERROR_MESSAGE);
        super.setPassengerCapacity(value);
    }

    @Override
    protected void setPricePerKilometer(double value) {
        super.setPricePerKilometer(value);
    }

    private void setCarts(int value) {
        ValidationHelper.validateValueInRange(value, CARTS_MIN_VALUE, CARTS_MAX_VALUE, INVALID_CARTS_ERROR_MESSAGE);
        this.carts = value;
    }

    @Override
    public int getCarts() {
        return this.carts;
    }

    @Override
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Train ----%n"));
        stringBuilder.append(super.getAsString());
        stringBuilder.append(String.format("Carts amount: %d%n",carts));
        return stringBuilder.toString();
    }
}