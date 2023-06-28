package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket, Identifiable, Printable {

    private static final String ID_VALUE_ERROR = "Id cannot be negative number.";
    private static final int ID_MIN_VALUE = 0;
    private int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        setJourney(journey);
        setCosts(costs);
        setId(id);
    }

    private void setId(int id) {
        if (id < ID_MIN_VALUE) {
            throw new IllegalArgumentException(ID_VALUE_ERROR);
        }
        this.id = id;
    }

    private void setJourney(Journey journey) {
        if (journey == null) {
            throw new IllegalArgumentException();
        }
        this.journey = journey;
    }

    private void setCosts(double costs) {
        if (costs < 0) {
            throw new InvalidUserInputException(String.format(
                    "Value of 'costs' must be a positive number. Actual value: %.2f.", costs));
        }
        this.costs = costs;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n", journey.getDestination(), calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }
}
