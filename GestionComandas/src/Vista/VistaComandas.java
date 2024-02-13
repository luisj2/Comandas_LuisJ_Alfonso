package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.swing.JTextArea;

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

	public JPanel panelComandas;
	private JButton silla1;
	private JButton silla2;
	private JButton silla3;
	private JButton silla4;
	private JButton silla5;
	private JButton silla6;
	private JButton silla7;
	private JButton silla8;
	private JButton[] sillas = new JButton[8];
	private JButton mesa1;
	private JButton mesa2;
	private JButton mesa3;
	private JButton mesa4;
	private JButton mesa5;
	private JButton mesa6;
	private JButton mesa7;
	private JButton mesa8;
	private JButton[] mesas = new JButton[8];
	public ArrayList <JButton> sitioComanda = new ArrayList<JButton>();
	public JPanel panelAniadirComanda;
	private JLabel lblNewLabel_6;
	
	public JList listComanda;
	
	public JButton btnEliminarComanda;
	public JButton btnPagarComanda;
	public JButton btnAgregar;
	public JList listProductosComandas;
	public JLabel imagenSitio;
	public JLabel lblNombreSitio;
	public JLabel lblPrecio;
	public JPanel panelCaja;
	public JLabel lblMesaPago;
	private JLabel lblNewLabel_7;
	public JLabel lblHoraInicio;
	private JLabel lblNewLabel_11;
	public JLabel lblHoraSalida;
	public JList listProductosComprados;
	public JButton btnRealizarPago;
	public JLabel lblPrecioTotal;
	public JTextArea txtRetroalimentacion;


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
		
		panelCaja = new JPanel();
		panelCaja.setBounds(203, 126, 565, 576);
		contentPane.add(panelCaja);
		panelCaja.setLayout(null);
		paneles.add(panelCaja);
		
		lblMesaPago = new JLabel("");
		lblMesaPago.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMesaPago.setBounds(206, 68, 250, 21);
		panelCaja.add(lblMesaPago);
		
		lblNewLabel_7 = new JLabel("Hora Inicio:");
		lblNewLabel_7.setBounds(168, 116, 103, 13);
		panelCaja.add(lblNewLabel_7);
		
		lblHoraInicio = new JLabel("");
		lblHoraInicio.setBounds(352, 116, 203, 13);
		panelCaja.add(lblHoraInicio);
		
		lblNewLabel_11 = new JLabel("Hora Salida");
		lblNewLabel_11.setBounds(168, 180, 103, 13);
		panelCaja.add(lblNewLabel_11);
		
		lblHoraSalida = new JLabel("");
		lblHoraSalida.setBounds(352, 180, 203, 13);
		panelCaja.add(lblHoraSalida);
		
		listProductosComprados = new JList();
		listProductosComprados.setBounds(10, 203, 221, 368);
		panelCaja.add(listProductosComprados);
		
		btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setBounds(301, 350, 155, 21);
		panelCaja.add(btnRealizarPago);
		
		lblPrecioTotal = new JLabel("");
		lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecioTotal.setBounds(342, 247, 100, 42);
		panelCaja.add(lblPrecioTotal);
		
		panelAniadirComanda = new JPanel();
		panelAniadirComanda.setBounds(199, 117, 567, 586);
		contentPane.add(panelAniadirComanda);
		paneles.add(panelAniadirComanda);
		panelAniadirComanda.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Comanda");
		lblNewLabel_6.setBounds(85, 86, 88, 13);
		panelAniadirComanda.add(lblNewLabel_6);
		
		listComanda = new JList();
		listComanda.setBounds(10, 104, 221, 368);
		panelAniadirComanda.add(listComanda);
		
		btnEliminarComanda = new JButton("Eliminar");
		btnEliminarComanda.setBounds(155, 535, 96, 21);
		panelAniadirComanda.add(btnEliminarComanda);
		
		btnPagarComanda = new JButton("Pagar");
		btnPagarComanda.setBounds(10, 535, 96, 21);
		panelAniadirComanda.add(btnPagarComanda);
		
		listProductosComandas = new JList();
		listProductosComandas.setBounds(336, 104, 221, 368);
		panelAniadirComanda.add(listProductosComandas);
		
		JLabel lblNewLabel_6_1 = new JLabel("Productos");
		lblNewLabel_6_1.setBounds(411, 86, 88, 13);
		panelAniadirComanda.add(lblNewLabel_6_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(411, 496, 96, 21);
		panelAniadirComanda.add(btnAgregar);
		
		imagenSitio = new JLabel("");
		imagenSitio.setBounds(336, 30, 66, 49);
		panelAniadirComanda.add(imagenSitio);
		
		lblNombreSitio = new JLabel("");
		lblNombreSitio.setBounds(208, 48, 96, 13);
		panelAniadirComanda.add(lblNombreSitio);
		
		lblPrecio = new JLabel("");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(73, 489, 100, 28);
		panelAniadirComanda.add(lblPrecio);

		panelComandas = new JPanel();
		panelComandas.setBounds(199, 117, 567, 586);
		contentPane.add(panelComandas);
		paneles.add(panelComandas);
		panelComandas.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 479, 547, 97);
		panelComandas.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("src/imagenes/barraBar.png"));
		
		 	silla1 = new JButton("Silla 1");
	        silla1.setBounds(36, 429, 45, 40);
	        panelComandas.add(silla1);
	        sillas[0] = silla1;

	        silla2 = new JButton("Silla 2");
	        silla2.setBounds(104, 429, 45, 40);
	        panelComandas.add(silla2);
	        sillas[1] = silla2;

	        silla3 = new JButton("Silla 3");
	        silla3.setBounds(171, 429, 45, 40);
	        panelComandas.add(silla3);
	        sillas[2] = silla3;

	        silla4 = new JButton("Silla 4");
	        silla4.setBounds(242, 429, 45, 40);
	        panelComandas.add(silla4);
	        sillas[3] = silla4;

	        silla5 = new JButton("Silla 5");
	        silla5.setBounds(310, 429, 45, 40);
	        panelComandas.add(silla5);
	        sillas[4] = silla5;

	        silla6 = new JButton("Silla 6");
	        silla6.setBounds(375, 429, 45, 40);
	        panelComandas.add(silla6);
	        sillas[5] = silla6;

	        silla7 = new JButton("Silla 7");
	        silla7.setBounds(443, 429, 45, 40);
	        panelComandas.add(silla7);
	        sillas[6] = silla7;

	        silla8 = new JButton("Silla 8");
	        silla8.setBounds(510, 429, 45, 40);
	        panelComandas.add(silla8);
	        sillas[7] = silla8;
	        
	        mesa1 = new JButton("");
	        mesa1.setBounds(36, 109, 66, 49);
	        panelComandas.add(mesa1);
	        mesas[0] = mesa1;
	        
	        mesa2 = new JButton("");
	        mesa2.setBounds(36, 246, 66, 49);
	        panelComandas.add(mesa2);
	        mesas[1] = mesa2;
	        
	        mesa3 = new JButton("New label");
	        mesa3.setBounds(171, 109, 66, 49);
	        panelComandas.add(mesa3);
	        mesas[2] = mesa3;
	        
	        mesa4 = new JButton("New label");
	        mesa4.setBounds(171, 246, 66, 49);
	        panelComandas.add(mesa4);
	        mesas[3] = mesa4;
	        
	        mesa5 = new JButton("New label");
	        mesa5.setBounds(321, 109, 66, 49);
	        panelComandas.add(mesa5);
	        mesas[4] = mesa5;
	        
	        mesa6 = new JButton("New label");
	        mesa6.setBounds(310, 246, 66, 49);
	        panelComandas.add(mesa6);
	        mesas[5] = mesa6;
	        
	        mesa7 = new JButton("New label");
	        mesa7.setBounds(462, 109, 66, 49);
	        panelComandas.add(mesa7);
	        mesas[6] = mesa7;
	        
	        mesa8 = new JButton("New label");
	        mesa8.setBounds(462, 246, 66, 49);
	        panelComandas.add(mesa8);
	        mesas[7] = mesa8;

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
		btnModStock.setBounds(223, 237, 110, 21);
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
		lblImagenLogo.setIcon(new ImageIcon("src//imagenes//logoBar.png"));
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
		btnGestionInventario.setIcon(new ImageIcon("src//imagenes//gestionInventario.png"));
		btnGestionInventario.setBounds(10, 254, 156, 87);
		panelCentral.add(btnGestionInventario);

		btnGestionComandas = new JButton("");
		btnGestionComandas.setIcon(new ImageIcon("src//imagenes//imagenComandas.png"));
		btnGestionComandas.setBounds(10, 402, 156, 87);
		panelCentral.add(btnGestionComandas);

		btnGestionCaja = new JButton("");
		btnGestionCaja.setIcon(new ImageIcon("src//imagenes//caja-registradora.png"));
		btnGestionCaja.setBounds(10, 537, 156, 87);
		panelCentral.add(btnGestionCaja);

		btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("src//imagenes//apagar.png"));
		btnExit.setBounds(10, 22, 156, 87);
		panelCentral.add(btnExit);
		
		txtRetroalimentacion = new JTextArea();
		txtRetroalimentacion.setBounds(20, 119, 146, 112);
		panelCentral.add(txtRetroalimentacion);

		panelGestionarInventario = new JPanel();
		panelGestionarInventario.setBounds(0, 0, 776, 713);
		contentPane.add(panelGestionarInventario);
		panelGestionarInventario.setLayout(null);
		panelGestionarInventario.setVisible(false);

		btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.setBounds(386, 273, 147, 28);
		panelGestionarInventario.add(btnVerInventario);

		btnAniadirProducto = new JButton("Añadir producto");
		btnAniadirProducto.setBounds(386, 366, 147, 28);
		panelGestionarInventario.add(btnAniadirProducto);

		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(386, 454, 147, 28);
		panelGestionarInventario.add(btnEliminarProducto);

		btnModificarStock = new JButton("Modificar Stock");
		btnModificarStock.setBounds(386, 546, 147, 28);
		panelGestionarInventario.add(btnModificarStock);

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
		btnSiguienteProducto.setBounds(224, 436, 100, 21);
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

		panelPreguntasProducto = new JPanel();
		panelPreguntasProducto.setBounds(193, 117, 583, 596);
		contentPane.add(panelPreguntasProducto);
		panelPreguntasProducto.setLayout(null);
		panelPreguntasProducto.setVisible(false);
		paneles.add(panelPreguntasProducto);

		radioBtnSi = new JRadioButton("SI");
		radioBtnSi.setBounds(141, 155, 103, 21);
		panelPreguntasProducto.add(radioBtnSi);
		grupo1.add(radioBtnSi);

		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setBounds(299, 155, 103, 21);
		panelPreguntasProducto.add(rdbtnNo);
		grupo1.add(rdbtnNo);

		lblPreguntaProducto = new JLabel("\u00BFEl Producto");
		lblPreguntaProducto.setBounds(182, 104, 196, 13);
		panelPreguntasProducto.add(lblPreguntaProducto);

		radioBtnCafeinaSi = new JRadioButton("SI");
		radioBtnCafeinaSi.setBounds(10, 292, 103, 21);
		panelPreguntasProducto.add(radioBtnCafeinaSi);
		componentesBebida.add(radioBtnCafeinaSi);
		grupoCafeina.add(radioBtnCafeinaSi);

		radioBtnCafeinaNo = new JRadioButton("NO");
		radioBtnCafeinaNo.setBounds(141, 292, 103, 21);
		panelPreguntasProducto.add(radioBtnCafeinaNo);
		componentesBebida.add(radioBtnCafeinaNo);
		grupoCafeina.add(radioBtnCafeinaNo);

		lblCafeina = new JLabel("\u00BFTiene cafeina la bebida?");
		lblCafeina.setBounds(10, 245, 196, 13);
		panelPreguntasProducto.add(lblCafeina);
		componentesBebida.add(lblCafeina);

		radioBtnAzucarSi = new JRadioButton("SI");
		radioBtnAzucarSi.setBounds(299, 292, 103, 21);
		panelPreguntasProducto.add(radioBtnAzucarSi);
		componentesBebida.add(radioBtnAzucarSi);
		grupoAzucar.add(radioBtnAzucarSi);

		radioBtnAzucarNo = new JRadioButton("NO");
		radioBtnAzucarNo.setBounds(460, 292, 103, 21);
		panelPreguntasProducto.add(radioBtnAzucarNo);
		componentesBebida.add(radioBtnAzucarNo);
		grupoAzucar.add(radioBtnAzucarNo);

		lblAzucarBebida = new JLabel("Contiene azucar la bebida");
		lblAzucarBebida.setBounds(302, 245, 196, 13);
		panelPreguntasProducto.add(lblAzucarBebida);
		componentesBebida.add(lblAzucarBebida);

		btnPonerProducto = new JButton("A\u00F1adir");
		btnPonerProducto.setBounds(204, 382, 85, 21);
		panelPreguntasProducto.add(btnPonerProducto);

		guardarBotonesIniciales();
		guardarBotonesInventario();
		guardarPaneles();
		ponerImagenSillas();
		ponerImagenesMesas();
		Collections.addAll(sitioComanda, sillas);
		Collections.addAll(sitioComanda, mesas);

	}

	private void ponerImagenesMesas() {
		
		for (int i = 0; i < mesas.length; i++) {
			mesas[i].setIcon(new ImageIcon("src/imagenes/mesa.png"));
			mesas[i].setName("Mesa "+(i+1));
			mesas[i].setText("");
			
		}
		
	}

	private void ponerImagenSillas() {

		for (int i = 0; i < sillas.length; i++) {
			sillas[i].setIcon(new ImageIcon("src/imagenes/sillaBar.png"));
			sillas[i].setName("silla "+(i+1));
			sillas[i].setText("");
		}
		
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
