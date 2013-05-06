package JuegoCartasJavadoc;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa una baraja para un juego de cartas.
 * @author Pablo Amilburu
 *
 */

public class Baraja {
	
	private ArrayList<Carta> baraja;
	
	/**
	 * Crea una baraja y la llena con cartas sin ordenar.
	 */
	public Baraja()
	{
		this.baraja= new ArrayList<Carta>();
		llenar();
		barajar();
		
	}
	
	
	/**
	 * Rellena una baraja con diez cartas de cuatro palos.
	 */
	public void llenar()
	{
		for (int i=1;i<=4;i++)
		{
			for (int j=1; j<=7;j++ )
			{
				baraja.add(new Carta(i,j));
			}
			for (int j=10; j<=12;j++)
			{
				baraja.add(new Carta(i,j));
			}
		}
	}
	
	/**
	 * Desordena la baraja.  
	 */
	public void barajar()
	{
		int tamaño,num,pos;
		Random random=new Random();
		
		ArrayList<Carta> aux = new ArrayList<Carta>();

		for (int i=0;i<=2;i++)
		{
			while(!this.baraja.isEmpty())
			{
				pos=0;
				tamaño=this.baraja.size();

				num=random.nextInt(tamaño);
				aux.add(pos,this.baraja.get(num));
				this.baraja.remove(num);
				pos=pos+1;
			}
			while(!aux.isEmpty())
			{
				pos=0;
				tamaño=aux.size();

				num=random.nextInt(tamaño);
				this.baraja.add(pos,aux.get(num));
				aux.remove(num);
				pos=pos+1;
			}


		}
	}
	
	
	/**
	 * Devuelve la primera carta de la baraja.
	 * @return La carta que ocupa la posicion cero de la baraja.
	 */
	public Carta sacarCarta()
	{
		Carta aux=this.baraja.get(0);
		this.baraja.remove(0);
		return aux;
	}
	
	/**
	 * Introduce una carta en la ultima posicion de la baraja.
	 * @param c La carta que se introduce en la baraja.
	 */
	public void meterCarta(Carta c)
	{
		this.baraja.add(this.baraja.size(),c);
	}
	
	/**
	 * Calcula si quedan cartas en la baraja.
	 * @return true si no quedan cartas y false en caso contrario.
	 */
	public boolean quedanCartas()
	{
		return this.baraja.isEmpty();
	}
	
	/**
	 * Calcula el numero de cartas que tiene la baraja.
	 * @return El numero de cartas de la baraja.
	 */
	public int numCartas()
	{
		return this.baraja.size();
	}

}
