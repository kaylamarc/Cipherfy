
public class OneTimePad {

	private char[] key; // key provided by user
	private StringBuffer cipherBin; // Binary representation of ciphertext

	public OneTimePad(String key) {
		this.key = key.toCharArray();
	}

	/**
	 * encrypts cypher text using onetime pad
	 * @param plaintext
	 * @return ciphertext character array
	 */
	public char[] encrypt(String plaintext) {
		
		cipherBin = new StringBuffer();
		
		// convert plaintext to char array 
		char[] plaintextChar = plaintext.toCharArray();

		char[] ciphertext = new char[plaintextChar.length];

		// loop and XOR every bit of plaintext with every bit of key
		for (int i = 0; i < ciphertext.length; i++) {
			ciphertext[i] = (char) (plaintextChar[i] ^ key[i]);
			
			// store binary version of cipher text
			cipherBin.append(" ");
			cipherBin.append(Integer.toBinaryString(ciphertext[i]));
		}

		return ciphertext;
	}

	/**
	 *  decrypts cipher text (in characters)
	 * @param ciphertext char[]
	 * @return plaintext char[]
	 */
	public char[] decryptChar(char[] ciphertext) {
		
		char[] plaintext = new char[ciphertext.length];
		
		// loop and XOR every bit of ciphertext with every bit of key
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (char) (ciphertext[i] ^ key[i]);
		}

		return plaintext;
	}
	
	/**
	 * decrypts binary ciphertext
	 * @param ciphertext (binary)
	 * @return plaintext char[]
	 */
	public char[] decryptBin(String ciphertext) {
		
		String[] ciphertextBin = ciphertext.split(" ");
		
		char[] ciphertextChar = new char[ciphertextBin.length];
		
		// store character version of binary ciphertext
		for (int i = 0; i < ciphertext.length(); i++) {
			ciphertextChar[i] = (char) Integer.parseInt(ciphertextBin[i], 2);
		}
		
		char[] plaintext = new char[ciphertextChar.length];

		// loop and XOR every bit of ciphertext with key
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (char) (ciphertextChar[i] ^ key[i]);
		}

		return plaintext;
	}
}
