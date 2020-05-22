package ui.console;

import java.awt.Graphics;
import java.awt.Label;

import javax.swing.JFrame;

import application.mvc.ApplicationViewAccess;

@SuppressWarnings("serial")
public class GuiFrame extends JFrame {
	private ApplicationViewAccess model;
	private Label textfield;

	public GuiFrame(ApplicationViewAccess model) {
		this.model = model;
		setSize(200, 250);
		textfield = new Label();
		setAlwaysOnTop(true);
		add(textfield);
	}

	@Override
	public void paint(Graphics arg0) {
		textfield.setText(model.getValue());
		super.paint(arg0);
	}
}
