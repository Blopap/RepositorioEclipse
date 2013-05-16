package rutinas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rutinas {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	// Lee un entero cualquiera
	public static int generaaleatorio(int vini, int vfin) {
		// Números entre vini y vfin
		return (int) (Math.random() * (vfin - vini + 1) + vini);
	}

	public static boolean continuar() {

		String conti = "";
		conti = leeString("Deseas continuar...").toUpperCase();
		if (conti.substring(0, 1).equals("S"))
			return true;
		else
			return false;

	}
	
	public static boolean leeBooleano(String mensaje) {
		boolean error = false;
		boolean dec = false;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				if(br.readLine().toLowerCase().startsWith("s"))
				{
					dec=true;
				}
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			}
		} while (error);

		return (dec);
	}

	// Lee una cadena
	public static String leeString(String mensaje) {
		boolean error = false;
		String fra = "";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				fra = br.readLine();
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			}
		} while (error);

		return (fra);
	}
	
	//Lee un float
	public static float leeFloat(String mensaje) {
		boolean error = false;
		float num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Float.parseFloat(n);
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero real ");
				error = true;
			}
		} while (error);

		return (num);
	}
	
	// Lee un float entre limites
	public static float leeFloat(String mensaje, double Inf, double Sup) {
		boolean error = false;
		float num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Float.parseFloat(n);
				if (num < Inf | num > Sup) {
					System.out.println("Nmuero incorrecto. Debe estar entre "
							+ Inf + " y " + Sup);
					error = true;
				}

			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}

	// Lee un double
	public static double leeDouble(String mensaje) {
		boolean error = false;
		double num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Double.parseDouble(n);
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero real ");
				error = true;
			}
		} while (error);

		return (num);
	}
	
	// Lee un double entre limites
	public static double leeDouble(String mensaje, double Inf, double Sup) {
		boolean error = false;
		double num = 0;
		String n="";
		do {
			error = false;
			try {
				System.out.println(mensaje);
				n = br.readLine().replace(",", ".");
				num = Double.parseDouble(n);
				if (num < Inf | num > Sup) {
					System.out.println("Nmuero incorrecto. Debe estar entre "
							+ Inf + " y " + Sup);
					error = true;
				}

			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}

	// Lee un entero entre limites
	public static int leeEntero(String mensaje, int Inf, int Sup) {
		boolean error = false;
		int num = 0;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				num = Integer.parseInt(br.readLine());
				if (num < Inf | num > Sup) {
					System.out.println("Numero incorrecto. Debe estar entre "
							+ Inf + " y " + Sup);
					error = true;
				}

			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}
	
	//Lee un entero con limite inferior.
	public static int leeEntero(String mensaje, int Inf) {
		boolean error = false;
		int num = 0;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				num = Integer.parseInt(br.readLine());
				if (num < Inf) {
					System.out.println("Numero incorrecto. Debe ser superior a "
							+ Inf);
					error = true;
				}

			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}

	public static int leeEntero(String mensaje) {

		boolean error = false;
		int num = 0;
		do {
			error = false;
			try {
				System.out.println(mensaje);
				num = Integer.parseInt(br.readLine());
			} catch (IOException io) {
				System.out.println("Atencion problemas al leer desde teclado "
						+ io.getMessage());
				error = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Ojito no es un numero entero ");
				error = true;
			}
		} while (error);

		return (num);
	}
	
	public static Date leeFecha(String mensa){
		Date fecha= new Date();
		boolean valida=false;
		do{
		String sfec =Rutinas.leeString(mensa);
		valida=Rutinas.isFechaValida( sfec , fecha);
		if (! valida){
			System.out.print("Fecha incorrecta");
		}
		fecha = new Date(Date.parse(sfec));
		} while (! valida);
	return fecha;
	
	}
	
	private static boolean isFechaValida(String fechax ,Date fecha) {
		
		try {
		SimpleDateFormat formatoFecha = new
		SimpleDateFormat("dd/MM/yyyy");
		formatoFecha.setLenient(false);
		fecha=formatoFecha.parse(fechax);
		} catch (ParseException e) {
		return false;
		}
		return true;
		}
	
	public static void muestraelemento(int indice, double array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}

	public static void muestraelemento(int indice, int array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}

	public static void muestraelemento(int indice, String array[]) {
		if (indice != array.length - 1)
			System.out.print(array[indice] + ", ");
		else
			System.out.print(array[indice] + "]");
	}
	
	//comprueba que la cadena esta compuesta por numeros
    public static boolean isNumeros(String cad)
    {
    	boolean corr=true;
    	int tam=cad.length();
    	int i=0;
    	
    	while(corr && i<tam)
    	{
    		corr=Character.isDigit(cad.charAt(i));
    		i++;
    	}
    	return corr;
    }
	
	 //metodo para validar correo electronico
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean updateBD(String sql,String url, String driver)
    //Realiza modificaciones o agregaciones de datos en la Base de datos cuya direccion es "url" 
    //utilizando el driver "driver". Ejecuta la sentencia SQL "sql".
    {
    	Connection con =null;
    	boolean estado=false;
    	
    	try{
    		
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			con.setAutoCommit(false);
			
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate(sql);

			//con.rollback();
			con.commit();
			stmt.close();
			return true;
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			if(con!=null)
			{
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("Excepcion capturada de SQL: "+e.toString());
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("No se puede cerrar la conexion: "+e.toString());
			}
		}
    	return estado;
    }
    

}
