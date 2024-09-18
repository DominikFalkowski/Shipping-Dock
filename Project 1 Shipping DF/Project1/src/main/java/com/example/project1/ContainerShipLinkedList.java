package com.example.project1;

import java.io.*;
import java.util.Scanner;

public class ContainerShipLinkedList {
    public ContainerShip head;

    public ContainerShipLinkedList() {
        this.head = null;
    }


    public void addContainerShip(ContainerShip newContainerShip) {


        if (head == null) {
            head = newContainerShip;
        } else {
            ContainerShip current = head;
            while (current.getNextContainerShip() != null) {
                current = current.getNextContainerShip();
            }
            current.getNextContainerShip();
        }
    }



    public void removeContainerShip(String shipName) {
        if (head == null) {
            return;
        }
        if (head.getShipName().equals(shipName)) {
            head = head.getNextContainerShip();
            return;
        }
        ContainerShip current = head;
        ContainerShip previous = null;

        while (current != null && !current.getShipName().equals(shipName)) {
            previous = current;
            current = current.getNextContainerShip();
        }
        if (current != null) {
            assert previous != null;
            previous.setNextContainerShip(current.getNextContainerShip());
        }
    }
    public ContainerShip getContainerShip(int index) {
        if (index < 0) {
            return null;
        }

        int currentIndex = 0;
        ContainerShip current = head;

        while (current != null) {
            if (currentIndex == index) {
                return current;
            }

            current = current.getNextContainerShip();
            currentIndex++;
        }
        return null;
    }
    public static boolean isValidContainerShip(ContainerShip head, String shipName) {
        ContainerShip current = head;

        while (current != null) {
            if (current.getShipName().equals(shipName)) {
                return true;
            }

            current = current.getNextContainerShip();
        }

        return false;
    }
    public int indexOfCS(String shipName) {
        int index = 0;
        ContainerShip current = head;

        while (current != null) {
            if (current.getShipName().equals(shipName)) {
                return index;
            }

            current = current.getNextContainerShip();
            index++;
        }

        return -1;
    }
    public static ContainerShip findContainerShip(ContainerShip head,String shipName) {
        ContainerShip current = head;

        while (current != null) {
            if (current.getShipName().equals(shipName)) {
                return current;
            }

            current = current.getNextContainerShip();
        }

        return null;
    }
    public static void updateContainerShip(ContainerShip head,String oldShipName, String newShipName,String newShipIdentifier, String newFlagState) {
        ContainerShip current =head;

        while (current != null) {
            if (current.getShipName().equals(oldShipName)) {
                current.setShipName(newShipName);
                current.setShipIdentifier(newShipIdentifier);
                current.setFlagState(newFlagState);
                return;
            }

            current = current.getNextContainerShip();
        }
    }
    public void saveToFile(String shipping) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(shipping))) {
            ContainerShip current = head;

            while (current != null) {
                writer.println(current.getShipName());

                current = current.getNextContainerShip();
            }

            System.out.println("Data saved to " + shipping);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String shipping) {
        try (Scanner scanner = new Scanner(new File(shipping))) {

            while (scanner.hasNextLine()) {
                String shipName = scanner.nextLine().trim();
                String shipIdentifier = scanner.nextLine().trim();
                String flagState = scanner.nextLine().trim();
                addContainerShip(new ContainerShip(shipName,shipIdentifier,flagState));
            }

            System.out.println("Data loaded from " + shipping);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + shipping);
        }


    }




}
