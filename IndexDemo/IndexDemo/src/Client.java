import oui.*;

public class Client {

	public static void main(String[] args) throws Exception {
		DataManager.basedir = args[0]; // Recieves the path of directory to create Data Base
		App app = new App(); // Launches the app
	}
}
