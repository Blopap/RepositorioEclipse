package ProgramacionBD;

import java.sql.*;

public class AccesoBDMySql {
	public static void main(String args[]){
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/TallerMecanico";
		Connection con=null;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from FacturaMecanica";
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			String conductores, marcas;
			int importes;
			
			while(rs.next())
			{
				conductores=rs.getString("Nombre");
				marcas=rs.getString("Marca");
				importes=rs.getInt("Importe");
				
				System.out.println("Conductor: "+conductores+". Marca: "+marcas+". Importe: "+importes);
			}
			
			rs.close();
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
