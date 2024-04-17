package edu.birzeit.saeedmosaffer.inventory_management_system.models;

public class Suppliers {
    // Suppliers: Attributes: Supplier ID, Name, Contact Information, Address, Payment Terms
    private int supplierID;
    private String name;
    private String contactInformation;
    private String address;
    private String paymentTerms;

    public Suppliers(int supplierID, String name, String contactInformation, String address, String paymentTerms) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
        this.paymentTerms = paymentTerms;
    }

    public Suppliers() {
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", address='" + address + '\'' +
                ", paymentTerms='" + paymentTerms + '\'' +
                '}';
    }
}
