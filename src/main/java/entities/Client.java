package entities;

import java.util.regex.Pattern;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int numero_telephone;
    private String date_de_naissance;
    private String mot_de_passe;

    public Client(int id, String nom, String prenom, String email, int numero_telephone, String date_de_naissance, String mot_de_passe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        setEmail(email);
        setNumero_telephone(numero_telephone);
        setDate_de_naissance(date_de_naissance);
        this.mot_de_passe = mot_de_passe;
    }

    public Client(String nom, String prenom, String email, int numero_telephone, String date_de_naissance, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        setEmail(email);
        setNumero_telephone(numero_telephone);
        setDate_de_naissance(date_de_naissance);
        this.mot_de_passe = mot_de_passe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must contain '@'");
        }
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(int numero_telephone) {
        if (String.valueOf(numero_telephone).length() == 8) {
            this.numero_telephone = numero_telephone;
        } else {
            throw new IllegalArgumentException("Phone number must be 8 digits");
        }
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        if (Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", date_de_naissance)) {
            this.date_de_naissance = date_de_naissance;
        } else {
            throw new IllegalArgumentException("Date must be in format jj/mm/aaaa");
        }
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", numero_telephone=" + numero_telephone +
                ", date_de_naissance='" + date_de_naissance + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                '}';
    }
}