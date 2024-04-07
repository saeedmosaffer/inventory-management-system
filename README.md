# inventory-management-system
![image](https://github.com/saeedmosaffer/inventory-management-system/assets/132621749/d637cf43-1544-4518-886f-cac015836533)
![image](https://github.com/saeedmosaffer/inventory-management-system/assets/132621749/a5daae28-8c12-4d51-b45e-019e6ce34a2a)

Products:
Attributes: Product ID, Name, Description, Price, Supplier ID, Category
Explanation: Products are the items managed by the system. They are Products relate to other resources such as Orders (for tracking sales), Suppliers (for managing procurement), and Warehouses (for tracking storage).

Warehouses:
Attributes: Warehouse ID, Name, Location, Capacity, Manager ID
Explanation: Warehouses are physical locations where inventory items are stored.  Warehouses are related to Products (for storing inventory), Orders (for fulfillment), and Suppliers (for receiving goods).

Orders:
Attributes: Order ID, Customer ID, Order Date, Delivery Date, Status, Total Amount, Payment Status
Explanation: Orders represent requests for products made by customers. Orders are related to Products (for the items being ordered), Customers (who place the orders), Warehouses (for fulfillment), and Suppliers (for purchasing inventory).

Suppliers:
Attributes: Supplier ID, Name, Contact Information, Address, Payment Terms
Explanation: Suppliers are external entities ,Suppliers are related to Products (as they provide the inventory), Orders (for purchasing items), and Warehouses (for receiving goods).

[Tables.pdf](https://github.com/saeedmosaffer/inventory-management-system/files/14899315/Tables.pdf)

https://app.swaggerhub.com/apis/SaeedMosaffer/inventory-management-system/1.0.0-oas3.1
