package io.unixca.netty.OJT;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Random;
import java.util.stream.LongStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class OJTUserIniMain extends Canvas implements Runnable {
	/////////////////////////////////////////////////////////////////////////////
   ////#!    (______)         $          _    _=____=__
	//#*     |      |          $$       /         |
	//#$     |      |         $$$$    _/         ZXZ
   //#%      |      |         ----  //            X
   //\#O     |______|        \____/               X           OPEN JAVA TERM  
	//\=========================================================================
	//||||||||||||||||||||||||# GNU
	 //###\
	  //###|
	   //##|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
	    ///|
//
	    //
	    /* 	 
* 
*    Open Java Term Framework - A opensource muti-OS command executer and server host
    	 *		Copyright (C) 2019  Unicxa (Unicxa Team) <https://www.unicxa.github.io/>
         *
    	 *		This program is free software: you can redistribute it and/or modify
    	 *		it under the terms of the GNU General Public License as published by
    	 *		the Free Software Foundation, either version 3 of the License, or
    	 *		(at your option) any later version.
         *
    	 *		This program is distributed in the hope that it will be useful,
    	 *		but WITHOUT ANY WARRANTY; without even the implied warranty of
    	 *		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    	 *		GNU General Public License for more details.
         *
    	 *		You should have received a copy of the GNU General Public License
    	 *		along with this program.  If not, see <https://www.gnu.org/licenses/>. 
*/
///\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	boolean START_ENABLED = true;
	public static String Version ="0.03Alpha(WinPine)";
    public static final long serialVersionUID = 179650234411234L;
    public int xOffset = 0;
    public int yOffset = 0;
    int UPDATE_DATA;
    int UP_TIME;
    String c;
    String OJT = "OJT";
    String Intro = "";
    String msg = "";
    String Strcolor;
    int i;
    private Color color;
    int size= 20;
    int r,g,b;
    boolean genID_Enabled = false;
    boolean StrobeOn;
     long GenID;
    private boolean on = false;
  
    
    /* Res Must be a hexadecimal number 
     * system e.g ( 16 32 64 128 256 512 1024)
     * #WARNING# Keep above 128 for best results
     */
    
 
 
    
    	
    
    JFrame frame;
    public static boolean running = false;
    public static final String TITLE = "OpenJTerm";
    static int Width = 1028;
    static int Hight = 780;
    BufferedImage image = new BufferedImage(Width,Hight,BufferedImage.TYPE_INT_RGB);
    public static final Dimension gameDim = new Dimension(Width,Hight);

 String d= "";


   
   
   Thread thread;
  
   long timer;
    
	@Override
	public void run() {
		
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		int updates = 0;
		@SuppressWarnings("unused")
		int frames = 0;
		@SuppressWarnings("unused")
		boolean i = true;
		while(running){
			this.timer = timer;
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				updates++;
				tick(updates);
				delta--;
				
			}
			render();
			frames++;
				
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
				updates = 0;
				
			}
		}
	}
	
	
	synchronized void start(){
		if(running) return;
	running = true;
    thread = new Thread(this);
	thread.start();
		}
	 synchronized void  stop(){
	running = false;
	System.exit(0);
		}
	public OJTUserIniMain(){
		
		this.setMinimumSize(gameDim);
		this.setMaximumSize(gameDim);
		this.setPreferredSize(gameDim);
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		init();
		this.requestFocus();
	}
	private void init(){
		this.addKeyListener(new OJTInputHandler(this));		
		
	}
	

	public void tick(int updates){
		System.out.println(updates);
		if(StrobeOn == true) {
			if(updates > 30){
				on = true;
			}
		}
		else {on = false;}
		if((updates%60)==0) {
			UP_TIME++;
		}

if(updates < 30){
		c = "_";
		
	}
 if(updates > 30){
  
	c = "";
 }
	}
	
	
	long GetKeyTime(){
		return System.currentTimeMillis();
		
	}
	boolean Wait(long millis,long wait){
		if(System.currentTimeMillis() > millis + wait) {
			return true;
		}
		return false;
		
	}
	
	
public int Base16(int i) {
int x =  i * 16;
	return x;
}
		
		

