import java.awt.*;

import javax.swing.*;

public class People extends MyPanel{
	private static final long serialVersionUID = 1L;

	People(){
		this.setBackground(new Color(255,0,0));
	      this.setVisible(false);	
	      JLabel label = new JLabel("Zawartosc3");
	      label.setHorizontalAlignment(JLabel.CENTER);
	      label.setPreferredSize(new Dimension(300, 160));
	      label.setBackground(new Color(223, 216, 236));
	      label.setOpaque(true); // labels non-opaque by default
	      this.add(label);
	}
}
