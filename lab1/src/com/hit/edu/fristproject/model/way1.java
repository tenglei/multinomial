package com.hit.edu.fristproject.model;

import java.util.Vector;
import com.hit.edu.firstproject.view.Element;
//import com.hit.edu.firstproject.view.view;

public class way1 {
	public String test;
	Vector<element> elementgroup = new Vector<element>();

	// Vector<Element> sign = new Vector<Element>();
	public way1(String c) {
		test = c;
	}

	public int firstmerge(int i) {
		int numnumber = 0;
		int tmp = i;
		int head, tail;
		head = i - 1;
		i--;
		while (i != elementgroup.size() && elementgroup.get(i).operator != '+' && elementgroup.get(i).operator != '-') {
			if (elementgroup.get(i).tag1) {
				numnumber += 1;
			}
			// System.out.print(elementgroup.get(i).operator);
			i++;
		}
		tail = i - 1;
		if (numnumber == 1 || numnumber == 0) {
			return tmp + 2;
		} else {
			Vector<Integer> numgroup = new Vector<Integer>();
			i = head;
			while (i != elementgroup.size() && elementgroup.get(i).operator != '+'
					&& elementgroup.get(i).operator != '-') {
				if (elementgroup.get(i).tag1) {
					numgroup.add(i);
				}
				i++;
			}
			int result;
			// for(int l=0;l<numgroup.size();l++){
			/// System.out.print(numgroup.get(l));
			// }
			for (int j = numgroup.size() - 1; j > 0; j--) {
				result = calculate(elementgroup.get(numgroup.get(j)).num,
						elementgroup.get(numgroup.get(j) - 1).operator, elementgroup.get(numgroup.get(j - 1)).num);
				elementgroup.removeElementAt(numgroup.get(j));
				// System.out.print(elementgroup.get(j).letter);

				elementgroup.removeElementAt(numgroup.get(j) - 1);
				elementgroup.get(numgroup.get(j - 1)).num = result; // ¿ÉÄÜ³ö´í

			}
			return tail;
		}
	}

	public int calculate(int a, char operate, int b) {
		if (operate == '*') {
			// System.out.print(a*b);
			return a * b;
		} else if (operate == '/') {
			return a / b;
		} else if (operate == '+') {
			return a + b;
		} else {
			return a - b; // possible error!!!
		}
	}

	public void secondmerge() {
		Vector<Integer> numgroup = new Vector<Integer>();
		for (int i = 0; i < elementgroup.size() - 1; i++) {
			if (elementgroup.get(i).tag1
					&& (elementgroup.get(i + 1).operator == '+' || elementgroup.get(i + 1).operator == '-')) {
				numgroup.add(i);
			}
			if (i == elementgroup.size() - 2 && elementgroup.get(i + 1).tag1) {

				numgroup.add(i + 1);
			}
		}
		// for(int k=0;k<numgroup.size();k++){
		// System.out.print(numgroup.get(k));
		// }
		// System.out.print(" ");
		for (int j = numgroup.size() - 1; j > 0; j--) {
			int result = calculate(elementgroup.get(numgroup.get(j)).num,
					elementgroup.get(numgroup.get(j) - 1).operator, elementgroup.get(numgroup.get(j - 1)).num);
			elementgroup.removeElementAt(numgroup.get(j));
			elementgroup.removeElementAt(numgroup.get(j) - 1);
			elementgroup.get(numgroup.get(j - 1)).num = result;
		}

	}

	public void merge() {
		for (int i = 0; i < elementgroup.size(); i++) {
			if (elementgroup.get(i).tag2 == true
					&& (elementgroup.get(i).operator == '*' || elementgroup.get(i).operator == '/')) {
				// System.out.print(i);
				i = firstmerge(i);
			}
		}
		secondmerge();

	}

	// public void initreplace(){
	// Element a = new Element();
	// a.letter = "x";
	// a.value = 2;
	// sign.add(a);
	// }
	public void replace(Vector<Element> sign) {
		for (int i = 0; i < sign.size(); i++) {
			String tmp = sign.get(i).e;
			for (int j = 0; j < elementgroup.size(); j++) {
				if (elementgroup.get(j).tag3 == true && tmp.endsWith(elementgroup.get(j).letter)) {
					elementgroup.get(j).tag3 = false;
					elementgroup.get(j).tag1 = true;
					elementgroup.get(j).num = sign.get(i).value;
				}
			}
		}
	}

	public void changeto(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (isdigital(s.charAt(i))) {
				int tmp = i;
				int bit = 0;
				int num = 0;
				while (s.length() > tmp && isdigital(s.charAt(tmp))) {
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
			} else if (isoperator(s.charAt(i))) {
				element operator = new element(s.charAt(i));
				elementgroup.add(operator);
			} else {
				String tmp = String.valueOf(s.charAt(i));
				element letter = new element(tmp);

				elementgroup.add(letter);
			}
		}
	}

	public void m() {
		for (int i = 0; i < elementgroup.size(); i++) {
			if (elementgroup.get(i).tag1 == true) {
				System.out.print(elementgroup.get(i).num);
			} else if (elementgroup.get(i).tag2 == true) {
				System.out.print(elementgroup.get(i).operator);
			} else {
				System.out.print(elementgroup.get(i).letter);
			}
		}
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
