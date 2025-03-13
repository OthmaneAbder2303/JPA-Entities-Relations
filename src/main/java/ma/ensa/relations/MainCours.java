package ma.ensa.relations;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class MainCours {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("coursPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Addresse adresse1 = new Addresse("Maroc", "Marrakech", "Massira 2", "40000", "0576546371");
        Addresse adresse2 = new Addresse("France", "Paris", "Avenue des Champs", "75000", "0524433221");
        Addresse adresse3 = new Addresse("Maroc", "Marrakech", "Mhammid", "40100", "0524433221");

        Cours cours1 = new Cours("Web 2.0", "Angular");
        Cours cours2 = new Cours("JEE", "Programmation en Java");

        Student student1 = new Student("Othmane", "Abderrazik", "othmane@gmail.com", adresse1, Arrays.asList(cours1, cours2));
        Student student2 = new Student("Ali", "Ayougil", "zaki@gmail.com", adresse2, Arrays.asList(cours1));
        Student student3 = new Student("Moha", "Eilo", "eilo@gmail.com", adresse3, Arrays.asList(cours2));

        adresse1.setStudent(student1);
        adresse2.setStudent(student2);
        adresse3.setStudent(student3);

        cours1.setStudent(Arrays.asList(student1, student2));
        cours2.setStudent(Arrays.asList(student1, student3));

        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(adresse3);

        em.persist(cours1);
        em.persist(cours2);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);

        em.getTransaction().commit();

        // Research of a student
        Student foundStudent = em.find(Student.class, student1.getId());
        System.out.println("Étudiant trouvé : " + foundStudent.getNom() + " " + foundStudent.getPrenom());

        // Mise à jour
        em.getTransaction().begin();
        foundStudent.setEmail("othmane_new@gmail.com");
        em.merge(foundStudent);
        em.getTransaction().commit();

        // Récupération
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println("Liste des étudiants :");
        students.forEach(s -> System.out.println(s.getNom() + " " + s.getPrenom()));

        // Suppression
        em.getTransaction().begin();
        Student toDelete = em.find(Student.class, student2.getId());
        em.remove(toDelete);
        em.getTransaction().commit();
        System.out.println("Étudiant supprimé avec succès.");

        em.close();
        emf.close();
    }
}


