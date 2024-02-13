package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Comanda {

	private String mesa;
	private double precioTotal;

	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	List <Producto> prodComprados;
	
	
	
	
	
	public Comanda() {
		this.horaEntrada = LocalTime.now();
		this.prodComprados = new ArrayList<>();
	}


	

	


	public List<Producto> getProdComprados() {
		return prodComprados;
	}







	public void setProdComprados(List<Producto> prodComprados) {
		this.prodComprados = prodComprados;
	}







	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	

	
	
	
	
	
}
