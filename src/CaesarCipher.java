public class CaesarCipher {

	/**
	 * alphabet to use for indexing
	 */
	private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private int shift; // shift value
	
	public CaesarCipher(int shift) {
		this.shift = shift;
	}
	
	/**
	 * encrypts plaintext
	 * @param plaintext
	 * @return
	 */
	public StringBuffer encrypt(String plaintext) {
		
		// ensure uniform ASCII values
		plaintext = plaintext.toUpperCase();

		StringBuffer ciphertext = new StringBuffer();

		// go through each index of plaintext and shift
		for (int i = 0; i < plaintext.length(); i++) {
			// get the value (index) of each character in the alphabet
			int alphaVal = alphabet.indexOf(plaintext.charAt(i));

			int enVal = (shift + alphaVal) % 26;
			
			// get shifted & encrypted character 
			char ciphVal = alphabet.charAt(enVal);

			// add the value to the cipher text
			ciphertext.append(ciphVal);
		}

		return ciphertext;
	}

	/**
	 * decrypts ciphertext
	 * @param ciphertext
	 * @return
	 */
	public StringBuffer decrypt(String ciphertext) {
		
		// ensure uniform ASCII values
		ciphertext = ciphertext.toUpperCase();

		StringBuffer plaintext = new StringBuffer();

		// go through each index of ciphertext and shift
		for (int i = 0; i < ciphertext.length(); i++) {
			int alphaVal = alphabet.indexOf(ciphertext.charAt(i));

			int decrVal = (alphaVal - shift) % 26;

			// check for negative values
			if (decrVal < 0) {
				decrVal += alphabet.length();
			}
			
			// get decrypted character
			char plainVal = alphabet.charAt(decrVal);
			
			plaintext.append(plainVal);
		}
		
		return plaintext;
	}

}
