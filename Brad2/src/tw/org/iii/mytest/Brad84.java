package tw.org.iii.mytest;

public class Brad84 {
	public static void main(String[] args) {
		Player p1 = new Player();
		System.out.println(p1.getDir());
		p1.setDir(Direction.LEFT);
		System.out.println(p1.getDir());
		switch (p1.getDir()) {
			case STOP:
				System.out.println("A"); break;
			case LEFT:
				System.out.println("B"); break;
			case RIGHT:
				System.out.println("C"); break;
			case UP:
				System.out.println("D"); break;
			case Down:
				System.out.println("E"); break;
		}
		
		if (p1.getDir() == Direction.LEFT) {
			System.out.println("go left");
		}else {
			System.out.println("go other");
		}
		
		
	}
}
enum Direction {
	STOP, LEFT, RIGHT, UP, Down
}
class Player {
	private Direction dir;
	
	private final static int STATE_NEW = 1;
	private final static int STATE_SLEEP = 2;
	private final static int STATE_RUNNING = 3;
	private final static int STATE_DIE = 4;
	
	private int state = STATE_NEW;
	
	
	void setDir(Direction dir) {
		this.dir = dir;
	}
	Direction getDir() {
		return dir;
	}
}