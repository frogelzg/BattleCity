package frame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import panel.StartPanel;;

public class MainFrame extends JFrame {

	MainFrame() {
		setTitle("Tank War");
		setSize(800, 600);
		setResizable(false);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension d = tool.getScreenSize();
		setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int closeCode = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the Tank War?", "Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (closeCode == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setPanel(new StartPanel(this));
	}
	
	public void setPanel(JPanel p) {
		Container c = this.getContentPane();
		c.removeAll();
		c.add(p);
		c.validate();
	}
}
