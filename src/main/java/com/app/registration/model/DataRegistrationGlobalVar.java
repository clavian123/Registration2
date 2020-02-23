package com.app.registration.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;

public class DataRegistrationGlobalVar {	
	public static Blob dataRegis;
	
	public static String blobToString(){
		String str = "";
		try {
			str = new String(dataRegis.getBytes(1l, (int) dataRegis.length()));
		}catch(Exception e){
			
		}
		return str;
	}

}
