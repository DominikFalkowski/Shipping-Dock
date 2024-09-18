package com.example.project1;


public class Pallet {

    public Pallet(String descriptionOfGoods, int quantity, int totalWeight, int valueOfPallet, int totalSize) {
        this.descriptionOfGoods = descriptionOfGoods;
        this.quantity = quantity;
        this.totalWeight = totalWeight;
        this.valueOfPallet = valueOfPallet;
        this.totalSize = totalSize;
    }

    public String descriptionOfGoods;
    public int quantity;
    public int totalWeight;
    public int valueOfPallet;
    public int totalSize;
    public Pallet NextPallet;

    public Pallet getNextPallet() {
        return NextPallet;
    }

    public void setNextPallet(Pallet nextPallet) {
        NextPallet = nextPallet;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        if (Util.validStringLength(descriptionOfGoods, 100))
            this.descriptionOfGoods = descriptionOfGoods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }



    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getValueOfPallet() {
        return valueOfPallet;
    }

    public void setValueOfPallet(int valueOfPallet) {
        this.valueOfPallet = valueOfPallet;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "descriptionOfGoods='" + descriptionOfGoods + '\'' +
                ", quantity=" + quantity +
                ", totalWeight=" + totalWeight +
                ", valueOfPallet=" + valueOfPallet +
                ", totalSize=" + totalSize +
                '}';
    }

}
