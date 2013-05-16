package proyectoProgramacion;

import java.util.Vector;

public class GestorDatos {
	
	//Gestion local de la base de datos.
	private static Vector<Cliente> vClientes=new Vector<Cliente>();
	//private static Vector<Vehiculo> vVehiculo = new Vector<Vehiculo>();
	
	public static void añadirCliente(Cliente c)
	//Añade el cliente c al vector local.
	{
		vClientes.add(c);
	}
	
	public static boolean existeDniCliente(String dni)
	//Comprueba si existe el dni "dni" en el vector local.
	//Devuelve true si EXISTE dicho dni y false en caso contrario.
	{
		boolean estado=false;
		
		for(int i=0;!estado && i<vClientes.size();i++)
		{
			if(vClientes.get(i).getDni().equals(dni))
			{
				estado=true;
			}
		}
				
		return estado;
	}
	
	public static boolean existeNombreCliente(String nombre)
	//Comprueba si existe un nombre "nombre" parecido en el vector local.
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado=false;
		
		for(int i=0;!estado && i<vClientes.size();i++)
		{
			if(vClientes.get(i).getNombre().contains(nombre))
			{
				estado=true;
			}
		}
		
		return estado;
	}
	
	public static boolean existeApellidosCliente(String apellidos)
	//Comprueba si existe unos apellidos "apellidos" parecidos en el vector local.
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado=false;
		
		for(int i=0;!estado && i<vClientes.size();i++)
		{
			if(vClientes.get(i).getApellidos().contains(apellidos))
			{
				estado=true;
			}
		}
		
		return estado;
	}
	
	public static Cliente devuelveClienteDni(String dni)
	//Busca el cliente cuyo dni sea "dni" y devuelve todo sus datos
	{
		Cliente aux=null;
		boolean estado=false;
		
		for(int i=0;!estado && i<vClientes.size();i++)
		{
			if(vClientes.get(i).getDni().equals(dni))
			{
				aux=vClientes.get(i);
				estado=true;
			}
		}
		
		return aux;
	}
	public static Vector<Cliente> devuelveClienteNombreApellidos(String nombre,String apellidos)
	//Busca todos los clientes cuyos nombre y apellidos coincidan con la busqueda y devuelve sus datos.
	{
		Vector<Cliente> aux=new Vector<Cliente>();
		
		for(int i=0;i<vClientes.size();i++)
		{
			if(vClientes.get(i).getNombre().contains(nombre) && vClientes.get(i).getApellidos().contains(apellidos))
			{
				aux.add(vClientes.get(i));
			}
		}
		
		return aux;
	}
	
	
	public static boolean comprobarDatos(String dni,String nombre,String apellidos)
	//Comprueba si existe un cliente con dni "dni"
	//o al menos un cliente con nombre coincidente a "nombre" y apellidos coincidentes a "apellidos"
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado=false;
		if(!dni.equals(""))
		{
			estado = existeDniCliente(dni);
		}
		else if (existeNombreCliente(nombre) && existeApellidosCliente(apellidos))
		{
			estado = true;
		}
		return estado;
	}
	
	public static Vector<Cliente> obtenerDatos(String dni,String nombre,String apellidos)
	//Devuelve los datos de aquellos clientes cuyo:
	//Dni sea "dni" o si esta vacio:
	//Nombre se parezca a "nombre" y Apellidos se parezca a "apellidos"
	{
		Vector<Cliente> aux=new Vector<Cliente>();
		
		if(!dni.equals(""))
		{
			aux.add(devuelveClienteDni(dni));
		}
		else
		{
			aux=devuelveClienteNombreApellidos(nombre, apellidos);
		}
		
		return aux;
	}
	
	public static Vector<String> DniNomApClientes()
	//Devuelve un vector del dni nombre y apellidos de los clientes.
	{
		Vector<String> aux=new Vector<String>();
		
		for(int i=0;i<vClientes.size();i++)
		{
			aux.add(vClientes.get(i).getDni()+" "+ 
					vClientes.get(i).getNombre()+" "+
					vClientes.get(i).getApellidos());
		}
		
		return aux;
	}

}
