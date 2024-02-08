package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorComandas;

public class VistaComandas extends JFrame {

	private JPanel contentPane;

	public JPanel panelInicial;
	public JButton btnGestionInventario;
	public JButton btnGestionComandas;
	public JButton btnGestionCaja;

	public List<JButton> botonesIniciales = new ArrayList<>();
	public List<JPanel> paneles = new ArrayList<>();
	public List<JButton> botonesInventario = new ArrayList<JButton>();

	// Componentes del panel de GestionarInventario
	public JPanel panelGestionarInventario;
	public JButton btnVerInventario;
	public JButton btnAniadirProducto;
	public JButton btnEliminarProducto;
	public JButton btnModificarStock;

	// Componentes del panel de verinventario
	public JPanel panelVerInventario;
	JScrollPane scrollBebidas;
	public JList listBebidas;
	JScrollPane scrollComidas;
	public JList listComidas;
	JScrollPane scrollPicar;
	public JList listPicar;

	public JPanel panelAniadirProducto;
	public String[] opcionesProductos = { "Bebidas", "Comidas", "Comida para picar" };
	public JComboBox boxTipoProducto;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	public JTextPane textRutaImagen;
	public JButton btnSiguienteProducto;

	public JPanel panelPreguntasProducto;
	public JRadioButton radioBtnCafeinaSi;
	public JRadioButton radioBtnCafeinaNo;
	public ButtonGroup grupoCafeina = new ButtonGroup();

	private JLabel lblCafeina;
	private JLabel lblCaducaBebida;
	public JTextPane textPaneFechaCaducidad;
	public JRadioButton radioBtnAzucarSi;
	public JRadioButton radioBtnAzucarNo;
	public ButtonGroup grupoAzucar = new ButtonGroup();

	private JLabel lblAzucarBebida;
	public JLabel lblPreguntaProducto;
	public JButton btnPonerProducto;

	private List<JComponent> componentesBebida = new ArrayList<JComponent>();
	public JRadioButton radioBtnSi;
	public JRadioButton rdbtnNo;
	public ButtonGroup grupo1 = new ButtonGroup();
	public JTextPane textCostoProducto;
	public JTextPane textPaneNombre;
	
	public JPanel atras;
	public JButton btnAtras;

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
		
				JPanel atras_1 = new JPanel();
				atras_1.setBounds(36, 29, 78, 31);
				contentPane.add(atras_1);
				
				btnAtras = new JButton("<---");
				atras_1.add(btnAtras);

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

		panelPreguntasProducto = new JPanel();
		panelPreguntasProducto.setBounds(0, 0, 776, 713);
		contentPane.add(panelPreguntasProducto);
		panelPreguntasProducto.setLayout(null);
		panelPreguntasProducto.setVisible(false);

		radioBtnSi = new JRadioButton("SI");
		radioBtnSi.setBounds(182, 116, 103, 21);
		panelPreguntasProducto.add(radioBtnSi);
		grupo1.add(radioBtnSi);

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setBounds(287, 116, 103, 21);
		panelPreguntasProducto.add(rdbtnNo);
		grupo1.add(rdbtnNo);

		lblPreguntaProducto = new JLabel("\u00BFEl Producto");
		lblPreguntaProducto.setBounds(182, 57, 196, 13);
		panelPreguntasProducto.add(lblPreguntaProducto);

		radioBtnCafeinaSi = new JRadioButton("SI");
		radioBtnCafeinaSi.setBounds(182, 244, 103, 21);
		panelPreguntasProducto.add(radioBtnCafeinaSi);
		componentesBebida.add(radioBtnCafeinaSi);
		grupoCafeina.add(radioBtnCafeinaSi);

		radioBtnCafeinaNo = new JRadioButton("NO");
		radioBtnCafeinaNo.setBounds(287, 244, 103, 21);
		panelPreguntasProducto.add(radioBtnCafeinaNo);
		componentesBebida.add(radioBtnCafeinaNo);
		grupoCafeina.add(radioBtnCafeinaNo);

		lblCafeina = new JLabel("\u00BFTiene cafeina la bebida?");
		lblCafeina.setBounds(182, 185, 196, 13);
		panelPreguntasProducto.add(lblCafeina);
		componentesBebida.add(lblCafeina);

		lblCaducaBebida = new JLabel("Cuando caduca la bebida");
		lblCaducaBebida.setBounds(182, 350, 196, 13);
		panelPreguntasProducto.add(lblCaducaBebida);
		componentesBebida.add(lblCaducaBebida);

		textPaneFechaCaducidad = new JTextPane();
		textPaneFechaCaducidad.setBounds(182, 412, 196, 19);
		panelPreguntasProducto.add(textPaneFechaCaducidad);
		componentesBebida.add(textPaneFechaCaducidad);

		radioBtnAzucarSi = new JRadioButton("SI");
		radioBtnAzucarSi.setBounds(182, 543, 103, 21);
		panelPreguntasProducto.add(radioBtnAzucarSi);
		componentesBebida.add(radioBtnAzucarSi);
		grupoAzucar.add(radioBtnAzucarSi);

		radioBtnAzucarNo = new JRadioButton("NO");
		radioBtnAzucarNo.setBounds(287, 543, 103, 21);
		panelPreguntasProducto.add(radioBtnAzucarNo);
		componentesBebida.add(radioBtnAzucarNo);
		grupoAzucar.add(radioBtnAzucarNo);

		lblAzucarBebida = new JLabel("Contiene azucar la bebida");
		lblAzucarBebida.setBounds(182, 484, 196, 13);
		panelPreguntasProducto.add(lblAzucarBebida);
		componentesBebida.add(lblAzucarBebida);

