package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorComandas;

public class VistaComandas extends JFrame {

	private JPanel contentPane;
	
	public JPanel panelInicial;
	public JButton btnGestionInventario;
	public JButton btnGestionComandas;
	public JButton btnGestionCaja;
	
	
	public List <JButton> botonesIniciales = new ArrayList<>();
	public List <JPanel> paneles = new ArrayList <>();
	public List <JButton> botonesInventario = new ArrayList<JButton>();
	
	public JPanel panelnventario;
	public JButton btnVerInventario;
	public JButton btnAniadirProducto;
	public JButton btnEliminarProducto;
	public JButton btnModificarStock;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaComandas frame = new VistaComandas();
					ControladorComandas controlador = new ControladorComandas(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaComandas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelnventario = new JPanel();
		panelnventario.setBounds(0, 0, 776, 713);
		contentPane.add(panelnventario);
		panelnventario.setLayout(null);
		
		btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.setBounds(350, 45, 133, 28);
		panelnventario.add(btnVerInventario);
		
		btnAniadirProducto = new JButton("A\u00F1adir producto");
		btnAniadirProducto.setBounds(350, 129, 133, 28);
		panelnventario.add(btnAniadirProducto);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(350, 224, 133, 28);
		panelnventario.add(btnEliminarProducto);
		
		btnModificarStock = new JButton("Modificar Stock");
		btnModificarStock.setBounds(350, 307, 133, 28);
		panelnventario.add(btnModificarStock);
		
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 776, 713);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);
		
		btnGestionInventario = new JButton("Gestionar Inventario");
		btnGestionInventario.setBounds(266, 86, 177, 28);
		panelInicial.add(btnGestionInventario);
		
		
		btnGestionComandas = new JButton("Gestionar Comandas");
		btnGestionComandas.setBounds(266, 170, 177, 28);
		panelInicial.add(btnGestionComandas);
		
		btnGestionCaja = new JButton("Gestionar Caja");
		btnGestionCaja.setBounds(266, 268, 177, 28);
		panelInicial.add(btnGestionCaja);
		
		guardarBotonesIniciales();
		guardarBotonesInventario();
		guardarPaneles();
		
	}
	
	//Guardar los botones de la pantalla inicial
	public void guardarBotonesIniciales () {
		botonesIniciales.add(btnGestionInventario);
		botonesIniciales.add(btnGestionComandas);
		botonesIniciales.add(btnGestionCaja);
	}
	
	public void guardarBotonesInventario () {
		botonesInventario.add(btnVerInventario);
		botonesInventario.add(btnAniadirProducto);
		botonesInventario.add(btnEliminarProducto);
		botonesInventario.add(btnModificarStock);
	}
	
	public void guardarPaneles() {
		paneles.add(panelInicial);
		paneles.add(panelnventario);
		
	}
	
	
	public void panelesInvisibles () {
		for (JPanel panel : paneles) {
			panel.setVisible(false);
		}
	}
}
