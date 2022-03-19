package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CACC {

    /*---------------------------------------D1-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccD1_1() throws DatoException {/* ERROR1 */
		DatoException expected;
		expected = assertThrows(DatoException.class, () -> new Dia(0));
	}

	@Test
	void caccD1_2() throws DatoException {
		DatoException expected;
		expected = assertThrows(DatoException.class, () -> new Dia(366));
	}

	@Test
	void caccD1_3() throws DatoException {
		Dia dia = new Dia(40);
		assertTrue(dia.getDiaNumero() == 40);
	}
	
    /*---------------------------------------D2-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccD2_1() throws DatoException {
		/* ERROR3 */
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		dia1.asignarCita(14, comida);
		int slot = dia1.buscaSlot(4);
		assertTrue(slot == -1);
	}

	@Test
	void caccD2_2() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(9, peluquero);
		int slot = dia1.buscaSlot(1);
		assertTrue(slot == 10);/* ERROR4 */
	}

	@Test
	void caccD2_3() throws DatoException {
		Dia dia1 = new Dia(1);
		int slot = dia1.buscaSlot(1);
		assertTrue(slot == 9);
	}

	@Test
	void caccD2_4_5() throws DatoException {
		Dia dia1 = new Dia(1);
		int slot = dia1.buscaSlot(2);
		assertTrue(slot == 9);
	}

	@Test
	void caccD2_6() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		int slot = dia1.buscaSlot(4);/* ERROR5 */
		assertTrue(slot == 13);
	}

	@Test
	void caccD2_7() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 7);
		dia1.asignarCita(9, peluquero);
		int slot = dia1.buscaSlot(2);/* ERROR6 *//* ERROR2 */
		assertTrue(slot == 16);
	}
	
    /*---------------------------------------D3-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccD3_1() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);

		boolean asignacion = dia1.asignarCita(19, peluquero);
		assertTrue(!asignacion);
	}

	@Test
	void caccD3_2() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		dia1.asignarCita(14, comida);
		Cita misa = new Cita("misa", 2);
		boolean asignacion = dia1.asignarCita(15, misa);
		assertTrue(!asignacion);
	}

	@Test
	void caccD3_3_4() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		dia1.asignarCita(14, comida);
		Cita misa = new Cita("misa", 1);
		boolean asignacion = dia1.asignarCita(17, misa);
		assertTrue(asignacion);
	}

    /*---------------------------------------D5-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccD5_1() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		String muestra = dia1.muestraCita(19);
		assertEquals(muestra, "Hora no valida");/* ERROR7 */
	}

	@Test
	void caccD5_2() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		String muestra = dia1.muestraCita(12);
		assertEquals(muestra, "12:00 peluquero");/* ERROR8 *//* ERROR9 */
	}

	@Test
	void caccD5_3() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		String muestra = dia1.muestraCita(14);
		assertEquals(muestra, "No existe");
	}

    /*---------------------------------------D7-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccD7_1() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		assertFalse(dia1.huecoLibre(19, 2));
	}

	@Test
	void caccD7_2() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(12, peluquero);
		assertFalse(dia1.huecoLibre(12, 2));
	}

	@Test
	void caccD7_3() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(9, peluquero);
		assertTrue(dia1.huecoLibre(12, 3));
	}

	@Test
	void caccD7_4() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(13, peluquero);
		assertFalse(dia1.huecoLibre(12, 3));/* ERROR10 */
	}

	@Test
	void caccD7_5() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(13, peluquero);
		assertTrue(dia1.huecoLibre(14, 2));
	}

	@Test
	void caccD7_6() throws DatoException {
		Dia dia1 = new Dia(1);
		Cita peluquero = new Cita("peluquero", 1);
		dia1.asignarCita(13, peluquero);
		assertFalse(dia1.huecoLibre(16, 3));/* ERROR11 *//* ERROR12 */
	}
	
    /*---------------------------------------S1-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccS1_1() throws DatoException {
		DatoException expected;
		expected = assertThrows(DatoException.class, () -> new Semana(0));
	}

	@Test
	void caccS1_2() throws DatoException {
		DatoException expected;
		expected = assertThrows(DatoException.class, () -> new Semana(54));
	}

	@Test
	void caccS1_3() throws DatoException {
		Semana semana2 = new Semana(2);
		assertTrue(semana2.getNumeroSemana() == 2);
		assertTrue(semana2.getDia(1).getDiaNumero() == 4);/* ERROR 13 *//* ERROR 14 *//* ERROR 15 *//* ERROR 16 */
		assertTrue(semana2.getDia(2).getDiaNumero() == 5);
		assertTrue(semana2.getDia(3).getDiaNumero() == 6);
		assertTrue(semana2.getDia(4).getDiaNumero() == 7);
		assertTrue(semana2.getDia(5).getDiaNumero() == 8);
	}
	
	// void S14() throws DatoException {} imposible diaDelAnio > 365 porque el dia 5
	// de la ultima semana acaba en 365
	
	@Test
	void caccS1_5() throws DatoException {
		Semana semana1 = new Semana(1);
		assertTrue(semana1.getNumeroSemana() == 1);
		assertTrue(semana1.getDia(1) == null);
		assertTrue(semana1.getDia(2) == null);
		assertTrue(semana1.getDia(3) == null);
		assertTrue(semana1.getDia(4) == null);
		assertTrue(semana1.getDia(5).getDiaNumero() == 1);
	}

    /*---------------------------------------S4-----------------------------------------------------
    -------------------------------------------------------------------------------------------------*/
	@Test
	void caccS4_1() throws DatoException {
		Semana semana1 = new Semana(1);
		Cita superm = new Cita("superm", 1);
		semana1.getDia(5).asignarCita(12, superm);
		Cita cena = new Cita("cena", 3);
		semana1.getDia(5).asignarCita(14, cena);
		assertEquals(semana1.primerHueco(4), "No hay disponibilidad");
	}

	@Test
	void caccS4_2() throws DatoException {
		Semana semana1 = new Semana(1);
		Cita superm = new Cita("superm", 1);
		semana1.getDia(5).asignarCita(12, superm);
		Cita cena = new Cita("cena", 3);
		semana1.getDia(5).asignarCita(14, cena);
		assertEquals(semana1.primerHueco(3), "Viernes 9:00");/* ERROR 17 */
	}

	@Test
	void caccS4_3() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.primerHueco(3), "Lunes 9:00");/* ERROR 18 */
	}

	@Test
	void caccS4_4() throws DatoException {
		Semana semana2 = new Semana(2);
		Cita peluquero = new Cita("peluquero", 1);
		semana2.getDia(1).asignarCita(12, peluquero);
		Cita comida = new Cita("comida", 3);
		semana2.getDia(1).asignarCita(14, comida);
		assertEquals(semana2.primerHueco(4), "Martes 9:00");/* ERROR 18 */
	}
}
