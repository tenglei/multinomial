package model;

import control.Element;
import control.view;
import java.util.Vector;
public class model {
 view in = new view();
 public Vector <Element> ele= new Vector <Element>();
 public String in(String str){
	 String w=in.inp(str);
	 return w;
 }
 public int sim(String str_in){
	 ele = in.ele;
	 return in.simplify(str_in);
 }
 public String der(String str_in){
	 return in.derivative(str_in);
 }

 
}
