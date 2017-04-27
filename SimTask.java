package MojApplet;

import java.util.TimerTask;

//metoda dziedziczaca z klasy TimerTask
public class SimTask extends TimerTask {

	//prywatne pola do przechowywania obiektow danych klas
	
	private SimEngine obiekt1;
	private SpringApplet1 obiekt2;
	private double dt;
	
	public SimTask(SimEngine obiekt1, SpringApplet1 obiekt2, double dt){ //konstruktor z parametrami
		
		this.obiekt1=obiekt1;
		this.obiekt2=obiekt2;
		this.dt=dt;
		
	}
	
	//przeslonieta metoda run
	
	public void run(){
		
	obiekt1.Przebieg(dt); //wywolanie kroku
	
	
		obiekt2.repaint(); //odswierzenie wyswietlania powierzchni appletu
		
	}
	
}

