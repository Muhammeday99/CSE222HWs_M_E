import java.util.Scanner;

public class main_System {

	public static void main(String[] args) {
		Admin admin = new Admin();
		systemMenus menus = new systemMenus();
		boolean done = false;
		while(!done) {
			done = menus.mainMenu(admin);
		}
	}
	
	

}
