package dat.daos;

import dat.entities.Poem;
import dat.exceptions.JpaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.Set;

public class PoemDAO implements IDAO<Poem> {
    EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Person create(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new JpaException("Error creating person: " + e.getMessage());
        }
        return person;
    }


    @Override
    public Poem update(Poem poem) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public Person getById(Long id) {
        return null;
    }

    @Override
    public Set<Person> getAll() {
        return Set.of();
    }
}
