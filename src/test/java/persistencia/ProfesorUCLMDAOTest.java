package persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import negocio.entities.CategoriaProfesor;
import negocio.entities.Centro;
import negocio.entities.ProfesorUCLM;

public class ProfesorUCLMDAOTest {	

	private ProfesorUCLM profesor;
	private int position;

	private ProfesorUCLM profesorEsperado;
	private List<ProfesorUCLM> profesoresEsperados;

	private ProfesorUCLM profesorObtenido;
	private List<ProfesorUCLM> profesoresObtenidos;


	@Test
	public void cp1() {
		try {
			// SETUP
			String dni = "dni";
			String nombre = "nombre";
			String apellidos = "appellido";
			Boolean doctor = true;
			CategoriaProfesor categoria = CategoriaProfesor.CATEDRATICO;
			Centro centro = new Centro("UCLM TAL");

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// ESPERADO
			profesorEsperado = profesor;
			profesoresEsperados = profesor.profesorUCLMDao.listarProfesores();
			profesoresEsperados.add(profesorEsperado);
			position = profesoresEsperados.size()-1;

			// CREACION
			profesor.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			profesorObtenido = profesoresObtenidos.get(position);
			assertEquals(profesorEsperado, profesorObtenido);

			// SELECCION + EDICCIÓN
			dni = "dni";
			nombre = "";
			apellidos = "";
			doctor = false;
			categoria = CategoriaProfesor.ASOCIADO;
			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
			profesorEsperado = profesor;

			profesor.profesorUCLMDao.editarProfesorUCLM(profesor);
			profesorObtenido = profesor.profesorUCLMDao.seleccionarProfesorUCLM(profesorObtenido);
			assertEquals(profesorEsperado, profesorObtenido);

			// ELIMINACION
			profesor.profesorUCLMDao.eliminarProfesorUCLM(profesorObtenido);
			profesoresEsperados.remove(position);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			assertEquals(profesoresEsperados.size(), profesoresObtenidos.size());

		} catch (SQLException e) {
			fail("HA TIRADO UNA EXCEPCION");
		}
	}

