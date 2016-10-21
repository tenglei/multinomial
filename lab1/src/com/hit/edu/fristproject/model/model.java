package com.hit.edu.fristproject.model;

import com.hit.edu.firstproject.view.Element;
import com.hit.edu.firstproject.view.view;
import java.util.Vector;

public class model {
	view in = new view();
	public Vector<Element> ele = new Vector<Element>();

	public String in() {
		String w = in.inp();
		return w;
	}

	public void sim(String str_in) {
		in.simplify(str_in);
		ele = in.ele;
	}

	public void der(String str_in) {
		in.derivative(str_in);
	}

	String str = "12+3";

}
