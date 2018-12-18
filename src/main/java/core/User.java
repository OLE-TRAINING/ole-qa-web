package core;

import java.util.Random;

public class User {
	private String email;
	private String name;
	private String user;
	private String passWord;
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public String newEmail(int nCaracteres) {
		Random rand = new Random();
		
		char[] letras = "abcdefghijklmnopqrstuvwxy123456789".toCharArray();

		StringBuffer nameBuffer = new StringBuffer();
		
		char[] bruno = "brunoferraresi".toCharArray();
		
		for (int i = 0; i < bruno.length; i++) {
			nameBuffer.append(bruno[i]);
		}
		
		nCaracteres-=(bruno.length+11);
		
		for (int i = 0; i < nCaracteres; i++) {
			int ch = rand.nextInt(letras.length);
			nameBuffer.append(letras[ch]);
		}
		
		nameBuffer.append('@');
		
		for (int i = 0; i < 6; i++) {
			int ch = rand.nextInt(letras.length);
			nameBuffer.append(letras[ch]);
		}
		
		nameBuffer.append('.');
		nameBuffer.append('c');
		nameBuffer.append('o');
		nameBuffer.append('m');

		return nameBuffer.toString();
	}
	
	public String newName(int nCaracteres) {
		Random rand = new Random();
		char[] letras = "abcdefghijklmnopqrstuvwxyABCDEFGHIJKLMNOPQRSTUVXWYZ".toCharArray();
		StringBuffer nameBuffer = new StringBuffer();
		
		for (int i = 0; i < nCaracteres; i++) {
			int ch = rand.nextInt(letras.length);
			nameBuffer.append(letras[ch]);
		}
		
		return nameBuffer.toString();
	}
}