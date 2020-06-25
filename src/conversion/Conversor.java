package conversion;

public class Conversor {
	private String roman;
	private int number;
	
	public String getRoman() {
		return roman;
	}

	public void setRoman(String roman) {
		this.roman = roman;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int RomanNumber() throws InvalidNumberException {
		int sum = 0;
		int iRepeating = 0;
		int vRepeating = 0;
		int xRepeating = 0;
		int lRepeating = 0;
		int cRepeating = 0;
		int dRepeating = 0;
		int mRepeating = 0;
		for(int i = 0; i < roman.length(); i++) {
			char letter = roman.charAt(i);
			if (letter == 'I') {
				sum += 1;
				iRepeating++;
			}
			if (letter == 'V') {
				sum += 5;
				vRepeating++;
			}
			if (letter == 'X') {
				sum += 10;
				xRepeating++;
			}
			if (letter == 'L') {
				sum += 50;
				lRepeating++;
			}
			if (letter == 'C') {
				sum += 100;
				cRepeating++;
			}
			if (letter == 'D') {
				sum += 500;
				dRepeating++;
			}
			if (letter == 'M') {
				sum += 1000;
				mRepeating++;
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'I' && letterAfter == 'V') {
					sum -= 2;
				}
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'I' && letterAfter == 'X') {
					sum -= 2;
				}
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'X' && letterAfter == 'L') {
					sum -= 20;
				}
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'X' && letterAfter == 'C') {
					sum -= 20;
				}
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'C' && letterAfter == 'D') {
					sum -= 200;
				}
			}
			if (roman.length() > 1 && i < (roman.length() - 1)) {
				char letterAfter = roman.charAt(i+1);
				if (letter == 'C' && letterAfter == 'M') {
					sum -= 200;
				}
			}
			if (iRepeating == 4 || vRepeating == 2 || xRepeating == 4 || lRepeating == 2 || cRepeating == 4 || dRepeating == 2 || mRepeating == 4) {
				throw new InvalidNumberException();
			}
		}
		return sum;
	}
	
	public String NumberRoman() throws InvalidNumberException {
		String result = "";
		if (number > 3999) {
			throw new InvalidNumberException();
		}
		if (number % 10 > 0) {
			if ((number % 10) < 4 || (number % 10) > 5 && (number % 10 < 9)) {
				for (int i = 0; i < (number % 5); i++) {
					result = "I" + result;
				}
			}
			if (number % 10 == 4) {
				result = "IV";
			}
			if (number % 10 >= 5 && number % 10 <= 8) {
				result = "V" + result;
			}
			if (number % 10 == 9) {
				result = "IX";
			}
		}
		if ((number % 100) >= 10) {
			if ((number % 100) < 40 || (number % 100) > 59 && (number % 100) < 90) {
				for (int i = 0; i < (((number / 10) % 5)); i++) {
					result = "X" + result;
				}
			}
			if (number % 100 >= 40 && number % 100 <= 49) {
				result = "XL" + result;
			}
			if (number % 100 >= 50 && number % 100 <= 89) {
				result = "L" + result;
			}
			if (number % 100 >= 90 && number % 100 <= 99) {
				result = "XC" + result;
			}
			
		}
		if ((number % 1000) >= 100) {
			if ((number % 1000) < 400 || (number % 100) > 599 && (number % 100) < 900) {
				for (int i = 0; i < ((number / 100) % 10); i++) {
					result = "C" + result;
				}
			}
			if (number % 1000 >= 400 && number % 1000 <= 499) {
				result = "CD" + result;
			}
			if (number % 1000 >= 500 && number % 1000 <= 899) {
				result = "D" + result;
			}
			if (number % 1000 >= 900 && number % 1000 <= 999) {
				result = "CM" + result;
			}
		}
		if ((number % 4000) >= 1000) {
			for (int i = 0; i < ((number / 1000) % 100); i++) {
				result = "M" + result;
			}
		}
		return result;
	}
}