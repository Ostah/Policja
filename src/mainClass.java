import javax.swing.JPanel;

public class mainClass {

	public enum ACTIVE_MENU {
		    PEOPLE(0),
		    CARS(1),
		    TICKETS(2),
		    FIND_CAR(3);
		    
		    private final int index;
		    ACTIVE_MENU(int index) {
		      this.index = index;
		    }
		    
		    int g(){
		    	return index;
		    }
	}

	ACTIVE_MENU mActiveMenu;
	MyPanel mPanels[] = new MyPanel[4];
	
	
	mainClass(){
		mActiveMenu=ACTIVE_MENU.PEOPLE;
		mPanels[ACTIVE_MENU.PEOPLE.g()] = new People();
		mPanels[ACTIVE_MENU.CARS.g()] = new Cars();
		mPanels[ACTIVE_MENU.TICKETS.g()] = new Cars();
		mPanels[ACTIVE_MENU.FIND_CAR.g()] = new Cars();
		
	}
	
	public static void main(String[] args) {

		
			System.out.print(ACTIVE_MENU.FIND_CAR.g());
		  OurFrame frame = new OurFrame();
		  frame.setVisible(true);
		  frame.start();
	}

}
