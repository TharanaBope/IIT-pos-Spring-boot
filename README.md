# Point of Sale (POS) System

This is a Point of Sale (POS) system built with **Spring Boot** to manage customers, items, and orders. It provides a RESTful API interface, centralized exception handling, and an interactive API documentation powered by Swagger.

## Features

### Customer Management
- Add, update, retrieve, and delete customer records.
- Fetch customers by active/inactive state.

### Item Management
- Add, update, retrieve, and delete items.
- Filter and paginate items based on their state.

### Order Management
- Place and manage customer orders.
- Fetch order details and manage relationships with customers and items.

### Other Features
- Centralized Exception Handling using `RestControllerAdvice`.
- API documentation with Swagger.
- DTO-based data transfer and validation.
- ModelMapper for entity-to-DTO conversions.

## Technologies Used

- **Spring Boot** - Framework for RESTful API development.
- **JPA (Hibernate)** - ORM for database interactions.
- **Swagger** - API documentation.
- **Lombok** - Simplifies boilerplate code.
- **JUnit** - Unit testing framework.
- **ModelMapper** - Simplified object mapping.

---

## Project Structure

### Controllers
- `CustomerController.java`
- `ItemController.java`
- `OrderController.java`
- `TestController.java` (for testing and basic responses)

### Services
- `CustomerService.java` and `CustomerServiceImpl.java`
- `ItemService.java` and `ItemServiceImpl.java`
- `OrderService.java` and `OrderServiceImpl.java`

### Repositories
- `CustomerRepo.java`
- `ItemRepo.java`
- `OrderRepo.java`
- `OrderDetailsRepo.java`

### Entities
- `Customer.java`
- `Item.java`
- `Orders.java`
- `OrderDetails.java`

### DTOs
- Request DTOs:
  - `CustomerSaveRequestDTO.java`
  - `ItemSaveRequestDTO.java`
  - `OrderSaveRequestDTO.java`
- Response DTOs:
  - `CustomerResposeDTO.java`
  - `ItemResponseDTO.java`
  - `PaginatedResponseItemDTO.java`

### Utilities
- `MeasuringType.java` (enum for item measurement types)
- `StandardResponse.java` (standardized API responses)

---

## Installation

### Prerequisites
1. Java 11 or later.
2. Maven for dependency management.
3. MySQL database.

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-name>

## Update the `application.properties` File

Update your database credentials in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pos_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

## Build the Project

Use Maven to build the project:

```bash
mvn clean install


Use Maven to build the project:

```bash
mvn clean install


## Key Endpoints

### Customer Endpoints
- **POST** `/api/v1/customer/save-customer`: Add a new customer.
- **PUT** `/api/v1/customer/update-customer`: Update customer details.
- **GET** `/api/v1/customer/get-customer-customerId`: Get customer by ID.
- **GET** `/api/v1/customer/get-all-customers`: Retrieve all customers.
- **GET** `/api/v1/customer/get-all-customer-bt-sate`: Retrieve customers by state.
- **DELETE** `/api/v1/customer/delete-customer/{id}`: Delete customer by ID.

### Item Endpoints
- **POST** `/api/v1/item/save-item`: Add a new item.
- **PUT** `/api/v1/item/update-item`: Update item details.
- **GET** `/api/v1/item/get-item-by-name`: Get items by name.
- **GET** `/api/v1/item/get-all-items`: Retrieve all items.
- **GET** `/api/v1/item/get-all-items-by-state`: Retrieve paginated items by state.
- **DELETE** `/api/v1/item/delete-item/{id}`: Delete item by ID.

### Order Endpoints
- **POST** `/api/v1/order/save-order`: Place an order.

---

## Exception Handling

Custom exception classes and centralized handling ensure consistent and user-friendly error messages.

### Key Exception
- **NotFoundException**: Used when requested resources are not found.


