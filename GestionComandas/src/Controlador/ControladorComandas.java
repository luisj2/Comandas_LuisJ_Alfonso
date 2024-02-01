package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;

import Modelo.Bebida;
import Modelo.Comida;
import Modelo.ComidaPicar;
import Modelo.Producto;
import Vista.VistaComandas;

public class ControladorComandas implements ActionListener {

	private VistaComandas vista;
	static List<Producto> inventario;

	public ControladorComandas(VistaComandas vista) {
		this.vista = vista;
		inventario = new ArrayList<Producto>();
		rellenarInventario();
		vista.visiblesComponentesBebida(false);

		vista.btnSiguienteProducto.addActionListener(this);
		vista.btnPonerProducto.addActionListener(this);

		for (JButton boton : vista.botonesIniciales) {
			boton.addActionListener(this);
		}

		for (JButton boton : vista.botonesInventario) {
			boton.addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

			aniadirProducto();

		}

		if (vista.btnPonerProducto == e.getSource()) {

			ponerProducto();

		}

	}

	private void ponerProducto() {
		Producto producto = new Producto();
		
		producto.setCantidad(1);
		producto.setNombre(vista.textPaneNombre.getText().toString());
		producto.setPrecio(Double.parseDouble(vista.textCostoProducto.getText().toString()));
		
		if (vista.boxTipoProducto.getSelectedItem().toString().equals(vista.opcionesProductos[0])) {
			
				
					
			} else {
				System.out.println("Rellena todas las opciones");
			}

		}

	

	private void aniadirProducto() {
		String coste = vista.textCostoProducto.getText().toString();
		if (coste.contains(",")) {
			coste = coste.replace(',', '.');
		}

		String rutaImagen = vista.textRutaImagen.getText().toString();
		boolean rellenarCampos = false;
		boolean pasoCorrecto = false;

		if (!coste.isEmpty()) {
			try {
				double costeDouble = Double.parseDouble(coste);
				pasoCorrecto = true;
			} catch (Exception e2) {
				System.out.println("Introduce numeros en el coste");
				vista.textCostoProducto.setText("");
			}
		} else {
			System.out.println("Rellena todos los campos,gracias");
		}

		if (!rutaImagen.isEmpty()) {
			try {
				ImageIcon imagenProducto = new ImageIcon(rutaImagen);
				System.out.println("Imagen correcta");

			} catch (Exception e2) {
				System.out.println("Introduce una ruta de imagen correcta");
			}
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

}
