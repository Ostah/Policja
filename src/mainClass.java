import javax.swing.*;
import java.awt.event.*;
import javax.swing.UIManager.*;

public class MainClass implements ActionListener{
	public final static int HOW_MANY_MODULES = 4; // ile mamy "okienek" ;
	public static String mSQLLogin="";
	public static String mSQLPassword="";
	ACTIVE_MENU mActiveMenu;
	MyPanel mPanels[] = new MyPanel[HOW_MANY_MODULES];
	JButton mButtons[] = new JButton[HOW_MANY_MODULES];
	static OurFrame mFrame;
	
	MainClass() {
		setLookAndFeel();
		mActiveMenu=ACTIVE_MENU.PEOPLE;
		mPanels[ACTIVE_MENU.PEOPLE.g()] = new People();
		mPanels[ACTIVE_MENU.CARS.g()] = new Cars();
		mPanels[ACTIVE_MENU.TICKETS.g()] = new Tickets();
		mPanels[ACTIVE_MENU.FIND_CAR.g()] = new FindCar();

		mButtons[ACTIVE_MENU.PEOPLE.g()] = new JButton("Katalog Osób");
		mButtons[ACTIVE_MENU.CARS.g()] = new JButton("Katalog Pojazdów");
		mButtons[ACTIVE_MENU.TICKETS.g()] = new JButton("Mandaty");
		mButtons[ACTIVE_MENU.FIND_CAR.g()] = new JButton("ZnajdŸ auto");
			
		mFrame = new OurFrame();
		mFrame.initComponents();
		
		for(int i=0;i<HOW_MANY_MODULES;i++){
			mButtons[i].setActionCommand(ACTIVE_MENU.values()[i].toString());
			mButtons[i].addActionListener(this);
			mFrame.addToolbarButton(mButtons[i]);
		}
		mFrame.addMyPanel(mPanels[0]);

	}
	
	public static void main(String[] args) {	
		@SuppressWarnings("unused")
		MainClass mMain = new MainClass();
		  mFrame.setVisible(true);
		  mFrame.start();	
	}

	
	public void actionPerformed(ActionEvent arg0) {	
		for(int i=0;i<HOW_MANY_MODULES;i++){		
			mFrame.removeMyPanel(mPanels[mActiveMenu.g()]);
		}
		mActiveMenu = ACTIVE_MENU.valueOf(arg0.getActionCommand());
		mFrame.addMyPanel(mPanels[mActiveMenu.g()]);		
	}
	
	private static void setLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		}catch (Exception e){
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
	

}
