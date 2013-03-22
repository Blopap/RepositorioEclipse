package Tema5;

public class Coche {
	private int velocidad;
	private static final int velmax=120;
	
	public Coche(){
		this.velocidad=80;
	}
	
	public String MuestraVelocidad()
	{
		return "La velocidad es: "+this.velocidad;
	}
	public void Acelerar(int a)
	{
		if(this.velocidad+a <= Coche.velmax)
		{
			this.velocidad=this.velocidad+a;
		}
	}
	public void Frenar (int a)
	{
		if(this.velocidad-a >=0)
		{
			this.velocidad=this.velocidad-a;
		}
		else
		{
			this.velocidad=0;
		}
	}
	

}
