package juegoCartas;

public class CartaContador extends Carta{
	
	private int contador;
	
	
	public CartaContador(int palo,int num)
	{
		super(palo, num);
		this.contador=0;
	}
	
	public int getContador()
	{
		return this.contador;
	}

}
