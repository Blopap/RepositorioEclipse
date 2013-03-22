package laboratorio;

import java.util.Date;

import rutinas.Rutinas;

public class Analisis {
	private String nifpaciente;
	private Date fecha;
	private String resultado;
	private int codmedico;
	private float importe;
	
	
	public Analisis(String nifpaciente, Date fecha, String resultado, int codmedico, float importe) {
		setNifpaciente(nifpaciente);
		setFecha(fecha);
		setResultado(resultado);
		setCodmedico(codmedico);
		setImporte(importe);
	}

	public String getNifpaciente() {
		return nifpaciente;
	}

	public void setNifpaciente(String nifpaciente) {
		this.nifpaciente = nifpaciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		while(resultado.length() > 100 && resultado.length() < 1)
		{
			resultado=Rutinas.leeString("Resultado no cumple formato, introduzca un nuevo resultado");
		}
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getCodmedico() {
		return codmedico;
	}

	public void setCodmedico(int codmedico) {
		this.codmedico = codmedico;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getImporte() {
		return importe;
	}
	
	
	
	
	
	

}
