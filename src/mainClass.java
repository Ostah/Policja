import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;

public class MainClass implements ActionListener{

	public enum ACTIVE_MENU {
		    PEOPLE(0),
		    CARS(1),
		    TICKETS(2),
		    FIND_CAR(3);
		    
		    private final int index;
		    ACTIVE_MENU(int index) {
		      this.index = index;
		    }
		    
		    //get
		    int g(){
		    	return index;
		    }
		    
		  
	}
	public final static int HOW_MANY_MODULES = 4; // ile mamy "okienek" 
	ACTIVE_MENU mActiveMenu;
	MyPanel mPanels[] = new MyPanel[HOW_MANY_MODULES];
	JButton mButtons[] = new JButton[HOW_MANY_MODULES];
	static OurFrame mFrame;

	MainClass(){
		setLookAndFeel();
		mActiveMenu=ACTIVE_MENU.PEOPLE;
		mPanels[ACTIVE_MENU.PEOPLE.g()] = new People();
		mPanels[ACTIVE_MENU.CARS.g()] = new Cars();
		mPanels[ACTIVE_MENU.TICKETS.g()] = new Cars();
		mPanels[ACTIVE_MENU.FIND_CAR.g()] = new Cars();

		mButtons[ACTIVE_MENU.PEOPLE.g()] = new JButton("Katalog Osób");
		mButtons[ACTIVE_MENU.CARS.g()] = new JButton("Katalog Pojazdów");
		mButtons[ACTIVE_MENU.TICKETS.g()] = new JButton("Mandaty");
		mButtons[ACTIVE_MENU.FIND_CAR.g()] = new JButton("ZnajdŸ auto");
			
		mFrame = new OurFrame();
		mFrame.initComponents();
		
		for(int i=0;i<HOW_MANY_MODULES;i++){
			mButtons[i].setActionCommand(ACTIVE_MENU.values()[i].toString());
			mButtons[i].addActionListener(this);
			mFrame.addMyPanel(mPanels[i]);
			mFrame.addToolbarButton(mButtons[i]);
		}
		mPanels[0].setVisible(true);
	}
	
	public static void main(String[] args) {
		
		MainClass mMain = new MainClass();
		
		  mFrame.setVisible(true);
		  mFrame.start();
		
	}

	

	public void actionPerformed(ActionEvent arg0) {
		
		for(int i=0;i<HOW_MANY_MODULES;i++){
			mPanels[i].setVisible(false);
			System.out.println("Hide: " + i);
		}
		mActiveMenu = ACTIVE_MENU.valueOf(arg0.getActionCommand());
		System.out.println("show: " + mActiveMenu.g());
		mPanels[mActiveMenu.g()].setVisible(true);
		
		
	}
	
	private static void setLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}

}
