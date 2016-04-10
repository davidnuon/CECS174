import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class FallingBall extends JApplet implements MouseListener {
	Ball ball;
	Ball ballshadow;
	Color color;
	double time = 0;
	
	double gravity = 9.2;
	boolean click = true;
	boolean firstRun = true;
	
	
	Timer timer;
	TimerTask task;

	public void init() {
		color = new Color((int)(Math.random()*256),(int)(Math.random()*256), (int)(Math.random()*256));		

		ball = new Ball(0, 0, 30);
		ballshadow = new Ball(0, 0, 30);
		
		setSize(500, 500);
		addMouseListener(this);
		timer = new Timer();

	}
	
	public void start() {
		task = new TimerTask() {
			public void run() {
				calc();
			}

		};
		
		timer.schedule(task, 0, 50);
	}

	public void stop() {
		task.cancel();
		timer.purge();
	}
	
	public void destroy() {
		timer.cancel();
	}
	
	public void calc() {
		time += .10;
		physics(ball, time);
		repaint();
	}
	
	public void paint(Graphics g) {	
		if(click) {
			clear(g);
		}
				
		if(!firstRun) {
			g.setColor(Color.white);
			g.fillOval(ballshadow.getX(), ballshadow.getY(), ballshadow.getR(), ballshadow.getR());
			g.setColor(color);
			g.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR());
		}
	}

	private void physics(Ball ball, double t) {
		if(ball.getY() < getHeight()) {
			ballshadow.setY(ball.getY());
			ball.setY((ball.getY() + (int)(gravity*t*t)));
		} else {
		
			if(ball.getY() > getHeight()) {
				click = true;
			}
		}
	}
	
	public void clear(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 400);		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(click) {
			time = 0;

			color = new Color((int)(Math.random()*256),(int)(Math.random()*256), (int)(Math.random()*256));		

			
			ball.setX(e.getX());
			ball.setY(e.getY());
			ball.setR((int)(Math.random()*30) + 30);
		
			ballshadow.setX(e.getX());
			ballshadow.setR(ball.getR());
			
			firstRun = false;
			click = false;
		}
	}

	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
