package dat.routes;

import io.javalin.apibuilder.EndpointGroup;
import jakarta.persistence.EntityManagerFactory;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Routes {

    private final PoemRoutes poemRoutes;

    public Routes(EntityManagerFactory emf){
        poemRoutes = new PoemRoutes(emf);
    }

    public EndpointGroup getRoutes() {
        return () -> {
            path("poems", poemRoutes.getRoutes());
        };
    }
}