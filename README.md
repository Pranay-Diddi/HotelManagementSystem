# Hotel Management System

## Overview

The Hotel Management System is a simple console-based Java application that allows users to manage room reservations, check-ins, and check-outs in a hotel. The application is designed to be user-friendly and is organized into multiple classes for better modularity and maintainability.

## Features

- **Room Booking:** Guests can book rooms by providing their details and selecting a room type.

  
- **Check-In:** Guests can check in using their reservation ID.

  
- **Check-Out:** Guests can check out using their room number, freeing up the room for future bookings.

  
- **View Reservations:** The system allows viewing all current reservations, including guest details, room numbers, and check-in/check-out dates.

## Project Structure

- **Room.java:** Represents a room in the hotel with attributes such as room number, type, and availability status.
  
- **Reservation.java:** Manages reservations made by guests, including details like guest name, contact information, room number, and check-in/check-out dates.

  
- **Hotel.java:** Contains a list of rooms and reservations, and provides methods for booking rooms, checking in, and checking out.

  
- **HotelManagementSystem.java:** Handles user interactions and the main program flow, allowing the user to book rooms, check-in, check-out, and view reservations.


## Usage
**Book a Room:** Enter guest details and select a room type (Single/Double/Suite).
Specify check-in and check-out dates in yyyy-MM-dd format.


**Check-In:** Provide the reservation ID to check in.


**Check-Out:** Provide the room number to check out.


**View Reservations:** Display all current reservations with detailed information.

## Example:
--- Hotel Management System ---
1. Book a Room
2. Check-In
3. Check-Out
4. View Reservations
5. Exit
Enter your choice: 1

Enter guest name: John Doe

Enter contact info: john@example.com

Enter room type (Single/Double/Suite): Double

Enter check-in date (yyyy-MM-dd): 2024-09-01

Enter check-out date (yyyy-MM-dd): 2024-09-05

Room booked successfully. Reservation ID: 1
