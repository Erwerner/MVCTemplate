package ui.console;

import helper.IO;

import java.util.HashMap;

import ui.template.Model;
import ui.template.View;
import application.mvc.ApplicationViewAccess;

public class ConsoleView extends View {
	private HashMap<ConsoleControllerType, ConsoleController> controllers;
	private boolean active = true;
	private ConsoleControllerFactory controllerFactory;

	public ConsoleView(Model model) {
		super(model);
		run();
	}

	private void run() {
		while (active) {
			ConsoleControllerType controller = (ConsoleControllerType) IO.getEnumFromInput("Choose Controller", ConsoleControllerType.values());
			controllers.get(controller).execute();
		}
	}

	@Override
	protected void initController() {
		controllers = new HashMap<>();
		controllerFactory = new ConsoleControllerFactory();
		controllers.put(ConsoleControllerType.EXIT, initExitController());
		controllers.put(ConsoleControllerType.EXEC,
				controllerFactory.initDoController(model));
	}

	private ConsoleController initExitController() {
		return new ConsoleController(model) {
			@Override
			public void execute() {
				System.out.println("Closing View...");
				active = false;
			}
		};
	}

	@Override
	public void update() {
		System.out.println(getModel().getValue());
	}

	private ApplicationViewAccess getModel() {
		return (ApplicationViewAccess) model;
	}
}
