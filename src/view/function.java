package view;
import java.util.Scanner;

import control.model;
import model.way1;
public class function {

	public static void main(String[] args) {
		String str_new=" ";
		int i=0;
		String str;
		way1 w=new way1();
	//	System.out.print(w.getCurrentPath());
		do
		{
			System.out.println("��ѡ���ܣ�");
			System.out.print("1.������ʽ\n");
			System.out.print("2.���ʽ�Ļ�������ֵ\n");
			System.out.print("3.���ʽ��\n");
			System.out.print("-1.�˳�\n");
			System.out.print("���������\n");
			Scanner s=new Scanner(System.in);
			i= s.nextInt();
			if(i!=1&&i!=2&&i!=3&&i!=-1)
				System.out.print("������������������\n");
			switch (i)
			{
			case 1:
				System.out.print("�밴����������ʽ��\n");
				System.out.print("֧��+��-��*��^��֧�ֶ���ĸ�������˺Ų���ʡ\n");
				do{
					Scanner c=new Scanner(System.in);
					str=c.nextLine();//
					model i_n = new model();
					str_new = i_n.in(str);
					if(str_new==" ")
					{
						System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
					}
				}while(str_new==" ");
				 w.initstring(str_new);
				 w.changeto(w.test);
				break;
			case 2:
				if(str_new==" ")
				{
					System.out.print("��������ʽ��\n");
					do{
						Scanner c=new Scanner(System.in);
						str=c.nextLine();//
						model i_n = new model();
						str_new = i_n.in(str);
						if(str_new==" ")
						{
							System.out.print("�մ�");
							System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
						}
					}while(str_new==" ");
					System.out.println(str_new);
				}
				else{
					
					System.out.println("��ǰ�Ķ���ʽΪ"+str_new);
					System.out.print("�밴���¸�ʽ�������ֵ��\n");
					System.out.print("��simplify x=1 y=2\n");
					model si_m = new model();
					int f=si_m.sim(str_new);
					if(f==0){		
						w.replace(si_m.ele);//û�г�����ֵ���
						w.merge();
						w.m();
						System.out.print('\n');
					}
					else if(f==1)
						System.out.println("��ʽ����ȷ���޷����м���");
					//System.out.print(si_m.ele.size());
					//System.out.print(si_m.ele.get(0).e);
				}
				break;
			case 3:
				System.out.println("��ǰ�Ķ���ʽΪ"+str_new);
				if(str_new==" ")
				{
					System.out.print("��������ʽ��\n");
					do{
						Scanner c=new Scanner(System.in);
						str=c.nextLine();//
						model i_n = new model();
						str_new = i_n.in(str);
						if(str_new==" ")
						{
							System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
						}
					}while(str_new==" ");
				}
				System.out.print("�밴���¸�ʽ������������㣺\n");
				System.out.print("��d/d x\n");
				model de_r = new model();
				String g=de_r.der(str_new);
				if(g==" ")
					System.out.println("��ʽ����ȷ���޷�������");
				else
					w.changeto(w.test);
					//System.out.println(g);
					w.derivative(g);
					break;
			default:
				break;
			}
		}while(i!=-1);
		
	}



public String expression(String str0)
{
	
	model i_n = new model();
	String str_1 = i_n.in(str0);
	return str_1;
}
}
