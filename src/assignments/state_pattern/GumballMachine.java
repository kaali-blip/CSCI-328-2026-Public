import java.util.Random;

public class GumballMachine {
 
	public enum GumballState { SoldOutState, NoQuarterState, HasQuarterState, SoldState, WinnerState }
	private int count = 0;
	private GumballState gumballState;
	private Random randomWinner = new Random(System.currentTimeMillis());
 
	public GumballMachine(int numberGumballs) {
		gumballState = GumballState.SoldOutState;
		this.count = numberGumballs;

 		if (numberGumballs > 0) {
			gumballState = GumballState.NoQuarterState;
		} 
	}
 
	public void insertQuarter() {
		if(gumballState == GumballState.SoldOutState){
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if(gumballState == GumballState.NoQuarterState) {
			System.out.println("You inserted a quarter");
			gumballState = GumballState.HasQuarterState;
		} else if(gumballState == GumballState.HasQuarterState) {
			System.out.println("You can't insert another quarter");
		} else if(gumballState == GumballState.SoldState) {
			System.out.println("Please wait, we're already giving you a gumball");
		} else if(gumballState == GumballState.WinnerState) {
			System.out.println("Please wait, we're already giving you a Gumball");
		} else {
			System.out.println("Unknown State. Gumball machine must be recalled");
		}
	}
 
	public void ejectQuarter() {
		if(gumballState == GumballState.SoldOutState){
			System.out.println("You can't eject, you haven't inserted a quarter yet");
		} else if(gumballState == GumballState.NoQuarterState) {
			System.out.println("You haven't inserted a quarter");
		} else if(gumballState == GumballState.HasQuarterState) {
			System.out.println("Quarter returned");
			gumballState = GumballState.NoQuarterState;
		} else if(gumballState == GumballState.SoldState) {
			System.out.println("Sorry, you already turned the crank");
		} else if(gumballState == GumballState.WinnerState) {
			System.out.println("Sorry, you already turned the crank");
		} else {
			System.out.println("Unknown State. Gumball machine must be recalled");
		}
	}
 
	public void turnCrank() {
		if(gumballState == GumballState.SoldOutState){
			System.out.println("You turned, but there are no gumballs");
			dispense();
		} else if(gumballState == GumballState.NoQuarterState) {
			System.out.println("You turned, but there's no quarter");
			dispense();
		} else if(gumballState == GumballState.HasQuarterState) {
			System.out.println("You turned...");
			int winner = randomWinner.nextInt(10);
			if ((winner == 0) && (count > 1)) {
				gumballState = GumballState.WinnerState;
			} else {
				gumballState = GumballState.SoldState;
			}
			dispense();
		} else if(gumballState == GumballState.SoldState) {
			System.out.println("Turning twice doesn't get you another gumball!");
			dispense();
		} else if(gumballState == GumballState.WinnerState) {
			System.out.println("Turning again doesn't get you another gumball!");
			dispense();
		} else {
			System.out.println("Unknown State. Gumball machine must be recalled");
			dispense();
		}
	}

	private void dispense(){
		if(gumballState == GumballState.SoldOutState){
			System.out.println("No gumball dispensed");
		} else if(gumballState == GumballState.NoQuarterState) {
			System.out.println("You need to pay first");
		} else if(gumballState == GumballState.HasQuarterState) {
			System.out.println("No gumball dispensed");
		} else if(gumballState == GumballState.SoldState) {
			releaseBall();
			if (count > 0) {
				gumballState = GumballState.NoQuarterState;
			} else {
				System.out.println("Oops, out of gumballs!");
				gumballState = GumballState.SoldOutState;
			}
		} else if(gumballState == GumballState.WinnerState) {
			releaseBall();
			if (count <= 0) {
				gumballState = GumballState.SoldOutState;
			} else {
				releaseBall();
				System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
				if (count > 0) {
					gumballState = GumballState.NoQuarterState;
				} else {
					System.out.println("Oops, out of gumballs!");
					gumballState = GumballState.SoldOutState;
				}
			}
		} else {
			System.out.println("Unknown State. Gumball machine must be recalled");
		}
	}
	
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count > 0) {
			count = count - 1;
		}
	}
 
	public int getCount() {
		return count;
	}

	// public ? getState(){}
 
	public void refill(int count) {
		this.count += count;
		System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
		if(gumballState == GumballState.SoldOutState){
			gumballState = GumballState.NoQuarterState;
		}
	}

	public String getStateToString(){
		String stateAction = "broken";
		if(gumballState == GumballState.SoldOutState){
			stateAction = "sold out";
		} else if(gumballState == GumballState.NoQuarterState) {
			stateAction = "waiting for quarter";
		} else if(gumballState == GumballState.HasQuarterState) {
			stateAction = "waiting for turn of crank";
		} else if(gumballState == GumballState.SoldState) {
			stateAction = "dispensing a gumball";
		} else if(gumballState == GumballState.WinnerState) {
			stateAction = "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
		} else {
			stateAction = "broken";
		}

		return stateAction;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + getStateToString() + "\n");
		return result.toString();
	}
}
