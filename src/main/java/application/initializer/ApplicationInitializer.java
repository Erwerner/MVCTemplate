package application.initializer;

import application.mvc.ApplicationModel;

public class ApplicationInitializer {
    public ApplicationInitializer(ViewFactory viewFactory, InputFactory inputFactory) {
        ApplicationModel model = new ApplicationModel(inputFactory.getInput());
        viewFactory.makeApllicationView(model);
    }
}
