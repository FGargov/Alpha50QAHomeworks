package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }

    private void setCategory(String category){
        validateCategory(category);
        this.category = category;
    }

    void validateCategory(String category) {
        ValidationHelpers.validateIntRange(category.length(), CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    @Override
    public int getWheels() {
        return wheels = 2;
    }

    @Override
    public String getVehicleDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category: ").append(getCategory());
        return sb.toString();
    }

    @Override
    public String getWheelsDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wheels: ").append(getWheels()).append(System.lineSeparator());
        return sb.toString();
    }
}
