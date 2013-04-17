package JuegoCartasJavadoc;

import java.util.ArrayList;
import rutinas.Rutinas;

public class Jugador {
	
	private ArrayList<Carta> cartas;
	private String nombre;
	
	public Jugador(int nCartasJ)
	{
		this.cartas= new ArrayList<Carta>(nCartasJ);
		
		this.nombre=Rutinas.leeString("Introduzca el nombre del jugador");
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Carta echarCarta(int i)
	{
		Carta aux=this.cartas.get(i);
		this.cartas.remove(i);
		return aux;
	}
	
	public void recogerCarta(Carta c)
	{
		this.cartas.add(c);
	}
	
	public boolean tieneCartas()
	{
		return this.cartas.isEmpty();
	}
	
	public Carta devCarta(int i)
	{
		return this.cartas.get(i);
	}
	
	public void mostrarCartas()
	{
		int tam=this.cartas.size();
		System.out.println("Jugador: "+this.nombre);
		for(int i=0;i<tam;i++)
		{
			System.out.print(this.cartas.get(i).muestra()+ " ");
		}
		System.out.println();
	}
	
	public double valorCartas()
	{
		double valor=0;
		
		for (int i=0; i<this.cartas.size();i++)
		{
			valor += this.cartas.get(i).valor();
		}
		
		return valor;
	}
	
	
	
	
	
	

}
