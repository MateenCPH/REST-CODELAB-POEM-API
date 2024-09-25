package dat;

import dat.config.HibernateConfig;
import dat.controllers.PoemController;
import jakarta.persistence.EntityManagerFactory;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("persons");
    }
}