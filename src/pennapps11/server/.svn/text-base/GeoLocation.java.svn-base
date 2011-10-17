package pennapps11.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Big Jim
 *	Used to get the lat/long coordinates for a zip code
 */
public class GeoLocation {
	String zip_code, latitude, longitude;

	/**
	 * @param zip is the zipcode you want the lat/long for
	 */
	public GeoLocation(String zip) {
		zip_code = zip;
		try {
			connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return latitude 
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @return longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	public void connect() throws IOException {
		URL myZip = new URL("http://rpc.geocoder.us/service/csv?zip=" + this.zip_code);

		URLConnection mz = myZip.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(mz.getInputStream()));
		String latLong = in.readLine();

		
		String[] numbers = latLong.split(", ");
		latitude = numbers[0];
		longitude = numbers[1];
		in.close();
	}

	

}

