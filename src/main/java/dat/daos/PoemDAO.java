package dat.daos;

import dat.config.HibernateConfig;
import dat.dtos.PoemDTO;
import dat.entities.Poem;
import dat.enums.PoemTypes;
import dat.services.PoemService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EnumType;
import jakarta.persistence.PersistenceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PoemDAO implements IDAO<PoemDTO> {

    private final EntityManagerFactory emf;

    public PoemDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PoemDTO create(PoemDTO poemDTO) {
        Poem poem = new Poem(poemDTO);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(poem);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Error while saving poem " + e.getMessage());
            e.printStackTrace();
        }
        return new PoemDTO(poem);
    }

    @Override
    public PoemDTO update(PoemDTO poemDTO) {
        Poem poem = new Poem(poemDTO);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Poem foundPoem = em.find(Poem.class, poem.getId());

            if (poem.getType() != null) {
                foundPoem.setType(poem.getType());
            }
            if (poem.getTitle() != null) {
                foundPoem.setTitle(poem.getTitle());
            }
            if (poem.getPoem() != null) {
                foundPoem.setPoem(poem.getPoem());
            }
            if (poem.getAuthor() != null) {
                foundPoem.setAuthor(poem.getAuthor());
            }
            em.getTransaction().commit();
            return new PoemDTO(foundPoem);
        }
    }

    @Override
    public void delete(PoemDTO poemDTO) {
        Poem poem = new Poem(poemDTO);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Poem foundPoem = em.find(Poem.class, poem.getId());
            em.remove(foundPoem);
            em.getTransaction().commit();
            em.close();
        } catch (PersistenceException e) {
            System.out.println("Error while deleting poem " + e);
            e.printStackTrace();
        }
    }

    @Override
    public PoemDTO getById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            Poem poem = em.find(Poem.class, id);
            return new PoemDTO(poem);
        } catch (PersistenceException e) {
            System.out.println("Error while getting poem by id " + e);
            return null;
        }
    }

    @Override
    public Set<PoemDTO> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Poem> poems = em.createQuery("SELECT p FROM Poem p", Poem.class).getResultList();

            Set<PoemDTO> poemDTOs = poems.stream()
                    .map(PoemDTO::new)
                    .collect(Collectors.toSet());
            return poemDTOs;
        } catch (PersistenceException e) {
            System.out.println("Error while fetching poems " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}