package com.example.project1;


public class Port {




    public String portName;
    private String county;

    public Port( String portName, String county, String internationalPortCode) {
        this.portName = portName;
        this.county = county;
        this.internationalPortCode = internationalPortCode;
    }

    public String internationalPortCode;



    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Port nextPort;

    public Port getNextPort() {
        return nextPort;
    }

    public void setNextPort(Port nextPort) {
        this.nextPort = nextPort;
    }



    public  String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }


    public String getInternationalPortCode() {
        return internationalPortCode;
    }

    public void setInternationalPortCode(String internationalPortCode) {
        this.internationalPortCode = internationalPortCode;
    }

    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
                ", county='" + county + '\'' +
                ", internationalPortCode='" + internationalPortCode + '\'' +
                ", nextPort=" + nextPort +
                '}';
    }
}

