package lab1_code;

import java.util.Scanner;

import com.hit.edu.fristproject.model.model;
import com.hit.edu.fristproject.model.way1;

public class function {

	public static void main(String[] args) {
		String str_new = " ";
		int i = 0;
		way1 w = new way1(str_new);
		do {
			System.out.print("请选择功能：\n");
			System.out.print("1.输入表达式\n");
			System.out.print("2.表达式的化简与求值\n");
			System.out.print("3.表达式求导\n");
			System.out.print("-1.退出\n");
			System.out.print("请输入序号\n");
			Scanner s = new Scanner(System.in);
			i = s.nextInt();
			if (i != 1 && i != 2 && i != 3 && i != -1)
				System.out.print("输入有误，请重新输入\n");
			switch (i) {
			case 1:
				System.out.print("请按规则输入表达式：\n");
				System.out.print("支持+、-、*、^，支持多字母变量，乘号不可省\n");
				do {
					model i_n = new model();
					str_new = i_n.in();
					if (str_new == " ") {
						System.out.print("表达式不符合规范，请重新输入表达式：\n");
					}
				} while (str_new == " ");
				// System.out.print("Begin to in:");
				// System.out.print(str_new);
				w.test = str_new;
				w.changeto(str_new);
				w.merge();
				w.m();
				break;
			case 2:
				if (str_new == " ") {
					System.out.print("请输入表达式：\n");
					do {
						model i_n = new model();
						str_new = i_n.in();
						if (str_new == " ") {
							System.out.print("空串");
							System.out.print("表达式不符合规范，请重新输入表达式：\n");
						}
					} while (str_new == " ");
				} else {

					System.out.println("当前的多项式为" + str_new);
					System.out.print("请按如下格式输入变量值：\n");
					System.out.print("！simplify x=1 y=2\n");
					model si_m = new model();
					si_m.sim(str_new);

					w.replace(si_m.ele);

				}
				break;
			case 3:
				System.out.println("当前的多项式为" + str_new);
				if (str_new == " ") {
					System.out.print("请输入表达式：\n");
					do {
						model i_n = new model();
						str_new = i_n.in();
						if (str_new == " ") {
							System.out.print("表达式不符合规范，请重新输入表达式：\n");
						}
					} while (str_new == " ");
				}
				System.out.print("请按如下格式输入进行求导运算：\n");
				System.out.print("！d/d x\n");
				model de_r = new model();
				de_r.der(str_new);
				break;
			default:
				break;
			}
		} while (i != -1);

	}

}
