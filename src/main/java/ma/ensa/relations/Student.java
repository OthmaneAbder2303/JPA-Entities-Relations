package ma.ensa.relations;

import jakarta.persistence.*;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Addresse adresse;

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
        this.email = email;
    }

    public Addresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Addresse adresse) {
        this.adresse = adresse;
    }

    public Student(){}

    public Student(Long id, String nom, String prenom, String email, Addresse Adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = Adresse;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
