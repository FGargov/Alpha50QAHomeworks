package com.company.oop.dealership.models;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class VehicleBase implements Vehicle {

        private static final int MAKE_MIN_LENGTH = 2;
        private static final int MAKE_MAX_LENGTH = 15;
        private static final String MAKE_ERROR_MSG = String.format(
                "Make must be between %d and %d characters long!",
                MAKE_MIN_LENGTH, MAKE_MAX_LENGTH);
        private static final int MODEL_MIN_LENGTH = 1;
        private static final int MODEL_MAX_LENGTH = 15;

        private static final String MODEL_ERROR_MSG = String.format(
            "Model must be between %d and %d characters long!",
            MODEL_MIN_LENGTH, MODEL_MAX_LENGTH);

        private static final double PRICE_VAL_MIN = 0;
        private static final double PRICE_VAL_MAX = 1000000.0;
        private static final String PRICE_VAL_ERR = String.format(
                "Price must be between %.1f and %.1f!", PRICE_VAL_MIN, PRICE_VAL_MAX);
        private static final String COMMENT_HEADER = "--COMMENTS--";
        private static final String NO_COMMENTS_HEADER = "--NO COMMENTS--";
        private String make;
        private String model;
        private double price;
        protected int wheels;
        private List<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        this.comments = new ArrayList<>();
    }

    @Override
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        validateMakeLength(make);
        this.make = make;
    }

    void validateMakeLength(String make) {
        ValidationHelpers.validateIntRange(make.length(), MAKE_MIN_LENGTH, MAKE_MAX_LENGTH, MAKE_ERROR_MSG);
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        validateModelLength(model);
        this.model = model;
    }

    void validateModelLength(String model) {
        ValidationHelpers.validateIntRange(model.length(), MODEL_MIN_LENGTH, MODEL_MAX_LENGTH, MODEL_ERROR_MSG);
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(price, PRICE_VAL_MIN, PRICE_VAL_MAX, PRICE_VAL_ERR);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public int getWheels() {
        return this.wheels;
    }

    protected abstract String getWheelsDetails();
    protected abstract String getVehicleDetails();

    public static String removeTrailingZerosFromDouble(double number) {
        BigDecimal num = BigDecimal.valueOf(number).stripTrailingZeros();
        return num.toPlainString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType()).append(":").append(System.lineSeparator());
        sb.append("Make: ").append(getMake()).append(System.lineSeparator());
        sb.append("Model: ").append(getModel()).append(System.lineSeparator());
        sb.append(getWheelsDetails());
        sb.append("Price: $").append(removeTrailingZerosFromDouble(getPrice())).append(System.lineSeparator());
        sb.append(getVehicleDetails());

        if (getComments().isEmpty()) {
            sb.append("\n--NO COMMENTS--");
        } else {
            sb.append("\n--COMMENTS--\n");
            for (Comment comment : getComments()) {
                sb.append("----------\n");
                sb.append(comment.getContent()).append("\nUser: ").append(comment.getAuthor())
                        .append(System.lineSeparator());
                sb.append("----------\n");
            }
            sb.append("----------\n");
            sb.append("--COMMENTS--");
        }

        return sb.toString();
    }
}
