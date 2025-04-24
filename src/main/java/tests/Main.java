package tests;

import entities.Client;
import entities.Reclamation;
import services.ServiceClient;
import services.ServiceReclamation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ServiceClient clientService = new ServiceClient();
        ServiceReclamation reclamationService = new ServiceReclamation();

        try {
            // Create a client (if not exists)
            Client client = new Client(
                    "Smith",
                    "John",
                    "john.smith@example.com",
                    98765432,
                    "20/05/1985",
                    "password123"
            );
            clientService.ajouter(client);

            // Create a reclamation for this client
            Reclamation reclamation = new Reclamation(
                    client.getId(),  // Linking to the client
                    "Service Quality",
                    "15/06/2023",
                    "The service was not as described in the brochure."
            );
            reclamationService.ajouter(reclamation);

            // Get all reclamations for this client
            System.out.println("Reclamations for client " + client.getNom() + ":");
            reclamationService.getByClient(client.getId()).forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}