package io.unixca.netty.OJT;

import static io.unixca.netty.OJT.OJTUserIniMain.Version;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class OJTInputHandler extends KeyAdapter {
	boolean toggle = false;

	OJTUserIniMain oJTUserIniMain;
	int i = 0;
	
	OJTAudioPlayer ap;
	public OJTInputHandler(OJTUserIniMain oJTUserIniMain){
    this.oJTUserIniMain = oJTUserIniMain;
	
	
	}
	long m = i;
	//our Args
	String[] size;
	String[] cmd;
	String[] color;
	String[] args;
	
	//Gets Current Time Millis
	long GetKeyTime(){
		return System.currentTimeMillis();
		
	}
	//wait method
	boolean Wait(long millis,long wait){
		if(System.currentTimeMillis() > millis + wait) {
			return true;
		}
		return false;
		
	}
	//Command Executer 
	public static String execCmd(String cmd) throws java.io.IOException {
	    @SuppressWarnings("resource")
		java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A"+ "\n");
	    return s.hasNext() ? s.next() + "\n" : "\n";
	}
	//KeyEvents
	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(e.getKeyCode () == KeyEvent.VK_ENTER) {
			
			

			if (oJTUserIniMain.d.equalsIgnoreCase("hello")){
				oJTUserIniMain.msg = "Hi There";
			}
			
			//Time & Date
			if (oJTUserIniMain.d.equalsIgnoreCase("time") ||oJTUserIniMain.d.equalsIgnoreCase("date") ){
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();  
				oJTUserIniMain.msg = "The time and date is " + date;
			}
			//sets the text color on UI
			if (oJTUserIniMain.d.contains("setcolor") ){
				if(oJTUserIniMain.d.contains(" ")) 
					color = oJTUserIniMain.d.split(" ");
				if(color.length == 2) { 
					
					oJTUserIniMain.Strcolor = color[1];
				}
					
			}
			//Test Multi-Tick Updates IE set text
			 //TODO  *Add Update Handler
			if (oJTUserIniMain.d.contains("strobeparty") ){
				if(oJTUserIniMain.d.contains(" ")) {
					String cint[];
					cint = oJTUserIniMain.d.split(" ");
					if(cint.length == 2) { 
						if(cint[1].equalsIgnoreCase("on")) {
						oJTUserIniMain.StrobeOn = true;
						oJTUserIniMain.msg = "########################### \n DANCE PARTY!!! GET TEH KEGS BOIS \n ###############################";
						
						}
						if(cint[1].equalsIgnoreCase("off")) {
						oJTUserIniMain.StrobeOn = false;
						oJTUserIniMain.msg = "Aww. Partys Over.";
						}	
					}
				
				}
			}
			//Sets The Text Size UI
			if (oJTUserIniMain.d.contains("textsize") ){
				if(oJTUserIniMain.d.contains(" ")) 
					 size = oJTUserIniMain.d.split(" ");
				if(size.length == 2) { 
						 try {
							 oJTUserIniMain.size = Integer.parseInt(size[1]);
							 
						 }
						 catch(Exception ex) {
							 oJTUserIniMain.msg = "Syntext: Not a Number";
							 
						 }
						
						  oJTUserIniMain.update(oJTUserIniMain.getGraphics());
					 }
					 
				}
				
			//Command 
			/* Launch(s) Verbose OS commands 
			 * Via Linux, OSX, Windows
			 * Max Args Currently 3
			 * TODO Get Arg[] Count
			 * IE cmd[i]
			 * i == argcount
			 */
			if (oJTUserIniMain.d.contains("cmd") ){
				if(oJTUserIniMain.d.contains(" ")) 
					 cmd = oJTUserIniMain.d.split(" ");
			
					System.out.println("length:" + cmd.length);
					try {


						String newline = System.getProperty("line.separator");
						if(cmd.length == 2) {
							if(cmd[1].equalsIgnoreCase("cmd")) {
								oJTUserIniMain.msg = "EASTER EGG> thought you could fool me -sickray34s.";
								
							} else if(cmd[1].equalsIgnoreCase("java")) {
							oJTUserIniMain.msg = "Did you honesty expect java to run itself -_-\"?";
							
							
						}else {
						oJTUserIniMain.msg = execCmd(cmd[1]);}
						} else if(cmd.length == 3){
						oJTUserIniMain.msg = execCmd(cmd[1] + " " +cmd[2]);
						} 
							else if(cmd.length == 4) {
							
							oJTUserIniMain.msg = execCmd(cmd[1] + " " + cmd[2] + " " + cmd[3]);
							}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
					

				
				
				//ui.msg = "Run a DOS command \"cmd {command}\" ";
				
			
			}
			//exit
			if(oJTUserIniMain.d.equalsIgnoreCase("exit")) {
			System.exit(0);
			}
			//default help command
			if(oJTUserIniMain.d.equalsIgnoreCase("help")) {
				oJTUserIniMain.msg = "\nCommands:\n\n"+
			             "Run Any System Command: cmd {commands} {args}\n"+
						 "Play Music: music {PATH} || pause || play || stop\n"+
			             "Time And Date: time || date\n"+
						 "Stobe Text: strobparty {on/off}\n"+
			             "Text Color: setcolor {color}\n"+
						 "Text Size: textsize {number}"+
						 "Info About This Program: info\n\n"+
						 "Author: sickray34s\n"+
			             "Version: "+ Version +"\n"+
						 "Website: https://unicxa.github.io/";
						 
						}
			//version info
			if(oJTUserIniMain.d.equalsIgnoreCase("info")) {
				oJTUserIniMain.msg = "Author: sickray34s\n"+
			             "Version: "+ Version +"\n"+
						 "Website: https://unicxa.github.io/";
						}
			//music player
			if(oJTUserIniMain.d.contains("music")) {
				 cmd = oJTUserIniMain.d.split(" ");
		
				if(cmd.length == 2) {
		
					if(cmd[1].equalsIgnoreCase("play")) {
						ap.play();
						oJTUserIniMain.msg = "Playing Now...  d(-_-)b";
					}else 
					if(cmd[1].equalsIgnoreCase("pause")) {
						oJTUserIniMain.msg = "Hold up, pause pause pause!";
						ap.pause();
					}else 
						
					if(cmd[1].equalsIgnoreCase("stop")) {
						oJTUserIniMain.msg = "Stopping the music :'(";
								try {
							ap.stop();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						
					try {
						oJTUserIniMain.msg = "Yett A NEW song!!";
						ap = new OJTAudioPlayer(cmd[1]);
					
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				
			}
			}
		
			if(oJTUserIniMain.d.contains("dir")){
				
				
			File file = new File("/");
			String[] directories = file.list(new FilenameFilter() {
			  @Override
			  public boolean accept(File current, String name) {
			    return new File(current, name).isDirectory();
			  }
			});
			oJTUserIniMain.msg = Arrays.toString(directories);
			}
		}
	
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
				
			StringBuilder strB = new StringBuilder(oJTUserIniMain.d);
           if(!(oJTUserIniMain.d.isEmpty())){
			strB.deleteCharAt(oJTUserIniMain.d.length() - 1);
			  
				 oJTUserIniMain.d = strB.toString();
		        
		  
   
           }
      
       
			
		
		
	} else if(!(e.getKeyChar() == KeyEvent.SHIFT_DOWN_MASK || e.getKeyChar() == KeyEvent.VK_SHIFT || e.getKeyCode() == 16 )){oJTUserIniMain.d = oJTUserIniMain.d + e.getKeyChar();}
		System.out.print(e.getKeyCode());
	
	}
	
	void render(Graphics g){
		
		
	}


}



