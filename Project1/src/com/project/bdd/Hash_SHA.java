package com.project.bdd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash_SHA {
	
	private String hash;
	
	public Hash_SHA(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convertir le tableau de bits en une format hexadécimal - méthode 2
        StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteData.length;i++) {
		  String hex=Integer.toHexString(0xff & byteData[i]);
		      if(hex.length()==1) hexString.append('0');
		      hexString.append(hex);
		}
		hash = hexString.toString();
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
