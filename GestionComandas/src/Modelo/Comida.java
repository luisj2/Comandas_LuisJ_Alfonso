package Modelo;

public class Comida extends Producto {

	
	
	private boolean esVegetariana;
	
	public Comida(String nombre, double precio, int cantidad,boolean esVegetariana) {
		super.nombre = nombre;
		super.precio = precio;
		super.cantidad = cantidad;
		this.esVegetariana = esVegetariana;
	}
	


	public Comida() {
		super();
	}



	public boolean isEsVegetariana() {
		return esVegetariana;
	}

	public void setEsVegetariana(boolean esVegetariana) {
		this.esVegetariana = esVegetariana;
	}
	
	
	
}
