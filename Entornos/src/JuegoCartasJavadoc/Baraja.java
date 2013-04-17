package JuegoCartasJavadoc;

import java.util.ArrayList;
import java.util.Random;

public class Baraja {
	
	private ArrayList<Carta> baraja;
	
	public Baraja()
	{
		this.baraja= new ArrayList<Carta>();
		llenar();
		barajar();
		
	}
	
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
	
	public void barajar()
	{
		int tama�o,num,pos;
		Random random=new Random();
		
		ArrayList<Carta> aux = new ArrayList<Carta>();

		for (int i=0;i<=2;i++)
		{
			while(!this.baraja.isEmpty())
			{
				pos=0;
				tama�o=this.baraja.size();

				num=random.nextInt(tama�o);
				aux.add(pos,this.baraja.get(num));
				this.baraja.remove(num);
				pos=pos+1;
			}
			while(!aux.isEmpty())
			{
				pos=0;
				tama�o=aux.size();

				num=random.nextInt(tama�o);
				this.baraja.add(pos,aux.get(num));
				aux.remove(num);
				pos=pos+1;
			}


		}
	}
	
	public Carta sacarCarta()
	{
		Carta aux=this.baraja.get(0);
		this.baraja.remove(0);
		return aux;
	}
	
	public void meterCarta(Carta c)
	{
		this.baraja.add(this.baraja.size(),c);
	}
	
	public boolean quedanCartas()
	{
		return this.baraja.isEmpty();
	}
	
	public int numCartas()
	{
		return this.baraja.size();
	}

}
