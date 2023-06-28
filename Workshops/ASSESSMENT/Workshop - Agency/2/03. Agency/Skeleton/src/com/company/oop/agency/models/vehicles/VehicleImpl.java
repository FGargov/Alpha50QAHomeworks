package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public  abstract class VehicleImpl implements Vehicle {
    private  static  final int PASSENGER_CAPACITY_MIN_VALUE = 1;
    private static final int PASSENGER_CAPACITY_MAX_VALUE = 800;

    private static final String INVALID_PASSENGER_ERROR_MESSAGE = "A vehicle with less than 1 passengers or more than 800 passengers cannot exist!";
    private static final String INVALID_PRICE_ERROR_MESSAGE = "A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!";
    public static final double PRICE_MIN_VALUE = 0.10;
    public static final double PRICE_MAX_VALUE = 2.50;
    private int passengerCapacity;
    private VehicleType type;
    private double pricePerKilometer;
    public static int NEXT_ID;
    protected int id;

    protected VehicleImpl(int passengerCapacity, VehicleType type, double pricePerKilometer) {
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setType(type);
    }

    protected void setPricePerKilometer(double value){
        ValidationHelper.validateValueInRange(value, PRICE_MIN_VALUE, PRICE_MAX_VALUE,INVALID_PRICE_ERROR_MESSAGE);
        this.pricePerKilometer = value;
    }
    protected void setPassengerCapacity(int value){
        ValidationHelper.validateValueInRange(value, PASSENGER_CAPACITY_MIN_VALUE, PASSENGER_CAPACITY_MAX_VALUE, INVALID_PASSENGER_ERROR_MESSAGE);
        this.passengerCapacity = value;
    }

    protected void setType(VehicleType value) {
        if (value==null){
            throw new IllegalArgumentException("Type cannot be null");
        }
        this.type = value;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getAsString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Passenger capacity: %d%n",passengerCapacity));
        sb.append(String.format("Price per kilometer: %.2f%n",pricePerKilometer));
        sb.append(String.format("Vehicle type: %s%n",type));
        return sb.toString();
    }

    @Override
    public VehicleType getType() {
       return this.type;
    }

    @Override
    public int getPassengerCapacity() {

        return this.passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {

        return this.pricePerKilometer;
    }
}
