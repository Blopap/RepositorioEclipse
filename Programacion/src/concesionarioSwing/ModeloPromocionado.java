package concesionarioSwing;

public class ModeloPromocionado extends Modelo implements java.io.Serializable{
	private float descuento;

	public ModeloPromocionado()
	{}
	
	public ModeloPromocionado(int codigoModelo, String descripcion, float pvp, float descuento) {
		super(codigoModelo, descripcion, pvp);
		this.setDescuento(descuento);
	}

	public float getDescuento() {
		return this.descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	public String toString() {
		return super.toString()+"     "+this.descuento;
	}
	
	

}
