package dto;

import entity.SuperEntity;

public class TransportCategoryDTO{
    private String TID;
    private String destination;
    private double peoplePrice;
    private double peopleItemPrice;
    private double itemPrice;
    private double peoplePetPrice;

    public TransportCategoryDTO() {
    }

    public TransportCategoryDTO(String TID, String destination, double peoplePrice, double peopleItemPrice, double itemPrice, double peoplePetPrice) {
        this.TID = TID;
        this.destination = destination;
        this.peoplePrice = peoplePrice;
        this.peopleItemPrice = peopleItemPrice;
        this.itemPrice = itemPrice;
        this.peoplePetPrice = peoplePetPrice;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPeoplePrice() {
        return peoplePrice;
    }

    public void setPeoplePrice(double peoplePrice) {
        this.peoplePrice = peoplePrice;
    }

    public double getPeopleItemPrice() {
        return peopleItemPrice;
    }

    public void setPeopleItemPrice(double peopleItemPrice) {
        this.peopleItemPrice = peopleItemPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getPeoplePetPrice() {
        return peoplePetPrice;
    }

    public void setPeoplePetPrice(double peoplePetPrice) {
        this.peoplePetPrice = peoplePetPrice;
    }
}
