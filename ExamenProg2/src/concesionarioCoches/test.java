package concesionarioCoches;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Modelo mod = new Modelo(1, "sfds", 1231);
		
		System.out.println(mod.getClass());
		
		ModeloPromocionado mod2 = new ModeloPromocionado(2,"sdfds",123,21);
		
		System.out.println(mod2.getClass().equals(mod2.getClass()));
//		Concesionarios con= new Concesionarios();
//		
//		con.altaConcesionario();
//		
//		System.out.println(con.toString());
//		
//		con.anyadirModelo(1, new Modelo(1,"adfas",123),4);
//		
//		con.anyadirModelo(1, new Modelo(2,"adfas",1234),5);
//		
//		con.anyadirModelo(1, new Modelo(3,"adfas",1235),6);
//		
//		con.anyadirModelo(1, new Modelo(4,"adfas",1236),7);
//		
//		con.altaConcesionario();
//		
//		con.altaConcesionario();
//		
//		System.out.println(con.toString());

	}

}
