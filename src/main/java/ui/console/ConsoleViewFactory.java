package ui.console;

import application.initializer.ViewFactory;
import application.mvc.ApplicationModel;

public class ConsoleViewFactory extends ViewFactory {
    @Override
    public void makeApllicationView(ApplicationModel model) {
        new ConsoleView(model);
    }
}
