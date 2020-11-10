import java.util.Random;
import java.util.Scanner;

public class Cipherfy {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Random r = new Random();
		
		String plaintext = input.nextLine();
		String key = input.nextLine();
		
		OneTimePad otp = new OneTimePad(key);
		
		char[] ciphertext = otp.encrypt(plaintext);
		
		for (int i = 0; i < ciphertext.length; i++) {
			System.out.print((int)ciphertext[i] + " ");
		}
		System.out.println("\n");
		
		System.out.println(otp.decryptChar(ciphertext));
		
		
		
	}

}
