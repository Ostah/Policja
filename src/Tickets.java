import java.awt.*;

import javax.swing.*;
public class Tickets extends MyPanel{
	private static final long serialVersionUID = 1L;

	Tickets(){
		this.setBackground(new Color(111,111,255));
	      this.setVisible(false);	
	      JLabel label = new JLabel("Zawartosc 3");
	      label.setHorizontalAlignment(JLabel.CENTER);
	      label.setPreferredSize(new Dimension(300, 160));
	      label.setBackground(new Color(223, 216, 236));
	      label.setOpaque(true); // labels non-opaque by default
	      this.add(label);
	}
}
