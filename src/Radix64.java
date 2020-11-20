// Personal Implementation of Radix64/Base64 encoding 

public class Radix64 {
	
	private String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	private char pad = '+';
	
	public Radix64() {
		
	}
	
	public String encode(String plaintext) {
		
		StringBuffer hexStr = new StringBuffer();
		
		// convert string to hex
		for (int i = 0; i < plaintext.length(); i++) {
			hexStr.append(Integer.toHexString(plaintext.charAt(i)).toUpperCase());
		}
		
		StringBuffer binStr = new StringBuffer();
		
		// convert string to binary
		for (int i = 0; i < hexStr.length(); i++) {
			binStr.append(hexToBin(hexStr.charAt(i)));
		}
		
		// calculate padding
		int numBits = binStr.length();
		int bitsToAdd = 6 - (numBits % 6);
		
		// pad 0 bits
		for (int i = 0; i < bitsToAdd; i++) {
			binStr.append('0');
		}
		
		int count = 0;	// check 6 bits
		String converter = "";
		StringBuffer ciphertext = new StringBuffer();
		
		// split by 6 bits
		for (int i = 0; i < binStr.length(); i++) {
			if (count < 6) {
				converter += binStr.charAt(i);
				count++;
			}
			else {
				// convert to answer
				ciphertext.append(charSet.charAt(Integer.parseInt(converter, 2)));
				count = 0;
				converter = "";
				i--;
			}
		}
		// convert to answer
		ciphertext.append(charSet.charAt(Integer.parseInt(converter, 2)));
		count = 0;
		converter = "";
		
		int numPads = 4 - (ciphertext.length() % 4);
		
		// add padding
		for (int i = 0; i < numPads; i++) {
			ciphertext.append(pad);
		}
		
		return ciphertext.toString();
	}
	
	// convert hex character to a binary string
	public String hexToBin(char c) {
		switch(c) {
		case '0':
			return "0000";
		case '1':
			return "0001";
		case '2':
			return "0010";
		case '3':
			return "0011";
		case '4':
			return "0100";
		case '5':
			return "0101";
		case '6':
			return "0110";
		case '7':
			return "0111";
		case '8':
			return "1000";
		case '9':
			return "1001";
		case 'A':
			return "1010";
		case 'B':
			return "1011";
		case 'C':
			return "1100";
		case 'D':
			return "1101";
		case 'E':
			return "1110";
		case 'F':
			return "1111";
		default:
			return "";
		}
	}
}
