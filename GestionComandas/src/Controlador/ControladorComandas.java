package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import Modelo.Bebida;
import Modelo.Comida;
import Modelo.ComidaPicar;
import Modelo.Producto;
import Vista.VistaComandas;

public class ControladorComandas implements ActionListener {
	
	private VistaComandas vista;
	static List <Producto> inventario;
	
	

	public ControladorComandas(VistaComandas vista) {
		this.vista = vista;
		inventario = new ArrayList<Producto>();
		rellenarInventario();
		construirListas();
		
		for (JButton boton : vista.botonesIniciales) {
			boton.addActionListener(this);
		}
		
		for (JButton boton : vista.botonesInventario) {
			boton.addActionListener(this);
		}
		
		
	}


		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(vista.btnGestionInventario == e.getSource()) {
			vista.panelesInvisibles();
			vista.panelGestionarInventario.setVisible(true);
		}
		
		if(vista.btnVerInventario == e.getSource()){
			vista.panelesInvisibles();
			vista.panelVerInventario.setVisible(true);
		}
		
		
		
		
		
		
		
		
	}
	
	public void rellenarInventario() {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		
		
		inventario.add(new Bebida("Zumito Humilde",10,30,null,false,false,calendar.getTime(),true));
		inventario.add(new ComidaPicar("Uva Solanera",5,2000,null,false));
		inventario.add(new ComidaPicar("Viejas Solaneras",4,30,null,false));
		inventario.add(new Comida("Moje Vendimiador",20,10,true));
		inventario.add(new ComidaPicar("Migas Gañanas con uva",30,20,null,false));
		inventario.add(new Comida("Gachas Solaneras",20,10,false));
		inventario.add(new ComidaPicar("Torrijas",4,20,null,false));
		inventario.add(new Comida("Pisto Manchego",15,10,false));
		//inventario.add(new Producto("",,));
		
	}
	
	public void construirListas () {
		List <Producto> bebidas = new ArrayList<>();
		List <Producto> comidas = new ArrayList<>();
		List <Producto> comidasPicar = new ArrayList<>();
		for (Producto producto : inventario) {
			if(producto instanceof Bebida) {
				bebidas.add((Bebida)producto);
			}
			if(producto instanceof Comida) {
				comidas.add((Comida)producto);
			}
			if(producto instanceof ComidaPicar) {
				comidasPicar.add((ComidaPicar)producto);
			}
		}
		
		rellenarListas(bebidas,vista.listBebidas);
		rellenarListas(comidas,vista.listComidas);
		rellenarListas(comidasPicar,vista.listPicar);
	}



	public void rellenarListas(List<Producto> p,JList lista) {
		
		DefaultListModel modelo = new DefaultListModel<>();
		
		for (Producto producto : p) {
			modelo.addElement(producto.getNombre()+" - "+producto.getCantidad());
		}
		lista.setModel(modelo);
		
	}
	
	

}
