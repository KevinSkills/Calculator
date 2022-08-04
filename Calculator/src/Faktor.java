
public class Faktor {
	private double number;
	boolean multiplikation;
	public int comma = 0;
	boolean function = false;
	String theFunction;
	double a;
	double b = -5656;
	private static boolean radians = false;


	public void function(String f) {
		this.theFunction = f;
		
		if(f == "no") {
			this.number = a;
			
		}else if(f == "removeAll"){
			this.number = 0;
		}else {
			function = true;
		}
	}

	
	
	public double getNumber() {
		if (function) {
			switch (theFunction) {
			case "sqrt":
				this.number = Math.sqrt(this.number);
				break;
				
			case "rooty":
				this.number = Math.round(Math.pow(b, 1/a)  *5  )  /5;
				break;
			case "exponent":
				this.number = Math.pow(a, b);
				break;
			case "Sin":
				this.number = (radians)? Math.sin(this.number) : Math.sin(Math.toRadians(this.number)); 
				break;
			case "Cos":
				this.number = (radians)? Math.cos(this.number) : Math.cos(Math.toRadians(this.number)); 
				break;
			case "Tan":
				this.number = (radians)? Math.tan(this.number) : Math.tan(Math.toRadians(this.number)); 
				break;
			case "Sin-1":
				this.number = (radians)? Math.asin(this.number) : Math.toDegrees(Math.asin(this.number)); 
				break;
			case "Cos-1":
				this.number = (radians)? Math.acos(this.number) : Math.toDegrees(Math.acos(this.number)); 
				break;
			case "Tan-1":
				this.number = (radians)? Math.atan(this.number) : Math.toDegrees(Math.atan(this.number)); 
				break;
			case "Log":
				this.number = Math.log10(this.number);
				break;
			case "Abs":
				this.number = Math.abs(this.number);
				break;
			}
			
			
		}
				

		return (multiplikation) ? this.number : 1 / this.number;

	}

	public void setNumber(double n) {
		this.number = n;
		
		a = (!function) ? this.number : a;
		b = (function) ? this.number : b;
	}

	public void addToNumber(double n) {
		if (function && b == -5656) {
			this.number = 0;
		}

		if (comma > 0) {
			this.number = this.number + n / ( Math.pow(10, comma));
			comma += 1;

		} else {

			this.number = this.number * 10 + n;
		}

		a = (!function) ? this.number : a;
		b = (function) ? this.number : b;

	}

	public Faktor(boolean m) {
		this.multiplikation = m;

	}
	
	public void removeNumber() {
		System.out.println(comma);
		if (comma > 1) {
			this.number = (double)((int) (this.number * (Math.pow(10, comma-2)))) / Math.pow(10, comma-2);
			comma -= 1;
			

		}else if (comma == 1) {
			comma -= 1;
		}
		else {

			this.number = (double)((int)(this.number / 10));
		}
		System.out.println(comma);
		
	}



	public boolean isRadians() {
		return radians;
	}



	public void setRadians(boolean radians) {
		this.radians = radians;
	}

}
