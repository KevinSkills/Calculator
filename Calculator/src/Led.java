import java.util.ArrayList;


public class Led {
	int currentFaktor = 0;
	ArrayList<Faktor> faktorer = new ArrayList<Faktor>();
	boolean positive;
	

	Faktor GetCurrentFaktor() {
		return faktorer.get(currentFaktor);
	}
	

	
	public void removeFaktor() {
		faktorer.remove(currentFaktor);
		currentFaktor--;
		
	}
	

	
	public void multiply() {
		
		faktorer.add(new Faktor(true) );
		currentFaktor = faktorer.size() - 1;
	}
	public void divide() {
		
		faktorer.add(new Faktor(false) );
		currentFaktor = faktorer.size() - 1;
	}
	
	public Led(boolean p) {
		this.positive = p;
		faktorer.add(new Faktor(true));
		currentFaktor = 0;
		
	}
	
	public double getNumber() {
		double n = faktorer.get(0).getNumber();
		
		for (int i = 1; i < faktorer.size(); i++) {
			n *= faktorer.get(i).getNumber();
			
		}
		return (positive)? n:-n;
		
	}
	

	
	
	
	
}
