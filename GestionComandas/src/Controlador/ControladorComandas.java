package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import Modelo.Producto;
import Vista.VistaComandas;

public class ControladorComandas implements ActionListener {
	
	private VistaComandas vista;
	static List <Producto> inventario;
	
	

	public ControladorComandas(VistaComandas vista) {
		this.vista = vista;
		inventario = new ArrayList<Producto>();
		rellenarInventario();
		
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
			vista.panelnventario.setVisible(true);
		}
		
		
		
		
		
	}
	
	public void rellenarInventario() {
		inventario.add(new Bebida("Zumito Humilde",10,30));
		inventario.add(new ("Uva Solanera",5,2000));
		inventario.add(new Producto("Viejas Solaneras",4,30));
		inventario.add(new Producto("Moje Vendimiador",20,10));
		inventario.add(new Producto("Migas Gañanas con uva",30,20));
		inventario.add(new Producto("Gachas Solaneras",20,10));
		inventario.add(new Producto("Torrijas",4,20));
		inventario.add(new Producto("Pisto Manchego",15,10));
		//inventario.add(new Producto("",,));
		
	}
	
	

}
