package Tema8;

import rutinas.Rutinas;

class Ordenador {
	static double totalpre;
	private String _marca;
	private double _precio;

	Ordenador(String mar, double prec) {
		set_marca(mar);
		set_precio(prec);
	}

	Ordenador() {
	}

	public void set_marca(String mar) {
		if (mar.length() > 10)
			mar = mar.substring(0, 10);
		_marca = mar;
	}

	public void set_precio(double prec) {
		_precio = prec;
	}

	public String mostrarmarca() {
		String rdo = _marca;
		return rdo;
	}

	public double mostrarprecio() {
		double rdo1 = _precio;
		return rdo1;
	}

	// Añadido getClass() y cambiados los separadores de "\t" a ","
	public String toString() {
		String rdo3 = getClass() + "," + mostrarmarca() + ","
				+ this.mostrarprecio();
		return rdo3;
	}

	public void datos() {
		String mar = Rutinas.leeString("Introduce la marca del ordenador: ");
		double prec = Rutinas.leeDouble("Introduce el precio del ordenador: ");
		set_marca(mar);
		set_precio(prec);
	}
}

class Portatil extends Ordenador {
	private int _peso;

	Portatil(String mar, double prec, int pes) {
		super(mar, prec);
		set_peso(pes);
	}

	Portatil() {
	}

	public void set_peso(int pes) {
		_peso = pes;
	}

	public int mostrarpeso() {
		int rdo2 = _peso;
		return rdo2;
	}

	// Cambiado el separador de "\t" a ","
	public String toString() {
		String rdo3 = super.toString() + "," + mostrarpeso();
		return rdo3;
	}

	public void datos() {
		super.datos();
		int peso = Rutinas.leeEntero("Introduce el peso del ordenador: ");
		set_peso(peso);
	}
}

class Netbook extends Portatil {
	private double _pantalla;

	Netbook(String marca, double precio, int peso, double pantalla) {
		super(marca, precio, peso);
		set_pantalla(pantalla);
	}

	Netbook() {
	}

	public double get_pantalla() {
		return _pantalla;
	}

	public void set_pantalla(double pantalla) {
		this._pantalla = pantalla;
	}

	// Cambiado el separador de "\t" a ","
	public String toString() {
		return super.toString() + "," + get_pantalla();
	}

	public void datos() {
		super.datos();
		double panta = Rutinas.leeDouble("Introduce la pantalla del Netbook: ");
		set_pantalla(panta);
	}

	public String pontegafas() {
		return ("Prueba casting metodo propio");
	}

}
