package ui.console;

import ui.template.Controller;
import ui.template.Model;
import application.mvc.ApplicationControllerAccess;

public abstract class ConsoleController extends Controller {

    public ConsoleController(Model model) {
        super(model);
    }

    public abstract void execute();

    protected ApplicationControllerAccess getModel() {
        return (ApplicationControllerAccess) this.model;
    }
}
