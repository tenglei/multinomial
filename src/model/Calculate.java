package model;

import java.util.Vector;
import control.Element;

public class Calculate {
    public String multinomal;
    Vector<element> elementgroup = new Vector<element>();
    Calculate(String c, Vector<Element> sign) {
	Standardization stand = new Standardization(c);
	multinomal=stand.Result();
	elementgroup = stand.changeto(multinomal);
	replace(sign);
	merge();
    }
    public Vector<element> Result() {
	return elementgroup;
    }
    public void replace(Vector<Element> sign) {
	// for(int i=0;i<sign.size();i++){ //!simplify 语句传进来的参数出了问题，比如x=2
	// y=1它只传进了y=1
	// System.out.print(sign.get(i).e);
	// System.out.print("=");
	// System.out.print(sign.get(i).value);
	// System.out.print(" ");
	// }
	for (int i = 0; i < sign.size(); i++) {
	    String tmp = sign.get(i).e;
	    for (int j = 0; j < elementgroup.size(); j++) {
		if (elementgroup.get(j).tag3 == true && tmp.equals(elementgroup.get(j).letter)) {
		    elementgroup.get(j).tag3 = false;
		    elementgroup.get(j).letter = " ";
		    elementgroup.get(j).tag1 = true;
		    elementgroup.get(j).num = sign.get(i).value;
		    // System.out.print(elementgroup.get(j).letter);
		}
	    }
	}
    }
    public int firstmerge(int i) {
	// System.out.print(i);
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
	    return tmp + 1;
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
	    // System.out.print(numgroup.get(l));
	    // }
	    // System.out.print("\n");
	    for (int j = numgroup.size() - 1; j > 0; j--) {
		result = calculate(elementgroup.get(numgroup.get(j)).num,
			elementgroup.get(numgroup.get(j) - 1).operator, elementgroup.get(numgroup.get(j - 1)).num);
		elementgroup.removeElementAt(numgroup.get(j));
		// System.out.print(elementgroup.get(j).letter);

		elementgroup.removeElementAt(numgroup.get(j) - 1);
		elementgroup.get(numgroup.get(j - 1)).num = result; // 可能出错

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
	// System.out.print("secondmerge:");
	// m();
	for (int i = 0; i < elementgroup.size() - 1; i++) {
	    if (elementgroup.get(i).tag1 && i == 0
		    && (elementgroup.get(i + 1).operator == '+' || elementgroup.get(i + 1).operator == '-')) {
		numgroup.add(i);
		// System.out.print("head:");
		// System.out.print(i);
	    } else if (elementgroup.get(i).tag1
		    && ((elementgroup.get(i + 1).operator == '+' || elementgroup.get(i + 1).operator == '-')
			    && (elementgroup.get(i - 1).operator == '+' || elementgroup.get(i - 1).operator == '-'))) {
		numgroup.add(i);
		// System.out.print("middle:");
		// System.out.print(i);
	    } else if (i == elementgroup.size() - 2 && elementgroup.get(i + 1).tag1) {

		numgroup.add(i + 1);
		// System.out.print("end:");
		// System.out.print(i+1);
	    }
	}
	// for(int k=0;k<numgroup.size();k++){
	// System.out.print(numgroup.get(k));
	// }
	// System.out.print("\n");
	// m();
	for (int j = numgroup.size() - 1; j > 0; j--) {
	    // System.out.print(elementgroup.get(numgroup.get(j)).num);
	    // System.out.print(elementgroup.get(numgroup.get(j)-1).operator);
	    // System.out.print(elementgroup.get(numgroup.get(j-1)).num);
	    int result = calculate(elementgroup.get(numgroup.get(j)).num,
		    elementgroup.get(numgroup.get(j) - 1).operator, elementgroup.get(numgroup.get(j - 1)).num);
	    // System.out.print("result: ");
	    // System.out.print(result);
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
		firstmerge(i);
	    }
	}
	// System.out.print("\n");
	// System.out.print("first merge:");
	// m();
	// System.out.print("\n");
	secondmerge();

    }
  
    public boolean isDigit(String strNum) {
   	return strNum.matches("[0-9]{1,}");
       }
    public void print(Vector<element>Elementgroup) {
	for (int i = 0; i < Elementgroup.size(); i++) {
	    if (Elementgroup.get(i).tag1 == true) {
		System.out.print(Elementgroup.get(i).num);
	    } else if (Elementgroup.get(i).tag2 == true) {
		System.out.print(Elementgroup.get(i).operator);
	    } else {
		System.out.print(Elementgroup.get(i).letter);
	    }
	}
    }
   
 
}
