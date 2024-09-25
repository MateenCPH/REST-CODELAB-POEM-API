package dat.controllers;
import dat.config.HibernateConfig;
import dat.daos.PoemDAO;
import dat.dtos.PoemDTO;
import dat.entities.Poem;
import dat.enums.PoemTypes;
import dat.services.PoemService;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.Set;

public class PoemController {
    private final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");
    PoemDAO poemDAO = new PoemDAO(emf);

    public void addPoems(Context ctx){
        ArrayList<PoemDTO> poemDTOs = PoemService.getPoems();
        for (PoemDTO poemDTO : poemDTOs) {
            poemDAO.create(poemDTO);
        }
        ctx.status(201);
        ctx.json(poemDTOs);
    }

    public void updatePoem(Context ctx) {
        Long id = Long.valueOf(ctx.pathParam("id"));
        PoemDTO poemDTO = poemDAO.getById(id);
        poemDTO.setTitle("Updated title");
        poemDTO.setTitle("Updated poem");
        poemDTO.setAuthor("Updated author");

        poemDAO.update(poemDTO);
        ctx.status(204);
        ctx.json(poemDTO);
    }

    public void deletePoem(Context ctx) {
        Long id = Long.valueOf(ctx.pathParam("id"));
        PoemDTO poemDTO = poemDAO.getById(id);
        poemDAO.delete(poemDTO);
        ctx.status(204);
        ctx.json(poemDTO);
    }

    public void getAllPoems(Context ctx){
        Set<PoemDTO> poemDTOs = poemDAO.getAll();
        for (PoemDTO poemDTO : poemDTOs) {
            ctx.json(poemDTO);
        }
        ctx.status(200);
        ctx.json(poemDTOs);
    }

    public void getByID(Context ctx){
        Long id = Long.valueOf(ctx.pathParam("id"));
        PoemDTO poemDTO = poemDAO.getById(id);
        ctx.status(200);
        ctx.json(poemDTO);
    }
}