package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private Journey journey;
    private double administrativeCosts;
    private int id;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format(
                "Ticket ----\n" +
                        "Destination: %s\n" +
                        "Price: %.2f\n", this.journey.getDestination(), this.calculatePrice());

    }

    @Override
    public Journey getJourney() {
        return this.journey;
    }

    @Override
    public double calculatePrice() {
        return this.administrativeCosts * this.journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return this.administrativeCosts;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    private void setAdministrativeCosts(double value) {
        String error = String.format("Value of 'costs' must be a positive number. Actual value: %.2f", value);
        if (value < 0) {
            throw new InvalidUserInputException(error);
        }

        this.administrativeCosts = value;
    }
}
