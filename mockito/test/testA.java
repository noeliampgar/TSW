package A;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class testA {

	@Test
	void test() {
		MailServer server = mock(MailServer.class);
		TemplateEngine engine = mock(TemplateEngine.class);
				
		Cliente cliente = mock(Cliente.class);
		Template template = mock(Template.class);
		
		Mensaje mensaje = new Mensaje(server, engine);
		
		when(cliente.getEmail()).thenReturn("cliente@email");
		when(engine.preparaMensaje(template, cliente)).thenReturn("resultadoTemplateEngine");
		
		mensaje.sendMensaje(cliente, template);
		verify(server).send(cliente.getEmail(), "resultadoTemplateEngine");
	}

}
