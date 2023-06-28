package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;
import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {


    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);
    private int seats;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price);
        setSeats(seats);
    }

    @Override
    public int getWheels() {
        return wheels = 4;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    public int getSeats() {
        return this.seats;
    }
    private void setSeats(int seats) {
        validateSeats(seats);
        this.seats = seats;
    }

    private void validateSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
    }

    @Override
    public String getVehicleDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seats: ").append(getSeats());
        return sb.toString();
    }

    @Override
    public String getWheelsDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wheels: ").append(getWheels()).append(System.lineSeparator());
        return sb.toString();
    }
}
