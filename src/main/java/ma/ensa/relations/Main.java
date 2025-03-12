package ma.ensa.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Addresse adresse = new Addresse();
        adresse.setPays("Maroc");
        adresse.setVille("Marrakech");
        adresse.setRue("Rue Mohammed V");
        adresse.setCodePostal("40000");
        adresse.setFax("0524433221");

        Student student = new Student();
        student.setNom("Othmane");
        student.setPrenom("Abderrazik");
        student.setEmail("othmane@gmail.com");
        student.setAdresse(adresse);

        em.persist(adresse);
        em.persist(student);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

