package game;

public class Start {

	private static long pauseD = 1500;

	
	public static void startText() {
		
		System.out.println("This is you");
		pause(pauseD);
		
		System.out.println(" ");
		
		System.out.println("          =,    (\\_/)    ,=");
		System.out.println("           /`-'--(\")--'-'\\");
		System.out.println("          /     (___)     \\");
		System.out.println("         /.-.-./ \" \" \\.-.-.\\");
		
		pause(2 * pauseD);
		
		
		System.out.println("You are a bat");
		pause(pauseD);
		

		
		
		System.out.println("Bats are blind");

		
		pause(pauseD);
		System.out.println(" ");
		System.out.println("You are also deaf");
		
		pause(pauseD);
		
		System.out.println("And you have accidentally flown into a house");
		pause(pauseD);
		
		System.out.println("And now u r trapped");
		pause(pauseD);
		
		System.out.println("Find your way out!");

		
		pause(pauseD);
		System.out.println(" ");
		System.out.println("Commands: up, down, left, right, smell");
		
		pause(pauseD);
		System.out.println(" ");
		System.out.println("good luck");
		
	}
	
	public static void pause(long duration) {
	
		long delta = 0;
		long now;
		long ini = System.currentTimeMillis();
		
		while(delta <= duration) {
			now = System.currentTimeMillis();
			delta = now - ini;
		}
		return;
	}
	
	
	
}
