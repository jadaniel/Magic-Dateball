package pennapps11.server;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class GeoLocationTest {

	@Test
	public void testGeoLocator() throws IOException {
		GeoLocation gc = new GeoLocation("19146");
		gc.connect();
		
		assertTrue(gc.latitude.equals("39.938512"));
		assertTrue(gc.longitude.equals("-75.18067"));
	}
	


}
