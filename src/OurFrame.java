import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OurFrame extends JPanel {
	private static final long serialVersionUID = 1L;

    static {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
    }
 
    private JFrame frame;
    private static JToolBar toolbar;
    public OurFrame() {
    	
        initComponents();
    }

    protected void initComponents() {
        frame = createFrame();
        setLayout(new BorderLayout());
    }

    
    public void addToolbarButton(JButton button){
    	toolbar.add(button);
        Dimension odstep = new Dimension(50,10);
        toolbar.addSeparator(odstep);       	
    }
    
    public void addMyPanel(MyPanel panel){
    	frame.add(panel);   
    	panel.setVisible(true);
    }
    public void removeMyPanel(MyPanel panel){
    	panel.setVisible(false);
    	frame.remove(panel) ; 	
    }
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Policja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        Image iconImage = null;
        try {
            URL imageURL = OurFrame.class.getResource("resources/2899.gif");
            iconImage = ImageIO.read(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setIconImage(iconImage);
 

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu menu = new JMenu("File");
        menu.add("Open");
        menu.add("Save");
        menubar.add(menu);
      

        toolbar = new JToolBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(toolbar, BorderLayout.NORTH);  
        

//        JPanel window = new JPanel();
//        window.setBackground(new Color(250,0,0));
//        window.setVisible(true);
//        frame.add(window);
        
//        JLabel label = new JLabel("Zawartosc");
//        label.setHorizontalAlignment(JLabel.CENTER);
//        label.setPreferredSize(new Dimension(300, 160));
//        label.setBackground(new Color(266, 216, 236));
//        label.setOpaque(true); // labels non-opaque by default
//        frame.add(label);

        JLabel statusLabel = new JLabel("Status Label");
        statusLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
        statusLabel.setHorizontalAlignment(JLabel.LEADING);
        frame.add(statusLabel, BorderLayout.SOUTH);
       	frame.setMinimumSize(new Dimension(640,480));
       
       	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		     // Determine the new location of the window
		     int w = frame.getSize().width;
		     int h = frame.getSize().height;
		     int x = (dim.width-w)/2;
		     int y = (dim.height-h)/2;
		     frame.setLocation(x, y);
		     
      //  frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH); maksymalizuj odrazu
        

        return frame;
    }

    public void start() {
        showFrame();
    }

    public void stop() {
        frame.setVisible(false);
    }

    public void showFrame() {
        if (frame.isShowing()) {
            frame.toFront();
        } else {
            frame.setVisible(true);
        }
    }
}
