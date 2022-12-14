package negocio.entities;

import java.util.*;
import persistencia.*;

public class CursoPropio {

	public Collection<Matricula> matriculas;
	public Centro centro;
	public ProfesorUCLM director;
	public ProfesorUCLM secretario;
	public Collection<Materia> materias;
	public EstadoCurso estado;
	public TipoCurso tipo;
	public CursoPropioDAO cursoPropioDao;
	private String id;
	private String nombre;
	private int eCTS;
	private Date fechaInicio;
	private Date fechaFin;
	private double tasaMatricula;
	private int edicion;
	public String requisitos;
	
	public CursoPropio() {
		cursoPropioDao = new CursoPropioDAO();
	}
	
	public CursoPropio(String id, int edicion) {
		cursoPropioDao = new CursoPropioDAO();
		this.id = id;
		this.edicion = edicion;
	}
	
	public CursoPropio(String id, String nombre, int eCTS, Date fechaInicio, Date fechaFin, double tasaMatricula, int edicion, EstadoCurso estado, TipoCurso tipo, Centro centro, ProfesorUCLM secretario, ProfesorUCLM director, String requisitos) {
		cursoPropioDao = new CursoPropioDAO();
		this.id = id;
		this.nombre = nombre;
		this.eCTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
		this.estado = estado;
		this.tipo = tipo;
		this.centro = centro;
		this.secretario=secretario;
		this.director=director;
		this.requisitos=requisitos;
	}
	
	public String toString() {
		/**String strMaterias = "";
		Materia[] arrayMaterias = (Materia[]) materias.toArray();
		for (int i=0; i<materias.size();i++) {
			strMaterias+=arrayMaterias[i].toString();
		}
		**/
		return "Curso:"
				+"\n\tId: "+id
				+"\n\tNombre: "+nombre
				+"\n\tECTS: "+eCTS
				+"\n\tfechaInicio: "+fechaInicio.toString()
				+"\n\tfechaFin: "+fechaFin.toString()
				+"\n\ttasaMatricula: "+tasaMatricula
				+"\n\tEdición: "+edicion
				+"\n\tEstado:"+estado.toString()
				+"\n\tTipo: "+tipo.toString()
				+"\n\tCentro: "+centro.getNombre()
				+"\n\tSecretario: "+secretario.getDni()
				+"\n\tDirector: "+director.getDni()
				//+"\n\tMaterias: "+materias.size()
				;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if (obj == null) return this != null;
		if (getClass() != obj.getClass()) return false;
		CursoPropio cursoObj = (CursoPropio) obj; 
		if (!(this.getId().equals(cursoObj.getId()))) return false; 
		if (!(this.getNombre().equals(cursoObj.getNombre()))) return false; 
		if (this.getECTS()!=cursoObj.getECTS()) return false;
		if (!(this.getFechaInicio().equals(cursoObj.getFechaInicio()))) return false; 
		if (!(this.getFechaFin().equals(cursoObj.getFechaFin()))) return false; 
		if (this.getTasaMatricula()!=cursoObj.getTasaMatricula()) return false;
		if (this.getEdicion()!=cursoObj.getEdicion()) return false; 
		if (this.estado != cursoObj.estado) return false;
		if (this.tipo != cursoObj.tipo) return false;
		if (!(this.centro.getNombre().equals(cursoObj.centro.getNombre()))) return false;
		if (!(this.secretario.getDni().equals(cursoObj.secretario.getDni()))) return false;
		if (!(this.director.getDni().equals(cursoObj.director.getDni()))) return false;
		if (this.requisitos == null){
			if (cursoObj.requisitos!=null) return false;
		} else {
			if (!(this.requisitos).equals(cursoObj.requisitos)) return false;
		}	
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, eCTS, fechaInicio, fechaFin, tasaMatricula, edicion, estado, tipo, centro, secretario, director, requisitos,
				matriculas, materias);
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public int getECTS() { return eCTS; }
	public void setECTS(int eCTS) { this.eCTS = eCTS; }
	
	public Date getFechaInicio() { return fechaInicio; }
	public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
	
	public Date getFechaFin() { return fechaFin; }
	public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
	
	public double getTasaMatricula() { return tasaMatricula; }
	public void setTasaMatricula(double tasaMatricula) { this.tasaMatricula = tasaMatricula; }
	
	public int getEdicion() { return edicion; }
	public void setEdicion(int edicion) { this.edicion = edicion; }	
}