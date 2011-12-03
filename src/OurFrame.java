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


    public OurFrame() {
        initComponents();
    }

    protected void initComponents() {
        frame = createFrame();
        setLayout(new BorderLayout());
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
      

        JToolBar toolbar = new JToolBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(toolbar, BorderLayout.NORTH);  
        toolbar.add(new JButton("Katalog Osób"));
        Dimension odstep = new Dimension(50,10);
        toolbar.addSeparator(odstep);   
        toolbar.add(new JButton("Katalog Pojazdów"));
        toolbar.addSeparator(odstep);
        toolbar.add(new JButton("Mandaty"));
        toolbar.addSeparator(odstep);
        toolbar.add(new JButton("ZnajdŸ auto"));

        JPanel window = new JPanel();
        window.setBackground(new Color(250,0,0));
        window.setVisible(true);
        frame.add(window);
        
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

        frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);

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
