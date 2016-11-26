package model;

import java.util.Vector;

public class Standardization {
    public String result;
    Vector<element> elementgroup = new Vector<element>();
    Standardization(String s) {
	String Temp = " ";
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '^') {
		int exponent = s.charAt(i + 1) - 48;
		while (exponent != 1) {
		    Temp += '*';
		    Temp += s.charAt(i - 1);
		    exponent--;
		}
		while (i != s.length() && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*'
			&& s.charAt(i) != '/') {
		    i++;
		}
		i--;
	    } else {
		Temp += s.charAt(i);
	    }

	}
	// System.out.print("Temp=");
	// System.out.print(Temp);
	this.result = Temp;
    }

    public String Result() {
	return this.result;
    }

    public Vector<element> changeto(String s) {
	s = s.trim();
	// System.out.print("\n String in: \n");
	// System.out.print(s);
	// System.out.print("elementgroup:");
	for (int i = 0; i < s.length(); i++) {
	    if (isdigital(s.charAt(i))) {
		// System.out.print("In digital");
		int tmp = i;
		int bit = 0;
		int num = 0;
		while (tmp != s.length() && isdigital(s.charAt(tmp))) {
		    bit++;
		    tmp++;
		}
		int step = bit;
		tmp = i;
		while (bit != 0) {
		    num += Math.pow(10, bit - 1) * (s.charAt(tmp) - 48);
		    tmp++;
		    bit--;
		}

		i += step - 1;
		element numberelement = new element(num);
		elementgroup.add(numberelement);
		// System.out.print("add num: ");
		// System.out.print(num);
		// System.out.print("\n");
	    } else if (isoperator(s.charAt(i))) {
		element operator = new element(s.charAt(i));
		elementgroup.add(operator);
		// System.out.print("add operator: ");
		// System.out.print(operator.operator);
		// System.out.print("\n");
	    } else {
		String tmp = " ";
		while (i != s.length() && isinletter(s.charAt(i))) {
		    tmp += s.charAt(i);
		    i++;
		}
		i--;
		// System.out.print("before trim: ");
		// System.out.print(tmp);
		tmp = tmp.trim();
		// System.out.print("after trim: ");
		// System.out.print(tmp);
		// String tmp = String.valueOf(s.charAt(i));
		element letter = new element(tmp);
		elementgroup.add(letter);
	    }
	}
	// System.out.print("printf:elementgroup");
	// Test();
	return elementgroup;
    }

    public boolean isinletter(char s) {
	if (s != '+' && s != '-' && s != '*' && s != '/') {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean isDigit(String strNum) {
	return strNum.matches("[0-9]{1,}");
    }

    public boolean isdigital(char s) {
	if (s >= '0' && s <= '9') {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean isoperator(char s) {
	if (s == '+' || s == '*' || s == '-' || s == '/') {
	    return true;
	} else {
	    return false;
	}

    }
}
