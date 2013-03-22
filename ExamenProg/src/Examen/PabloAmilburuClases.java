
//Pablo Amilburu Fontecha
//Examen Programacion 10-12-2012

//He comprendido incorrectamente el enunciado del examen y he echo cosas distintas a las que has pedido.
//Si quieres, valorame lo que he echo, porque me he dado cuenta demasido tarde y ya no me daba tiempo a cambiarlo.

/*
Crear una clase ordenador con los atributos marca y precio. 
Crear una subclase que se denomine portatil con un atributo adicional que se denomine peso.
Crar con todos los metodos set get y constructores necesario o habituales.

Crear un programa que nos permita meter estos datos y mostrarlos en pantalla.
 */
package Examen;

import rutinas.Rutinas;
 class Ordenador {
	static double totalpre;
	private String _marca;
	private double _precio;
	private Procesador procesador;
	
	
	//Codigo cambiado/introducido por Pablo AmilburuFontecha
	Ordenador(String mar, double prec,Procesador proc) {
		set_marca(mar);
		set_precio(prec);
		setProcesador(proc);
	}
	Ordenador (){
		}

	public void setProcesador(Procesador proc)
	{
		this.procesador=proc;
	}
	
	public Procesador getProcesador()
	{
		return this.procesador;
	}
	
	public String mostrarProcesador()
	{
		return this.procesador.toString();
	}
	
	public String toString (){
		String rdo3=mostrarmarca() + "\t"  +this.mostrarprecio() + "\t" +this.mostrarProcesador();
		return rdo3;
	}
	
	public void datos() {
		String mar=Rutinas.leeString("Introduce la marca del ordenador: ");
		double prec=Rutinas.leeDoble("Introduce el precio del ordenador: ");
		Procesador proc=new Procesador();
		proc.datos();
		set_marca(mar);
		set_precio(prec);
		this.setProcesador(proc);
	}
	
	//FinCodigo
	
	
	public void set_marca(String mar) {
		if (mar.length()>10)
			mar=mar.substring(0, 10);	
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
	
	
}
class Portatil extends Ordenador {
	private int _peso;
	Portatil(String mar, double prec, int pes,Procesador proc) {//Incluido procesador en clase Portatil.
		super(mar, prec,proc);
		set_peso(pes);
	}
	Portatil() {}
	public void set_peso(int pes) {
		_peso = pes;
	}
	public int mostrarpeso(){
		int rdo2=_peso;
		return rdo2;
	}
	public String toString (){
		String rdo3=super.toString() + "\t" + mostrarpeso();
		return rdo3;
	}
	public  void datos() {
		super.datos();
		int peso =Rutinas.leeEntero("Introduce el peso del ordenador: ");
		set_peso(peso);
	}
}
class Netbook extends Portatil {
	private double _pantalla;
	Netbook(String marca, double precio, int peso, double pantalla,Procesador proc) {//Añadido procesador en clase Netbook
		super(marca, precio, peso,proc);
		set_pantalla(pantalla);
	}
	Netbook() {	}
	public double get_pantalla() {
		return _pantalla;
	}
	public void set_pantalla(double pantalla) {
		this._pantalla = pantalla;
	}
	public String toString() {
		return super.toString() + "\t" + get_pantalla();
	}
	public  void datos() {
		super.datos();
		double panta=Rutinas.leeDoble("Introduce la pantalla del Netbook: ");
		set_pantalla(panta);
	}
	public  String pontegafas() {
		return("Prueba casting metodo propio");
	}
	
}

//Clase añadida por Pablo Amilburu Fontecha

class Procesador{
	private int codigo;
	private String descripcion;
	
	public Procesador()
	{
	}
	
	public Procesador(int cod,String desc)
	{
		this.setCodigo(cod);
		this.setDescripcion(desc);
	}
	
	public int getCodigo()
	{
		return this.codigo;
	}
	
	public void setCodigo(int cod)
	{
		this.codigo=cod;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public void setDescripcion(String desc)
	{
		this.descripcion=desc;
	}
	
	public String toString()
	{
		//return "Procesador: "+"Codigo: "+this.codigo+" Descripcion: "+this.descripcion;
		
		return this.codigo +"\t"+this.descripcion;
	}
	
	public void datos()
	{
		int cod=Rutinas.leeEntero("Introduzca el codigo del procesador: ");
		String desc=Rutinas.leeString("Introduzca la descripcion del procesador: ");
		
		this.setCodigo(cod);
		this.setDescripcion(desc);
	}
	
}

//Fin clase añadida.