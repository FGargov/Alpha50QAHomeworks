package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private int id;
    private double administrativeCost;
    private final Journey journey;


    public TicketImpl(int id, Journey journey, double administrativeCost) {
        setId(id);
        this.journey = journey;
        setAdministrativeCost(administrativeCost);
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id < 0) {
            throw new NumberFormatException();
        }
        this.id = id;
    }

    public void setAdministrativeCost(double administrativeCost) {
        if (administrativeCost < 0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", administrativeCost));
        }
        this.administrativeCost = administrativeCost;
    }

    @Override
    public Journey getJourney() {
        return this.journey;
    }

    @Override
    public double calculatePrice() {
        return journey.calculateTravelCosts() * getAdministrativeCost();
    }

    @Override
    public double getAdministrativeCost() {
        return administrativeCost;
    }

    @Override
    public String getAsString() {
        return String.format(
                "Ticket ----%n" +
                        "Destination: %s%n" +
                        "Total ticket price: %.2f" + System.lineSeparator()+ "####################" + System.lineSeparator(),
                this.getJourney().getDestination(),
                this.calculatePrice());
    }
}
