package sistema;


import java.util.TimerTask;
import java.util.Vector;

import graphic.VentanaPrincipal;

import java.util.Timer;

public final class TimerTick {
	
	int contadorTickEx = 0;
	
	public TimerTick () {
		Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                contadorTickEx++; 
                System.out.println("Horas de ejecución: " + contadorTickEx);
                
                
            }
        };
        
        timer.schedule(tarea, 1000, 1000); 
		
	}
	
}
