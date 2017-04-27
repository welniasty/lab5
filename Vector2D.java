package MojApplet;

public class Vector2D {
		
	public double x,y; // deklaracja publicznych pól wpó³rzênych wektora
	public Vector2D(){ // konstruktor domyœlny
		
	}
	
	public Vector2D(double x, double y){// konstruktor z parametrami
		
		this.x=x;
		this.y=y;
	}
	
	// Metoda  z  parametrem zwracaj¹ca nowy  obiekt klasy  Vector2D,
	//bêd¹cy  sum¹ wektora,  dla którego zosta³a wywo³ana i wektora podanego jako parametr
	public Vector2D Addition(Vector2D v){ 
		
		Vector2D vec = new Vector2D(x + v.x,y + v.y);
		return vec;
		
	}
	
	// Metoda  z  parametrem zwracaj¹ca nowy  obiekt klasy  Vector2D,
	//bêd¹cy  ró¿nic¹ wektora,  dla którego zosta³a wywo³ana i wektora podanego jako parametr
	
	public Vector2D Substraction(Vector2D v){
		
		Vector2D vec = new Vector2D(x - v.x,y - v.y);
		return vec;
		
	}

	
	// Metoda  z  parametrem zwracaj¹ca nowy  obiekt klasy  Vector2D,
	//bêd¹cy  przemno¿onym przez sta³¹ wektorem, dla którego zosta³a wywo³ana
	public Vector2D Multiplication(double m){
		
		Vector2D vec = new Vector2D(x * m, y * m);
		return vec;
		
	}	

	
	//Metoda bez parametrów zwracaj¹ca d³ugoœæ wektora, dla którego zosta³a wywo³ana

	public double Length(){
		
		return Math.sqrt(x*x+y*y);
		
	}
	
	//Metoda  bez  parametrów zwracaj¹canowy     obiekt klasy     Vector2D,    
	//bêd¹cy znormalizowanym wektorem, dla którego zosta³a wywo³ana
	
	public Vector2D Norm(){
		
		double xx,yy;
	
		xx=x/(Math.sqrt(x*x+y*y));
		yy=y/(Math.sqrt(x*x+y*y));
		Vector2D vec = new Vector2D(xx, yy);
		return vec;
		
	}
	
}
