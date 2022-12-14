package persistencia;

import negocio.entities.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ProfesorUCLMDAO {

	//profesor_DNI, categoriaProfesor, centro_nombre, fechaCreacion, fechaActualizacion

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public int crearNuevoProfesorUCLM(ProfesorUCLM profesor) throws SQLException {
		Date fechaCreacion =  new Date();
		Date fechaActualizacion = fechaCreacion;
		
		Profesor profesorNormal = new Profesor(profesor.getDni(), profesor.getNombre(), profesor.getApellidos(), profesor.isDoctor());
		
		int numberReturn = 0;
		
		numberReturn += profesorNormal.profesorDao.crearNuevoProfesor(profesorNormal);
		
		numberReturn += GestorBD.getInstancia().insert("INSERT INTO profesorUCLM (profesor_DNI, categoriaProfesor, centro_nombre, fechaCreacion, fechaActualizacion) VALUES ('"
				+ profesor.getDni()+"', '"
				+ profesor.categoria.toString()+"', '"
				+ profesor.centroAdscripcion.getNombre()+"', '"
				+ dateFormat.format(fechaCreacion)+"', '"
				+ dateFormat.format(fechaActualizacion)+"')");
		
		if (numberReturn == 2) return 1;
		else return 0;
	}

	public ProfesorUCLM seleccionarProfesorUCLM(ProfesorUCLM profesor) throws SQLException {
		Vector datosProfUCLM = GestorBD.getInstancia().select("SELECT * FROM profesor AS p JOIN profesorUCLM AS puclm ON puclm.profesor_DNI = p.dni WHERE puclm.profesor_DNI='"+profesor.getDni()+"'");
		datosProfUCLM = (Vector) datosProfUCLM.get(0);
		
		//columnas tras el join:
		//p.dni, p.nombre, p.apellidos, p.doctor, p.fechaCreacion, p.fechaActualizacion, puclm.profesor_DNI, puclm.categoriaProfesor, puclm.centro_nombre, puclm.fechaCreacion, puclm.fechaActualizacion		
		
		String dni=(String) datosProfUCLM.get(0);
		String nombre=(String) datosProfUCLM.get(1);
		String apellidos= (String) datosProfUCLM.get(2);
		boolean doctor=(Boolean) datosProfUCLM.get(3);
		CategoriaProfesor categoria = CategoriaProfesor.valueOf((String) datosProfUCLM.get(7));
		Centro centro = new Centro((String) datosProfUCLM.get(8));
		
		return new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
	}

	public int editarProfesorUCLM(ProfesorUCLM profesor) throws SQLException {
		Date fechaActualizacion=new Date();
		
		Profesor profesorNormal = new Profesor(profesor.getDni(), profesor.getNombre(), profesor.getApellidos(), profesor.isDoctor());
		
		int numberReturn = 0;
		
		numberReturn += profesorNormal.profesorDao.editarProfesor(profesorNormal);

		numberReturn += GestorBD.getInstancia().update("UPDATE profesorUCLM SET "
				+ "categoriaProfesor='" +profesor.categoria.toString()+"', "
				+ "centro_nombre='"+profesor.centroAdscripcion.getNombre()+"',"
				+ "fechaActualizacion='" + dateFormat.format(fechaActualizacion)
				+ "' WHERE profesor_DNI='"+profesor.getDni()+"'");
		
		if (numberReturn == 2) return 1;
		else return 0;
	}

	public int eliminarProfesorUCLM(ProfesorUCLM profesor) throws SQLException {
		Profesor profesorNormal = new Profesor(profesor.getDni(), profesor.getNombre(), profesor.getApellidos(), profesor.isDoctor());
		
		int numberReturn = 0;
				
		numberReturn += GestorBD.getInstancia().delete("DELETE FROM profesorUCLM WHERE profesor_DNI='"+profesor.getDni()+"'");
		
		numberReturn += profesorNormal.profesorDao.eliminarProfesor(profesorNormal);
		
		if (numberReturn == 2) return 1;
		else return 0;
	}
	
	public List<ProfesorUCLM> listarProfesores() throws SQLException {
		Vector datosProfUCLM = GestorBD.getInstancia().select("SELECT * FROM profesor AS p JOIN profesorUCLM AS puclm ON puclm.profesor_DNI = p.dni");
		
		List<ProfesorUCLM> listaProfesUCLM = new ArrayList<>();
		for (int i=0; i<datosProfUCLM.size(); i++) {
			Vector profUCLMDatosTemp = (Vector) datosProfUCLM.get(i);
			
			String dni=(String) profUCLMDatosTemp.get(0);
			String nombre=(String) profUCLMDatosTemp.get(1);
			String apellidos= (String) profUCLMDatosTemp.get(2);
			boolean doctor=(Boolean) profUCLMDatosTemp.get(3);
			CategoriaProfesor categoria = CategoriaProfesor.valueOf((String) profUCLMDatosTemp.get(7));
			Centro centro = new Centro((String) profUCLMDatosTemp.get(8));
			
			listaProfesUCLM.add(new ProfesorUCLM(dni, nombre, apellidos,doctor,categoria,centro));
		}
		return listaProfesUCLM;
	}
}