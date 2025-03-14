package org.example.hollidaybooking.models;

import java.sql.Date;

public class Flight {
    private int id;
    private String departure;
    private String arrival;
    private Date departureDate;
    private Date arrivalDate;

    public Flight() {
    }

    public Flight(int id, String departure,
                  String arrival, Date departureDate, Date arrivalDate) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id" + id +
                ", departureAirport='" + departure + '\'' +
                ", destinationAirport='" + arrival + '\'' +
                ", departure=" + departureDate +
                ", arrival=" + arrivalDate +
                '}';
    }
}
