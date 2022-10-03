
public class Snail {
	
	public static char icon = '@';
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {
		movePattern = new LinkedQueue<Integer>();
		position = 0;
		
		for (int i = 0; i < pattern.length; i++) {
			movePattern.enqueue(pattern[i]);
		}
	}
	
	public void move () {
		int step = movePattern.dequeue();
		movePattern.enqueue(step);
		
		if ((position+step) > SnailRace.raceLength) {  
			position = SnailRace.raceLength;
		} else {
			position += step;
		}
	}
	
	public int getPosition () {
		return position;
	}
	
	public void display () {
		int dashesBefore = position;
		int dashesAfter = (SnailRace.raceLength - position);
		
		for (int i = 0; i < dashesBefore; i++) {
			System.out.print("-");
		}
		System.out.print(icon);
		for (int i = 0; i < dashesAfter; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}

}
