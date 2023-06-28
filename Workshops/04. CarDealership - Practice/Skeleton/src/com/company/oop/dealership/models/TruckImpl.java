package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);

    private int weightCapacity;
    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setWeightCapacity(weightCapacity);
    }

    public void setWeightCapacity(int weightCapacity) {
        validateWeightCapacity(weightCapacity);
        this.weightCapacity = weightCapacity;
    }

    private void validateWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    @Override
    public int getWheels() {
        return wheels = 8;
    }

    @Override
    protected String getWheelsDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wheels: ").append(getWheels()).append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    protected String getVehicleDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weight Capacity: ").append(getWeightCapacity()).append("t");
        return sb.toString();
    }
}
