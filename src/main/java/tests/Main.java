package tests;

import entities.Client;
import services.ServiceClient;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ServiceClient serviceClient = new ServiceClient();

        System.out.println("Travel Agency Client Management");

        try {
            // Example Client usage
            Client newClient = new Client(
                    "Doe",
                    "John",
                    "john.doe@example.com",
                    12345678,
                    "15/01/1990",
                    "securePassword123"
            );

            // Add client to database
            serviceClient.ajouter(newClient);
            System.out.println("Client added successfully!");

            // Retrieve all clients
            System.out.println("\nAll registered clients:");
            serviceClient.recuperer().forEach(client ->
                    System.out.println("- " + client.getPrenom() + " " + client.getNom())
            );

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}