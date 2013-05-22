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
	
	//CLIENTES
	
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
			System.out.println("Excepción capturada de SQL: "+e.toString());
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
				System.out.println("No se puede cerrar la conexión: "+e.toString());
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
				
				GestorDatos.anyadirCliente(c);
			}
			
			rs.close();
			stmt.close();
			estado=true;
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			System.out.println("Excepción capturada de SQL: "+e.toString());
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
				System.out.println("No se puede cerrar la conexión: "+e.toString());
			}
		}
		
		return estado;
	}
	
	public static boolean modificarCliente(Cliente c)
	//Modifica los datos del cliente c en la base de datos
	{
		boolean estado=false;
		String sql;
		
		Boolean s=c.getSexo();
		
		boolean fechaN=c.getFechaNacimiento()==null || c.getFechaNacimiento().isEmpty();
		
		if(fechaN)
		{
			
			sql="UPDATE  "+bdnombre+".cliente SET  " +
					" Nombre =  '"+c.getNombre()+"' ," +
					" Apellidos =  '"+c.getApellidos()+"' ," +
					" Sexo =  '"+s.compareTo(false)+"' ," +//Si es hombre, sexo true, compareTo devuelve 1 cuando son distintos
					" Direccion =  '"+c.getDireccion()+"' ," +
					" CodigoPostal =  "+c.getCodigoPostal()+" ," +
					" Ciudad =  '"+c.getCiudad()+"' ," +
					" Telefono =  "+c.getTelefono()+" ," +
					" FechaNacimiento = NULL "+
					" WHERE  cliente.Dni =  '"+c.getDni()+"' ;";
		}
		else
		{
			sql="UPDATE  "+bdnombre+".cliente SET  " +
					" Nombre =  '"+c.getNombre()+"' ," +
					" Apellidos =  '"+c.getApellidos()+"' ," +
					" Sexo =  '"+s.compareTo(false)+"' ," +//Si es hombre, sexo true, compareTo devuelve 1 cuando son distintos
					" Direccion =  '"+c.getDireccion()+"' ," +
					" CodigoPostal =  "+c.getCodigoPostal()+" ," +
					" Ciudad =  '"+c.getCiudad()+"' ," +
					" Telefono =  "+c.getTelefono()+" ," +
					" FechaNacimiento =  '"+c.getFechaNacimiento()+"' " +
					" WHERE  cliente.Dni =  '"+c.getDni()+"' ;";
		}
		estado = Rutinas.updateBD(sql, url, driver);
				
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
	//Inserta el cliente c en la base de datos 
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
	
	//VEHICULOS
	
	public static boolean insertarVehiculo(Vehiculo v)
	//Inserta los datos del vehiculo v en la base de datos
	{
		String sql="INSERT INTO  "+bdnombre+".`vehiculo` " +
				"(`IdVehiculo` ,`Duenyo` ,`Marca` ,`Modelo` , " +
				"`Color` ,`FechaFabricacion`) " +
				"VALUES ('"+v.getIdVehiculo()+"',  " +
				"'"+v.getDuenyo()+"',  " +
				"'"+v.getMarca()+"',  " +
				"'"+v.getModelo()+"',  " +
				"'"+v.getColor()+"',  " +
				"'"+v.getFechaFabricacion()+"');";
		
		return Rutinas.updateBD(sql, url, driver);
	}
	
	public static boolean cargaVehiculos()
	//Carga los datos de la base de datos al vector local de vehiculos.
	{
		boolean estado=false;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from Vehiculo";			
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				Vehiculo v = new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				
				GestorDatos.anyadirVehiculo(v);			
				
			}
			
			rs.close();
			stmt.close();
			estado=true;
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			System.out.println("Excepción capturada de SQL: "+e.toString());
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
				System.out.println("No se puede cerrar la conexión: "+e.toString());
			}
		}
		
		return estado;
	}
	
	public static boolean modificarVehiculo(Vehiculo v)
	//Modifica los datos del vehiculo v en vehiculo
	{
		boolean estado=false;
		String sql;
		
		boolean color = v.getColor()==null || v.getColor().isEmpty();
		
		boolean fechaFab = v.getFechaFabricacion()==null || v.getFechaFabricacion().isEmpty();
		
		
		//fechaN=c.getFechaNacimiento()==null || c.getFechaNacimiento().isEmpty();
		
		if(color && fechaFab)
		{
			sql = "UPDATE  "+bdnombre+".vehiculo SET  " +
					" Marca =  '"+v.getMarca()+"'," +
					" Modelo =  '"+v.getModelo()+"'," +
					" Color =  NULL ," +
					" FechaFabricacion =  NULL " +
					" WHERE  vehiculo.IdVehiculo = "+v.getIdVehiculo()+";";
		}
		else if(color)
		{
			sql = "UPDATE  "+bdnombre+".vehiculo SET  " +
					" Marca =  '"+v.getMarca()+"'," +
					" Modelo =  '"+v.getModelo()+"'," +
					" Color =  NULL ," +
					" FechaFabricacion =  '"+v.getFechaFabricacion()+"' " +
					" WHERE  vehiculo.IdVehiculo = "+v.getIdVehiculo()+";";
		}
		else if(fechaFab)
		{
			sql = "UPDATE  "+bdnombre+".vehiculo SET  " +
					" Marca =  '"+v.getMarca()+"'," +
					" Modelo =  '"+v.getModelo()+"'," +
					" Color =  '"+v.getColor()+"'," +
					" FechaFabricacion =  NULL " +
					" WHERE  vehiculo.IdVehiculo = "+v.getIdVehiculo()+";";
		}
		else
		{
			sql = "UPDATE  "+bdnombre+".vehiculo SET  " +
					" Marca =  '"+v.getMarca()+"'," +
					" Modelo =  '"+v.getModelo()+"'," +
					" Color =  '"+v.getColor()+"'," +
					" FechaFabricacion =  '"+v.getFechaFabricacion()+"' " +
					" WHERE  vehiculo.IdVehiculo = "+v.getIdVehiculo()+";";
		}
				
		estado = Rutinas.updateBD(sql, url, driver);
				
		return estado;
	}
	
	
	//OPERACIONES
	
	public static boolean insertarOperacion(Operacion o)
	//Inserta una nueva operacion en la base de datos
	{
		String sql = "INSERT INTO "+bdnombre+".`operacionesvehiculos` " +
				"(`IdOperacion`, `Vehiculo`, `RevCambio`, " +
				"`Descripcion`, `FechaEntrada`, `FechaSalida`) " +
				"VALUES ("+o.getIdOperacion()+", " +
				""+o.getVehiculo()+", " +
				""+o.getRevCambio()+", " +
				"'"+o.getDescripcion()+"', " +
				"'"+o.getFechaEntrada()+"', " +
				""+o.getFechaSalida()+" );";
		return Rutinas.updateBD(sql, url, driver);
		
	}
	
	public static boolean cargaOperaciones()
	//Carga los datos de la base de datos al vector local de operaciones.
	{
		boolean estado=false;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from operacionesVehiculos";			
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				Operacion o = new Operacion(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				
				GestorDatos.anyadirOperacion(o);			
				
			}
			
			rs.close();
			stmt.close();
			estado=true;
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			System.out.println("Excepción capturada de SQL: "+e.toString());
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
				System.out.println("No se puede cerrar la conexión: "+e.toString());
			}
		}
		
		return estado;
	}
	
	public static boolean modificarOperacion(Operacion o)
	//Actualiza los datos de la fecha de Salida.
	{
		boolean estado=false;
		String sql;
		
		sql = "UPDATE  "+bdnombre+".`operacionesvehiculos` SET  " +
				"`FechaSalida` =  '"+o.getFechaSalida()+"' " +
				"WHERE  `operacionesvehiculos`.`IdOperacion` = "+o.getIdOperacion()+";";
				
		estado = Rutinas.updateBD(sql, url, driver);
				
		return estado;
	}

}