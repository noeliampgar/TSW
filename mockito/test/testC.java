
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import C.Logger;
import C.Result;
import C.Server;
import C.Web;
import C.WebVerificator;

class testC {

	@Test
	void testOk() {
		Server server = mock(Server.class);
		Logger logger = mock(Logger.class);
		Web web = mock(Web.class);
		Result result = mock(Result.class);
		
		WebVerificator ver = new WebVerificator(logger);
		
		when(result.isOk()).thenReturn(true); // bien
		when(server.connect(web)).thenReturn(result);
		
		ver.checkWeb(server, web);
		 
		verify(logger,atLeastOnce()).registerWebisOk(web);
		verify(logger,never()).registerWebReturnedError(web,result);
	}
	
	@Test
	void testError() {
		Server server = mock(Server.class);
		Logger logger = mock(Logger.class);
		Web web = mock(Web.class);
		Result result = mock(Result.class);
		
		WebVerificator ver = new WebVerificator(logger);
		
		when(result.isOk()).thenReturn(false); // mal
		when(server.connect(web)).thenReturn(result);
		
		ver.checkWeb(server, web);
		 
		verify(logger,never()).registerWebisOk(web);
		verify(logger,atLeastOnce()).registerWebReturnedError(web,result);
	}

}
