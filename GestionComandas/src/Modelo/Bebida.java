package Modelo;

import java.util.Date;

import javax.swing.ImageIcon;

public class Bebida extends Producto {

	private boolean alcoholica;
	private boolean cafeina;
	private Date fechaCaducidad;
	private boolean azucarada;
	
	public Bebida(String nombre, double precio, int cantidad,ImageIcon imagen,boolean alcoholica,boolean cafeina,
			Date fechaCaducidad,boolean azucarada) {
		super.nombre = nombre;
		super.precio = precio;
		super.cantidad = cantidad;
		super.imagen = imagen;
		this.alcoholica = alcoholica;
		this.cafeina = cafeina;
		this.fechaCaducidad = fechaCaducidad;
		this.azucarada = azucarada;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	public boolean isCafeina() {
		return cafeina;
	}

	public void setCafeina(boolean cafeina) {
		this.cafeina = cafeina;
	}

	public boolean isAzucarada() {
		return azucarada;
	}

	public void setAzucarada(boolean azucarada) {
		this.azucarada = azucarada;
	}
	

}
