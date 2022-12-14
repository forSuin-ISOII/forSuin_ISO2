package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@Generated
public class PantallaAlumno extends JFrame{
    
    public PantallaAlumno () {
    	initLayout();
    	botonesLayout();        
    }
    
	private void initLayout() {
		// Propiedades basicas
        getContentPane().setLayout(null);
        setBounds(10, 10, 800,600);
        setTitle("Direccion de cursos");
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	private void botonesLayout() {
		// Boton para visualizar cursos aprobados
        JButton button = new JButton("Consultar cursos aprobados");
        button.setBounds(300,163,200,30);
        getContentPane().add(button);
    
        button.addActionListener(new ActionListener() {
            @Generated @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaCursosAprobados(0, null);
                setVisible(false);
            }
        });
        
        
        // Boton para cerrar sesion
        button = new JButton("Cerrar sesion");
        button.setBounds(300,204,200,30);
        getContentPane().add(button);
    
        button.addActionListener(new ActionListener() {
            @Generated @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaLogin();
                setVisible(false);
            }
        });
	}

	public void altaCurso() {
		throw new UnsupportedOperationException();
	}

	public void edicionCurso() {
		throw new UnsupportedOperationException();
	}
}