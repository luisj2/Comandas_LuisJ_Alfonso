package Modelo;

public class Bebida extends Producto {

	boolean alcoholica;
	boolean cafeina;
	
	public Bebida(String nombre, int precio, int cantidad) {
		super.nombre = nombre;
		super.precio = precio;
		super.cantidad = cantidad;
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
	
	
}
