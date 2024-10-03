package dat.routes;

import dat.controllers.PoemController;
import dat.daos.PoemDAO;
import io.javalin.apibuilder.EndpointGroup;
import jakarta.persistence.EntityManagerFactory;

import static io.javalin.apibuilder.ApiBuilder.*;

public class PoemRoutes {

    private final PoemController poemController;

    public PoemRoutes(EntityManagerFactory emf) {
        poemController = new PoemController(new PoemDAO(emf));
    }

    public EndpointGroup getRoutes() {
        return () -> {
            get("/", poemController::getAllPoems);
            get("/{id}", poemController::getByID);
            post("/populateDatabase", poemController::addPoems);
//
//            post(poemController::addDog);
        };
    }
}