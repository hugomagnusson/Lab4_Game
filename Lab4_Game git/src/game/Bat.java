package game;

public class Bat {

	private int x, y;
	private long time;
	private World world;
	private int block;
	private int level;
	
	private final int START_X = 0;
	private final int START_Y = 0;
	
	
	public Bat(int x, int y, World world) {
		this.x = x;
		this.y = y;
		this.world = world;
		time = System.currentTimeMillis();
		
		
	}
	
	public void reset() {
		x = world.getStartX();
		y = world.getStartY();
		System.out.println("Room " + level + ":");

		
		//System.out.println(world.getStartX());
		//System.out.println(world.getStartY());
	}
	
	public void move(int dx, int dy) {
		x = x + dx;
		y = y + dy;
	}
	
	public int checkPos() {
		
		block = world.getBlock(x, y);
		
		int effect = world.getHit(block);
		
		if (effect == 1) {
			death(block);
			return 1;
		}
			
		if (effect == 2) {
			collision(block);
			return 2;
		}
		
		if (effect == 9) {
			return 9;
		}
		
		
		if (x >= world.getXdim() || x < 0) {
			collision(10);
		}
		if (y >= world.getYdim() || y < 0) {
			collision(10);
		}
		
		return 0;
	}
	
	private void collision(int block) {
		
	}
	
	public void death(int block) {
		if (block == 10) {
			System.out.println("You collided with the shadow realm and dided");
		}
		else {
		System.out.println("You collided with " + world.getDeath() + " and died. RIP.");
		}
		reset();
	}
	
	public void win() {
		reset();
	}
	
	public String smell() {
		int xd = world.getFinishX() - x;
		int yd = world.getFinishY() - y;
		
		//String phrase;
		
		StringBuilder stb = new StringBuilder("The smell of outside is coming from ");
		
		if (xd > 0) {
			stb.append(xd + " meters to the right");
			//phrase = "the smell of outside is coming from " + xd + " meters to the right and " + yd + " meters forward";
		}
		else if (xd < 0) {
			stb.append(-xd + " meters to the left");
		}
		
		if (yd != 0 && xd != 0)
			stb.append(" and ");
		
		if (yd > 0) {
			stb.append(yd + " meters behind you");
			//phrase = "the smell of outside is coming from " + xd + " meters to the right and " + yd + " meters forward";
		}
		else if (yd < 0) {
			stb.append(-yd + " meters in front of you");
		}
		
		return stb.toString();
		
		
	}
	
	
	//GETTERS AND SETTERS

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
