/*
 * Project: AutoJava2
 * Package: com.jbetterly.lib
 * @author: Joel Betterly
 * Date: 	May 8, 2013
 */
package com.jbetterly.lib;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class WebChecks
{
	static Boolean _conn = false;
	static String _connectionType = "Unavailable";
	
	public static boolean haveNetworkConnection(final Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        final ConnectivityManager cm = (ConnectivityManager) context
                     .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
               final NetworkInfo[] netInfo = cm.getAllNetworkInfo();
               for (final NetworkInfo netInfoCheck : netInfo) {
                     if (netInfoCheck.getTypeName().equalsIgnoreCase("WIFI")) {
                            if (netInfoCheck.isConnected()) {
                                   haveConnectedWifi = true;
                            }
                     }
                     if (netInfoCheck.getTypeName().equalsIgnoreCase("MOBILE")) {
                            if (netInfoCheck.isConnected()) {
                                   haveConnectedMobile = true;
                            }
                     }
               }
        }

        return haveConnectedWifi || haveConnectedMobile;
 }
	
	public static String getURLStringResponse(URL url){
		String response = "";
		try{
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());

			byte[] contentBytes = new byte[1024];
			int bytesRead = 0;
			StringBuffer responseBuffer = new StringBuffer();

			while((bytesRead = bin.read(contentBytes)) != -1){
				response = new String(contentBytes,0,bytesRead);
				responseBuffer.append(response);
			}
			return responseBuffer.toString();		
		} catch(Exception e){
			Log.e("URL RESPONSE ERROR", "GetUtURLStringResponse");
		}
		
		return response;
	}

	
}
