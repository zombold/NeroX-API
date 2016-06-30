package de.zombold.api.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import sun.net.www.URLConnection;

public class UUIDManager {
	
public static String getUpdate(String playerName) {
		
		String[] args;
		
		String UUID = null;
		try {
			
		    // Send data
		    URL url = new URL("https://api.mojang.com/users/profiles/minecraft/"+playerName);
		    URLConnection conn = (URLConnection) url.openConnection();
		    
		    // Get the response
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		    // MAIN
		    String line;
			try {
				while ((line = rd.readLine()) != null) {
					if (UUID != null) {
						return null;
					}
					args = line.split("\"");
					UUID = args[3].toString();
					
				}
			} catch (Exception e) {
				System.out.println("ERROR reading UUID");
			}
		    
		    rd.close();
		    
		} catch (Exception e) {
			System.out.println("ERROR connecting to UUID server");
			//e.printStackTrace();
			return null;
		}
		if (UUID.trim().equals("")) {
			return null;
		}
		return UUID;
	}
	
	
}
