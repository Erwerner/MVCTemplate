package application.mvc;

import application.core.ApplicationData;
import application.initializer.InputFactory;
import application.service.ApplicationService;
import ui.template.Model;

public class ApplicationModel extends Model implements ApplicationControllerAccess, ApplicationViewAccess {
    private final ApplicationData data;
    private final ApplicationService service;

    public ApplicationModel(InputFactory inputFactory) {
        data = new ApplicationData();
        service = new ApplicationService(inputFactory);
    }

    //View
    @Override
    public boolean getValue() {
        return data.getValue();
    }

    //Controller
    @Override
    public void execute() {
        service.execute(data);
        notifyViews();
    }

}
