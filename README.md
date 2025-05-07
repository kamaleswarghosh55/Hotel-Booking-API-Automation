
# Hotel Booking API Test Suite

This project is a complete automated API testing framework for a mock hotel booking system. It validates endpoints such as hotel search, booking creation, booking updates, and more using **Java**, **Rest Assured**, and **TestNG**.

## Features

- Test all core hotel booking endpoints (GET, POST, PATCH)
- Clean, modular test structure with TestNG
- Supports parameterized searches (location, date)
- Easy test execution via Maven
- JSON-server based backend with mock data

## Project Structure

```
hotel-booking-api-tests/
├── pom.xml
├── db.json
├── requirements.sh
└── src/
    └── test/
        └── java/
            └── hotelbooking/
                └── tests/
                    ├── CreateBookingTest.java
                    ├── GetBookingsTest.java
                    ├── GetHotelsTest.java
                    ├── SearchHotelsTest.java
                    └── UpdateBookingTest.java
```

## Prerequisites

- Java 17+
- Maven
- Node.js & npm
- Internet connection for dependency downloads

## Installation & Setup

To set up and run everything with a single command:

1. Clone the repo and `cd` into the folder.
2. Run the provided shell script:

```bash
chmod +x requirements.sh
./requirements.sh
```

This will:
- Install `json-server` locally
- Start the mock API at `http://localhost:3000`
- Launch test cases via `mvn clean test`

## Running Tests

```bash
mvn clean test
```

All test results will be printed in the console. You can explore detailed results in the `target/surefire-reports` folder.

## Mock API Source

The `db.json` file acts as the data backend, simulating:
- Hotels
- Bookings
- Users

## Contact

If you face any issues or have suggestions, feel free to open an issue or connect via LinkedIn.
