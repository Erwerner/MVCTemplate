package application.service;

import application.core.ApplicationData;
import application.initializer.InputFactory;

public class ApplicationService {
    private final ApplicationInput input;

    public ApplicationService(InputFactory inputFactory) {
        input = inputFactory.getInput();
    }

    public void execute(ApplicationData data) {
        data.setValue(input.readValue());
    }
}
