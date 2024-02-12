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
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class VistaComandas extends JFrame {

	private JPanel contentPane;
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

	public JPanel panelAniadirProducto;
	public String[] opcionesProductos = { "Bebidas", "Comidas", "Comida para picar" };
	public JComboBox boxTipoProducto;
	private JLabel lblNewLabel_1;
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
	public JPanel eliminarPanel;
	public JPanel panelModificarStock;
	public JButton btnEliminar;

	public JRadioButton rdbtnAniadir;
	public JRadioButton rdbtnEliminar;
	private ButtonGroup grupoStock = new ButtonGroup();
	private JPanel panelParteArriba;
	private JLabel lblImagenLogo;
	private JLabel lblNewLabel_9;
	public JPanel panelVerInventario;
	private JLabel lblNewLabel;

	public JList listBebidas;
	public JList listComidas;
	public JList listPicar;
	public JButton btnExit;

	public JComboBox boxProductosEliminar;
	public JComboBox boxStock;
	public JButton btnModStock;
	public JSpinner spinnerModStock;

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
				atras_1.setBounds(217, 140, 109, 58);
				contentPane.add(atras_1);
				
						btnAtras = new JButton("");
						atras_1.add(btnAtras);
						btnAtras.setIcon(new ImageIcon("src//imagenes//felchaAtras.png"));

		panelModificarStock = new JPanel();
		panelModificarStock.setBounds(193, 117, 583, 596);
		contentPane.add(panelModificarStock);
		panelModificarStock.setLayout(null);
		paneles.add(panelModificarStock);

		rdbtnAniadir = new JRadioButton("Aniadir");
		rdbtnAniadir.setBounds(172, 108, 103, 21);
		panelModificarStock.add(rdbtnAniadir);
		grupoStock.add(rdbtnAniadir);

		rdbtnEliminar = new JRadioButton("Quitar");
		rdbtnEliminar.setBounds(306, 108, 103, 21);
		panelModificarStock.add(rdbtnEliminar);
		grupoStock.add(rdbtnEliminar);

		boxStock = new JComboBox();
		boxStock.setBounds(186, 162, 166, 21);
		panelModificarStock.add(boxStock);
		
		btnModStock = new JButton("Modificar");
		btnModStock.setBounds(223, 237, 85, 21);
		panelModificarStock.add(btnModStock);
		
		spinnerModStock = new JSpinner();
		spinnerModStock.setBounds(395, 163, 41, 20);
		panelModificarStock.add(spinnerModStock);

		eliminarPanel = new JPanel();
		eliminarPanel.setBounds(203, 126, 573, 587);
		contentPane.add(eliminarPanel);
		eliminarPanel.setLayout(null);
		paneles.add(eliminarPanel);

		JLabel lblNewLabel_5 = new JLabel("Introduce el producto que quieres eliminar");
		lblNewLabel_5.setBounds(149, 79, 264, 13);
		eliminarPanel.add(lblNewLabel_5);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(231, 200, 85, 21);
		eliminarPanel.add(btnEliminar);

		boxProductosEliminar = new JComboBox();
		boxProductosEliminar.setBounds(157, 114, 192, 21);
		eliminarPanel.add(boxProductosEliminar);

		panelParteArriba = new JPanel();
		panelParteArriba.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panelParteArriba.setBounds(193, 0, 583, 116);
		contentPane.add(panelParteArriba);
		panelParteArriba.setLayout(null);

		lblImagenLogo = new JLabel("");
		lblImagenLogo.setIcon(new ImageIcon(
				"src//imagenes//logoBar.png"));
		lblImagenLogo.setBounds(269, 10, 196, 98);
		panelParteArriba.add(lblImagenLogo);

		lblNewLabel_9 = new JLabel("BIENVENIDOS A");
		lblNewLabel_9.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 24));
		lblNewLabel_9.setBounds(79, 10, 146, 98);
		panelParteArriba.add(lblNewLabel_9);

		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panelCentral.setBounds(10, 0, 180, 713);
		contentPane.add(panelCentral);
		panelCentral.setLayout(null);

		btnGestionInventario = new JButton("");
		btnGestionInventario.setIcon(new ImageIcon(
				"src//imagenes//gestionInventario.png"));
		btnGestionInventario.setBounds(10, 254, 156, 87);
		panelCentral.add(btnGestionInventario);

		btnGestionComandas = new JButton("");
		btnGestionComandas.setIcon(new ImageIcon(
				"src//imagenes//imagenComandas.png"));
		btnGestionComandas.setBounds(10, 403, 156, 87);
		panelCentral.add(btnGestionComandas);

		btnGestionCaja = new JButton("");
		btnGestionCaja.setIcon(new ImageIcon(
				"src//imagenes//caja-registradora.png"));
		btnGestionCaja.setBounds(10, 537, 156, 87);
		panelCentral.add(btnGestionCaja);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(
				"src//imagenes//apagar.png"));
		btnExit.setBounds(10, 22, 156, 87);
		panelCentral.add(btnExit);

		panelGestionarInventario = new JPanel();
		panelGestionarInventario.setBounds(0, 0, 776, 713);
		contentPane.add(panelGestionarInventario);
		panelGestionarInventario.setLayout(null);
		panelGestionarInventario.setVisible(false);

		btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.setBounds(386, 273, 133, 28);
		panelGestionarInventario.add(btnVerInventario);

		btnAniadirProducto = new JButton("Añadir producto");
		btnAniadirProducto.setBounds(386, 366, 133, 28);
		panelGestionarInventario.add(btnAniadirProducto);

		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(386, 454, 133, 28);
		panelGestionarInventario.add(btnEliminarProducto);

		btnModificarStock = new JButton("Modificar Stock");
		btnModificarStock.setBounds(386, 546, 133, 28);
		panelGestionarInventario.add(btnModificarStock);

		panelPreguntasProducto = new JPanel();
		panelPreguntasProducto.setBounds(193, 117, 583, 596);
		contentPane.add(panelPreguntasProducto);
		panelPreguntasProducto.setLayout(null);
		panelPreguntasProducto.setVisible(false);
		paneles.add(panelPreguntasProducto);

		radioBtnSi = new JRadioButton("SI");
		radioBtnSi.setBounds(25, 155, 103, 21);
		panelPreguntasProducto.add(radioBtnSi);
		grupo1.add(radioBtnSi);

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setBounds(151, 155, 103, 21);
		panelPreguntasProducto.add(rdbtnNo);
		grupo1.add(rdbtnNo);

		lblPreguntaProducto = new JLabel("\u00BFEl Producto");
		lblPreguntaProducto.setBounds(25, 120, 196, 13);
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
		btnPonerProducto.setBounds(77, 480, 85, 21);
		panelPreguntasProducto.add(btnPonerProducto);

		panelAniadirProducto = new JPanel();
		panelAniadirProducto.setLayout(null);
		panelAniadirProducto.setBounds(203, 126, 573, 587);
		contentPane.add(panelAniadirProducto);
		panelAniadirProducto.setVisible(false);

		boxTipoProducto = new JComboBox(opcionesProductos);
		boxTipoProducto.setBounds(23, 151, 143, 21);
		panelAniadirProducto.add(boxTipoProducto);

		lblNewLabel_1 = new JLabel("\u00BFCual sera el costo del producto?");
		lblNewLabel_1.setBounds(168, 268, 176, 13);
		panelAniadirProducto.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u00BFQue tipo de producto quieres a\u00F1adir?");
		lblNewLabel_2.setBounds(10, 91, 221, 28);
		panelAniadirProducto.add(lblNewLabel_2);

		textCostoProducto = new JTextPane();
		textCostoProducto.setBounds(179, 329, 165, 19);
		panelAniadirProducto.add(textCostoProducto);

		btnSiguienteProducto = new JButton("Siguiente");
		btnSiguienteProducto.setBounds(224, 436, 85, 21);
		panelAniadirProducto.add(btnSiguienteProducto);

		JLabel lblNewLabel_4 = new JLabel("Introduce el nombre del producto");
		lblNewLabel_4.setBounds(270, 99, 239, 13);
		panelAniadirProducto.add(lblNewLabel_4);

		textPaneNombre = new JTextPane();
		textPaneNombre.setBounds(282, 151, 165, 19);
		panelAniadirProducto.add(textPaneNombre);
		panelAniadirProducto.setVisible(false);

		panelVerInventario = new JPanel();
		panelVerInventario.setBounds(199, 117, 567, 586);
		contentPane.add(panelVerInventario);
		panelVerInventario.setLayout(null);
		paneles.add(panelVerInventario);

		lblNewLabel = new JLabel("Bebidas");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 140, 116, 38);
		panelVerInventario.add(lblNewLabel);

		listBebidas = new JList();
		listBebidas.setBounds(10, 188, 155, 388);
		panelVerInventario.add(listBebidas);

		JLabel lblComidas = new JLabel("Comidas");
		lblComidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComidas.setForeground(new Color(0, 128, 255));
		lblComidas.setBounds(220, 140, 116, 38);
		panelVerInventario.add(lblComidas);

		listComidas = new JList();
		listComidas.setBounds(194, 188, 150, 388);
		panelVerInventario.add(listComidas);

		JLabel lblNewLabel_10 = new JLabel("Comidas Picar");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(new Color(0, 128, 255));
		lblNewLabel_10.setBounds(412, 140, 116, 38);
		panelVerInventario.add(lblNewLabel_10);

		listPicar = new JList();
		listPicar.setBounds(385, 188, 172, 388);
		panelVerInventario.add(listPicar);

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
		paneles.add(panelGestionarInventario);
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
