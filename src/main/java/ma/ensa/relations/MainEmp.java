package ma.ensa.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employe chef = new Employe("El Mehdi", "Biba", "Rabat", "mehdi@gmail.com", null);
        em.persist(chef);

        Employe employe1 = new Employe("Othmane", "Abderrazik", "Marrakech", "othmane@gmail.com", chef);
        Employe employe2 = new Employe("Zakriae", "Ayougil", "Sraghna", "zaki@gmail.com", chef);

        em.persist(employe1);
        em.persist(employe2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

