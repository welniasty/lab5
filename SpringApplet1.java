	package MojApplet;

//zaimportowanie bibliotek 


import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import java.util.Timer;

// implementacja interfejsu MouseListener, MouseMotionListener oraz ActionListener
public class SpringApplet1 extends JApplet implements MouseListener, MouseMotionListener, ActionListener {

	// prywatne pola do przechowywania obiektow danych klas
	
	private SimEngine obiekt3;
	private SimTask obiekt4;
	private Timer timer;
	
	// zmienna typu bool do przechowywania stanu myszy (mowi o tym czy kursor jest w dany momencie "przeci¹gany")
	boolean mDrag;
	//prywatne pola do przechowywania polozenia kursora myszy
	private int x,y;
//metody konieczne do implementacji metod  MouseListener i MouseMotionListener
    public void mouseDragged(MouseEvent arg0) {
    	
//sprawdzenie czy wystepuje "przeciaganie" myszy
    	if(mDrag==true){
    		//ustawienie pozycji masy zgodnie z pozycja kursora
    		Vector2D a = new Vector2D(arg0.getX(),arg0.getY());
    		obiekt3.setZ(a);
    		//wywolanie metody repaint
    		repaint();
    		arg0.consume();
    	}
    	
        System.out.println("mouseDragged");
    }
 
  
    public void mouseMoved(MouseEvent arg0) {
        System.out.println("mouseMoved");
    }
 

    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }
 
   
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }
 
   
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }
 
  
    public void mousePressed(MouseEvent e) {
    	
    	//odczytanie polozenia kursora
    	x = e.getX();
    	y = e.getY();
    	
    	//warunek czy kursor znajduje sie na owalu reprezentuj¹cym po³o¿enie masy
    	if (obiekt3.getZ().x <= x && x <= obiekt3.getZ().x+20 && obiekt3.getZ().y<= y && obiekt3.getZ().y +20 >= y){
    		//wylaczenie timera
    		timer.cancel();
    		timer.purge();
    		//wyzerowanie predkosci masy
    		obiekt3.Zeruj();
    		//zmiana stanu logicznego myszy na true
    		mDrag=true;
    		//wywolanie metody consume()
    		e.consume();
    	}
    	
        System.out.println("mousePressed");
    }
 
    
    public void mouseReleased(MouseEvent e) {
    	//sprawdzenie czy wystapilo "przeciaganie myszy"
    	if(mDrag==true){
    		//wlaczenie timera
    		timer = new Timer();
    		//timer.scheduleAtFixedRate(obiekt4, 0, 5); 
    		obiekt4 = new SimTask(obiekt3, this , 0.04);
    		timer.scheduleAtFixedRate(obiekt4, 0, 5);
    		mDrag=false; //ustawienie wartosci false - koniec "przeciagania" myszy
    		e.consume();
    	}
    	
        System.out.println("mouseReleased");
    }
    
    //metoda konieczna do implementacji interfejsu ActionListener
    public void actionPerformed(ActionEvent e) {
    
    	//stworzenie obiektu typu Object, aby znac zrodlo zdarzenia 
    	Object zrodlo = e.getSource();
    	//sprawdzenie czy Ÿród³em akcji jest stworzony przycisk
    	if(zrodlo == breset) {
    		//wylaczenie timera
    		timer.cancel();
    		timer.purge();
    		//wyzerowanie predkosci (zresetowanie symulacji)
    		obiekt3.Zeruj();
    		
    		//ustawienie pozycji poczatkowej masy
    		double w = obiekt3.getXl().y + Double.parseDouble(tdl_spo_sprezyny.getText());
    		Vector2D nowy = new Vector2D(obiekt3.getXl().x, w);
    		obiekt3.setZ(nowy);
    		
    		//ustawienie parametrow symulacji wedlug wartosci wpisanych w pola tekstowe
    		obiekt3.setM(Double.parseDouble(tmasa.getText()));
    		obiekt3.setK(Double.parseDouble(twsp_sprezystosci.getText()));
    		obiekt3.setB(Double.parseDouble(twsp_tlumienia.getText()));
    		obiekt3.setG(Double.parseDouble(tprzyspieszenie_graw_.getText()));
    		obiekt3.setL0(Double.parseDouble(tdl_spo_sprezyny.getText()));
    		
    		//wywolanie metody repaint
    		
    		repaint();
    	}
    	
    	
    }
    
    
    //Prywatne pola do przechowywania elementów interfejsu graficznego
   private TextField tmasa, twsp_sprezystosci, twsp_tlumienia, tprzyspieszenie_graw_, tdl_spo_sprezyny;
   private Button breset;
   private Label lmasa, lwsp_sprezystosci, lwsp_tlumienia, lprzyspieszenie_graw_, ldl_spo_sprezyny;
   
    
   
   
	public void init(){
		
		
		
		setLayout(null);
		mDrag=false;
		//dodanie “nas³uchiwacza” myszy do appletu  
		addMouseListener(this);
		//dodanie “nas³uchiwacza” ruchu myszy do appletu 
        addMouseMotionListener(this);
        
        //inicjalizacja stworzonych pól obiektami oraz rozmieszczenie ich na powierzchni appletu
        tmasa = new TextField("");
        tmasa.setBounds(20,30,80,20);
        twsp_sprezystosci = new TextField("");
        twsp_sprezystosci.setBounds(130,30,80,20);
        twsp_tlumienia = new TextField("");
        twsp_tlumienia.setBounds(240,30,80,20);
        tprzyspieszenie_graw_ = new TextField("");
        tprzyspieszenie_graw_.setBounds(350,30,80,20);
        tdl_spo_sprezyny = new TextField("");
        tdl_spo_sprezyny.setBounds(460,30,80,20);
    
        lmasa = new Label("masa");
        lmasa.setBounds(20,10,110,20);
        lwsp_sprezystosci = new Label("wsp_sprezystosci");
        lwsp_sprezystosci.setBounds(130,10,110,20);
        lwsp_tlumienia = new Label("wsp_tlumienia");
        lwsp_tlumienia.setBounds(240,10,110,20);
        lprzyspieszenie_graw_ = new Label("przyspieszenie_g");
        lprzyspieszenie_graw_.setBounds(350,10,110,20);
        ldl_spo_sprezyny = new Label("dl_spo_sprezyny");
        ldl_spo_sprezyny.setBounds(460,10,110,20);
        
    //dodanie elementow do GUI
        add(tmasa);
        add(twsp_sprezystosci);
        add(twsp_tlumienia);
        add(tprzyspieszenie_graw_);
        add(tdl_spo_sprezyny);
        
        add(lmasa);
        add(lwsp_sprezystosci);
        add(lwsp_tlumienia);
        add(lprzyspieszenie_graw_);
        add(ldl_spo_sprezyny);
	
        	breset = new Button("Reset");
        	breset.setBounds(50,80,100,25);
        	add(breset);
        	//dodanie “nas³uchiwacza” do obiektu reprezentuj¹cego przycisk
        	breset.addActionListener(this);
		
        	
		//stworzenie obiektow ktore uzyjemy w konstruktorze
		Vector2D z = new Vector2D(500,150);
		Vector2D v = new Vector2D(0,0);
		Vector2D xl = new Vector2D(500,80);
	
		//stworzenie obiektow danych klas
		obiekt3 = new SimEngine(10.0,5.0,2.0,100.0,z,v,xl,9.81);
		obiekt4 = new SimTask(obiekt3, this , 0.04);
		timer = new Timer(); //stworzenie obiektu klasy timer
		timer.scheduleAtFixedRate(obiekt4, 0, 5); // uzycie metody timera (zadanie, czas pierwszego wyswietlenia, czas powtarzania zadania)
		
	}
	
	public void paint(Graphics g){
	
	
		g.clearRect(0,0,getWidth(),getHeight()); // wyczyszczenie powierzchni appletu
		
		setBackground(Color.GREEN);
		
		//narysowanie grafiki 
		
		g.drawLine((int) obiekt3.getXl().x, (int) obiekt3.getXl().y,(int) obiekt3.getZ().x, (int) obiekt3.getZ().y);
		
		g.drawLine((int) obiekt3.getXl().x-40, (int) obiekt3.getXl().y,(int) obiekt3.getXl().x+40, (int) obiekt3.getXl().y);
		
		g.drawOval((int) obiekt3.getZ().x - 10, (int) obiekt3.getZ().y, 20, 20);
					
	}
	
}
