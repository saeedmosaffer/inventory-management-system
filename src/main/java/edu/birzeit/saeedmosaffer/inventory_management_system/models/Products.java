package edu.birzeit.saeedmosaffer.inventory_management_system.models;

public class Products {
    private int productID;
    private String name;
    private String description;
    private double price;
    private int supplierID;
    private String category;

    public Products(int productID, String name, String description, double price, int supplierID, String category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplierID = supplierID;
        this.category = category;
    }

    public Products() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", supplierID=" + supplierID +
                ", category='" + category + '\'' +
                '}';
    }

    public void display() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Supplier ID: " + supplierID);
        System.out.println("Category: " + category);
    }
}
