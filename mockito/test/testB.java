package B;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class testB {

	@Test
	void testEmail() {
		Cliente cliente = new Cliente("clientemail", true); // formato email
		Factura dummieFactura = mock(Factura.class);
		
		PrinterService printer = mock(PrinterService.class);
		EmailService email = mock(EmailService.class);
		
		EmisorFactura emisor = new EmisorFactura(printer, email);

		emisor.emitirFactura(dummieFactura, cliente);
		verify(email,atLeastOnce()).sendFactura(dummieFactura, cliente.getEmail());
		verify(printer,never()).printFactura(dummieFactura);
	}
	
	@Test
	void testPaper() {
		Cliente cliente = new Cliente("clientemail", false); // formato papel
		Factura dummieFactura = mock(Factura.class);
		
		PrinterService printer = mock(PrinterService.class);
		EmailService email = mock(EmailService.class);
		
		EmisorFactura emisor = new EmisorFactura(printer, email);

		emisor.emitirFactura(dummieFactura, cliente);
		verify(email,never()).sendFactura(dummieFactura, cliente.getEmail());
		verify(printer,atLeastOnce()).printFactura(dummieFactura);
	}

}
