package Modelo;

import javax.swing.ImageIcon;

public class ComidaPicar extends Producto {

	
	boolean picante;
	
	public ComidaPicar (String nombre, double precio, int cantidad,ImageIcon imagen,boolean picante) {
		super.cantidad = cantidad;
		super.nombre = nombre;
		super.imagen = imagen;
		super.precio = precio;
		this.picante = picante;
	}
	
	

	public ComidaPicar() {
		super();
	}



	public boolean isPicante() {
		return picante;
	}

	public void setPicante(boolean esPicante) {
		this.picante = esPicante;
	}
	
	

	
}
