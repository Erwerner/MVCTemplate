package ui.console;

import ui.template.Model;

public class ConsoleControllerFactory {
	public ConsoleController initDoController(Model model) {
		return new ConsoleController(model) {
			@Override
			public void execute() {
				getModel().execute();
			}
		};
	}
}
