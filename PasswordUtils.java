/*
 * @Author: Jaume Florit
 * Free use
 * Simple password utils with generate random password and encode/decode
 */

package mySecure;

import java.util.Base64;
import java.util.Random;

public class PasswordUtils {
	private String password = new String();

	public PasswordUtils() {
		if (password.length() == 0) {
			this.password = generatePassword(15);
			System.out.println(this.password);
		}
	}

	public PasswordUtils(String password) {
		this.password = password;
	}

	//Generate a random & Strong password
	private String generatePassword(int length) {
		//Generate a random password with specific length.
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();
		char[] password = new char[length];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		for (int i = 4; i < length; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		this.password = new String(password);
		System.out.println(this.password);
		
		return encryptPassword();
	}
	
	//Encode method using Base64
	private String encryptPassword() {
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encoded = encoder.encode(this.password.getBytes());
		return new String(encoded);
	}
	
	//Decode method using Base64
	private String decode() {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decoded = decoder.decode(this.password);
		return new String(decoded);
	}
	
	public static void main(String[] args) {
		PasswordUtils new_pas = new PasswordUtils();
		System.out.println(new_pas.decode());
		
	}
	
}
