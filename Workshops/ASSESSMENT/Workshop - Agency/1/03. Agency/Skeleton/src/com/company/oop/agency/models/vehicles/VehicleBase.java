package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleBase implements Vehicle, Identifiable, Printable {

    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String PASSENGER_CAPACITY_ERROR = String.format(
            "A vehicle with less than %d passengers or more than %d passengers cannot exist!",
            PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final String PRICE_VALUE_ERROR = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private static final String VEHICLE_TYPE_ERROR = "Vehicle type must be Land, Air or Sea";
    private static final String ID_VALUE_ERROR = "Id cannot be negative number.";
    private static final int ID_MIN_VALUE = 0;
    private int passengerCapacity;
    private VehicleType vehicleType;
    private double pricePerKilometer;
    private int id;

    public VehicleBase(int id, int passengerCapacity, double pricePerKilometer) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setId(id);
    }

    protected abstract void validate(int passengerCapacity, double pricePerKilometer);
    protected void setId(int id) {
        if (id < ID_MIN_VALUE) {
            throw new IllegalArgumentException(ID_VALUE_ERROR);
        }
        this.id = id;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    private void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_CAPACITY_ERROR);
        }
    }

    protected void setVehicleType(VehicleType vehicleType) {
        if (vehicleType == null) {
            throw new IllegalArgumentException(VEHICLE_TYPE_ERROR);
        }
        this.vehicleType = vehicleType;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    private void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(PRICE_VALUE_ERROR);
        }
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("%s ----\nPassenger capacity: %d\nPrice per kilometer: %.2f\nVehicle type: %s\n",
                this.getClass().getInterfaces()[0].getSimpleName(),this.getPassengerCapacity(),
                this.getPricePerKilometer(), this.getType());
    }
}
