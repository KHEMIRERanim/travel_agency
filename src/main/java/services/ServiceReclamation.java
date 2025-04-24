package services;

import entities.Reclamation;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceReclamation implements IService<Reclamation> {
    private Connection cnx;

    public ServiceReclamation() {
        cnx = MyDatabase.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reclamation reclamation) throws SQLException {
        String req = "INSERT INTO reclamation (client_id, type, date_incident, description) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, reclamation.getClientId());
        ps.setString(2, reclamation.getType());
        ps.setString(3, reclamation.getDateIncident());
        ps.setString(4, reclamation.getDescription());

        ps.executeUpdate();

        // Get the generated ID
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            reclamation.setId(rs.getInt(1));
        }
    }

    @Override
    public void modifier(Reclamation reclamation) throws SQLException {
        String req = "UPDATE reclamation SET type=?, date_incident=?, description=? WHERE id=?";
        PreparedStatement ps = cnx.prepareStatement(req);

        ps.setString(1, reclamation.getType());
        ps.setString(2, reclamation.getDateIncident());
        ps.setString(3, reclamation.getDescription());
        ps.setInt(4, reclamation.getId());

        ps.executeUpdate();
    }

    @Override
    public void supprimer(Reclamation reclamation) throws SQLException {
        String req = "DELETE FROM reclamation WHERE id=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, reclamation.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Reclamation> recuperer() throws SQLException {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT * FROM reclamation";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            Reclamation r = new Reclamation(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("type"),
                    rs.getString("date_incident"),
                    rs.getString("description")
            );
            reclamations.add(r);
        }
        return reclamations;
    }

    // Additional method to get reclamations by client
    public List<Reclamation> getByClient(int clientId) throws SQLException {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT * FROM reclamation WHERE client_id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, clientId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Reclamation r = new Reclamation(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("type"),
                    rs.getString("date_incident"),
                    rs.getString("description")
            );
            reclamations.add(r);
        }
        return reclamations;
    }
}