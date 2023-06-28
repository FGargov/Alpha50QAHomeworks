package com.company.oop.agency.core;

import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.exceptions.ElementNotFoundException;
import com.company.oop.agency.models.JourneyImpl;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.AirplaneImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.TrainImpl;
import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepositoryImpl implements AgencyRepository {

    private int nextId;
    private final List<Vehicle> vehicles;
    private final List<Journey> journeys;
    private final List<Ticket> tickets;

    public AgencyRepositoryImpl() {
        this.nextId = 0;
        this.vehicles = new ArrayList<>();
        this.journeys = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public List<Journey> getJourneys() {
        return new ArrayList<>(journeys);
    }

    @Override
    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    @Override
    public Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }

        throw new ElementNotFoundException(String.format("No vehicle with ID %d", id));
    }

    @Override
    public Ticket findTicketById(int id) {
        for (Ticket ticket: tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }

        throw new ElementNotFoundException(String.format("No ticket with ID %d", id));
    }

    @Override
    public Journey findJourneyById(int id) {
        for (Journey journey : this.journeys) {
            if (journey.getId() == id) {
                return journey;
            }
        }
        throw new ElementNotFoundException(String.format("No journey with ID %d", id));
    }


    @Override
    public Airplane createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
       Airplane airplane = new AirplaneImpl(++this.nextId, passengerCapacity, pricePerKilometer, hasFreeFood);
       this.vehicles.add(airplane);
       return airplane;
    }

    @Override
    public Bus createBus(int passengerCapacity, double pricePerKilometer) {
        Bus bus = new BusImpl(++this.nextId, passengerCapacity, pricePerKilometer);
        this.vehicles.add(bus);
        return bus;
    }

    @Override
    public Train createTrain(int passengerCapacity, double pricePerKilometer, int carts) {
        Train train = new TrainImpl(+this.nextId, passengerCapacity, pricePerKilometer, carts);
        this.vehicles.add(train);
        return train;
    }

    @Override
    public Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle) {
        Journey journey = new JourneyImpl(++this.nextId, startLocation, destination, distance, vehicle);
        this.journeys.add(journey);
        return journey;
    }

    @Override
    public Ticket createTicket(Journey journey, double costs) {
        Ticket ticket = new TicketImpl(++this.nextId, journey, costs);
        this.tickets.add(ticket);
        return ticket;
    }
}