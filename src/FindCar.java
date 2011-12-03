import javax.swing.JLabel;
import java.awt.*;

public class FindCar extends MyPanel{
	private static final long serialVersionUID = 1L;
	
	FindCar(){
		this.setBackground(new Color(154,250,100));
		this.setVisible(false);	
	    JLabel label = new JLabel("Zawartosc4");
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setPreferredSize(new Dimension(300, 160));
	    label.setBackground(new Color(223, 216, 236));
	    label.setOpaque(true); // labels non-opaque by default
	    this.add(label);
	}

}
