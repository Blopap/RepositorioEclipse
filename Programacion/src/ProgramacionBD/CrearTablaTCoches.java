package ProgramacionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaTCoches {
	
public static void main(String args[]){
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/bdcoches";
		String BDNombre="bdcoches";
		Connection con=null;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			con.setAutoCommit(false);
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL= "create table " + BDNombre + ".tcoches " +
					"(Matricula varchar(10) NOT NULL," +
					"Marca varchar(20) NOT NULL," +
					"Modelo varchar(20) NOT NULL," +
					"Color varchar(20) NULL," +
					"Anyo integer NULL ," +
					"Precio float NOT NULL ," +
					"PRIMARY KEY (Matricula))";
			stmt.executeUpdate(sentenciaSQL);
			
//			con.rollback();
			con.commit();
			
			stmt.close();
			
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
	}

}
