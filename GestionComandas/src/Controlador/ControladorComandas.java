package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Modelo.Bebida;
import Modelo.Comida;
import Modelo.ComidaPicar;
import Modelo.Producto;
import Vista.VistaComandas;

public class ControladorComandas implements ActionListener {

	private VistaComandas vista;
	static List<Producto> inventario;
	public static Producto productoAniadir;
	SpinnerNumberModel modeloSpinner;
	

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

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	
		if(vista.btnExit == e.getSource()) {
			System.exit(0);
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
		if(vista.btnAtras == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelGestionarInventario.setVisible(true);
		}
		
		if(vista.btnEliminarProducto == e.getSource()) {
			vista.panelesInvisibles();
			vista.eliminarPanel.setVisible(true);
			agregarProductosAlComboBox(vista.boxProductosEliminar, inventario);
		}
		if(vista.btnModificarStock == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelModificarStock.setVisible(true);
			agregarProductosAlComboBox(vista.boxStock, inventario);
			
		}
		if(vista.btnEliminar ==e.getSource()) {
			
			for (int i = 0; i < inventario.size(); i++) {
				if(vista.boxProductosEliminar.getSelectedItem().equals(inventario.get(i).getNombre())) {
					System.out.println("Producto " +inventario.get(i).getNombre()+" eliminado");
					inventario.remove(i);
					break;
				}
			}
			vista.boxProductosEliminar.removeAllItems();
			agregarProductosAlComboBox(vista.boxProductosEliminar, inventario);
			
		}
		
		if(vista.btnModStock == e.getSource()) {
			int numeroModificar = (int) vista.spinnerModStock.getValue();
			int index = -1;
			
			for (int i = 0; i < inventario.size(); i++) {
				if(vista.boxStock.getSelectedItem().equals(inventario.get(i).getNombre())) {
					index = i;
					break;
				}
			}
			
			
			if(vista.rdbtnAniadir.isSelected()) {
				inventario.get(index).setCantidad(inventario.get(index).getCantidad()+numeroModificar);
				System.out.println("Se han añadido correctamente");
			}
			else if(vista.rdbtnEliminar.isSelected()) {
				if(inventario.get(index).getCantidad()>=numeroModificar) {
					inventario.get(index).setCantidad(inventario.get(index).getCantidad()-numeroModificar);
				}else{
					System.out.println("No puedes quitar tantos "+inventario.get(index).getNombre());
				}
				
			
			}else {
				System.out.println("Selecciona alguna de las opciones");
			}
		}

	}

	private void ponerProducto() {

		productoAniadir.setCantidad(1);

		if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[0])) {

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

		productoAniadir = new Producto();

		String coste = vista.textCostoProducto.getText().toString();
		boolean rellenarCampos = false;
		boolean pasoCorrecto = false;

		String nombreProducto = vista.textPaneNombre.getText().toString();
		productoAniadir.setNombre(nombreProducto);

		if (!coste.isEmpty()) {
			try {
				if (coste.contains(",")) {
					coste = coste.replace(',', '.');
				}
				double costeDouble = Double.parseDouble(coste);
				productoAniadir.setPrecio(costeDouble);
				pasoCorrecto = true;
			} catch (Exception e2) {
				System.out.println("Introduce numeros en el coste");
				vista.textCostoProducto.setText("");
			}
		} else {
			System.out.println("Rellena todos los campos,gracias");
		}

		if (pasoCorrecto) {
			vista.panelesInvisibles();
			vista.panelPreguntasProducto.setVisible(true);
			// si el producto es bebida
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[0])) {
				vista.visiblesComponentesBebida(true);

				vista.lblPreguntaProducto.setText(vista.lblPreguntaProducto.getText() + " es alcoholico?");
			}
			// si el producto es una comida
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[1])) {
				vista.visiblesComponentesBebida(false);
				vista.lblPreguntaProducto.setText(vista.lblPreguntaProducto.getText() + " es vegetariano?");

			}

			// si el producto es picoteo
			if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[2])) {
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
			modelo.addElement(producto.getNombre() + " - " + producto.getCantidad());
		}

		lista.setModel(modelo);

	}
	
	public static void agregarProductosAlComboBox(JComboBox comboBox, List<Producto> inventario2) {
        for (Producto producto : inventario2) {
            comboBox.addItem(producto.getNombre());
        }
    }



	
}
