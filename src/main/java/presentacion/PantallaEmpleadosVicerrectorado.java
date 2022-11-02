package presentacion;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import negocio.controllers.GestorConsultas;
import negocio.entities.CursoPropio;
import negocio.entities.EstadoCurso;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class PantallaEmpleadosVicerrectorado extends JFrame {

	private JButton button;
	private List cursosDao = null;
    private List cursosNombre = new ArrayList();
    private JList propuestasLista;
    private DefaultListModel model = new DefaultListModel(); 
	
    public PantallaEmpleadosVicerrectorado () {
    	initLayout();
    	basicLayout();
    	botonesLayout();
    }

	private void initLayout() {
		// Propiedades basicas
        getContentPane().setLayout(null);
        setBounds(10, 10, 800,600);
        setTitle("Gestion de cursos propuestos");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
		
	}
	
	private void basicLayout() {
		GestorConsultas gestor = new GestorConsultas();

		try {
			cursosDao = gestor.listarCursosPorEstado(EstadoCurso.PROPUESTO);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(cursosDao != null) {
			for(int i = 0; i<cursosDao.size(); i++) {
				CursoPropio cursoTemp = (CursoPropio) cursosDao.get(i);
				cursosNombre.add(cursoTemp.getNombre());
			}
		}

        propuestasLista = new JList(cursosNombre.toArray());
        propuestasLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollLista = new JScrollPane(propuestasLista);
        scrollLista.setBounds(200, 69, 400, 200);
        getContentPane().add(scrollLista);
	}

	private void botonesLayout() {
		 button = new JButton("Evaluar Propuesta");
	     button.setBounds(300,280,200,30);
	     getContentPane().add(button);

		 button.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(propuestasLista.isSelectionEmpty()) return;

	            	//pantallaEvaluarCurso --> Re-utilizar pantalla de realizar --> Añadir cuadro de opinion al rechazar
	                //setVisible(false);
	            }

	     });
		 
		 button = new JButton("Cerrar Sesión");
	     button.setBounds(10,520,200,30);
		 getContentPane().add(button);

		 button.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new PantallaLogin();
	                setVisible(false);
	            }

	        });
	}

	
	public void evaluarCurso() {
		throw new UnsupportedOperationException();
	}
}