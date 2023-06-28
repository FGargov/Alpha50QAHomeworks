package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.enums.VehicleType;


public class BusImpl extends Vehicle implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String PASSENGER_ERROR_MSG = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);


    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
            super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setPassengerCapacity(passengerCapacity);
    }

    @Override
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_ERROR_MSG);
        }
        super.setPassengerCapacity(passengerCapacity);
    }
    @Override
    public String getAsString() {
        return String.format(
                "Bus ----%n" +
                        "Passenger capacity: %d%n" +
                        "Price per kilometer: %.2f%n" +
                        "Vehicle type: %s" + System.lineSeparator(),
                this.getPassengerCapacity(),
                this.getPricePerKilometer(),
                this.getType()
        );
    }
}