package org.example.hollidaybooking.models;

public class Reservation {
    private int userId;
    private int flightId;
    private int childrenNr;
    private int adultsNr;

    public Reservation() {
    }

    public Reservation(int userId, int flightId, int childrenNr, int adultsNr) {
        this.userId = userId;
        this.flightId = flightId;
        this.childrenNr = childrenNr;
        this.adultsNr = adultsNr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getChildrenNr() {
        return childrenNr;
    }

    public void setChildrenNr(int childrenNr) {
        this.childrenNr = childrenNr;
    }

    public int getAdultsNr() {
        return adultsNr;
    }

    public void setAdultsNr(int adultsNr) {
        this.adultsNr = adultsNr;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userId=" + userId +
                ", flightId=" + flightId +
                ", childrenNr=" + childrenNr +
                ", adultsNr=" + adultsNr +
                '}';
    }
}
