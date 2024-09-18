package com.example.project1;

import java.io.*;
import java.util.Scanner;

public class ContainerLinkedList {
    public Container head;

    public ContainerLinkedList() {
        this.head = null;
    }


    public void addContainer(Container newContainer) {


        if (head == null) {
            head = newContainer;
        } else {
            Container current = head;
            while (current.getContainerID() != null) {
                current = current.getNextContainer();
            }
            current.getNextContainer();
        }
    }

    public void displayContainers() {
        Container current = head;


        while (current != null) {
            System.out.println(current.getContainerID() + current.getContainerSize());
            current = current.getNextContainer();
        }
    }

    public void removeContainer(String contianerId) {
        if (head == null) {
            return;
        }
        if (head.getContainerID().equals(contianerId)) {
            head = head.getNextContainer();
            return;
        }
        Container current = head;
        Container previous = null;

        while (current != null && !current.getContainerID().equals(contianerId)) {
            previous = current;
            current = current.getNextContainer();
        }
        if (current != null) {
            assert previous != null;
            previous.setContainerID(current.getContainerID());
        }
    }

    public Container getContainer(int index) {
        if (index < 0) {
            return null; // Invalid index
        }

        int currentIndex = 0;
        Container current = head;

        while (current != null) {
            if (currentIndex == index) {
                return current;
            }

            current = current.getNextContainer();
            currentIndex++;
        }
        return null;
    }

    public static boolean isValidContainer(Container head, String containerID) {
        Container current = head;

        while (current != null) {
            if (current.getContainerID().equals(containerID)) {
                return true;
            }

            current = current.getNextContainer();
        }

        return false;
    }

    public int indexOfC(String containerID) {
        int index = 0;
        Container current = head;

        while (current != null) {
            if (current.getContainerID().equals(containerID)) {
                return index;
            }

            current = current.getNextContainer();
            index++;
        }

        return -1;
    }

    public static Container findContainer(Container head, String containerID) {
        Container current = head;

        while (current != null) {
            if (current.getContainerID().equals(containerID)) {
                return current;
            }

            current = current.getNextContainer();
        }

        return null;
    }

    public static void updateContainer(Container head, String oldContainerID, String newContainerID, int newContainerSize) {
        Container current = head;

        while (current != null) {
            if (current.getContainerID().equals(oldContainerID)) {
                current.setContainerID(newContainerID);
                current.setContainerSize(newContainerSize);
                return;
            }

            current = current.getNextContainer();
        }
    }


    public void saveToFile(String shipping) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(shipping))) {
            Container current = head;

            while (current != null) {
                // Save each container's information in CSV format
                writer.println(current.getContainerID());

                current = current.getNextContainer();
            }

            System.out.println("Data saved to " + shipping);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from a file
    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {

            while (scanner.hasNextLine()) {
                String containerID = scanner.nextLine().trim();
                int containerSize = scanner.nextInt();
                addContainer(new Container(containerID, containerSize));
            }

            System.out.println("Data loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }


    }
}
