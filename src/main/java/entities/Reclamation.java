package entities;

import java.util.regex.Pattern;

public class Reclamation {
    private int id;
    private int clientId;  // Links to the Client
    private String type;
    private String dateIncident;
    private String description;

    public Reclamation(int clientId, String type, String dateIncident, String description) {
        this.clientId = clientId;
        setType(type);
        setDateIncident(dateIncident);
        setDescription(description);
    }

    public Reclamation(int id, int clientId, String type, String dateIncident, String description) {
        this(clientId, type, dateIncident, description);
        this.id = id;
    }

    // Getters and Setters with validation
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getType() { return type; }
    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be empty");
        }
        this.type = type;
    }

    public String getDateIncident() { return dateIncident; }
    public void setDateIncident(String dateIncident) {
        if (Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", dateIncident)) {
            this.dateIncident = dateIncident;
        } else {
            throw new IllegalArgumentException("Date must be in format jj/mm/aaaa");
        }
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", type='" + type + '\'' +
                ", dateIncident='" + dateIncident + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}