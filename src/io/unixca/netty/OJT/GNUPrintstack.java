package io.unixca.netty.OJT;

import java.awt.Graphics;
import java.util.Random;
import java.util.stream.LongStream;

public  class GNUPrintstack  {
     long GenID;
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 8005841560312333284L;
	private void drawString(Graphics g, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
	public void GNU(Graphics G){
		

		Random r = new Random();
		GenID = (long) (r.nextFloat()  * serialVersionUID % r.nextInt((int) Math.random() / 10) + r.nextFloat());
		this.drawString(G, "	     *    Open Java Term Framework - A opensource muti-OS command executer and server host\r\n" + 
				"    	 *		Copyright (C) 2019  Unicxa (Unicxa Team) <https://www.unicxa.github.io/>\r\n" + 
				"         *\r\n" + 
				"    	 *		This program is free software: you can redistribute it and/or modify\r\n" + 
				"    	 *		it under the terms of the GNU General Public License as published by\r\n" + 
				"    	 *		the Free Software Foundation, either version 3 of the License, or\r\n" + 
				"    	 *		(at your option) any later version.\r\n" + 
				"         *\r\n" + 
				"    	 *		This program is distributed in the hope that it will be useful,\r\n" + 
				"    	 *		but WITHOUT ANY WARRANTY; without even the implied warranty of\r\n" + 
				"    	 *		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\r\n" + 
				"    	 *		GNU General Public License for more details.\r\n" + 
				"         *\r\n" + 
				"    	 *		You should have received a copy of the GNU General Public License\r\n" + 
				"    	 *		along with this program.  If not, see <https://www.gnu.org/licenses/>.\n"+
				 "\n "+ "UID Token: " + GenID , 30, 30);
		        
	
		
     
    	   
		
    	   
		

	}
    	   
	}
   
	

