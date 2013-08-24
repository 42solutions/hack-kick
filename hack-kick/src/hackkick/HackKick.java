package hackkick;

import java.math.RoundingMode;

import jgame.*;
import jgame.platform.*;

public class HackKick extends StdGame {

	public static void main(String[]args) {new HackKick(new JGPoint(640,480));}
	public HackKick() { initEngineApplet(); }
	public HackKick(JGPoint size) { initEngine(size.x,size.y); }
	public void initCanvas() { setCanvasSettings(32,24,8,8,null,null,null); }
	
	public double time_left;
	
	public void initGame() {
		//defineMedia("hackkick.tbl");
		if (isMidlet()) {
			setFrameRate(60,0);
			setGameSpeed(1.0);
		} else {
			setFrameRate(60,1);
			setGameSpeed(1.0);
		}
		setHighscores(10,new Highscore(0,"nobody"),15);
		startgame_ingame=false;
		initial_lives = 3;
		time_left = 10.0;
	}
	
	public void startGameOver() { time_left = 10.0;}
	
	public void doFrameInGame() {
		// Decrement time by timer change
		if (checkTime(1) &&
		   (time_left > 0.0) && 
		   ((Math.round(gametime)) % 5) == 0)
		{
			time_left-=0.1;
			time_left=Math.round(time_left * 10.0) / 10.0;
		}
		
		if (time_left == 0.0)
		{
			
			gameOver();
		}
	}

	public void paintFrame() {
		setFont(status_font);
		setColor(status_color);
		drawString("Score "+score,status_l_margin,0,-1);
		drawString("Time "+time_left,viewWidth()-status_r_margin,0,1);
		drawString("GameTime "+gametime,viewWidth()-status_r_margin,8,1);
		
	}
	
}
