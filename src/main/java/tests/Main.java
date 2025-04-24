package tests;

import entities.Flight;
import services.ServiceFlight;
import entities.ReservationVol;
import services.ServiceReservationVol;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ServiceFlight serviceFlight = new ServiceFlight();
        ServiceReservationVol serviceReservationVol = new ServiceReservationVol();


        try {
           /* Flight flight = new Flight(
                    150, // flight_duration
                    "AF456", // flight_number
                    150, // available_seats
                    "Tunis", // departure
                    "Rome", // destination
                    "Tunisair", // airline
                    Timestamp.valueOf("2025-07-01 09:30:00"), // arrival_Time
                    Timestamp.valueOf("2025-07-01 07:00:00"), // departure_Time
                    Date.valueOf("2025-07-01"), // flight_date
                    400// price
            );

            // Insertion
            serviceFlight.ajouter(flight);

            Flight modifiedFlight = new Flight(
                    10, // flight_id à modifier
                    90, // flight_duration
                    "AF999", // flight_number
                    120, // available_seats
                    "Paris", // departure
                    "Berlin", // destination
                    "Air France", // airline
                    Timestamp.valueOf("2025-06-01 18:00:00"), // arrival_Time
                    Timestamp.valueOf("2025-06-01 16:30:00"), // departure_Time
                    Date.valueOf("2025-06-01"), // flight_date
                    350.00 // price
            );

            serviceFlight.modifier(modifiedFlight);

            Flight flightToDelete = new Flight(10, 0, "", 0, "", "", "", null, null, null, 0.0);

            // Appeler la méthode supprimer pour supprimer ce vol
            serviceFlight.supprimer(flightToDelete);

            List<Flight> flights = serviceFlight.recuperer();

            // Affichage des vols récupérés
            for (Flight flight : flights) {
                System.out.println("Flight ID: " + flight.getFlight_id());
                System.out.println("Departure: " + flight.getDeparture());
                System.out.println("Destination: " + flight.getDestination());
                System.out.println("Departure Time: " + flight.getDeparture_Time());
                System.out.println("Arrival Time: " + flight.getArrival_Time());
                System.out.println("Flight Date: " + flight.getFlight_date());
                System.out.println("Flight Duration: " + flight.getFlight_duration());
                System.out.println("Flight Number: " + flight.getFlight_number());
                System.out.println("Airline: " + flight.getAirline());
                System.out.println("Available Seats: " + flight.getAvailable_seats());
                System.out.println("Price: " + flight.getPrice());
                System.out.println("-------------------------------------------");
            }

            ReservationVol reservation = new ReservationVol(
                    1, // client_id
                    "Confirmed", // status
                    Date.valueOf("2025-06-01"), // reservationvol_date
                    250.0, // price
                    "John Doe", // passenger_name
                    10 // flight_id
            );

            // Ajouter la réservation à la base de données
            serviceReservationVol.ajouter(reservation);

            /*ReservationVol modifiedReservation = new ReservationVol(
                    1, // reservationvol_id à modifier
                    1, // client_id
                    "Cancelled", // status
                    Date.valueOf("2025-06-05"), // reservationvol_date
                    300.0, // price
                    "Jane Smith", // passenger_name
                    10 // flight_id
            );

            serviceReservationVol.modifier(modifiedReservation);
            ReservationVol reservationToDelete = new ReservationVol(
                    1, // reservationvol_id à supprimer
                    0, // client_id (pas nécessaire pour la suppression)
                    "", // status (pas nécessaire pour la suppression)
                    null, // reservationvol_date (pas nécessaire pour la suppression)
                    0.0, // price (pas nécessaire pour la suppression)
                    "", // passenger_name (pas nécessaire pour la suppression)
                    0  // flight_id (pas nécessaire pour la suppression)
            );

            // Appeler la méthode supprimer pour supprimer la réservation
            serviceReservationVol.supprimer(reservationToDelete);*/

            List<ReservationVol> reservations = serviceReservationVol.recuperer();

            // Affichage des réservations récupérées
            for (ReservationVol res : reservations) {  // Utilisation de 'res' au lieu de 'reservation'
                System.out.println("Reservation ID: " + res.getReservationvol_id());
                System.out.println("Client ID: " + res.getClient_id());
                System.out.println("Flight ID: " + res.getFlight_id());
                System.out.println("Passenger Name: " + res.getPassenger_name());
                System.out.println("Reservation Date: " + res.getReservationvol_date());
                System.out.println("Status: " + res.getStatus());
                System.out.println("Price: " + res.getPrice());
                System.out.println("-------------------------------------------");
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }}
