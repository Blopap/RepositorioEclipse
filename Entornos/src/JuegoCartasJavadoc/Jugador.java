package JuegoCartasJavadoc;

import java.util.ArrayList;
import rutinas.Rutinas;

/**
 * Una clase que representa a un jugador en un juego de cartas
 * @author Pablo Blopap
 *
 */
public class Jugador {
	
	private ArrayList<Carta> cartas;
	private String nombre;
	
	/**
	 * Crea un nuevo jugador. 
	 * Pide por pantalla en nombre del jugador
	 * @param nCartasJ Asigna este valor al numero de cartas que tendrá el jugador.
	 */
	public Jugador(int nCartasJ)
	{
		this.cartas= new ArrayList<Carta>(nCartasJ);
		
		this.nombre=Rutinas.leeString("Introduzca el nombre del jugador");
	}
	
	/**
	 * Devuelve el nombre del jugador
	 * @return Nombre del jugador
	 */
	public String getNombre()
	{
		return this.nombre;
	}
	
	/**
	 * Devuelve una carta elegida del mazo del jugador.
	 * La carta se elimina del mazo.
	 * @param i Posicion en el mazo de la carta a devolver.
	 * @return Carta que se devuelve.
	 */
	public Carta echarCarta(int i)
	{
		Carta aux=this.cartas.get(i);
		this.cartas.remove(i);
		return aux;
	}
	
	/**
	 * Introduce en el mazo del jugador una Carta
	 * @param c Carta que se introduce en el mazo.
	 */
	public void recogerCarta(Carta c)
	{
		this.cartas.add(c);
	}
	
	/**
	 * Obtiene si el jugador tiene cartas en el mazo.
	 * @return true si no quedan cartas y false en caso contrario
	 */
	public boolean tieneCartas()
	{
		return this.cartas.isEmpty();
	}
	
	/**
	 * Devuelve una carta elegida del mazo del jugador.
	 * La cara no se elimina del mazo.
	 * @param i Posicion en el mazo de la carta a devolver.
	 * @return Carta que se devuelve.
	 */
	public Carta devCarta(int i)
	{
		return this.cartas.get(i);
	}
	
	/**
	 * Muestra por pantalla las cartas que tiene el jugador. 
	 */
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
	
	/**
	 * Devuelve el valor que tienen las cartas del jugador
	 * @return Valor de las cartas
	 */
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
