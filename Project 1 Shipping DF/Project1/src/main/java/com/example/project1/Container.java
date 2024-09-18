package com.example.project1;

public class Container {




    public Container(  String containerID, int containerSize) {
        this.containerID = containerID;
        this.containerSize = containerSize;
    }
    public String containerID;
    public int containerSize ;
    public Container NextContainer;

    public Container getNextContainer() {
        return NextContainer;
    }

    public void setNextContainer(Container nextContainer) {
        NextContainer = nextContainer;
    }

    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {

        this.containerSize = containerSize;
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerID='" + containerID + '\'' +
                ", containerSize=" + containerSize +
                '}';
    }
}
