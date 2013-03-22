package juegoCartas;

public class Carta {
	
	private int palo;
	private int numero;
	private final static String [] palos={ "oros", "copas", "espadas", "bastos"};
	private final static String [] nums={ "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "", "", "Sota", "Caballo", "Rey"};
	
	public Carta(int palo,int num)
	{
		this.palo=palo;
		this.numero=num;
		
	}
	
	public void setPalo(int palo)
	{
		this.palo=palo;
	}
	public int getPalo()
	{
		return this.palo;
	}
	
	public void setNumero(int num)
	{
		this.numero=num;
	}
	
	public int getNum()
	{
		return this.numero;
	}
	
	public double valor()
	{
		return  Math.pow(10, this.numero);
	}
	
	public String muestra()
	{		
		return Carta.nums[this.numero-1] + " de "+ Carta.palos[this.palo-1];
	}
}
