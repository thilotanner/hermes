package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Dashboard.index;

public class Dashboard extends Controller {

    public static Result index() {
        return ok(index.render());
    }

}