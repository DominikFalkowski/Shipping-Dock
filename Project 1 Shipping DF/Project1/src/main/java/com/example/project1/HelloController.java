package com.example.project1;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class HelloController {
    PortLinkedList ports = new PortLinkedList();
    ContainerShipLinkedList containerShips = new ContainerShipLinkedList();
    PalletLinkedList pallets = new PalletLinkedList();
    ContainerLinkedList containers = new ContainerLinkedList();

    @FXML
    private TextField portNameField;
    public TextField portNameField2;
    public TextField portNameField3;
    @FXML
    private TextArea portList2;
    @FXML
    private TextArea containerShipList2;
    @FXML
    private TextArea containerList2;
    @FXML
    private TextArea palletList2;
    @FXML
    private TextArea goodsList2;
    @FXML
    private TextArea portList3;
    @FXML
    private TextArea containerShipList3;
    @FXML
    private TextArea containerShipList4;
    @FXML
    private TextArea containerList3;
    @FXML
    private TextArea containerList4;
    @FXML
    private TextArea palletList3;
    @FXML
    private TextArea palletList4;
    @FXML
    private TextArea goodsList3;
    @FXML
    private TextField portCodeField;
    @FXML
    private TextField portCodeField2;
    @FXML
    private TextArea portList;
    @FXML
    private TextArea portList4;

    @FXML
    private TextArea containerShipList;
    @FXML
    private TextArea containerList;
    @FXML
    private TextArea palletList;
    @FXML
    private TextArea goodsList;
    @FXML
    private TextField Pcounty;
    @FXML
    private TextField descriptionOfGoodsField;
    @FXML
    private TextField descriptionOfGoodsField2;
    @FXML
    private TextField descriptionOfGoodsField3;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField totalWeightField;
    @FXML
    private TextField valueOfPalletField;
    @FXML
    private TextField totalSizeField;
    @FXML
    private TextField containerIDField;
    @FXML
    private TextField containerIDField2;
    @FXML
    private TextField containerIDField3;
    @FXML
    private TextField containerSizeField;
    @FXML
    private TextField shipNameField;
    @FXML
    private TextField shipIdentifierField;
    @FXML
    private TextField flagStateField;

    @FXML
    private TextField newPortNameField;
    @FXML
    private TextField newCodeField;
    @FXML
    private TextField newCountyField;
    @FXML
    private TextField newShipNameField;
    @FXML
    private TextField newShipIdentifierField;
    @FXML
    private TextField newFlagStateField;
    @FXML
    private TextField newStatusField;
    @FXML
    private TextField newContainerIDField;
    @FXML
    private TextField newContainerSizeField;
    @FXML
    private TextField newDescriptionOfGoodsField;
    @FXML
    private TextField newQuantityField;
    @FXML
    private TextField newTotalWeightField;
    @FXML
    private TextField newValueOfPalletField;
    @FXML
    private TextField newTotalSizeField;





    //Add Delete Buttons
    @FXML
    public void onAddPortButtonCLick(ActionEvent actionEvent) {
        String portName = portNameField.getText();
        String code = portCodeField.getText();
        String county = Pcounty.getText();

        Port port = new Port(portName, code, county);
        System.out.println(port.getPortName() + port.getCounty()+ port.getInternationalPortCode());
        ports.addPort(port);

        portList.setText(port.getPortName() + port.getCounty()+ port.getInternationalPortCode());
        portList2.setText(port.getPortName() + port.getCounty()+ port.getInternationalPortCode());
        portList3.setText(port.getPortName() + port.getCounty()+ port.getInternationalPortCode());
        portList4.setText(port.getPortName() + port.getCounty()+ port.getInternationalPortCode());
    }

    @FXML
    public void onDeletePortButtonCLick(ActionEvent actionEvent) {
        String portName = portNameField.getText();
        if (portName!=null){
            Port head=null;
            Port removeP = findPortbyName(head,portName);
            ports.removePort(portName);
            portList.setText(String.valueOf(removeP));
            portList2.setText(String.valueOf(removeP));
            portList3.setText(String.valueOf(removeP));
            portList4.setText(String.valueOf(removeP));
        }
    }
    @FXML
    public void onAddPalletButtonCLick(ActionEvent actionEvent) {
        String descriptionOfGoods = descriptionOfGoodsField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        int totalSize = Integer.parseInt(totalSizeField.getText());
        int totalWeight = Integer.parseInt(totalWeightField.getText());
        int valueOfPallet = Integer.parseInt(valueOfPalletField.getText());;

        Pallet pallet = new Pallet(descriptionOfGoods,quantity,totalWeight,valueOfPallet,totalSize);

        pallets.addPallet(pallet);
        palletList.setText(pallet.getDescriptionOfGoods() + pallet.getTotalSize() + pallet.getTotalWeight() + pallet.getQuantity() + pallet.getValueOfPallet());
        palletList2.setText(pallet.getDescriptionOfGoods() + pallet.getTotalSize() + pallet.getTotalWeight() + pallet.getQuantity() + pallet.getValueOfPallet());
        palletList3.setText(pallet.getDescriptionOfGoods() + pallet.getTotalSize() + pallet.getTotalWeight() + pallet.getQuantity() + pallet.getValueOfPallet());
        palletList4.setText(pallet.getDescriptionOfGoods() + pallet.getTotalSize() + pallet.getTotalWeight() + pallet.getQuantity() + pallet.getValueOfPallet());



    }
    @FXML
    public void onDeletePalletButtonCLick(ActionEvent actionEvent) {
        String descriptionOfGoods = descriptionOfGoodsField.getText();
        if (descriptionOfGoods!=null){
            Pallet head = null;
            Pallet Rpallet = findPalletDescription(head,descriptionOfGoods);
            pallets.removePallet(descriptionOfGoods);
            palletList.setText(String.valueOf(Rpallet));
            palletList2.setText(String.valueOf(Rpallet));
            palletList3.setText(String.valueOf(Rpallet));
            palletList4.setText(String.valueOf(Rpallet));
        }
    }
    @FXML
    public void onAddContainerButtonCLick(ActionEvent actionEvent) {
        String containerID = containerIDField.getText();
        int containerSize = Integer.parseInt(containerSizeField.getText());

        Container container = new Container(containerID,containerSize);

        containers.addContainer(container);
        containerList.setText(container.getContainerID() + container.getContainerSize());
        containerList2.setText(container.getContainerID() + container.getContainerSize());
        containerList3.setText(container.getContainerID() + container.getContainerSize());
        containerList4.setText(container.getContainerID() + container.getContainerSize());
    }
    @FXML
    public void onDeleteContainerButtonCLick(Event actionEvent) {
        String containerID = containerIDField.getText();
        if (containerID!=null){
            Container head = null;
            Container RContainer = findContainerbyName(head,containerID);
            containers.removeContainer(containerID);
            containerList.setText(String.valueOf(RContainer));
            containerList2.setText(String.valueOf(RContainer));
            containerList3.setText(String.valueOf(RContainer));
            containerList4.setText(String.valueOf(RContainer));
        }
    }
    @FXML
    public void onAddContainerShipButtonCLick(ActionEvent actionEvent) {
        String shipName = shipNameField.getText();
        String shipIdentifier = shipIdentifierField.getText();
        String flagState = flagStateField.getText();

        ContainerShip containership = new ContainerShip(shipName,shipIdentifier,flagState);
        System.out.println(containership.getShipName()+containership.getFlagState()+containership.getShipIdentifier());
        containerShips.addContainerShip(containership);
        containerShipList.setText(containership.getShipName()+containership.getFlagState()+containership.getShipIdentifier());
        containerShipList2.setText(containership.getShipName()+containership.getFlagState()+containership.getShipIdentifier());
        containerShipList3.setText(containership.getShipName()+containership.getFlagState()+containership.getShipIdentifier());
        containerShipList4.setText(containership.getShipName()+containership.getFlagState()+containership.getShipIdentifier());
    }
    @FXML
    public void onDeleteContainerShipButtonCLick(ActionEvent actionEvent) {
        String shipName = shipNameField.getText();
        if (shipName!=null){
            ContainerShip head=null;
            ContainerShip RContainership = findContainerShipbyName(head,shipName);
            containerShips.removeContainerShip(shipName);
            containerShipList.setText(String.valueOf(RContainership));
            containerShipList2.setText(String.valueOf(RContainership));
            containerShipList3.setText(String.valueOf(RContainership));
            containerShipList4.setText(String.valueOf(RContainership));
        }
    }
//    Find and list buttons
@FXML
    public void findPortButtonClick(ActionEvent actionEvent){
        String portName =portNameField.getText();
    Port head=null;
        if(portName.isEmpty()){
            Port port = PortLinkedList.findPort(ports.head,portName);
            //Port port2 = ports.findPort(portName);

            if(port != null){
                System.out.println("Port Found:"+port.getPortName());
            }
            else{
                System.out.println("Port NotFound");
            }
        }

}

    @FXML
    public void findContainerButtonClick(ActionEvent actionEvent){
        String containerID = containerIDField.getText() ;
        Container head=null;
        if(containerID.isEmpty()){
            Container container = ContainerLinkedList.findContainer(head,containerID);
            if(container != null){
                System.out.println("Container Found:"+container.getContainerID());
            }
            else{
                System.out.println("Container Not Found");
            }
        }


    }
    @FXML
    public void findContainerShipButtonClick(ActionEvent actionEvent){
        String shipName =shipNameField.getText();
        ContainerShip head=null;
        if(shipName.isEmpty()){
            ContainerShip containerShip = ContainerShipLinkedList.findContainerShip(head,shipName);
            if(containerShip != null){
                System.out.println("ContainerShip Found:"+containerShip.getShipName());
            }
            else{
                System.out.println("ContainerShip Not Found");
            }
        }

    }
    @FXML
    public void findPalletButtonClick(ActionEvent actionEvent){
        String descriptionOfGoods = descriptionOfGoodsField.getText();
        Pallet head=null;
        if(descriptionOfGoods.isEmpty()){
            Pallet pallet = PalletLinkedList.findPallet(head,descriptionOfGoods);
            if(pallet != null){
                System.out.println("Pallet Found:"+pallet.getDescriptionOfGoods());
            }
            else{
                System.out.println("Pallet Not Found");
            }
        }

    }




//    Additional methods
@FXML
public void onPortUpdateButtonClicked(ActionEvent actionEvent) {
    String oldPortName = portNameField.getText();
    String newPortName = portNameField.getText();
    String newCode = portCodeField.getText();
    String newFlagState = flagStateField.getText();
    Port head = null;


    PortLinkedList.updatePort(head,oldPortName, newPortName, newCode, newFlagState);
    System.out.println("Port Updated");


}
    @FXML
    public void onContainerShipUpdateButtonClicked(ActionEvent actionEvent) {
        String oldShipName = shipNameField.getText();
        String newShipName = shipNameField.getText();
        String newShipIdentifier = shipIdentifierField.getText();
        String newFlagState = flagStateField.getText();
        ContainerShip head = null;


        ContainerShipLinkedList.updateContainerShip(head,oldShipName, newShipName, newShipIdentifier, newFlagState);
        System.out.println("ContainerShip Updated");

    }
    @FXML
    public void onContainerUpdateButtonClicked(ActionEvent actionEvent) {
        String oldContainerID = containerIDField.getText();
        String newContainerID = containerIDField.getText();
        int newContainerSize = Integer.parseInt(containerSizeField.getText());

        Container head = null;


        ContainerLinkedList.updateContainer(head,oldContainerID, newContainerID, newContainerSize);
        System.out.println("Container Updated");
    }
    @FXML
    public void onPalletUpdateButtonClicked(ActionEvent actionEvent) {
        String oldDescriptionOfGoods = descriptionOfGoodsField.getText();
        String newDescriptionOfGoods = descriptionOfGoodsField.getText();
        int newQuantity = Integer.parseInt(quantityField.getText());
        int newTotalWeight = Integer.parseInt(totalWeightField.getText());
        int newValueOfPallet = Integer.parseInt(valueOfPalletField.getText());
        int newTotalSize = Integer.parseInt(totalSizeField.getText());
        Pallet head = null;


        PalletLinkedList.updatePallet(head,oldDescriptionOfGoods, newDescriptionOfGoods, newQuantity, newTotalWeight,newValueOfPallet,newTotalSize);
        System.out.println("Pallet Updated");


    }
    @FXML

    public String onShoreOffShoreButtonClick (ActionEvent actionEvent){
        ContainerShip.statusOfShip = !ContainerShip.statusOfShip;
        if(ContainerShip.statusOfShip){
            return "on shore";
        }
        containerShipList.setText(" This ship is"+ ContainerShip.statusOfShip);

        return "off shore";
    }
    @FXML
    public void ResetButtonClick(){
        ports.head = null;
        containers.head = null;
        containerShips.head =null;
        pallets.head = null;

    }

    //find methods
    public Port findPortbyName(Port head,String portName) {
        int index = findPortByIndex(head,portName);
        if (index != -1) {
            return ports.getPort(index);
        }
        return null;
    }
    public int findPortByIndex(Port head,String portName) {
        if (PortLinkedList.isValidPort(head,portName)) {
            return ports.indexOfP(portName);
        }
        return 0;
    }
    public ContainerShip findContainerShipbyName(ContainerShip head,String shipName) {
        int index = findContainerShipByIndex(head,shipName);
        if (index != -1) {
            return containerShips.getContainerShip(index);
        }
        return null;
    }
    public int findContainerShipByIndex(ContainerShip head, String shipName) {
        if (ContainerShipLinkedList.isValidContainerShip(head,shipName)) {
            return containerShips.indexOfCS(shipName);
        }
        return 0;
    }
    private Pallet findPalletDescription(Pallet head,String descriptionOfGoods) {
        int index = findPalletByIndex(head,descriptionOfGoods);
        if (index != -1) {
            return pallets.getPallet(index);
        }
        return null;
    }
    public int findPalletByIndex(Pallet head,String descriptionOfGoods) {
        if (PalletLinkedList.isValidPallet(head,descriptionOfGoods)) {
            return pallets.indexOfPa(descriptionOfGoods);
        }

        return -1;
    }
    public Container findContainerbyName(Container head,String containerID) {
        int index = findContainerByIndex(head,containerID);
        if (index != -1) {
            return containers.getContainer(index);
        }
        return null;
    }
    public int findContainerByIndex(Container head,String containerID) {
        if (ContainerLinkedList.isValidContainer(head,containerID)) {
            return containers.indexOfC(containerID);
        }
        return 0;
    }


}