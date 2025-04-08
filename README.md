# Hotel Reservation System

This project implements a **Hotel Reservation System** using **Spring Boot**. It allows users to manage hotels, make reservations, and retrieve reservation details. The system is designed to be flexible and extendable for future enhancements.
# Developed By
- **Sukanta Dey Amit**
- **A00483108**
  
## Features

- **Hotel Management**: Add, delete, and fetch hotel details.
- **Reservation System**: Create reservations, including guest details, check-in/check-out dates, and hotel selection.
- **Reservation Confirmation**: Retrieve reservation details by a unique confirmation ID.

## Technologies Used

- **Spring Boot** for the backend framework
- **JPA** for database interactions
- **MySQL** (or any relational database) for data storage
- **RESTful APIs** for communication

## Setup Instructions

### Prerequisites

Make sure you have the following installed on your local machine:
- [Java 11 or later](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [Postman](https://www.postman.com/) (Optional for testing APIs)

### Clone the Repository

Clone the project from GitHub:

```bash
git clone https://github.com/A00483108/HotelProject.git
cd hotel-reservation-system
```
### App URL 
http://localhost:8081

## API Endpoints
### 1. Hotels**
- **Get All Hotels**
GET /api/hotels
Fetch all hotels from the system.

- **Get Hotel by ID**
GET /api/hotels/{id}
Fetch details of a specific hotel by ID.

- **Get Hotels by Location**
GET /api/hotels/location/{location}
Fetch hotels based on location.

- **Add New Hotel**
POST /api/hotels
Add a new hotel. Example request body:
```bash
{
  "hotelName": "Grand Hotel",
  "location": "New York",
  "price": 150,
  "availability": true
}
```
- **Delete Hotel by ID**
DELETE /api/hotels/{id}
Delete a hotel by ID.

### 2. Reservations**
- **Create Reservation**
POST /api/reservations
Create a new reservation. Example request body:
```bash
{
  "hotelId": 1,
  "checkin": "2025-04-10",
  "checkout": "2025-04-15",
  "guestsList": [
    {
      "guestName": "John Doe",
      "gender": "Male"
    }
  ]
}
```

- **Get Reservation by Confirmation ID**
GET /api/reservations/confirmation/{confirmationId}
Fetch a reservation by confirmation ID.

# Screenshots
## GET Hotel Data
![GET /api/hotels](src/main/resources/static/HotelGet.PNG)

## POST Hotel Data
![GET /api/hotels](src/main/resources/static/HotelPost.PNG)

## POST Reservation Data
![GET /api/hotels](src/main/resources/static/Reservation-1.PNG)
