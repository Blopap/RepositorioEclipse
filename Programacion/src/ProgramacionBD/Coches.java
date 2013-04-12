package ProgramacionBD;

public class Coches {
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int anyo;
	private float precio;
	
	public Coches(String matricula, String marca, String modelo, String color,
			int anyo, float precio) {
		this.setMatricula(matricula);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setAnyo(anyo);
		this.setPrecio(precio);
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
