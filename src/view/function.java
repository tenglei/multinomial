package view;
import java.util.Scanner;

import control.model;
//import model.way1;
public class function {

	public static void main(String[] args) {
		String str_new="fail!";
		int i=0;
		String str = null;
		String g;
		//way1 w=new way1();
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
					str_new=In.In(str);
				}while(str_new=="fail!");
				Out.Out(str_new);
				break;
			case 2:
				if(str_new=="fail!")
				{
					System.out.print("��������ʽ��\n");
					do{
						str_new=In.In(str);
					}while(str_new=="fail!");
					Out.Out(str_new);
				}
				else{
					System.out.println("��ǰ�Ķ���ʽΪ"+str_new);
					System.out.print("�밴���¸�ʽ�������ֵ��\n");
					System.out.print("��simplify x=1 y=2\n");
					InSim.InSim(str_new, str);
					//OutSim.OutSim(str);
				}
				break;
			case 3:
				if(str_new=="fail!")
				{
					System.out.print("��������ʽ��\n");
					do{
						str_new=In.In(str);
					}while(str_new=="fail!");
					Out.Out(str_new);
				}
				System.out.println("��ǰ�Ķ���ʽΪ"+str_new);
				System.out.print("�밴���¸�ʽ������������㣺\n");
				System.out.print("��d/d x\n");
				g=InDer.InDer(str_new, str);
				OutDer.OutDer(g);
					break;
			default:
				break;
			}
		}while(i!=-1);
		
	}




}
class In {
	public static String In(String str){
		String str_new;
		str=null;
		Scanner c=new Scanner(System.in);
		str=c.nextLine();//
		model i_n = new model();
		str_new = i_n.in(str);
		if(str_new=="fail!")
		{
			System.out.print("���ʽ�����Ϲ淶��������������ʽ��\n");
		}
		return str_new;
	}
}
class InSim {
	public static void InSim(String str_in,String str){
		str=null;
		model si_m = new model();
		Scanner c=new Scanner(System.in);
		str=c.nextLine();
		int f=si_m.sim(str_in,str);
	}
}
class InDer {
	public static String InDer(String str_in,String str){
		str=null;
		model de_r = new model();
		Scanner c=new Scanner(System.in);
		str=c.nextLine();
		String g=de_r.der(str_in,str);
		return g;
	}
}
class Out{
	public static String Out(String str){
		System.out.println("������Ķ���ʽΪ��");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}
class OutSim{
	public static String OutSim(String str){
		System.out.println("���Ϊ��");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}
class OutDer{
	public static String OutDer(String str){
		System.out.println("���Ϊ��");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}