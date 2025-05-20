package test;

import org.junit.jupiter.api.*;

import Ejercicios.PaqueteEnviado;
import Ejercicios.ServicioEnvios;

public class testServicioEnvio {
//Cobertura del 80%
	
	@Test
	public void testPaqueteNull(ServicioEnvios.calcularCosteEnvio) {
		paquete = null;
		
		assertThrows(IllegalArgumentException.class, () -> {paquete;});
	}
	
	@Test
	public void testPesoPaqueteNegativo() {
		paquete = new paquete (ServicioEnvios.calcularCosteEnvio("Francia", -30, "expres"));
		
		assertThrows(IllegalArgumentException.class, () -> {});
	}
	
	@Test
	public void testTipoServicioNulo() {
		paquete = new paquete (PaqueteEnviado.PaqueteEnviado("Francia", 9, null));
		
		assertThrows(IllegalArgumentException.class, () -> {});
	}
	
	@Test
	public void testFranciaEstandar() {
		paquete = new paquete(PaqueteEnviado.PaqueteEnviado("Francia", 5.0, "estandar"));
		
		assertEquals(ServicioEnvios.calcularCosteEnvio())
	}
	
	@Test
	public void testItaliaExpres() {
		paquete = new paquete(PaqueteEnviado.PaqueteEnviado("Francia", 5.0, "estandar"));
		
		double Estimado = ServicioEnvios.calcularCosteEnvio(paquete)
	
	assertEquals(25.0, Estimado);
	}
}
