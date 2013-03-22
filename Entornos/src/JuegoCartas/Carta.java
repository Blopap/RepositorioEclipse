/**
 * 
 */
package JuegoCartas;

/**
 * @author Pablo Blopap
 *
 */
public class Carta {
	
	private int num;
	private int palo;
	private final static String [] palos={ "oros", "copas", "espadas", "bastos"};
	private final static String [] nums={ "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete","Ocho","Nueve"};
	
	
	
	/**
	 * @param numero
	 * @param palo
	 */
	
	public Carta(int numero, int palo) {
		this.num = numero;
		this.palo = palo;
	}
	public int getNumero() {
		return num;
	}
	public void setNumero(int numero) {
		this.num = numero;
	}
	public int getPalo() {
		return palo;
	}
	public void setPalo(int palo) {
		this.palo = palo;
	}
	public double valor()
	{
		return  Math.pow(10, this.num);
	}
	
	public String muestra()
	{
		return Carta.nums[this.num] + " de "+ Carta.palos[this.palo];
	}
	

}
