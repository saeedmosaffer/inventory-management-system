package edu.birzeit.saeedmosaffer.inventory_management_system.models;

public class Warehouses {
    // Warehouses: Attributes: Warehouse ID, Name, Location, Capacity, Manager ID
    private int warehouseID;
    private String name;
    private String location;
    private int capacity;
    private int managerID;

    public Warehouses(int warehouseID, String name, String location, int capacity, int managerID) {
        this.warehouseID = warehouseID;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.managerID = managerID;
    }

    public Warehouses() {
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "Warehouses{" +
                "warehouseID=" + warehouseID +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", managerID=" + managerID +
                '}';
    }
}
