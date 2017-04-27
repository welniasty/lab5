package MojApplet;

public class SimEngine {

	//stworzenie prywatnych pól parametrów symulacji
	//m-masa
	//b-wsp.t³umienia
	//k-wsp.sprê¿ystoœci
	//l0-d³.swobodna sprê¿yny
	//g-wsp.grawitacji
	//z-po³o¿enie masy
	//v-prêdkoœæ
	//xl-po³o¿enie punktu zawieszenia
	
	private double m,k,b,l0,g;
	
	private Vector2D z,v,xl;
	
public SimEngine(double m, double k, double b, double l0, Vector2D z, Vector2D v, Vector2D xl, double g){  // konstruktor z parametrami
		
		this.m=m;
		this.k=k;
		this.b=b;
		this.l0=l0;
		this.z=z;
		this.v=v;
		this.xl=xl;
		this.g=g;	
		
	}

	//akcesory

	public double getM(){
		return m;
	}

	public void setM(double m){
		this.m=m;	
	}
	
	public double getK(){
		return k;
	}

	public void setK(double k){
		this.k=k;	
	}
	public double getB(){
		return b;
	}

	public void setB(double b){
		this.b=b;	
	}
	public double getL0(){
		return l0;
	}

	public void setL0(double l0){
		this.l0=l0;
	}
	public Vector2D getZ(){
		return z;
	}

	public void setZ(Vector2D z){
		this.z=z;
	}
	public Vector2D getV(){
		return v;
	}

	public void setV(Vector2D v){
		this.v=v;
	}
	public Vector2D getXl(){
		return xl;
	}

	public void setXl(Vector2D xl){
		this.xl=xl;
	}
	
	public double getG(){
		return g;
	}

	public void setG(double g){
		this.g=g;
	}
	
	
	public void Przebieg(double dt){
		
		//stworzenie obiektow klasy Vector2D do przechowywania poszczegolnych si³ i wykorzystania klasy Vector 2D w obliczeniach
		
		 Vector2D Wyp=new Vector2D(); //sila wypadkowa
		 Vector2D Graw=new Vector2D(0,m*g); //sila grawitacji
		 Vector2D Fs=new Vector2D(); //sila sprezystosci
		 Vector2D Fb=new Vector2D(); //sila tlumienia
		 
		 
		 Fs=xl.Substraction(z).Norm().Multiplication(k*(z.Substraction(xl)).Length()-l0); //obliczenie sily sprezystosci
		 Fb=v.Multiplication(-b); // (przeciwny zwrot do ruchu dlatego -b)
		 Wyp=Fs.Addition(Fb).Addition(Graw);
		 
		 v=v.Addition(Wyp.Multiplication(dt/m)); //obliczenie predkosci z metody Eulera
		 z=z.Addition(v.Multiplication(dt)); //obliczenie polozenia masy z metody Eulera
		 //System.out.println(z.x+" ; "+z.y);
		
		}
	
	//metoda zerujaca predkosc
	
	public void Zeruj(){
	v.x=0;
	v.y=0;
		
	}
	
}
