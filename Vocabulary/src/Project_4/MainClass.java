package Project_4;

public class MainClass {

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();
		SubPanelFrame sub = new SubPanelFrame(frame);
		MainPanelFrame main = new MainPanelFrame(frame);
		MenuBarFrame menu = new MenuBarFrame(frame);


	}

}