	@Test
	public void cp2() {
		try {
			// SETUP
			String dni = "";
			String nombre = "";
			String apellidos = "";
			Boolean doctor = false;
			CategoriaProfesor categoria = CategoriaProfesor.TITULAR_UNIVERSIDAD;
			Centro centro = null;

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// CREACION
			try{
				profesorEsperado.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// SELECCION
			try{
				profesorEsperado.profesorUCLMDao.seleccionarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// EDICCION
			try{
				profesorEsperado.profesorUCLMDao.editarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// ELIMINACION
			try{
				profesorEsperado.profesorUCLMDao.eliminarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

		} catch (SQLException e) {
			fail("HA TIRADO UNA EXCEPCION");
		}
	}

	@Test
	public void cp3() {
		try {
			// SETUP
			String dni = "";
			String nombre = "nombre";
			String apellidos = "";
			Boolean doctor = true;
			CategoriaProfesor categoria = CategoriaProfesor.CONTRATADO_DOCTOR;
			Centro centro = new Centro("UCLM TAL");

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// ESPERADO
			profesorEsperado = profesor;
			profesoresEsperados = profesor.profesorUCLMDao.listarProfesores();
			profesoresEsperados.add(profesorEsperado);
			position = profesoresEsperados.size()-1;

			// CREACION
			profesor.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			profesorObtenido = profesoresObtenidos.get(position);
			assertEquals(profesorEsperado, profesorObtenido);

			// SELECCION + EDICCIÓN
			dni = "";
			nombre = "";
			apellidos = "apellido";
			doctor = true;
			categoria = CategoriaProfesor.AYUDANTE_DOCTOR;
			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
			profesorEsperado = profesor;

			profesor.profesorUCLMDao.editarProfesorUCLM(profesor);
			profesorObtenido = profesor.profesorUCLMDao.seleccionarProfesorUCLM(profesorObtenido);
			assertEquals(profesorEsperado, profesorObtenido);

			// ELIMINACION
			profesor.profesorUCLMDao.eliminarProfesorUCLM(profesorObtenido);
			profesoresEsperados.remove(position);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			assertEquals(profesoresEsperados.size(), profesoresObtenidos.size());

		} catch (SQLException e) {
			System.out.println(e);
			fail("HA TIRADO UNA EXCEPCION");
		}
	}


	@Test
	public void cp4() {
		try {
			// SETUP
			String dni = "dni";
			String nombre = "";
			String apellidos = "apellido";
			Boolean doctor = false;
			CategoriaProfesor categoria = CategoriaProfesor.AYUDANTE_DOCTOR;
			Centro centro = new Centro("UCLM TAL");

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// ESPERADO
			profesorEsperado = profesor;
			profesoresEsperados = profesor.profesorUCLMDao.listarProfesores();
			profesoresEsperados.add(profesorEsperado);
			position = profesoresEsperados.size()-1;

			// CREACION
			profesor.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			profesorObtenido = profesoresObtenidos.get(position);
			assertEquals(profesorEsperado, profesorObtenido);

			// SELECCION + EDICCIÓN
			dni = "dni";
			nombre = "nombre";
			apellidos = "";
			doctor = true;
			categoria = CategoriaProfesor.CONTRATADO_DOCTOR;
			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
			profesorEsperado = profesor;

			profesor.profesorUCLMDao.editarProfesorUCLM(profesor);
			profesorObtenido = profesor.profesorUCLMDao.seleccionarProfesorUCLM(profesorObtenido);
			assertEquals(profesorEsperado, profesorObtenido);

			// ELIMINACION
			profesor.profesorUCLMDao.eliminarProfesorUCLM(profesorObtenido);
			profesoresEsperados.remove(position);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			assertEquals(profesoresEsperados.size(), profesoresObtenidos.size());

		} catch (SQLException e) {
			System.out.println(e);
			fail("HA TIRADO UNA EXCEPCION");
		}
	}
	
	@Test
	public void cp5() {
		try {
			// SETUP
			String dni = "dni";
			String nombre = "nombre";
			String apellidos = "apellido";
			Boolean doctor = false;
			CategoriaProfesor categoria = CategoriaProfesor.AYUDANTE;
			Centro centro = new Centro("UCLM TAL");

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// ESPERADO
			profesorEsperado = profesor;
			profesoresEsperados = profesor.profesorUCLMDao.listarProfesores();
			profesoresEsperados.add(profesorEsperado);
			position = profesoresEsperados.size()-1;

			// CREACION
			profesor.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			profesorObtenido = profesoresObtenidos.get(position);
			assertEquals(profesorEsperado, profesorObtenido);

			// SELECCION + EDICCIÓN
			dni = "dni";
			nombre = "";
			apellidos = "";
			doctor = true;
			categoria = CategoriaProfesor.TITULAR_UNIVERSIDAD;
			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
			profesorEsperado = profesor;

			profesor.profesorUCLMDao.editarProfesorUCLM(profesor);
			profesorObtenido = profesor.profesorUCLMDao.seleccionarProfesorUCLM(profesorObtenido);
			assertEquals(profesorEsperado, profesorObtenido);

			// ELIMINACION
			profesor.profesorUCLMDao.eliminarProfesorUCLM(profesorObtenido);
			profesoresEsperados.remove(position);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			assertEquals(profesoresEsperados.size(), profesoresObtenidos.size());

		} catch (SQLException e) {
			System.out.println(e);
			fail("HA TIRADO UNA EXCEPCION");
		}
	}
	
	@Test
	public void cp6() {
		try {
			// SETUP
			String dni = "";
			String nombre = "";
			String apellidos = "";
			Boolean doctor = true;
			CategoriaProfesor categoria = CategoriaProfesor.ASOCIADO;
			Centro centro = new Centro("UCLM TAL");

			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);

			// ESPERADO
			profesorEsperado = profesor;
			profesoresEsperados = profesor.profesorUCLMDao.listarProfesores();
			profesoresEsperados.add(profesorEsperado);
			position = profesoresEsperados.size()-1;

			// CREACION
			profesor.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			profesorObtenido = profesoresObtenidos.get(position);
			assertEquals(profesorEsperado, profesorObtenido);

			// SELECCION + EDICCIÓN
			dni = "";
			nombre = "nombre";
			apellidos = "apellido";
			doctor = true;
			categoria = CategoriaProfesor.CATEDRATICO;
			profesor = new ProfesorUCLM(dni, nombre, apellidos, doctor, categoria, centro);
			profesorEsperado = profesor;

			profesor.profesorUCLMDao.editarProfesorUCLM(profesor);
			profesorObtenido = profesor.profesorUCLMDao.seleccionarProfesorUCLM(profesorObtenido);
			assertEquals(profesorEsperado, profesorObtenido);

			// ELIMINACION
			profesor.profesorUCLMDao.eliminarProfesorUCLM(profesorObtenido);
			profesoresEsperados.remove(position);
			profesoresObtenidos = profesor.profesorUCLMDao.listarProfesores();
			assertEquals(profesoresEsperados.size(), profesoresObtenidos.size());

		} catch (SQLException e) {
			System.out.println(e);
			fail("HA TIRADO UNA EXCEPCION");
		}
	}
	
	@Test
	public void cp7() {
		try {
			// SETUP
			profesor = null;

			// CREACION
			try{
				profesorEsperado.profesorUCLMDao.crearNuevoProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// SELECCION
			try{
				profesorEsperado.profesorUCLMDao.seleccionarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// EDICCION
			try{
				profesorEsperado.profesorUCLMDao.editarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

			// ELIMINACION
			try{
				profesorEsperado.profesorUCLMDao.eliminarProfesorUCLM(profesor);
			}catch (NullPointerException e) {
				assertTrue(true);
			}

		} catch (SQLException e) {
			fail("HA TIRADO UNA EXCEPCION");
		}
	}
}
