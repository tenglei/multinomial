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
			System.out.print("��ѡ���ܣ�\n");
			System.out.print("1.������ʽ\n");
			System.out.print("2.���ʽ�Ļ�������ֵ\n");
			System.out.print("3.���ʽ��\n");
			System.out.print("-1.�˳�\n");
			System.out.print("���������\n");
			Scanner s = new Scanner(System.in);
			i = s.nextInt();
			if (i != 1 && i != 2 && i != 3 && i != -1)
				System.out.print("������������������\n");
			switch (i) {
			case 1:
				System.out.print("�밴����������ʽ��\n");
				System.out.print("֧��+��-��*��^��֧�ֶ���ĸ�������˺Ų���ʡ\n");
				do {
					model i_n = new model();
					str_new = i_n.in();
					if (str_new == " ") {
						System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
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
					System.out.print("��������ʽ��\n");
					do {
						model i_n = new model();
						str_new = i_n.in();
						if (str_new == " ") {
							System.out.print("�մ�");
							System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
						}
					} while (str_new == " ");
				} else {

					System.out.println("��ǰ�Ķ���ʽΪ" + str_new);
					System.out.print("�밴���¸�ʽ�������ֵ��\n");
					System.out.print("��simplify x=1 y=2\n");
					model si_m = new model();
					si_m.sim(str_new);

					w.replace(si_m.ele);

				}
				break;
			case 3:
				System.out.println("��ǰ�Ķ���ʽΪ" + str_new);
				if (str_new == " ") {
					System.out.print("��������ʽ��\n");
					do {
						model i_n = new model();
						str_new = i_n.in();
						if (str_new == " ") {
							System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
						}
					} while (str_new == " ");
				}
				System.out.print("�밴���¸�ʽ������������㣺\n");
				System.out.print("��d/d x\n");
				model de_r = new model();
				de_r.der(str_new);
				break;
			default:
				break;
			}
		} while (i != -1);

	}

}