private void drawString(Graphics g, String text, int x, int y) {
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
}
String BootLoader( int UP_TIME) {
	String s = null;
	if(UP_TIME == 0) {
		s = "."; 
	}
	if(UP_TIME == 1) {
		s = ".."; 
	}
	else
		if(UP_TIME == 2) {
			s = "..."; 
		}
		else
			if(UP_TIME == 3) {
				s = "...."; 
			}
	if(UP_TIME == 4) {
		s = "....DONE;"; 
	}
	if(UP_TIME >= 5) {
		s = "....DONE;\n Init()..........."; 
	}
	return s;
	
}

	
	/**
	 * {@code <HOST-BS>}
	 */
	public void render(){
		
		
		BufferStrategy  bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0,0, this.getWidth(), this.getHeight(), null);
		//put in TODO classHandler [0]
//TODO *add TextHandler Refactor and clean up Much??
		//Yeesh I Could Use A Hand
		//Help??
		//Wont Display, StackOverflow?
 
		
		
			
		if(UP_TIME <= 10) {
			try {
				BufferedImage img = ImageIO.read(new URL("https://unicxa.github.io/LOGO.png"));
				g.setColor(Color.green);
				String load = null;
				load = this.BootLoader(UP_TIME);
				g.setFont(new Font("Calibri", Font.PLAIN, size)); 
				this.drawString(g, "UNXICA OPEN JAVA TERM:"+ load, 125, 500);
			
				
				g.drawImage(img, 0,0 + 100, this);
				bs.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}else
			
		if((UP_TIME < 20 && UP_TIME > 10)) {
			System.out.println("UPTIME: " + UP_TIME);
			
			if(genID_Enabled == false) {
			Random r = new Random();
			GenID = (long) (r.nextFloat()  * serialVersionUID);
			genID_Enabled = true;
			}
			g.setFont(new Font("Calibri", Font.PLAIN, size)); 
			g.setColor(Color.green);
			this.drawString(g, 
					"	     *      Open Java Term Framework - A opensource muti-OS command executer and server host\r\n" + 
					"    	 *		Copyright (C) 2019  Unicxa (Unicxa Team) <https://www.unicxa.github.io/>\r\n" + 
					"        *\n" + 
					"    	 *		This program is free software: you can redistribute it and/or modify\r\n" + 
					"    	 *		it under the terms of the GNU General Public License as published by\r\n" + 
					"    	 *		the Free Software Foundation, either version 3 of the License, or\r\n" + 
					"    	 *		(at your option) any later version.\r\n" + 
					"        *\n" + 
					"    	 *		This program is distributed in the hope that it will be useful,\r\n" + 
					"    	 *		but WITHOUT ANY WARRANTY; without even the implied warranty of\r\n" + 
					"    	 *		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\r\n" + 
					"    	 *		GNU General Public License for more details.\r\n" + 
					"        *\n" + 
					"    	 *		You should have received a copy of the GNU General Public License\r\n" + 
					"    	 *		along with this program.  If not, see <https://www.gnu.org/licenses/>.\n"+
					 "\n "+ "UID Token: " + GenID , 30, 30);
			bs.show();
			
		} else {
		
		
		
		try {
		  
			Field field = Class.forName("java.awt.Color").getField(Strcolor);
		    color = (Color)field.get(null);
		    g.setColor(color);
		} catch (Exception e) {
		    color = null; // Not defined
		    g.setColor(Color.green);
		    
		}
		if(StrobeOn == true) {
			if(on == true) {

			    Random rand = new Random();
			    g.setColor(Color.getHSBColor(rand.nextFloat() * (255 - 0) + 0,
 rand.nextFloat() * (255 - 0) + 0, rand.nextFloat() * (255 - 0) + 0));
			    
				
			}
		}

		g.setFont(new Font("Calibri", Font.PLAIN, size)); 
		g.drawString( "OJT>" + d + c, this.Base16(2), this.Base16(2));
		g.setFont(new Font("Calibri", Font.PLAIN, size - 2)); 
	    this.drawString(g, "OJT: " + msg, this.Base16(2), this.Base16(4));
		
	    
		Debug(g);
		g.dispose();
		bs.show();
	
		}
	}
	//put in TODO classHandler [1]
	public void Debug(Graphics g){
	
	 
		
	}
	//put in TODO classHandler [2]
	public void snake(Graphics g) {
		
 //a planed snake game
	//	g.drawRect(snakex, snakey, snakewidth, 20);
		
		//More soon 
		
	}
	//main
	
public static void main(String args[]) {
	if(args.length == 2) {
	Width =Integer.valueOf(args[0]);
	Hight =Integer.valueOf(args[1]);
	}
	OJTUserIniMain oJTUserIniMain = new OJTUserIniMain();
	oJTUserIniMain.start();
}


}
