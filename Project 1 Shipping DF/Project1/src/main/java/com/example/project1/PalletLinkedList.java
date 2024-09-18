package com.example.project1;

import java.io.*;
import java.util.Scanner;

public class PalletLinkedList {
    public Pallet head;

    public PalletLinkedList() {
        this.head = null;
    }


    public void addPallet(Pallet newPallet) {


        if (head == null) {
            head = newPallet;
        } else {
            Pallet current = head;
            while (current.getNextPallet() != null) {
                current = current.getNextPallet();
            }
            current.getNextPallet();
        }
    }

    public void displayPallets() {
        Pallet current = head;


        while (current != null) {
            System.out.println(current.getDescriptionOfGoods() + current.getQuantity() + current.getTotalWeight() + current.getTotalSize());
            current = current.getNextPallet();
        }
    }

    public void removePallet(String descriptionOfGoods) {
        if (head == null) {
            return;
        }
        if (head.getDescriptionOfGoods().equals(descriptionOfGoods)) {
            head = head.getNextPallet();
            return;
        }
        Pallet current = head;
        Pallet previous = null;

        while (current != null && !current.getDescriptionOfGoods().equals(descriptionOfGoods)) {
            previous = current;
            current = current.getNextPallet();
        }
        if (current != null) {
            assert previous != null;
            previous.setNextPallet(current.getNextPallet());
        }
    }

    public Pallet getPallet(int index) {
        if (index < 0) {
            return null; // Invalid index
        }

        int currentIndex = 0;
        Pallet current = head;

        while (current != null) {
            if (currentIndex == index) {
                return current;
            }

            current = current.getNextPallet();
            currentIndex++;
        }
        return null;
    }

    public static boolean isValidPallet(Pallet head, String descriptionOfGoods) {
        Pallet current = head;

        while (current != null) {
            if (current.getDescriptionOfGoods().equals(descriptionOfGoods)) {
                return true;
            }

            current = current.getNextPallet();
        }

        return false;
    }

    public int indexOfPa(String descriptionOfGoods) {
        int index = 0;
        Pallet current = head;

        while (current != null) {
            if (current.getNextPallet().equals(descriptionOfGoods)) {
                return index;
            }

            current = current.getNextPallet();
            index++;
        }

        return -1;
    }

    public static Pallet findPallet(Pallet head, String descriptionOfGoods) {
        Pallet current = head;

        while (current != null) {
            if (current.getDescriptionOfGoods().equals(descriptionOfGoods)) {
                return current;
            }

            current = current.getNextPallet();
        }

        return null;
    }

    public static void updatePallet(Pallet head, String newDescriptionOfGoods, String oldDescriptionOfGoods, int newQuantity, int newTotalWeight, int newValueOfPallet, int newTotalSize) {
        Pallet current = head;

        while (current != null) {
            if (current.getDescriptionOfGoods().equals(oldDescriptionOfGoods)) {
                current.setDescriptionOfGoods(newDescriptionOfGoods);
                current.setQuantity(newQuantity);
                current.setTotalWeight(newTotalWeight);
                current.setValueOfPallet(newValueOfPallet);
                current.setTotalSize(newTotalSize);

                return;
            }

            current = current.getNextPallet();
        }

    }
    public void saveToFile(String shipping) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(shipping))) {
            Pallet current = head;

            while (current != null) {
                writer.println(current.getDescriptionOfGoods());

                current = current.getNextPallet();
            }

            System.out.println("Data saved to " + shipping);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String shipping) {
        try (Scanner scanner = new Scanner(new File(shipping))) {

            while (scanner.hasNextLine()) {
                String descriptionOfGoods = scanner.nextLine().trim();
                int quantity = scanner.nextInt();
                int totalWeight = scanner.nextInt();
                int valueOfPallet = scanner.nextInt();
                int totalSize = scanner.nextInt();
                addPallet(new Pallet(descriptionOfGoods,quantity,totalWeight,valueOfPallet,totalSize));
            }

            System.out.println("Data loaded from " + shipping);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + shipping);
        }


    }
}
