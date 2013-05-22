package proyectoProgramacion;

import java.util.Vector;

public class GestorDatos {
	
	//Gestion local de la base de datos.
	private static Vector<Cliente> vClientes = new Vector<Cliente>();
	private static Vector<Vehiculo> vVehiculos = new Vector<Vehiculo>();
	private static Vector<Operacion> vOperaciones = new Vector<Operacion>();
	
	//TRATAMIENTO DE CLIENTES
	
	public static void anyadirCliente(Cliente c)
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
	
	
	public static boolean comprobarDatosCliente(String dni,String nombre,String apellidos)
	//Comprueba si existe un cliente con dni "dni"
	//o al menos un cliente con nombre coincidente a "nombre" y apellidos coincidentes a "apellidos"
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado=false;
		if(!dni.equals(""))
		{
			estado = existeDniCliente(dni);
		}
		else
		{
			estado = existeNombreCliente(nombre) && existeApellidosCliente(apellidos);
		}
		return estado;
	}
	
	public static Vector<Cliente> obtenerDatosCliente(String dni,String nombre,String apellidos)
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
	
	
	//TRATAMIENTO DE VEHICULOS
	
	public static void anyadirVehiculo(Vehiculo v)
	//Añade el Vehiculo "v" al vector vVehiculos
	{
		vVehiculos.add(v);
	}
	
	public static int siguienteIdentificadorVehiculo()
	//Devuelve el siguiente identificador de vehiculo para insertar.
	{
		return vVehiculos.size()+1;
	}
	
	public static boolean existeIdVehiculoVehiculo(Integer idVehiculo)
	//Comprueba si existe el identificador de vehiculo "id"
	//Devuelve true si EXISTE y false en caso contrario
	{
		boolean estado = false;
		
		if(idVehiculo > 0 && idVehiculo < vVehiculos.size())
		{
			estado=true;
		}
		
		return estado;
	}
	
	public static String ComboBoxDuenyo(String duenyo)
	//Transforma la cadena duenyo de tipo "dni nombre apellido"
	//Devuelve solo el dni.
	{
		String aux=duenyo;
		
		return aux.substring(0, aux.indexOf(" "));
		
	}
	
	public static boolean existeDuenyoVehiculo(String duenyo)
	//Comprueba si el dueño tiene vehiculos el vector local
	//Devuelve true si existe y false en caso contrario
	{
		boolean estado = false;
		if(duenyo.equals(""))
		{
			return true;
		}
		else
		{
			String aux = ComboBoxDuenyo(duenyo);
			for(int i=0;!estado && i<vVehiculos.size();i++)
			{
				if(vVehiculos.get(i).getDuenyo().equals(aux))
				{
					estado=true;
				}
			}
		}
		
		return estado;		
	}
	
	public static boolean existeMarca(String marca)
	//Comprueba si existe la marca "marca" en el vector local.
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado = false;
		
		for(int i=0;!estado && i<vVehiculos.size();i++)
		{
			if(vVehiculos.get(i).getMarca().contains(marca))
			{
				estado=true;
			}
		}
		
		return estado;
	}
	
	public static boolean existeModelo(String modelo)
	//Comprueba si existe el modelo "modelo" en el vector local.
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado = false;
		
		for(int i=0;!estado && i<vVehiculos.size();i++)
		{
			if(vVehiculos.get(i).getModelo().contains(modelo))
			{
				estado=true;
			}
		}
		
		return estado;
	}
	
	public static boolean comprobarDatosVehiculo(String id,String marca,String modelo)
	//Comprueba si existe un vehiculo con identificador de Vehiculo "id"
	//o al menos un vehiculo cuya marca coincide con "marca" y su modelo coincide con "modelo"
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean estado=false;
		
		if(!id.equals(""))
		{
			estado = existeIdVehiculoVehiculo(Integer.parseInt(id));
		}
		else
		{
			estado = existeMarca(marca) && existeModelo(modelo);
		}
		
		return estado;
	}
	
	public static Vehiculo devuelveVehiculoId(Integer id)
	//Devuelve el vehiculo cuyo identificador sea "id"
	{
		return vVehiculos.get(id-1);
	}
	
	public static Vector<Vehiculo> devuelveVehiculoDuenyo(String duenyo)
	//Busca todos los vehiculos cuyo dueño coincida con "duenyo" y devuelve sus datos.
	{
		Vector<Vehiculo> aux = new Vector<Vehiculo>();
		
		for(int i = 0;i<vVehiculos.size();i++)
		{
			if(vVehiculos.get(i).getDuenyo().equals(duenyo))
			{
				aux.add(vVehiculos.get(i));
			}
		}
		
		return aux;
	}
	
	public static Vector<Vehiculo> devuelveVehiculoMarcaModelo(String marca,String modelo)
	//Busca todos los vehiculos cuya marca coincida con "marca" y modelo con "modelo" y devuelve sus datos.
	{
		Vector<Vehiculo> aux = new Vector<Vehiculo>();
		
		for(int i = 0;i<vVehiculos.size();i++)
		{
			if(vVehiculos.get(i).getMarca().contains(marca) && vVehiculos.get(i).getModelo().contains(modelo))
			{
				aux.add(vVehiculos.get(i));
			}
		}
		
		return aux;
	}
	
	public static Vector<Vehiculo> obtenerDatosVehiculo(String id,String duenyo,String marca,String modelo)
	//Devuelve los datos de aquellos vehiculos cuyo:
	//Identificador de Vehiculo sea "id" o si esta vacio:
	//Dueño del vehiculo sea "duenyo" o si esta vacio:
	//Marca se parezca a "marca" y modelo se parezca a "modelo"
	{
		Vector<Vehiculo> aux=new Vector<Vehiculo>();
		
		if(!id.equals(""))
		{
			aux.add(devuelveVehiculoId(Integer.parseInt(id)));
		}
		else if(!duenyo.equals(""))
		{
			aux=devuelveVehiculoDuenyo(duenyo);
		}
		else 
		{
			aux=devuelveVehiculoMarcaModelo(marca, modelo);
		}
		
		return aux;
	}
	
	//TRATAMIENTO DE OPERACIONES
	
	public static void anyadirOperacion(Operacion o)
	//Añade el Vehiculo "v" al vector vVehiculos
	{
		vOperaciones.add(o);
	}
	
	public static int siguienteIdentificadorOperacion()
	//Devuelve el siguiente identificador de vehiculo para insertar.
	{
		return vOperaciones.size()+1;
	}
	
	public static int valorRevCambios(boolean aceite,
			boolean filtroAire,boolean filtroCombustible,
			boolean filtroAceite,boolean ruedas,boolean otros)
	//Obtiene el valor de las revisiones/cambios
	{
		Operacion aux = new Operacion();
		return aux.valorRevCambios(aceite, filtroAire, filtroCombustible, filtroAceite, ruedas, otros);
	}
	
	
	public static Vector<String> dniMarcaModeloVehiculos()
	//Devuelve el dni del cliente junto con la marca y el modelo de sus vehiculos.
	{
		Vector<String> vAux = new Vector<String>();
		
		String aux;
		
		for(int i = 0;i<vClientes.size();i++)
		{
			for(int j = 0;j<vVehiculos.size();j++)
			//Para cada cliente
			{
				
				if(vClientes.get(i).getDni().equals(vVehiculos.get(j).getDuenyo()))
				//Busca los vehiculos cuyo dueño coincida con el dni del cliente
				{
					
					aux = 	vVehiculos.get(j).getDuenyo()+" "+
							vVehiculos.get(j).getMarca()+" "+
							vVehiculos.get(j).getModelo();
					
					vAux.add(aux);
				}
			}
		}
		
		return vAux;
	}
	
	public static int identificadorVehiculoDniMarcaModelo(String dniMarcaModelo)
	//Busca a partir de la cadena que contiene el dni, marca y modelo
	//Aquel vehiculo que coincida y devuelve el identificador de dicho vehiculo.
	{
		int idVehiculo = 0;
		
		if(!dniMarcaModelo.equals(""))
		{
			boolean encontrado=false;
			
			String aux = dniMarcaModelo;
			
			String dni = aux.substring(0, aux.indexOf(" "));
			aux = aux.substring(dni.length()+1);
			String marca =aux.substring(0, aux.indexOf(" "));
			String modelo = aux.substring(marca.length()+1);
					
			for(int i = 0;!encontrado && i<vVehiculos.size();i++)
			{
				if(vVehiculos.get(i).getDuenyo().equals(dni) && 
						vVehiculos.get(i).getMarca().equals(marca) &&
						vVehiculos.get(i).getModelo().equals(modelo))
				{
					idVehiculo = vVehiculos.get(i).getIdVehiculo();
					encontrado=true;
				}
			}
		}
		return idVehiculo;
	}
	
	public static boolean comprobarDatosOperacion(int idVehiculo, String fechaEntrada)
	//Busca a partir del identificador del vehiculo ("idVehiculo") si existe una operacion echa a dicho vehiculo
	//o si existen operaciones echas a vehiculos en la fecha de "fechaEntrada"
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean encontrado=false;
		
		if(idVehiculo!=0)
		{
			encontrado=existeIdVehiculoOperacion(idVehiculo);
		}
		else if(!fechaEntrada.equals(""))
		{
			encontrado=existeFechaEntrada(fechaEntrada);
		}
		
		return encontrado;
	}
	
	public static boolean existeIdVehiculoOperacion(int idVehiculo)
	//Comprueba si se ha realizado alguna operacion al vehiculo con identificador "idVehiculo"
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean encontrado=false;
		
		for(int i=0;!encontrado && i<vOperaciones.size();i++)
		{
			if(vOperaciones.get(i).getVehiculo()==idVehiculo)
			{
				encontrado=true;
			}
		}
		
		return encontrado;
	}
	
	public static boolean existeFechaEntrada(String fechaEntrada)
	//Comprueba si existen operaciones cuya fecha de Entrada sea "fechaEntrada" 
	//y que la fecha de salida de dichas operaciones no haya sido introducida
	//Devuelve true si EXISTE y false en caso contrario.
	{
		boolean encontrado=false;
		
		for(int i=0;!encontrado && i<vOperaciones.size();i++)
		{
			if(vOperaciones.get(i).getFechaEntrada().equals(fechaEntrada) && vOperaciones.get(i).getFechaSalida()==null)
			{
				encontrado=true;
			}
		}
		
		return encontrado;
	}
	public static Vector<Operacion> obtenerDatosOperacion(int idVehiculo, String fechaEntrada)
	//Devuelve los datos de aquellos vehiculos cuyo:
	//Identificador de Vehiculo sea "id" o si esta vacio:
	//Dueño del vehiculo sea "duenyo" o si esta vacio:
	//Marca se parezca a "marca" y modelo se parezca a "modelo"
	{
		Vector<Operacion> aux=new Vector<Operacion>();
		
		if(idVehiculo!=0)
		{
			aux=devuelveOperacionVehiculo(idVehiculo);
		}
		else
		{
			aux=devuelveOperacionFecha(fechaEntrada);
		}
		
		return aux;
	}
	
	public static Vector<Operacion> devuelveOperacionVehiculo(int idVehiculo)
	//Devuelve un vector de Operacion con todas las operaciones cuyo Identificador de vehiculo sea "idVehiculo"
	{
		Vector<Operacion> aux = new Vector<Operacion>();
		
		for(int i=0;i<vOperaciones.size();i++)
		{
			if(vOperaciones.get(i).getVehiculo()==idVehiculo)
			{
				aux.add(vOperaciones.get(i));
			}
		}
		
		return aux;
	}
	
	public static Vector<Operacion> devuelveOperacionFecha(String fechaEntrada)
	//Devuelve un vector de Operacion con todas las operaciones cuya fecha de Entrada sea "fechaEntrada"
	{
		Vector<Operacion> aux = new Vector<Operacion>();
		
		for(int i=0;i<vOperaciones.size();i++)
		{
			if(vOperaciones.get(i).getFechaEntrada().equals(fechaEntrada))
			{
				aux.add(vOperaciones.get(i));
			}
		}
		
		return aux;
	}
	
}
