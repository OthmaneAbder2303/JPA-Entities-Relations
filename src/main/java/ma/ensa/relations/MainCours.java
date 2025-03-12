package ma.ensa.relations;

import jakarta.persistence.*;

import java.util.Arrays;

public class MainCours {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("coursPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Addresse adresse1 = new Addresse("Maroc", "Marrakech", "Rue 123", "40000", "0524433221");
        Addresse adresse2 = new Addresse("France", "Paris", "Avenue des Champs", "75000", "0524433221");

        Cours cours1 = new Cours("Mathématiques", "Cours avancé de maths");
        Cours cours2 = new Cours("Informatique", "Programmation en Java");

        Student student1 = new Student("Othmane", "Abderrazik", "othmane@gmail.com", adresse1, Arrays.asList(cours1, cours2));
        Student student2 = new Student("Ali", "Ayougil", "zaki@gmail.com", adresse2, Arrays.asList(cours1));

        adresse1.setStudent(student1);
        adresse2.setStudent(student2);

        cours1.setStudent(Arrays.asList(student1, student2));
        cours2.setStudent(Arrays.asList(student1));

        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(cours1);
        em.persist(cours2);
        em.persist(student1);
        em.persist(student2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}


