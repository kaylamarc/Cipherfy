import java.util.Scanner;

public class Cipherfy {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String plaintext = input.nextLine();
		int shift = input.nextInt();
		
		CaesarCipher caesar = new CaesarCipher(shift);
		
		String ciphertext = (caesar.encrypt(plaintext)).toString(); 
		
		System.out.println(ciphertext);
		System.out.println(caesar.decrypt(ciphertext));
		
	}

}
