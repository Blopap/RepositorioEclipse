package JuegoCartasJavadoc;


/**
 * Clase que representa una carta para un juego de cartas.
 * @author Pablo Amilburu
 *
 */
public class Carta {
	
	private int palo;
	private int numero;
	private final static String [] palos={ "oros", "copas", "espadas", "bastos"};
	private final static String [] nums={ "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "", "", "Sota", "Caballo", "Rey"};
	
	/**
	 * Crea una carta a partir de su palo y su indice.
	 * @param palo El palo de la carta.
	 * @param num El indice de la carta.
	 */
	public Carta(int palo,int num)
	{
		this.palo=palo;
		this.numero=num;
		
	}
	
	/**
	 * Cambia el valor del palo.
	 * @param palo Nuevo valor del palo.
	 */
	public void setPalo(int palo)
	{
		this.palo=palo;
	}
	
	/**
	 * Devuelve el palo de la carta.
	 * @return El valor del palo.
	 */
	public int getPalo()
	{
		return this.palo;
	}
	
	/**
	 * Cambia el valor del indice.
	 * @param num Nuevo valor del indice.
	 */
	public void setNumero(int num)
	{
		this.numero=num;
	}
	
	/**
	 * Devuelve el valor del indice.
	 * @return El valor del indice.
	 */
	public int getNum()
	{
		return this.numero;
	}
	
	/**
	 * Devuelve el valor del indice multiplicado por diez.
	 * @return El valor de la carta.
	 */
	public double valor()
	{
		return  Math.pow(10, this.numero);
	}
	
	/**
	 * Devuelve una cadena con el valor de la carta.
	 * @return Devuelve la cadena.
	 */
	public String muestra()
	{		
		return Carta.nums[this.numero-1] + " de "+ Carta.palos[this.palo-1];
	}
}
