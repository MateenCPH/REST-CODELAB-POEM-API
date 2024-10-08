package dat;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat.config.HibernateConfig;
import dat.config.ApplicationConfig;
import dat.controllers.PoemController;
import dat.dtos.PoemDTO;
import dat.services.JsonFileReader;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.Javalin;

    public class Main {
        private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");

        public static void main(String[] args) {
            ApplicationConfig.startServer(7070, emf);
        }

//    public static void main(String[] args) {
//        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("poems");
//        PoemDTO poemDTO = new PoemDTO();
//        PoemController poemController = new PoemController();
//
//        var app = Javalin.create((config) -> {
//            config.router.contextPath = "/api";
//            config.bundledPlugins.enableRouteOverview("/routes");
//        });
//
//        app.get("/", ctx -> ctx.result("Hello Javalin"));
//
//        //Create poems from JSON file
//        app.post("/poem", ctx -> poemController.addPoems(ctx));
//
//        // GET All poems from database
//        app.get("/poems", ctx -> poemController.getAllPoems(ctx));
//
//        // PUT/UPDATE a poem
//        app.put("/poem/{id}", ctx -> poemController.updatePoem(ctx));
//
//        // DELETE a poem
//        app.delete("/poem/{id}", ctx -> poemController.deletePoem(ctx));
//
//        // GET A specific poem from ID
//        app.get("/poem/{id}", ctx -> poemController.getByID(ctx));
//
//        app.start(7000);
//    }
}