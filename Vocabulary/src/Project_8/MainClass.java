package Project_8;

public class MainClass {

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();
		
		DataClass data = new DataClass(frame);
		UserInforClass infor = new UserInforClass(data);
		EditClass edit = new EditClass(data);

		SubPanelFrame sub = new SubPanelFrame(data, frame);
		MainPanelFrame main = new MainPanelFrame(data, frame);

	}
}
