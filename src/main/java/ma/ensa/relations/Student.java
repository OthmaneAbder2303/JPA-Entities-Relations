package ma.ensa.relations;

import jakarta.persistence.*;

import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "student_cours",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "cours_id")
//    )
    private List<Cours> cours;

    public Student(){}

    public Student(String nom, String prenom, String email, Addresse adresse, List<Cours> cours) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.cours = cours;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
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
        this.email = email;
    }
    public Addresse getAdresse() {
        return adresse;
    }
    public void setAdresse(Addresse adresse) {
        this.adresse = adresse;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
