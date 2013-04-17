package JuegoCartasJavadoc;

import java.util.ArrayList;

import rutinas.Rutinas;

public class Partida {
	
	private Baraja baraja;
	
	private int numCartas;
	
	private ArrayList<Jugador> jugadores;
	
	public Partida(int numJ, int numCartasJ)
	{
		this.baraja=new Baraja();
		this.jugadores= new ArrayList<Jugador>(numJ);
		this.numCartas=numCartasJ;
		
		for (int i=0; i<numJ;i++)
		{
			this.jugadores.add(new Jugador(numCartasJ));
		}
	}
	
	public void repartir()
	{
		this.baraja.barajar();
		
		for (int i=0; i<numCartas;i++)
		{
			for (int j=0;j<this.jugadores.size();j++)
			{
				if(!this.baraja.quedanCartas())
				{
					this.jugadores.get(j).recogerCarta(this.baraja.sacarCarta());
				}
			}
		}
	}
	
	public void recojer()
	{
		int j;
		for (int i=0;i<this.jugadores.size();i++)
		{
			while(!this.jugadores.get(i).tieneCartas())
			{
				j=0;
				this.baraja.meterCarta(this.jugadores.get(i).echarCarta(j));
				j++;
			}
		}
	}
	
	
	public void descartar()
	{
		for(int i=0;i<this.jugadores.size();i++)
		{
			System.out.println("Jugador "+this.jugadores.get(i).getNombre());
			for (int j=0;j<numCartas;j++)
			{
				
				if(Rutinas.leeBooleano("Eliminar "+this.jugadores.get(i).devCarta(j).muestra()+"?  S/N"))
				{
					this.baraja.meterCarta(this.jugadores.get(i).echarCarta(j));
					this.jugadores.get(i).recogerCarta(this.baraja.sacarCarta());
				}
				
				
			}
			System.out.println();
		}
	}
	
	public void ganaGrande()
	{
		int jugador=0;
		double valorGrande=0;
		
		for (int i=0;i<this.jugadores.size();i++)
		{
			
			if(this.jugadores.get(i).valorCartas() > valorGrande)
			{
				jugador=i;
				valorGrande=this.jugadores.get(i).valorCartas();
			}
		}
		
		System.out.println("Gana el jugador "+this.jugadores.get(jugador).getNombre());
		System.out.println("Valor de las cartas: "+valorGrande);
		
	}
	
	public void jugar()
	{
		do{
			repartir();
			
			
			
			descartar();
			ganaGrande();
			
			
			
			
			recojer();
			
		}while(Rutinas.leeBooleano("Deseas continuar? S/N"));
	}
	
//	public void mostrarCartasJugadores()
//	{
//		for (int i=0;i<jugadores.size();i++)
//		{
//			this.jugadores.get(i).mostrarCartas();
//		}
//	}
	
	
	
	

}
