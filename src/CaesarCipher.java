public class CaesarCipher {

	private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private int shift;
	
	public CaesarCipher(int shift) {
		this.shift = shift;
	}
	
	public StringBuffer encrypt(String plaintext) {

		plaintext = plaintext.toUpperCase();

		StringBuffer ciphertext = new StringBuffer();

		for (int i = 0; i < plaintext.length(); i++) {
			// get the value (index) of each character in the alphabet
			int alphaVal = alphabet.indexOf(plaintext.charAt(i));

			int enVal = (shift + alphaVal) % 26;

			char ciphVal = alphabet.charAt(enVal);

			// add the value to the cipher text
			ciphertext.append(ciphVal);
		}

		return ciphertext;
	}

	public StringBuffer decrypt(String ciphertext) {
		ciphertext = ciphertext.toUpperCase();

		StringBuffer plaintext = new StringBuffer();

		for (int i = 0; i < ciphertext.length(); i++) {
			int alphaVal = alphabet.indexOf(ciphertext.charAt(i));

			int decrVal = (alphaVal - shift) % 26;

			// check for negative values
			if (decrVal < 0) {
				decrVal += alphabet.length();
			}
			
			char plainVal = alphabet.charAt(decrVal);
			
			plaintext.append(plainVal);
		}
		
		return plaintext;
	}

}
