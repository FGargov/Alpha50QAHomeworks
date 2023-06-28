package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.enums.VehicleType;


public abstract class Vehicle implements com.company.oop.agency.models.vehicles.contracts.Vehicle {
    private static final double MIN_PRICE_PER_KM = 0.1;
    private static final double MAX_PRICE_PER_KM = 2.5;
    private static final String INVALID_PRICE_MSG = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            MIN_PRICE_PER_KM, MAX_PRICE_PER_KM);
    private static final int MIN_PASSENGER_NUMBER = 1;
    private static final int MAX_PASSENGER_NUMBER = 800;
    private static final String INVALID_PASSENGER_CAPACITY_MESSAGE = String.format(
            "A vehicle with less than %d passengers or more than %d passengers cannot exist!",
            MIN_PASSENGER_NUMBER, MAX_PASSENGER_NUMBER);
    private int id;
    private int passengerCapacity;
    private double pricePerKilometer;
    private final VehicleType vehicleType;

    protected Vehicle(int id, int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.vehicleType = vehicleType;
    }

    protected Vehicle(int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        this.vehicleType = vehicleType;
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        if (id < 0) {
            throw new NumberFormatException();
        }

        this.id = id;
    }

    @Override
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < MIN_PASSENGER_NUMBER || passengerCapacity > MAX_PASSENGER_NUMBER) {
            throw new IllegalArgumentException(INVALID_PASSENGER_CAPACITY_MESSAGE);
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }

    protected void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < MIN_PRICE_PER_KM || pricePerKilometer > MAX_PRICE_PER_KM) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public VehicleType getType() {
        return this.vehicleType;
    }

    @Override
    public String getAsString() {
        return String.format(
                "Passenger capacity: %d%nPrice per kilometer: %.2f%nVehicle type: %s",
                this.getPassengerCapacity(),
                this.getPricePerKilometer(),
                this.getType()
        );
    }
}
