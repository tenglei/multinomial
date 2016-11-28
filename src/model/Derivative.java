package model;

import java.util.Vector;

import control.Element;

public class Derivative {
    public String multinomal;
    public String derivativeResult;
    Vector<element> elementgroup = new Vector<element>();
    public Derivative(String c,String s){
	Standardization stand = new Standardization(c);
	multinomal=stand.Result();
	elementgroup = stand.changeto(multinomal);
	merge();
	derivativeResult=derivative(s);
    } 
    public String derivative(String s) {
	boolean illegal = false;
	merge();
	String derivatives = " ";
	// System.out.print("the letter send in: ");
	// System.out.print(s);
	// System.out.print("\n");
	// Test();
	if (s == "+" || s == "-" || s == "*") {
	    return "inputError";
	}
	if (s.length() == 1 && isdigital(s.charAt(0))) {
	    return "inputError";
	} else if (elementgroup.size() == 1 && isDigit(elementgroup.get(0).num.toString())) {
	    return "0";
	}
	// Vector <Integer> globalderivatives = new Vector <Integer>();
	for (int i = 1; i < elementgroup.size(); i++) {
	    if (elementgroup.get(i).tag3 == true && s.equals(elementgroup.get(i).letter)) {
		illegal = true;
		// System.out.print(elementgroup.get(i).letter);
		// System.out.print("inside jude");
		Integer number = 0;
		int tmp = i;
		int head, tail;
		while (tmp != elementgroup.size()
			&& (elementgroup.get(tmp).operator != '+' && elementgroup.get(tmp).operator != '-')) {
		    if (elementgroup.get(tmp).tag3 == true && s.equals(elementgroup.get(tmp).letter)) {
			// System.out.print("tmp ");
			// System.out.print(tmp);
			// System.out.print(elementgroup.get(tmp).letter);
			// System.out.print(s);

			number += 1;
		    }
		    tmp++;
		}
		tail = tmp - 1;
		// System.out.print("Number: ");
		// System.out.print(number);
		tmp = i;
		while (tmp != -1 && elementgroup.get(tmp).operator != '+' && elementgroup.get(tmp).operator != '-') {
		    tmp--;
		}
		head = tmp + 1;
		// System.out.print("head: ");
		// System.out.print(head);
		Vector<Integer> num = new Vector<Integer>();
		Vector<String> letter = new Vector<String>();
		while (head != elementgroup.size() && elementgroup.get(head).operator != '+'
			&& elementgroup.get(head).operator != '-') {
		    if (elementgroup.get(head).tag1) {
			num.add(head);
			// System.out.print(head);
		    }
		    if (elementgroup.get(head).tag3 && !s.equals(elementgroup.get(head).letter)) {
			letter.add(elementgroup.get(head).letter);
			// System.out.print(letter.lastElement());
		    }
		    head++;
		}
		Integer coefficent = 0;
		coefficent = elementgroup.get(num.firstElement()).num;
		if (num.firstElement() - 1 >= 0 && elementgroup.get(num.firstElement() - 1).operator == '-') {
		    coefficent = -coefficent;
		}
		coefficent *= number;
		derivatives += coefficent.toString(); // 可能出现ascar码错误
		// System.out.print("coefficent: ");
		// System.out.print(coefficent);
		number -= 1;
		if (!letter.isEmpty()) {
		    for (int j = 0; j < letter.size(); j++) {
			derivatives += "*";
			derivatives += letter.get(j);
		    }
		}
		while (number != 0) {
		    derivatives += "*";
		    derivatives += s;
		    number--;
		}
		// System.out.print("head:");
		// System.out.print(head);
		if (head != elementgroup.size()) {
		    if (head == elementgroup.size() - 2 && elementgroup.lastElement().tag1 == true) {

		    } else {
			derivatives += elementgroup.get(head).operator;
			i = head;
		    }

		}

		// for(tmp=num.size()-1;tmp>0;tmp--){
		// coefficent+=
		// calculate(elementgroup.get(num.get(tmp)).num,elementgroup.get(num.get(tmp)-1).operator,elementgroup.get(num.get(tmp-1)).num);
		// }
		// coefficent *=number-1;
		// i = head-1;

		//
		i = tail;
	    }
	}
	if (!illegal) {
	    return "inputError";
	}
	derivatives = derivatives.trim();

	if (derivatives.charAt(derivatives.length() - 1) == '+'
		|| derivatives.charAt(derivatives.length() - 1) == '-') {
	    // System.out.print(derivatives);
	    derivatives = derivatives.substring(0, derivatives.length() - 1);
	    // System.out.print("Inside if");
	}
//	System.out.print(derivatives);
//	System.out.print("\n");
	return derivatives;
    }
    public String Result() {
	return derivativeResult;
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
