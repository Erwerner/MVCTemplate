package ui.console;

import application.mvc.ApplicationControllerAccess;
import application.mvc.ApplicationViewAccess;
import helper.IO;
import ui.template.Model;
import ui.template.View;

import java.util.HashMap;

public class ConsoleView implements View {
    private final ApplicationViewAccess model;
    private HashMap<ConsoleControllerType, ConsoleController> controllers;
    private boolean active = true;
    private ConsoleControllerFactory controllerFactory;
    private final GuiFrame guiView;

    public ConsoleView(Model model) {
        this.model = (ApplicationViewAccess) model;
        model.registerView(this);
        initController(model);
        guiView = new GuiFrame((ApplicationViewAccess) model);
        guiView.show();
        run();
    }

    private void run() {
        while (active) {
            ConsoleControllerType controller = (ConsoleControllerType) IO
                    .getEnumFromInput("Choose Command",
                            ConsoleControllerType.values());
            controllers.get(controller).execute();
        }
    }

    private void initController(Model model) {
        controllers = new HashMap<>();
        controllerFactory = new ConsoleControllerFactory();
        controllers.put(ConsoleControllerType.EXIT, initExitController(model));
        controllers.put(ConsoleControllerType.EXEC,
                controllerFactory.initDoController((ApplicationControllerAccess) model));
    }

    private ConsoleController initExitController(Model model) {
        return new ConsoleController((ApplicationControllerAccess) model) {
            @Override
            public void execute() {
                System.out.println("Closing View...");
                guiView.dispose();
                active = false;
            }
        };
    }

    @Override
    public void update() {
        guiView.repaint();
    }

    private ApplicationViewAccess getModel() {
        return (ApplicationViewAccess) model;
    }
}
