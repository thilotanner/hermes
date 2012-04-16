package controllers;

import dao.ConfigurationDAO;
import models.Configuration;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Configurations.*;

import javax.inject.Inject;

public class Configurations extends Controller {

    @Inject
    private static ConfigurationDAO configurationDAO;

    public static Result index() {
        Configuration configuration = new Configuration();
        configuration.name = "Test";
        configurationDAO.save(configuration);
        
        return ok(index.render());
    }

}