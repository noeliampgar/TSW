package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PPC {
	
    /*---------------------------------------D2-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	
	// camino de test: 12356
	@Test
	void ppcD2_1() throws DatoException {
		Dia day = new Dia(1);
		int slot = day.buscaSlot(1);
		assertTrue(slot == 9);
	}
	
	// camino de test: 12342356
	@Test
	void ppcD2_2() throws DatoException {
		Dia day = new Dia(2);
		Cita peluquero = new Cita("peluquero", 1);
		day.asignarCita(9, peluquero);
		int slot = day.buscaSlot(1);
		assertTrue(slot == 10);
	}
	
	// camino de test: 1235789898_10_11
	@Test
	void ppcD2_3() throws DatoException {
		Dia day = new Dia(3);
		int slot = day.buscaSlot(3);
		assertTrue(slot == 9);
	}
	
	// camino de test: 12342342342342342342342342342342_13
	@Test
	void ppcD2_4() throws DatoException {
		Dia day = new Dia(4);
		Cita medico = new Cita("medico", 2);
		day.asignarCita(9, medico);
		Cita peluquero = new Cita("peluquero", 2);
		day.asignarCita(11, peluquero);
		Cita examen = new Cita("examen", 3);
		day.asignarCita(13, examen);
		Cita comida = new Cita("comida", 2);
		day.asignarCita(16, comida);
		int slot = day.buscaSlot(1);
		assertTrue(slot == -1);
	}
	
	// camino de test: 123578_10_12_2342357898_10_12_23423578_10_12_2_13
	@Test
	void ppcD2_5() throws DatoException {
		Dia day = new Dia(5);
		Cita medico = new Cita("medico", 2);
		day.asignarCita(10, medico);
		Cita comida = new Cita("comida", 2);
		day.asignarCita(14, comida);
		Cita examen = new Cita("examen", 1);
		day.asignarCita(17, examen);
		int slot = day.buscaSlot(3);
		assertTrue(slot == -1);
	}
	
	// camino de test: 123578_10_12_23578_10_12_2357898_10_11
	@Test
	void ppcD2_6() throws DatoException {
		Dia day = new Dia(6);
		Cita medico = new Cita("medico", 1);
		day.asignarCita(10, medico);
		Cita examen = new Cita("examen", 1);
		day.asignarCita(12, examen);
		int slot = day.buscaSlot(2);
		assertTrue(slot == 13);
	}
	
	// camino de test: 12357898_10_12_23578_10_12_23578_10_12_2342342_13
	@Test
	void ppcD2_7() throws DatoException {
		Dia day = new Dia(7);
		Cita medico = new Cita("medico", 1);
		day.asignarCita(11, medico);
		Cita examen = new Cita("examen", 1);
		day.asignarCita(13, examen);
		Cita comida = new Cita("comida", 3);
		day.asignarCita(15, comida);
		int slot = day.buscaSlot(3);
		assertTrue(slot == -1);
	}
	
    /*---------------------------------------S5-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/

	// camino de test: 128
	@Test
	void ppcS5_1() throws DatoException {
		Semana s = new Semana(1);
		String res = s.diaSemana(1);
		assertTrue(res == "Lunes");
	}
	
	// camino de test: 138
	@Test
	void ppcS5_2() throws DatoException {
		Semana s = new Semana(2);
		String res = s.diaSemana(2);
		assertTrue(res == "Martes");
	}
	
	// camino de test: 148
	@Test
	void ppcS5_3() throws DatoException {
		Semana s = new Semana(3);
		String res = s.diaSemana(3);
		assertTrue(res == "Miercoles");
	}
	
	// camino de test: 158
	@Test
	void ppcS5_4() throws DatoException {
		Semana s = new Semana(4);
		String res = s.diaSemana(4);
		assertTrue(res == "Jueves");
	}
	
	// camino de test: 168
	@Test
	void ppcS5_5() throws DatoException {
		Semana s = new Semana(5);
		String res = s.diaSemana(5);
		assertTrue(res == "Viernes");
	}
	
	// camino de test: 178
	@Test
	void ppcS5_6() throws DatoException {
		Semana s = new Semana(6);
		String res = s.diaSemana(6);
		assertTrue(res == "No citable");
	}
}
