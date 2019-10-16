package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import type.GameType;
import util.ImageUtil;

public class StartPanel extends JPanel implements KeyListener {
	private JFrame frame;
	private Image background;
	private Image tank;
	private int Y[] = {302, 362, 422};
	private int pos = 0;

	public StartPanel(JFrame frame) {
		this.frame = frame;
		frame.addKeyListener(this);
		try {
			background = ImageIO.read(new File(ImageUtil.START_IMAGE_URL));
			tank = ImageIO.read(new File(ImageUtil.PLAYER1_RIGHT_C0_T1_S0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		Font font = new Font("黑体", Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("1 PLAYER", 340, 330);
		g.drawString("2 PLAYERS", 340, 390);
		g.drawString("CONSTRUCTION", 340, 450);
		g.drawImage(tank, 280, Y[pos], this);
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			pos = pos - 1 >= 0 ? pos - 1 : 2;
			repaint();
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			pos = (pos + 1) % 3;
			repaint();
			break;
		case KeyEvent.VK_Y:
		case KeyEvent.VK_NUMPAD1:
		case KeyEvent.VK_ENTER:
			/*
			if (tankY == y1) {
				type = GameType.ONE_PLAYER;
			} else {
				type = GameType.TWO_PLAYER;
			}
			gotoLevelPanel();
			*/
			break;
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
