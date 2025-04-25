package tests;

import entities.Client;
import entities.Reclamation;
import services.ServiceClient;
import services.ServiceReclamation;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ServiceClient clientService = new ServiceClient();
        Scanner scanner = new Scanner(System.in);

        try {
            // ===== 1. ajout client =====
            /*Client testClient = new Client(
                    "Smith",
                    "John",
                    "john.mortadha@gmail.com", //
                    98765432,
                    "20/05/1985",
                    "password123"
            );

            if (!clientService.emailExists(testClient.getEmail())) {
                clientService.ajouter(testClient);
                System.out.println("Client added ");
            } else {
                System.out.println("Client not added - email already exists!");
            }*/

            // ===== 2. supprimer client =====
            /*System.out.print("\nEnter client ID to delete: ");
            int clientId = scanner.nextInt();

            Client clientToDelete = new Client();
            clientToDelete.setId(clientId);

            clientService.supprimer(clientToDelete);
            System.out.println(" Client " + clientId + " deleted!");
*/
            // === modifier client ===



            /*System.out.print("Enter client ID to modify: ");
            int clientId = scanner.nextInt();
            scanner.nextLine(); // Clear buffer


            Client existingClient = clientService.getById(clientId);
            if (existingClient == null) {
                System.out.println(" Client not found!");
                return;
            }


            System.out.println("\nCurrent client data:");
            System.out.println("1. Last Name: " + existingClient.getNom());
            System.out.println("2. First Name: " + existingClient.getPrenom());
            System.out.println("3. Email: " + existingClient.getEmail());
            System.out.println("4. Phone: " + existingClient.getNumero_telephone());
            System.out.println("5. Birth Date: " + existingClient.getDate_de_naissance());
            System.out.println("6. Password");


            System.out.print("\nEnter field number to update (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            Client updatedClient = new Client(
                    existingClient.getNom(),
                    existingClient.getPrenom(),
                    existingClient.getEmail(),
                    existingClient.getNumero_telephone(),
                    existingClient.getDate_de_naissance(),
                    existingClient.getMot_de_passe()
            );
            updatedClient.setId(clientId);


            System.out.print("Enter new value: ");
            String newValue = scanner.nextLine();

            switch (choice) {
                case 1 -> updatedClient.setNom(newValue);
                case 2 -> updatedClient.setPrenom(newValue);
                case 3 -> {
                    if (clientService.emailExists(newValue) &&
                            !newValue.equals(existingClient.getEmail())) {
                        System.out.println("Email already in use!");
                        return;
                    }
                    updatedClient.setEmail(newValue);
                }
                case 4 -> {
                    try {
                        updatedClient.setNumero_telephone(Integer.parseInt(newValue));
                    } catch (NumberFormatException e) {
                        System.out.println("Phone must be a number!");
                        return;
                    }
                }
                case 5 -> updatedClient.setDate_de_naissance(newValue);
                case 6 -> updatedClient.setMot_de_passe(newValue);
                default -> {
                    System.out.println("Invalid choice!");
                    return;
                }
            }


            clientService.modifier(updatedClient);
            System.out.println("Client updated successfully!");*/

            // === recepuration clients===
            List<Client> clients = clientService.recuperer();


            System.out.println("\n=== CLIENT LIST ===");
            for (Client c : clients) {
                System.out.println(
                        c.getId() + "\t" +
                                c.getNom() + "\t\t" +
                                c.getPrenom() + "\t\t" +
                                c.getEmail() + "\t" +
                                c.getNumero_telephone() + "\t" +
                                c.getDate_de_naissance() + "\t" +
                                c.getMot_de_passe()
                );
            }
            System.out.println("Total clients: " + clients.size());


        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}