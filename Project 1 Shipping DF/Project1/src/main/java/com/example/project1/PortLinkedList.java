package com.example.project1;


import java.io.*;
import java.util.Scanner;

public class PortLinkedList {
    public Port head;

    public PortLinkedList() {
        this.head = null;
    }


    public void addPort(Port newPort) {


        if (head == null) {
            head = newPort;
        } else {
            Port current = head;
            while (current.getNextPort() != null) {
                current = current.getNextPort();
            }
            current.getNextPort();
        }
    }

    public void displayPorts() {
        Port current = head;


        while (current != null) {
            System.out.println(current.getPortName()+ current.getCounty()+current.getInternationalPortCode());
            current = current.getNextPort();
        }
    }

    public void removePort(String portName) {
        if (head == null) {
            return;
        }
        if (head.getPortName().equals(portName)) {
            head = head.getNextPort();
            return;
        }
        Port current = head;
        Port previous = null;

        while (current != null && !current.getPortName().equals(portName)) {
            previous = current;
            current = current.getNextPort();
        }
        if (current != null) {
            assert previous != null;
            previous.setNextPort(current.getNextPort());
        }
    }
    public Port getPort(int index) {
        if (index < 0) {
            return null; // Invalid index
        }

        int currentIndex = 0;
        Port current = head;

        while (current != null) {
            if (currentIndex == index) {
                return current;
            }

            current = current.getNextPort();
            currentIndex++;
        }
        return null;
    }
    public static boolean isValidPort(Port head, String portName) {
        Port current = head;

        while (current != null) {
            if (current.getPortName().equals(portName)) {
                return true;
            }

            current = current.getNextPort();
        }

        return false;
    }
    public int indexOfP(String portName) {
        int index = 0;
        Port current = head;

        while (current != null) {
            if (current.getPortName().equals(portName)) {
                return index;
            }

            current = current.getNextPort();
            index++;
        }

        return -1;
    }
    public static Port findPort(Port head,String portName) {
        Port current = head;

        while (current != null) {
            if (current.getPortName().equals(portName)) {
                return current;
            }

            current = current.getNextPort();
        }

        return null;
    }

    public Port findPort(String portName) {
        Port current = head;

        while (current != null) {
            if (current.getPortName().equals(portName)) {
                return current;
            }

            current = current.getNextPort();
        }

        return null;
    }

    public static void updatePort(Port head,String oldPortName, String newPortName, String newCode, String newCounty) {
        Port current =head;

        while (current != null) {
            if (current.getPortName().equals(oldPortName)) {
                current.setPortName(newPortName);
                current.setInternationalPortCode(newCode);
                current.setCounty(newCounty);
                return;
            }

            current = current.getNextPort();
        }
    }
    public void saveToFile(String shipping) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(shipping))) {
            Port current = head;

            while (current != null) {
                writer.println(current.getPortName());

                current = current.getNextPort();
            }

            System.out.println("Data saved to " + shipping);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFromFile(String shipping) {
        try (Scanner scanner = new Scanner(new File(shipping))) {

            while (scanner.hasNextLine()) {
                String portName = scanner.nextLine().trim();
                String county = scanner.nextLine().trim();
                String internationalPortCode = scanner.nextLine().trim();
                addPort(new Port(portName,county,internationalPortCode));
            }

            System.out.println("Data loaded from " + shipping);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + shipping);
        }


    }




}