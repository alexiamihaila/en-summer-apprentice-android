package com.example.myapplication.Domains;

public class CartDomain {


    private String eventName;
    private int price;
    private String description;
    private String pic;

    public CartDomain(String eventName, int price, String description, String pic) {
        this.price = price;
        this.description = description;
        this.eventName = eventName;
        this.pic = pic;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
