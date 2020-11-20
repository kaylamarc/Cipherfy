import java.util.Scanner;
import java.util.Base64;

public class Cipherfy {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String plaintext = input.nextLine();
		
		Radix64 rad64 = new Radix64();
		
		System.out.println(rad64.encode(plaintext));
		
	}

}
