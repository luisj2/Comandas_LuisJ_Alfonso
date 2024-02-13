package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;

import Modelo.Bebida;
import Modelo.Comanda;
import Modelo.Comida;
import Modelo.ComidaPicar;
import Modelo.Producto;
import Vista.VistaComandas;

public class ControladorComandas implements ActionListener {

	public static VistaComandas vista;
	static List<Producto> inventario;
	public static Producto productoAniadir;
	SpinnerNumberModel modeloSpinner;
	Comanda [] comandas = new Comanda[16];
	Comanda comanda = null;
	List <Producto> produs = new ArrayList<>();
	int posicionArray = -1;

	public ControladorComandas(VistaComandas vista) {
		this.vista = vista;
		inventario = new ArrayList<Producto>();
		rellenarInventario();
		vista.panelesInvisibles();
		vista.panelGestionarInventario.setVisible(true);
		vista.visiblesComponentesBebida(false);

		vista.btnSiguienteProducto.addActionListener(this);
		vista.btnPonerProducto.addActionListener(this);

		for (JButton boton : vista.botonesIniciales) {
			boton.addActionListener(this);
		}

		for (JButton boton : vista.botonesInventario) {
			boton.addActionListener(this);
		}
		vista.btnAtras.addActionListener(this);
		vista.btnExit.addActionListener(this);
		vista.btnEliminar.addActionListener(this);
		vista.btnModStock.addActionListener(this);
		vista.btnAgregar.addActionListener(this);
		vista.btnEliminarComanda.addActionListener(this);
		vista.btnRealizarPago.addActionListener(this);
		vista.btnPagarComanda.addActionListener(this);
		
		
		for (JButton b : vista.sitioComanda) {
			b.addActionListener(this);
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(vista.btnRealizarPago == e.getSource()) {
			DefaultListModel<String> modeloLista = (DefaultListModel<String>) vista.listProductosComprados.getModel();

			if(modeloLista.size() >0) {
				mostrarMensaje("Pago realizado \n correctamente");
				for (int i = 0; i < vista.sitioComanda.size(); i++) {
					if(vista.sitioComanda.get(i).getName().equals(vista.lblNombreSitio.getText().toString())){
						vista.sitioComanda.get(i).setBackground(null);
						comandas[i] = null;
					}
				}
			}else {
				mostrarMensaje("Añade algun producto");
			}
		}

		if (vista.btnGestionComandas == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelComandas.setVisible(true);
			for (int i = 0; i < comandas.length; i++) {
				if(comandas[i] != null && !comandas[i].getProdComprados().isEmpty()) {
					vista.sitioComanda.get(i).setBackground(Color.red);
				}
			}
		}
		
		if(vista.btnAgregar == e.getSource()) {
			agregarProducto();
		}
		
		if(vista.btnEliminarComanda == e.getSource()) {
			eliminarProductoComanda();
		}
		
		if(vista.btnPagarComanda == e.getSource() || vista.btnGestionCaja == e.getSource()) {
			Comanda comandaPago = null;
			
			vista.panelesInvisibles();
			vista.panelCaja.setVisible(true);
			
			for (int i = 0; i < comandas.length; i++) {
				if(comandas[i] != null && comandas[i].getMesa().equals(vista.lblNombreSitio.getText().toString())) {
					comandaPago = comandas[i];
					posicionArray = i;
				}
			}
			if(comandaPago != null) {
				comandaPago.setHoraSalida(LocalTime.now());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		        
		        String horaEntradaFormateada = comandaPago.getHoraEntrada().format(formatter);
		        String horaSalidaFormateada = comandaPago.getHoraSalida().format(formatter);
		        
		        
		        vista.lblMesaPago.setText("Pago de "+comandaPago.getMesa());
				vista.lblHoraInicio.setText(horaEntradaFormateada);
				vista.lblHoraSalida.setText(horaSalidaFormateada);
				vista.lblPrecioTotal.setText(vista.lblPrecio.getText());
				rellenarListas(comandaPago.getProdComprados(), vista.listProductosComprados);
			}
			
			
			
		}

		if (vista.btnExit == e.getSource()) {
			System.exit(0);
		}

		for (int i = 0; i < vista.sitioComanda.size(); i++) {
			if(vista.sitioComanda.get(i) == e.getSource()) {
				if(vista.sitioComanda.get(i).getBackground().equals(Color.red)) {
					rellenarListasSinPrecio(comandas[i].getProdComprados(), vista.listComanda);
				}else {
					DefaultListModel<String> modeloLista = new DefaultListModel<>();
					vista.listComanda.setModel(modeloLista);
				}
				vista.lblPrecio.setText("");
				aniadirComanda(i,vista.sitioComanda.get(i).getName());
				break;
			}
		}
			
		

		if (vista.btnGestionInventario == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelGestionarInventario.setVisible(true);
			
			
		}

		if (vista.btnVerInventario == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelVerInventario.setVisible(true);
			construirListasCantidades();
		}
		if (vista.btnAniadirProducto == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelAniadirProducto.setVisible(true);
		}

		if (vista.btnSiguienteProducto == e.getSource()) {

			siguienteProducto();

		}

		if (vista.btnPonerProducto == e.getSource()) {

			ponerProducto();

		}
		if (vista.btnAtras == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelGestionarInventario.setVisible(true);
		}

		if (vista.btnEliminarProducto == e.getSource()) {
			vista.panelesInvisibles();
			vista.eliminarPanel.setVisible(true);
			agregarProductosAlComboBox(vista.boxProductosEliminar);
		}
		if (vista.btnModificarStock == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelModificarStock.setVisible(true);
			agregarProductosAlComboBox(vista.boxStock);

		}
		if (vista.btnEliminar == e.getSource()) {

			for (int i = 0; i < inventario.size(); i++) {
				if (vista.boxProductosEliminar.getSelectedItem().equals(inventario.get(i).getNombre())) {
					mostrarMensaje("Producto " + inventario.get(i).getNombre() + " eliminado");
					inventario.remove(i);
					break;
				}
			}
			vista.boxProductosEliminar.removeAllItems();
			agregarProductosAlComboBox(vista.boxProductosEliminar);

		}

		if (vista.btnModStock == e.getSource()) {
			int numeroModificar = (int) vista.spinnerModStock.getValue();
			int index = -1;

			for (int i = 0; i < inventario.size(); i++) {
				if (vista.boxStock.getSelectedItem().equals(inventario.get(i).getNombre())) {
					index = i;
					break;
				}
			}

			if (vista.rdbtnAniadir.isSelected()) {
				inventario.get(index).setCantidad(inventario.get(index).getCantidad() + numeroModificar);
				mostrarMensaje("Se han añadido \n correctamente");
			} else if (vista.rdbtnEliminar.isSelected()) {
				if (inventario.get(index).getCantidad() >= numeroModificar) {
					inventario.get(index).setCantidad(inventario.get(index).getCantidad() - numeroModificar);
					mostrarMensaje("Se han eliminado \ncorrectamente");
				} else {
					mostrarMensaje("No puedes quitar \n tantos " + inventario.get(index).getNombre());
				}

			} else {
				mostrarMensaje("Selecciona alguna \n de las opciones");
			}
		}

	}
	
	
	
	private void agregarProducto() {
		Integer posicionLista = vista.listProductosComandas.getSelectedIndex();
		
		
		boolean encontrado = false;
		
		
		if(posicionLista != null) {
			String texto = (String) vista.listProductosComandas.getModel().getElementAt(posicionLista);
			int posicionGuion = texto.indexOf("-");
			String resultado = texto.substring(0, posicionGuion);
			resultado = resultado.trim();
			double precio = 0;
			int cantidad = 1;
			
			
			for (int i = 0; i < comanda.getProdComprados().size(); i++) {
				if(comanda.getProdComprados().get(i) != null && comanda.getProdComprados().get(i).getNombre().equals(resultado)) {
					comanda.getProdComprados().get(i).setCantidad(comanda.getProdComprados().get(i).getCantidad()+1);
					encontrado = true;
				}
			}
			for (int i = 0; i < inventario.size(); i++) {
				if(inventario.get(i).getNombre().equals(resultado)) {
					if(inventario.get(i).getCantidad()>1) {
						inventario.get(i).setCantidad(inventario.get(i).getCantidad()-1);
						precio = inventario.get(i).getPrecio();
						mostrarMensaje("Inventario actualizado");
					}else{
						inventario.remove(i);
					}
						
				}
			}
			
			if(!encontrado) {
				Producto produ = new Producto();
				produ.setNombre(resultado);
				produ.setCantidad(cantidad);
				produ.setPrecio(precio);
				
				comanda.getProdComprados().add(produ);
			}
			
			
			
			
			
			
			rellenarListasSinPrecio(inventario, vista.listProductosComandas);
			rellenarListasSinPrecio(comanda.getProdComprados(), vista.listComanda);
		
			int comandaEs = cualComandaEs(vista.lblNombreSitio.getText().toString().trim());
			comanda.setMesa(vista.lblNombreSitio.getText().toString().trim());
			comandas[comandaEs] = comanda;
			vista.lblPrecio.setText(String.valueOf(calcularPrecio())+"€");
			
			
			
			
			
		}
	}
	
	private int cualComandaEs(String nombre) {
		int res = -1;
		for (int i = 0; i < vista.sitioComanda.size(); i++) {
			if(vista.sitioComanda.get(i).getName().equals(nombre)) {
				res = i;
			}
		}
		return res;
	}


	public int calcularPrecio () {
		int total = 0;
		for (Producto p : comanda.getProdComprados()) {
			total += (p.getPrecio()*p.getCantidad());
		}
		return total;
	}
	
	public void eliminarProductoComanda () {
		Integer posicionLista = vista.listComanda.getSelectedIndex();
		String texto = (String) vista.listComanda.getModel().getElementAt(posicionLista);
		int posicionGuion = texto.indexOf("-");
		String resultado = texto.substring(0, posicionGuion);
		resultado = resultado.trim();
		for (int i = 0; i < comanda.getProdComprados().size(); i++) {
			if(comanda.getProdComprados().get(i).getNombre().equals(resultado)) {
				if(comanda.getProdComprados().get(i).getCantidad()>1) {
					comanda.getProdComprados().get(i).setCantidad(comanda.getProdComprados().get(i).getCantidad()-1);
				}else{
					comanda.getProdComprados().remove(i);
				}
					
			}
		}
		
		for (int i = 0; i < inventario.size(); i++) {
			if(inventario.get(i).getNombre().equals(resultado)) {
				inventario.get(i).setCantidad(inventario.get(i).getCantidad()+1);
			}
		}
		
		
		rellenarListasSinPrecio(comanda.getProdComprados(), vista.listComanda);
		rellenarListasSinPrecio(inventario, vista.listProductosComandas);
		vista.lblPrecio.setText(String.valueOf(calcularPrecio())+"€");

	}

	public void aniadirComanda(int posicion,String nombre) {
		ImageIcon imagen = null;
		 comanda = new Comanda();
		
		rellenarListas(inventario, vista.listProductosComandas);
		vista.panelesInvisibles();
		vista.panelAniadirComanda.setVisible(true);
		
		vista.lblNombreSitio.setText(nombre);
		comanda.setMesa(nombre);
		
		if(nombre.contains("silla")) {
			imagen = new ImageIcon("src/imagenes/sillaBar.png");
		}else {
			imagen = new ImageIcon("src/imagenes/mesa.png");
		}
		vista.imagenSitio.setIcon(imagen);
		
		
		
		
	}

	private void ponerProducto() {

		productoAniadir.setCantidad(1);

		if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[0])) {
			boolean alcoholico = false, cafeina = false, azucarada = false;
			Bebida bebida = (Bebida) productoAniadir;
			// botones del alcohol
			if (vista.rdbtnNo.isSelected()) {
				alcoholico = false;
			} else if (vista.radioBtnSi.isSelected()) {
				alcoholico = true;
			}
			// botones de la cafeina
			if (vista.radioBtnCafeinaNo.isSelected()) {
				cafeina = false;
			} else if (vista.radioBtnCafeinaSi.isSelected()) {
				cafeina = true;
			}

			// botones de azucar

			if (vista.radioBtnAzucarNo.isSelected()) {
				azucarada = false;
			} else if (vista.radioBtnAzucarSi.isSelected()) {
				azucarada = true;
			}

			bebida.setAlcoholica(alcoholico);
			bebida.setAzucarada(azucarada);
			bebida.setCafeina(cafeina);

			inventario.add(bebida);
			mostrarMensaje("Bebida añadida con exito");

		} else if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[1])) {
			Comida comida = (Comida) productoAniadir;
			boolean vegetariana = false;

			if (vista.rdbtnNo.isSelected()) {
				vegetariana = false;
			} else if (vista.radioBtnSi.isSelected()) {
				vegetariana = true;
			}

			comida.setEsVegetariana(vegetariana);
			mostrarMensaje("Comida añadida con exito");

			inventario.add(comida);
		} else if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[2])) {
			ComidaPicar picar = (ComidaPicar) productoAniadir;

			boolean picante = false;

			if (vista.rdbtnNo.isSelected()) {
				picante = false;
			} else if (vista.radioBtnSi.isSelected()) {
				picante = true;
			}
			picar.setPicante(picante);

			inventario.add(picar);
			mostrarMensaje("Comida picar \nañadida con \n exito");
		}

	}

	/*
	 * private Bebida new Bebida() { Bebida bebida = new Bebida();
	 * bebida.setPrecio(productoAniadir.getPrecio());
	 * bebida.setNombre(productoAniadir.getNombre()); bebida.setCantidad(1);
	 * bebida.setImagen(productoAniadir.getImagen()); String fecha =
	 * vista.textPaneFechaCaducidad.getText().toString();
	 * 
	 * if (vista.grupo1.getSelection() != null) { if
	 * (vista.grupo1.getSelection().equals(vista.radioBtnSi.getModel())) {
	 * bebida.setAlcoholica(true);
	 * 
	 * }else { bebida.setAlcoholica(false); } } else {
	 * System.out.println("Rellena los primeros botones"); }
	 * 
	 * if (vista.grupoCafeina.getSelection() != null) { if
	 * (vista.grupoCafeina.getSelection().equals(vista.radioBtnCafeinaSi.getModel())
	 * ) { bebida.setCafeina(true); }else { bebida.setCafeina(false); } } else {
	 * System.out.println("Rellena los segundos botones"); } if
	 * (vista.grupoAzucar.getSelection() != null) { if
	 * (vista.grupoAzucar.getSelection().equals(vista.radioBtnAzucarSi.getModel()))
	 * { bebida.setAzucarada(true); }else { bebida.setAzucarada(false); } } else {
	 * System.out.println("Rellena los terceros botones"); }
	 * 
	 * 
	 * 
	 * inventario.add(bebida); System.out.println("Bebida añadida"); } else {
	 * System.out.println("Raellena todas las opciones"); } }
	 */

	private void siguienteProducto() {

		productoAniadir = null;

		String coste = vista.textCostoProducto.getText().toString();
		boolean rellenarCampos = false;
		boolean pasoCorrecto = false;
		double costeDouble = 0;

		String nombreProducto = vista.textPaneNombre.getText().toString();

		if (!coste.isEmpty()) {
			try {
				if (coste.contains(",")) {
					coste = coste.replace(',', '.');
				}
				costeDouble = Double.parseDouble(coste);

				pasoCorrecto = true;
			} catch (Exception e2) {
				mostrarMensaje("Introduce numeros \nen el coste");
				vista.textCostoProducto.setText("");
			}
		} else {
			mostrarMensaje("Rellena todos \nlos campos,gracias");
		}

		if (pasoCorrecto) {
			vista.panelesInvisibles();
			vista.panelPreguntasProducto.setVisible(true);
			// si el producto es bebida
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[0])) {
				productoAniadir = new Bebida();
				productoAniadir.setNombre(nombreProducto);
				productoAniadir.setPrecio(costeDouble);
				vista.visiblesComponentesBebida(true);

				vista.lblPreguntaProducto.setText(vista.lblPreguntaProducto.getText() + " es alcoholico?");
			}
			// si el producto es una comida
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[1])) {
				productoAniadir = new Comida();
				productoAniadir.setNombre(nombreProducto);
				productoAniadir.setPrecio(costeDouble);
				vista.visiblesComponentesBebida(false);
				vista.lblPreguntaProducto.setText(vista.lblPreguntaProducto.getText() + " es vegetariano?");

			}

			// si el producto es picoteo
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[2])) {
				productoAniadir = new ComidaPicar();
				productoAniadir.setNombre(nombreProducto);
				productoAniadir.setPrecio(costeDouble);
				vista.visiblesComponentesBebida(false);
				vista.lblPreguntaProducto.setText(vista.lblPreguntaProducto.getText() + " contiene picante?");

			}

		}

	}

	public void rellenarInventario() {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_MONTH, 5);

		inventario.add(new Bebida("Zumito Humilde", 10, 30, null, false, false, calendar.getTime(), true));
		inventario.add(new ComidaPicar("Uva Solanera", 5, 2000, null, false));
		inventario.add(new ComidaPicar("Viejas Solaneras", 4, 30, null, false));
		inventario.add(new Comida("Moje Vendimiador", 20, 10, true));
		inventario.add(new ComidaPicar("Migas Gañanas con uva", 30, 20, null, false));
		inventario.add(new Comida("Gachas Solaneras", 20, 10, false));
		inventario.add(new ComidaPicar("Torrijas", 4, 20, null, false));
		inventario.add(new Comida("Pisto Manchego", 15, 10, false));
		// inventario.add(new Producto("",,));

	}

	public void construirListasCantidades() {
		List<Producto> bebidas = new ArrayList<>();
		List<Producto> comidas = new ArrayList<>();
		List<Producto> comidasPicar = new ArrayList<>();
		for (Producto producto : inventario) {
			if (producto instanceof Bebida) {
				bebidas.add((Bebida) producto);
			}
			if (producto instanceof Comida) {
				comidas.add((Comida) producto);
			}
			if (producto instanceof ComidaPicar) {
				comidasPicar.add((ComidaPicar) producto);
			}
		}

		rellenarListas(bebidas, vista.listBebidas);
		rellenarListas(comidas, vista.listComidas);
		rellenarListas(comidasPicar, vista.listPicar);
	}

	public void rellenarListas(List<Producto> p, JList lista) {

		DefaultListModel modelo = new DefaultListModel<>();
		

		for (Producto producto : p) {
			modelo.addElement(producto.getNombre() + " - " + producto.getCantidad()+" - "+producto.getPrecio()+"€");

		lista.setModel(modelo);

	}
	}
	public void rellenarListasSinPrecio(List<Producto> p, JList lista) {

		DefaultListModel modelo = new DefaultListModel<>();
		

		for (Producto producto : p) {
			modelo.addElement(producto.getNombre() + " - " + producto.getCantidad());
		}

		lista.setModel(modelo);

	}

	public static void agregarProductosAlComboBox(JComboBox comboBox) {
		for (Producto producto : inventario) {
			comboBox.addItem(producto.getNombre());
		}
	}
	public static void mostrarMensaje(String mensaje) {
        Timer timer = new Timer();
        long delay = 2000;
        
        vista.txtRetroalimentacion.setText(mensaje);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                vista.txtRetroalimentacion.setText("");
                timer.cancel(); // Detener el temporizador después de mostrar el mensaje
            }
        }, delay);
    }

}
