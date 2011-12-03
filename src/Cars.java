import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
public class Cars extends MyPanel {
	private static final long serialVersionUID = 1L;

	Cars(){
      this.setBackground(new Color(250,0,0));
      
      this.setVisible(false);
      JLabel label = new JLabel("Zawartosc");
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setPreferredSize(new Dimension(300, 160));
      label.setBackground(new Color(223, 216, 236));
      label.setOpaque(true); // labels non-opaque by default
      this.add(label);
      
	}
}
