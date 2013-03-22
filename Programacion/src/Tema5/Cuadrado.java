package Tema5;

public class Cuadrado {
	
	private int lado1;
	private int lado2;
	
	public Cuadrado(int lado1, int lado2)
	{
		this.lado1=lado1;
		this.lado2=lado2;
	}
	public Cuadrado(int lado)
	{
		this.lado1=lado;
		this.lado2=lado;
	}
	public int getLado1()
	{
		return this.lado1;
	}
	public int getLado2()
	{
		return this.lado2;
	}
	public void setLado1(int lado)
	{
		this.lado1=lado;
	}
	public void setLado2(int lado)
	{
		this.lado2=lado;
	}
	
	public float area()
	{
		return this.lado1*this.lado2;
	}
	public void aumentarMismo(int aumento)
	{
		this.lado1=this.lado1*(aumento/100);
		this.lado2=this.lado2*(aumento/100);
		
	}
	public Cuadrado aumentarConNuevo(int aumento)
	{
		Cuadrado cuad=new Cuadrado(this.lado1*(aumento/100),this.lado2*(aumento/100));
		
		return cuad;
	}
	

}
