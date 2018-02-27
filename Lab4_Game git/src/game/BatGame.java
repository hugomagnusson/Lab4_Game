package game;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BatGame {
	
	public int startX = 20, startY = 20;
	private Bat bat;
	private Scanner scan;
	private World world;
	private String worldname = "world1";
	private boolean running;
	private int level;
	private int state;
	private int maxlevel = 3;

	public static void main(String[] args) {
		
		BatGame batgame = new BatGame();
		
		Start.startText();
		
		batgame.init();
		
		System.out.println("hello git");

		

	}
	
	private void init() {
		world = new World();
		bat = new Bat(0, 0, world);
		scan = new Scanner(System.in);
		level = 1;
		
		
		
		
		//"E:\\Programs\\pt-workspace\\Lab4_Game\\Worlds\\world1.txt"
		
		try {
			world.readWorld(Integer.toString(level));
		} catch (FileNotFoundException e) {
			System.out.println("File not found :(   " /* + world.getUrl() */);
			e.printStackTrace();
		}
		
		/*
		System.out.println(world.getBlock(0, 0) + " " + world.getBlock(1, 0) + " " + world.getBlock(2, 0));
		System.out.println(world.getBlock(0, 1) + " " + world.getBlock(1, 1) + " " + world.getBlock(2, 1));
		System.out.println(world.getBlock(0, 2) + " " + world.getBlock(1, 2) + " " + world.getBlock(2, 2));
		*/
		
		int i1 = 0;
		StringBuilder sb = new StringBuilder();
		while (i1 < world.getYdim()) { //012
			
			int c1 = 0;
			while (c1 < world.getXdim()) {
				
				sb.append(" " + world.getBlock(c1, i1));
				
				//world[c1][i1] = reader.nextInt();
				c1++;
			}
			sb.append("\n");
			i1++;
		}
		
		//System.out.println(sb);
		
		bat.reset();
		
		loop();
	}

	public void loop() {
		
		running = true;
		boolean entered = false;
		String command;
		
		//System.out.println("starting location of bat:  x=" + bat.getX() + "  y=" + bat.getY());
		
		while (running) {
			command = scan.next().toUpperCase();
			
			
			
			switch (command) {
				case "UP":
				case "U": bat.move(0, -1);
					break;
					
				case "DOWN":
				case "D": bat.move(0, 1);
					break;
					
				case "LEFT":
				case "L": bat.move(-1, 0);
					break;
					
				case "RIGHT":
				case "R": bat.move(1, 0);
					break;
					
				case "EXIT":
				case "E": running = false;
					break;
					
				case "SMELL":
				case "S": System.out.println(bat.smell());
					break;
					
				case "LOCATION": System.out.println("x=" + bat.getX() + " y=" + bat.getY());
					break;
					
				default: 
					break;	
			}
			
			//System.out.println("Location of bat:  x=" + bat.getX() + "  y=" + bat.getY());
			
			state = bat.checkPos();
			
			if (state == 9) {
				
				
				
				
				System.out.println("You escaped room " + level + "!");
				
				level++;
				bat.setLevel(level);
				
				Start.pause(2000);
				
				
				if (level > maxlevel) {
					System.out.println("You escaped the house!");
				}
				else {
				try {
					world.readWorld(Integer.toString(level));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bat.win();
				}
			}
			
			
			
		}
		System.out.println("terminated");
	}

}
