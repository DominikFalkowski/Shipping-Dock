package com.example.project1;

public class ContainerShip {



    public ContainerShip NextContainerShip;
    public String shipName;

    public String shipIdentifier;
    public String flagState;
    public String photograph;
    public static boolean statusOfShip = false;

    public ContainerShip(String shipName, String shipIdentifier, String flagState) {
        this.shipName = shipName;
        this.shipIdentifier = shipIdentifier;
        this.flagState = flagState;
    }



    public boolean isStatusOfShip() {
        return statusOfShip;
    }

    public void setStatusOfShip(boolean statusOfShip) {;
    }
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipIdentifier() {
        return shipIdentifier;
    }

    public void setShipIdentifier(String shipIdentifier) {
        this.shipIdentifier = shipIdentifier;
    }

    public String getFlagState() {
        return flagState;
    }

    public void setFlagState(String flagState) {
        this.flagState = flagState;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }
    public ContainerShip getNextContainerShip() {
        return NextContainerShip;
    }

    public void setNextContainerShip(ContainerShip nextContainerShip) {
        NextContainerShip = nextContainerShip;
    }

    @Override
    public String toString() {
        return "Containership{" +
                "shipName='" + shipName + '\'' +
                ", shipIdentifier='" + shipIdentifier + '\'' +
                ", flagState='" + flagState + '\'' +
                ", photograph='" + photograph + '\'' +
                '}';
    }
}