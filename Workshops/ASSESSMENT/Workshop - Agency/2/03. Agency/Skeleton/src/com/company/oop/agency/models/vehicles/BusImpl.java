package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Bus  {
    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String INVALID_PASSENGER_ERROR_MESSAGE = String.format("A bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);

    protected BusImpl(int passengerCapacity, VehicleType type, double pricePerKilometer) {
        super(passengerCapacity, type, pricePerKilometer);
    }

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer){
        this(passengerCapacity, VehicleType.LAND, pricePerKilometer);
        this.id=id;
    }

    @Override
    protected void setPassengerCapacity(int value) {
        ValidationHelper.validateValueInRange(value, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_PASSENGER_ERROR_MESSAGE );
        super.setPassengerCapacity(value);
    }

    @Override
    public String getAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Bus ----%n"));
        stringBuilder.append(super.getAsString());
        return stringBuilder.toString();
    }
}