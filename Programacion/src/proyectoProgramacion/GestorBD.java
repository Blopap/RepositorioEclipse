package proyectoProgramacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rutinas.Rutinas;

public class GestorBD {
	
	private static String driver="com.mysql.jdbc.Driver";
	private static String bdnombre="bdproyecto";
	private static String url="jdbc:mysql://localhost:3306/"+bdnombre;
	
	static Connection con = null;
	
	
	public static boolean comprobarContrasenya(String u,String c)
	//Comprueba si el usuario y contraseña son correctas
	{
		boolean estado= false;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * " +
								"from usuarios " +
								"where Usuario = '"+u+"' " +
										"and Contrasenya = '"+c+"'";
			
			
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			if(rs.next())
			{
				estado=true;
			}
			
			rs.close();
			stmt.close();
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
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
	
	public static boolean cargaClientes()
	//Carga los datos de la base de datos al vector local de clientes.
	{
		boolean estado=false;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from Cliente ";			
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				boolean s=false;
				Integer tel=null;
				String fech=null;
				if(rs.getInt(4)==1)
				{
					s=true;
				}
				if(rs.getObject(8)!=null)
				{
					tel=rs.getInt(8);
				}
				if(rs.getObject(9)!=null)
				{
					fech=rs.getString(9);
				}
				
				
				Cliente c = new Cliente(rs.getString(1), 
						rs.getString(2), rs.getString(3), 
						s, rs.getString(5), rs.getInt(6), 
						rs.getString(7), tel, fech);
				
				GestorDatos.añadirCliente(c);
			}
			
			rs.close();
			stmt.close();
			estado=true;
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
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
	
//	public static boolean comprobarDniCliente(String dni)
//	//Comprueba si existe el dni "dni" en la base de datos.
//	//Devuelve true si NO EXISTE dicho dni y false en caso contrario.
	//Nota: Desusado, ahora se usa el vector local de datos.
//	{
//		boolean estado=true;
//		
//		try{
//			Class.forName(driver);
//			
//			con=DriverManager.getConnection(url,"root","");
//			
//			Statement stmt=con.createStatement();
//			
//			String sentenciaSQL="Select * " +
//								"from cliente " +
//								"where Dni = '"+dni+"'";			
//			
//			
//			ResultSet rs=stmt.executeQuery(sentenciaSQL);
//			
//			if(rs.next())
//			{
//				estado=false;
//			}
//			
//			rs.close();
//			stmt.close();
//		
//		}
//		catch(ClassNotFoundException e){
//			System.out.println("Controlador JDBC no encontrado: "+e.toString());
//		}
//		catch(SQLException e){
//			System.out.println("Excepcion capturada de SQL: "+e.toString());
//		}
//		finally{
//			try{
//				if(con!=null)
//				{
//					con.close();
//				}
//			}
//			catch(SQLException e)
//			{
//				System.out.println("No se puede cerrar la conexion: "+e.toString());
//			}
//		}
//		
//		return estado;
//	}
	

	public static boolean insertarCliente(Cliente c)
	{
		Boolean s=c.getSexo();
		
		String sql="INSERT INTO "+bdnombre+".`cliente` " +
				"(`Dni`, `Nombre`, `Apellidos`, `Sexo`, `Direccion`, " +
				"`CodigoPostal`, `Ciudad`, `Telefono`, `FechaNacimiento`) " +
				"VALUES ('"+c.getDni()+"', " +
						"'"+c.getNombre()+"', " +
						"'"+c.getApellidos()+"', " +
						"'"+s.compareTo(false)+"', " +//Si es hombre, sexo true, compareTo devuelve 1 cuando son distintos
						"'"+c.getDireccion()+"', " +
						"'"+c.getCodigoPostal()+"', " +
						"'"+c.getCiudad()+"', " +
						""+c.getTelefono()+" , " +
						""+c.getFechaNacimiento()+" );";
		return Rutinas.updateBD(sql, url, driver);
	}

}
