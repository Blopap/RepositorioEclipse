package concesionarioSwing;

public class Modelo implements java.io.Serializable{
	private int codigoModelo;
	private String descripcion;
	private float pvp;

	public Modelo()
	{
	}
	
	public Modelo(int codigoModelo, String descripcion, float pvp) {
		this.setCodigoModelo(codigoModelo);
		this.setDescripcion(descripcion);
		this.setPvp(pvp);
	}


	public int getCodigoModelo() {
		return this.codigoModelo;
	}


	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPvp() {
		return this.pvp;
	}


	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public String toString() {
		return this.codigoModelo+"    \n"+this.descripcion+"     \n"+this.pvp;
	}
	
	
	
	
	
	
	
	
	

}
