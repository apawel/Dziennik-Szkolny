
/*
 * curl -X POST \
  -H "X-Parse-Application-Id: 0OzZHchfwt0mPcV5S9W2SeDk7GvI5Hcar717dcme" \
  -H "X-Parse-REST-API-Key: HoaMIxhUfU6qtEaFSPAVNSWaKXJISqOiufRKvYL9" \
  -H "Content-Type: application/json" \
  -d '{
        "channels": [
          "Giants",
          "Mets"
        ],
        "data": {
          "alert": "The Giants won against the Mets 2-3."
        }
      }' \
  https://api.parse.com/1/push
  */
package controller;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * UZC WRRAPER EXAMPLE W POBRANYCH !!!!!!!!!!
 * @author Pawel
 *
 */
public class Push {
	public static void main(String[] args) {
		String APP_ID = "0OzZHchfwt0mPcV5S9W2SeDk7GvI5Hcar717dcme";
		String REST_API_KEY = "HoaMIxhUfU6qtEaFSPAVNSWaKXJISqOiufRKvYL9";

		String header = "-H \"X-Parse-Application-Id: " + APP_ID
		    + "\" -H \"X-Parse-REST-API-Key: " + REST_API_KEY
		    + "\" -H \"Content-Type: application/json\" ";

		

		String outputString;
		
	
		
		
	

		String command = "curl -X POST \\" + header + "-d {"+ "channels" +": ["+   ""+','+    "Mets"+"    ], "+"data"+": {"+     "alert"+':'+ "The Giants won against the Mets 2-3." + '}'+"}' \\ https://api.parse.com/1/push";
	

		System.out.println(command);

		Process curlProc;
		try {
		    curlProc = Runtime.getRuntime().exec("command");

		    DataInputStream curlIn = new DataInputStream(
		            curlProc.getInputStream());

		    while ((outputString = curlIn.readLine()) != null) {
		        System.out.println(outputString);
		    }

		} catch (IOException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
	}

}
