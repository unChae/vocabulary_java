package Project_7;

public class MainClass {

	public static void main(String[] args) {

		DataClass data = new DataClass();
		UserInforClass infor = new UserInforClass(data);
		
		MainFrame frame = new MainFrame();
		SubPanelFrame sub = new SubPanelFrame(frame);
		MainPanelFrame main = new MainPanelFrame(frame);
	
	}
}