		btnPonerProducto = new JButton("A\u00F1adir");
		btnPonerProducto.setBounds(218, 629, 85, 21);
		panelPreguntasProducto.add(btnPonerProducto);
		componentesBebida.add(btnPonerProducto);

		panelAniadirProducto = new JPanel();
		panelAniadirProducto.setLayout(null);
		panelAniadirProducto.setBounds(0, 0, 776, 713);
		contentPane.add(panelAniadirProducto);
		panelAniadirProducto.setVisible(false);

		boxTipoProducto = new JComboBox(opcionesProductos);
		boxTipoProducto.setBounds(273, 94, 143, 21);
		panelAniadirProducto.add(boxTipoProducto);

		lblNewLabel_1 = new JLabel("\u00BFCual sera el costo del producto?");
		lblNewLabel_1.setBounds(240, 178, 176, 13);
		panelAniadirProducto.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u00BFQue tipo de producto quieres a\u00F1adir?");
		lblNewLabel_2.setBounds(240, 43, 221, 28);
		panelAniadirProducto.add(lblNewLabel_2);

		textCostoProducto = new JTextPane();
		textCostoProducto.setBounds(251, 232, 165, 19);
		panelAniadirProducto.add(textCostoProducto);

		lblNewLabel_3 = new JLabel("Introduce ruta de la imagen (opcional)");
		lblNewLabel_3.setBounds(240, 464, 193, 13);
		panelAniadirProducto.add(lblNewLabel_3);

		textRutaImagen = new JTextPane();
		textRutaImagen.setBounds(251, 517, 165, 19);
		panelAniadirProducto.add(textRutaImagen);

		btnSiguienteProducto = new JButton("Siguiente");
		btnSiguienteProducto.setBounds(285, 587, 85, 21);
		panelAniadirProducto.add(btnSiguienteProducto);

		JLabel lblNewLabel_4 = new JLabel("Introduce el nombre del producto");
		lblNewLabel_4.setBounds(251, 313, 239, 13);
		panelAniadirProducto.add(lblNewLabel_4);

		textPaneNombre = new JTextPane();
		textPaneNombre.setBounds(251, 372, 165, 19);
		panelAniadirProducto.add(textPaneNombre);
		panelAniadirProducto.setVisible(false);

		panelGestionarInventario = new JPanel();
		panelGestionarInventario.setBounds(0, 0, 776, 713);
		contentPane.add(panelGestionarInventario);
		panelGestionarInventario.setLayout(null);
		panelGestionarInventario.setVisible(false);

		btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.setBounds(350, 45, 133, 28);
		panelGestionarInventario.add(btnVerInventario);

		btnAniadirProducto = new JButton("Añadir producto");
		btnAniadirProducto.setBounds(350, 129, 133, 28);
		panelGestionarInventario.add(btnAniadirProducto);

		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(350, 224, 133, 28);
		panelGestionarInventario.add(btnEliminarProducto);

		btnModificarStock = new JButton("Modificar Stock");
		btnModificarStock.setBounds(350, 307, 133, 28);
		panelGestionarInventario.add(btnModificarStock);

		panelVerInventario = new JPanel();
		panelVerInventario.setBounds(0, 0, 776, 713);
		contentPane.add(panelVerInventario);
		panelVerInventario.setLayout(null);
		panelVerInventario.setVisible(false);

		JLabel lblNewLabel = new JLabel("Bebidas");
		lblNewLabel.setBounds(59, 65, 120, 27);
		panelVerInventario.add(lblNewLabel);

		listBebidas = new JList();
		listBebidas.setBounds(23, 100, 187, 516);
		panelVerInventario.add(listBebidas);

		scrollBebidas = new JScrollPane(listBebidas);
		scrollBebidas.setBounds(23, 100, 187, 516);
		panelVerInventario.add(scrollBebidas);

		JLabel lblComidas = new JLabel("Comidas");
		lblComidas.setBounds(300, 65, 120, 27);
		panelVerInventario.add(lblComidas);

		listComidas = new JList();
		listComidas.setBounds(264, 100, 187, 516);
		panelVerInventario.add(listComidas);

		scrollComidas = new JScrollPane(listComidas);
		scrollComidas.setBounds(264, 100, 187, 516);
		panelVerInventario.add(scrollComidas);

		JLabel lblComidasPicar = new JLabel("Comidas Picar");
		lblComidasPicar.setBounds(531, 65, 120, 27);
		panelVerInventario.add(lblComidasPicar);

		listPicar = new JList();
		listPicar.setBounds(531, 100, 187, 496);
		panelVerInventario.add(listPicar);
		scrollPicar = new JScrollPane(listPicar);
		scrollPicar.setBounds(531, 100, 187, 496);
		panelVerInventario.add(scrollPicar);

		guardarBotonesIniciales();
		guardarBotonesInventario();
		guardarPaneles();

	}

	// Guardar los botones de la pantalla inicial
	public void guardarBotonesIniciales() {
		botonesIniciales.add(btnGestionInventario);
		botonesIniciales.add(btnGestionComandas);
		botonesIniciales.add(btnGestionCaja);
	}

	public void guardarBotonesInventario() {
		botonesInventario.add(btnVerInventario);
		botonesInventario.add(btnAniadirProducto);
		botonesInventario.add(btnEliminarProducto);
		botonesInventario.add(btnModificarStock);
	}

	public void guardarPaneles() {
		paneles.add(panelInicial);
		paneles.add(panelGestionarInventario);
		paneles.add(panelVerInventario);
		paneles.add(panelAniadirProducto);
	}

	public void panelesInvisibles() {
		for (JPanel panel : paneles) {
			panel.setVisible(false);
		}
	}

	public void visiblesComponentesBebida(boolean b) {

		for (JComponent componente : componentesBebida) {
			componente.setVisible(b);
		}
	}
}
