package Tema5;

public class Quebrado {

	private float upper;
	private float lower;
	
	public Quebrado()
	{
		this.upper=1;
		this.lower=1;
	}
	public Quebrado(float u,float l)
	{
		this.setUpper(u);
		this.setLower(l);
	}
	
	public void setUpper(float u)
	{
		this.upper=u;
	}
	
	public void setLower(float l)
	{
		if(l!=0)
		{
			this.lower=l;
		}
		else
		{
			this.lower=1;
		}
	}
	
	public float getUpper()
	{
		return this.upper;
	}
	public float getLower()
	{
		return this.lower;
	}
	
	public Quebrado suma(Quebrado b)
	{
		Quebrado aux= new Quebrado();
		
		if(this.getLower()==b.getLower())
		{
			aux.setUpper(this.getUpper()+b.getUpper());
			aux.setLower(this.getLower());
		}
		else
		{
			float mul=this.getLower()*b.getLower();
			float Ut=this.getUpper()*b.getLower();
			float Ub=b.getUpper()*this.getLower();
			
			aux.setUpper(Ut+Ub);
			aux.setLower(mul);
		}
		return aux;
	}
	
	public Quebrado resta(Quebrado b)
	{
		Quebrado aux=new Quebrado();
		
		if(this.getLower()==b.getLower())
		{
			aux.setUpper(this.getUpper()-b.getUpper());
			if(aux.getUpper()==0)
			{
				aux.setLower(1);
			}
			else aux.setLower(this.getLower());	
		}
		else
		{
			float mul=this.getLower()*b.getLower();
			float Ut=this.getUpper()*b.getLower();
			float Ub=b.getUpper()*this.getLower();
			
			aux.setUpper(Ut-Ub);
			aux.setLower(mul);
		}
		return aux;
	}
	
	public Quebrado multiplicacion(Quebrado b)
	{
		return new Quebrado(this.getUpper()*b.getUpper(),this.getLower()*b.getLower());
	}
	
	public Quebrado division(Quebrado b)
	{
		return new Quebrado(this.getUpper()/b.getUpper(),this.getLower()/b.getLower());
	}
	
	public String toString()
	{
		return this.getUpper()+" / "+this.getLower();
	}
	
	public boolean equals(Quebrado b)
	{
		boolean igual=false;
		
		if(this.getUpper()==b.getUpper() && this.getLower()==b.getLower())
		{
			igual=true;
		}
		
		return igual;
	}
	

}
