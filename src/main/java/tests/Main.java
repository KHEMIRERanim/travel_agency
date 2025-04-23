package tests;

import entities.Flight;
import entities.Client;
import services.ServiceFlight;
import services.ServiceClient;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ServiceFlight serviceFlight = new ServiceFlight();

        ServiceClient serviceClient = new ServiceClient();

        System.out.println("Hello World!");

        try {
            Client newClient = new Client(
                    "Doe",
                    "John",
                    "john.doe@example.com",
                    12345678,
                    "15/01/1990",
                    "securePassword123"
            );

            serviceClient.ajouter(newClient);
            System.out.println("Client added successfully!");

            System.out.println("All clients:");
            serviceClient.recuperer().forEach(client ->
                    System.out.println(client.getNom() + " " + client.getPrenom())
            );

        } catch (SQLException e) {
            System.err.println("Error working with Client: " + e.getMessage());
        }
    }
}