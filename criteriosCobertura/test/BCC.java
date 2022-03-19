package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BCC {

    /*---------------------------------------D4-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void bccD4_1() throws DatoException {
		int hora = 9;
		Dia dia = new Dia(10);
		Cita cita = new Cita("cita",1);
		dia.asignarCita(hora, cita);
		assertEquals(cita, dia.getCita(hora));	
	}
	
	@Test
	void bccD4_2() throws DatoException {
		int hora = 8;
		Dia dia = new Dia(10);
		assertEquals(null, dia.getCita(hora));	
	}
	
	@Test
	void bccD4_3() throws DatoException {
		int hora = 9;
		Dia dia = new Dia(10);
		assertEquals(null, dia.getCita(hora));	
	}
	
    /*---------------------------------------D5-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void bccD5_1() throws DatoException {
		int hora = 9;
		Dia dia = new Dia(10);
		Cita cita = new Cita("cita",1);
		dia.asignarCita(9, cita);
		assertEquals(hora + ":00 cita", dia.muestraCita(hora));
	}
	
	@Test
	void bccD5_2() throws DatoException {
		int hora = 8;
		Dia dia = new Dia(10);
		assertEquals("Hora no valida", dia.muestraCita(hora));
	}
	
	@Test
	void bccD5_3() throws DatoException {
		int hora = 9;
		Dia dia = new Dia(10);
		assertEquals("No existe", dia.muestraCita(hora));
	}
	
    /*---------------------------------------D6-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void bccD6_1() throws DatoException {
		int hora = 8;
		Dia dia = new Dia(10);
		assertEquals(false, dia.validaHora(hora));
	}
	
	@Test
	void bccD6_2() throws DatoException {
		int hora = 9;
		Dia dia = new Dia(10);
		assertEquals(true, dia.validaHora(hora));
	}
	
	@Test
	void bccD6_3() throws DatoException {
		int hora = 18;
		Dia dia = new Dia(10);
		assertEquals(false, dia.validaHora(hora));
	}
	
	/*---------------------------------------S2-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void bccS2_1() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.mostrarCita(12, 1), "12:00 peluquero");
	}

	@Test
	void bccS2_2() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.mostrarCita(12, 7), "Dia no valido");
	}

	@Test
	void bccS2_3() throws DatoException {
		Semana semana1 = new Semana(1);
		assertEquals(semana1.mostrarCita(12, 1), "Dia no citable");
	}

	@Test
	void bccS2_4() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.mostrarCita(19, 1), "Hora no valida");
	}

	@Test
	void bccS2_5() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.mostrarCita(13, 1), "No existe");
	}

	
    /*---------------------------------------S3-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void bccS3_1() throws DatoException {
		Dia dia = new Dia(4);
		Semana semana = new Semana(2);
		assertEquals(dia.getDiaNumero(), semana.getDia(1).getDiaNumero());
	}

	@Test
	void bccS3_2() throws DatoException {
		Semana semana = new Semana(2);
		assertEquals(null, semana.getDia(6));
	}
	
	@Test
	void bccS3_3() throws DatoException {
		Semana semana = new Semana(1);
		assertEquals(null, semana.getDia(1));
	}

}
