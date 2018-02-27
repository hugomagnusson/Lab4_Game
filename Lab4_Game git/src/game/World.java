package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class World {

	private int[][] world;
	
	private int xdim, ydim;
	private File worldfile;
	private int startX, startY;
	private String killer;
	private int finishX;
	private int finishY;
	


	public World() {
		
	}
	
	public void readWorld(String worldname) throws FileNotFoundException {
		
		//URL fileUrl = getClass().getResource(worldpath);
		
		//worldfile = new File(fileUrl.getFile());
		
		//worldfile = new File("E:\\Programs\\pt-workspace\\Lab4_Game\\Worlds\\world1.txt");

		
		//"E:\\Programs\\pt-workspace\\Lab4_Game\\Worlds\\world1.txt"
		Scanner reader = new Scanner(new File("Worlds/" + worldname + ".txt"));

		ydim = reader.nextInt();
		xdim = reader.nextInt();
		
		startX = reader.nextInt();
		startY = reader.nextInt();
		
		System.out.println(xdim + " " + ydim + " " + startX + " " + startY + " " + worldname);
		
		
		world = new int[xdim][ydim];
		
		int i = 0;
		while (i < ydim) { //012
			
			int c = 0;
			while (c < xdim) {
				if(reader.hasNextInt()) {
					world[c][i] = reader.nextInt();
				}
				else {
					//System.out.println("out of ints wtf  " + c + "  " + i);
				}
				c++;
			}
			i++;
		}
		
		int i1 = 0;
		while (i1 < ydim) { //012
			
			int c1 = 0;
			while (c1 < xdim) {
				if(world[c1][i1] == 9) {
					finishX = c1;
					finishY = i1;
					c1 = xdim;
					i1 = ydim;
				}
				else {
					//System.out.println("out of ints wtf  " + c + "  " + i);
				}
				c1++;
			}
			i1++;
		}
	}
	
	public int getHit(int death) {
		
		killer = "a UFO";
		int effect = 0;
		
		switch (death) {
			case 1: killer = "a wall"; effect = 1;
				break;
				
			case 2: killer = "a window"; effect = 1;
				break;
				
			case 3: killer = "an oven"; effect = 1;
				break;
				
			case 4: killer = "a bookshelf"; effect = 1;
				break;
			
			case 9: effect = 9;
				break;
		}
		
		return effect;
				
		
	}
	
	public String getDeath() {
		return killer;
	}
	
	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public String getUrl() {
		return worldfile.getAbsolutePath();
	}
	
	public int getXdim() {
		return xdim;
	}

	public int getYdim() {
		return ydim;
	}

	public int getBlock(int x, int y) {
		
		return world[x][y];
	}
	
	public int getFinishX() {
		return finishX;
	}

	public int getFinishY() {
		return finishY;
	}
		
	
	
}
