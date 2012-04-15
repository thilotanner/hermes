package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Configurations.index;

public class Configurations extends Controller {

    public static Result index() {
        return ok(index.render());
    }

}