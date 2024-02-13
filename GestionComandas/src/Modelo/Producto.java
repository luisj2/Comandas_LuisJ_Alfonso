package Modelo;

import javax.swing.ImageIcon;

public class Producto {

	protected String nombre;
	protected double precio;
	protected int cantidad;
	protected ImageIcon imagen;
	
	
	public Producto() {
		super();
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", imagen=" + imagen
				+ "]";
	}
	
	
}
