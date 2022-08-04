import java.util.ArrayList;

public class MathSentence {
	

	
	int currentLed = 0;
	ArrayList<Led> led = new ArrayList<Led>();



	Led GetCurrentLed() {
		return led.get(currentLed);
	}
	
	Faktor GetCurrentFaktor() {
		return GetCurrentLed().GetCurrentFaktor();
	}
	
	public MathSentence() {
		led.add(new Led(true));
		currentLed = 0;
	}
	
	
	public void removeLed() {
		led.remove(currentLed);
		currentLed--;
		
	}
	
	public void add() {
		led.add(new Led(true) );
		currentLed = led.size() - 1;
		
	}
	public void subtract() {
		led.add(new Led(false) );
		currentLed = led.size() - 1;
		
	}
	

	
	
	double equals() {
		double number = 0;
		for (int i = 0; i < led.size(); i++) {
			number += led.get(i).getNumber();
			
		}
		
		
		return number;
		
	}
	

	
	
	


	
	

	

	


	
	

	
	

}
