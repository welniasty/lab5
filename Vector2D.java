package MojApplet;

public class Vector2D {
		
	public double x,y; // deklaracja publicznych p�l wp�rz�nych wektora
	public Vector2D(){ // konstruktor domy�lny
		
	}
	
	public Vector2D(double x, double y){// konstruktor z parametrami
		
		this.x=x;
		this.y=y;
	}
	
	// Metoda  z  parametrem zwracaj�ca nowy  obiekt klasy  Vector2D,
	//b�d�cy  sum� wektora,  dla kt�rego zosta�a wywo�ana i wektora podanego jako parametr
	public Vector2D Addition(Vector2D v){ 
		
		Vector2D vec = new Vector2D(x + v.x,y + v.y);
		return vec;
		
	}
	
	// Metoda  z  parametrem zwracaj�ca nowy  obiekt klasy  Vector2D,
	//b�d�cy  r�nic� wektora,  dla kt�rego zosta�a wywo�ana i wektora podanego jako parametr
	
	public Vector2D Substraction(Vector2D v){
		
		Vector2D vec = new Vector2D(x - v.x,y - v.y);
		return vec;
		
	}

	
	// Metoda  z  parametrem zwracaj�ca nowy  obiekt klasy  Vector2D,
	//b�d�cy  przemno�onym przez sta�� wektorem, dla kt�rego zosta�a wywo�ana
	public Vector2D Multiplication(double m){
		
		Vector2D vec = new Vector2D(x * m, y * m);
		return vec;
		
	}	

	
	//Metoda bez parametr�w zwracaj�ca d�ugo�� wektora, dla kt�rego zosta�a wywo�ana

	public double Length(){
		
		return Math.sqrt(x*x+y*y);
		
	}
	
	//Metoda  bez  parametr�w zwracaj�canowy     obiekt klasy     Vector2D,    
	//b�d�cy znormalizowanym wektorem, dla kt�rego zosta�a wywo�ana
	
	public Vector2D Norm(){
		
		double xx,yy;
	
		xx=x/(Math.sqrt(x*x+y*y));
		yy=y/(Math.sqrt(x*x+y*y));
		Vector2D vec = new Vector2D(xx, yy);
		return vec;
		
	}
	
}
