package services;

import entities.Flight;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceFlight implements IService<Flight> {
    private Connection con;

    public ServiceFlight() {
        con = MyDatabase.getInstance().getCnx();

    }
    @Override
    public void ajouter(Flight flight) throws SQLException {
        String req = "INSERT INTO flight (flight_number, departure, destination, departure_time, arrival_time, flight_date, flight_duration, available_seats, airline, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setString(1, flight.getFlight_number());
        ps.setString(2, flight.getDeparture());
        ps.setString(3, flight.getDestination());
        ps.setTimestamp(4, flight.getDeparture_Time());
        ps.setTimestamp(5, flight.getArrival_Time());
        ps.setDate(6, flight.getFlight_date());
        ps.setInt(7, flight.getFlight_duration());
        ps.setInt(8, flight.getAvailable_seats());
        ps.setString(9, flight.getAirline());
        ps.setDouble(10, flight.getPrice());

        ps.executeUpdate();
        System.out.println("vol ajouté");
    }


    @Override
    public void modifier(Flight flight) throws SQLException {
        String req = "UPDATE flight SET flight_number=?, departure=?, destination=?, " +
                "departure_time=?, arrival_time=?, flight_date=?, flight_duration=?, " +
                "available_seats=?, airline=?, price=? WHERE flight_id=?";
        PreparedStatement ps = con.prepareStatement(req);

        ps.setString(1, flight.getFlight_number());
        ps.setString(2, flight.getDeparture());
        ps.setString(3, flight.getDestination());
        ps.setTimestamp(4, flight.getDeparture_Time());
        ps.setTimestamp(5, flight.getArrival_Time());
        ps.setDate(6, new java.sql.Date(flight.getFlight_date().getTime()));
        ps.setInt(7, flight.getFlight_duration());
        ps.setInt(8, flight.getAvailable_seats());
        ps.setString(9, flight.getAirline());
        ps.setDouble(10, flight.getPrice());
        ps.setInt(11, flight.getFlight_id());

        ps.executeUpdate();
        System.out.println("Vol modifié");
    }



    @Override
    public void supprimer(Flight flight) throws SQLException {
        String req = "DELETE FROM flight WHERE flight_id=?";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, flight.getFlight_id());
        ps.executeUpdate();
        System.out.println("Vol supprimé");
    }


    @Override
    public List<Flight> recuperer() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String req = "SELECT * FROM flight"; // Récupérer tous les vols de la table flight
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            int flight_id = rs.getInt("flight_id");
            String flight_number = rs.getString("flight_number");
            String departure = rs.getString("departure");
            String destination = rs.getString("destination");
            Timestamp departure_time = rs.getTimestamp("departure_time");
            Timestamp arrival_time = rs.getTimestamp("arrival_time");
            Date flight_date = rs.getDate("flight_date");
            int flight_duration = rs.getInt("flight_duration");
            int available_seats = rs.getInt("available_seats");
            String airline = rs.getString("airline");
            double price = rs.getDouble("price");

            // Création de l'objet Flight avec les données récupérées
            Flight flight = new Flight(flight_id, flight_duration, flight_number, available_seats,
                    departure, destination, airline, departure_time, arrival_time, flight_date, price);

            flights.add(flight); // Ajout du vol à la liste
        }

        return flights;
    }

}
