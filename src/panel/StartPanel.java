package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import type.GameType;
import util.ImageUtil;

public class StartPanel extends JPanel implements KeyListener {
	private JFrame frame;
	private Image background;

	public StartPanel(JFrame frame) {
		this.frame = frame;
		frame.addKeyListener(this);
		try {
			background = ImageIO.read(new File(ImageUtil.START_IMAGE_URL));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			if (tankY == y1) {
				tankY = y2;
			} else {
				tankY = y1;
			}
			repaint();
			break;
		case KeyEvent.VK_Y:
		case KeyEvent.VK_NUMPAD1:
		case KeyEvent.VK_ENTER:
			if (tankY == y1) {
				type = GameType.ONE_PLAYER;
			} else {
				type = GameType.TWO_PLAYER;
			}
			gotoLevelPanel();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
