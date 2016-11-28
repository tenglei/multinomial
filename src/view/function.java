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
			System.out.println("请选择功能：");
			System.out.print("1.输入表达式\n");
			System.out.print("2.表达式的化简与求值\n");
			System.out.print("3.表达式求导\n");
			System.out.print("-1.退出\n");
			System.out.print("请输入序号\n");
			Scanner s=new Scanner(System.in);
			i= s.nextInt();
			if(i!=1&&i!=2&&i!=3&&i!=-1)
				System.out.print("输入有误，请重新输入\n");
			switch (i)
			{
			case 1:
				System.out.print("请按规则输入表达式：\n");
				System.out.print("支持+、-、*、^，支持多字母变量，乘号不可省\n");
				do{
					str_new=In.In(str);
				}while(str_new=="fail!");
				Out.Out(str_new);
				break;
			case 2:
				if(str_new=="fail!")
				{
					System.out.print("请输入表达式：\n");
					do{
						str_new=In.In(str);
					}while(str_new=="fail!");
					Out.Out(str_new);
				}
				else{
					System.out.println("当前的多项式为"+str_new);
					System.out.print("请按如下格式输入变量值：\n");
					System.out.print("！simplify x=1 y=2\n");
					InSim.InSim(str_new, str);
					//OutSim.OutSim(str);
				}
				break;
			case 3:
				if(str_new=="fail!")
				{
					System.out.print("请输入表达式：\n");
					do{
						str_new=In.In(str);
					}while(str_new=="fail!");
					Out.Out(str_new);
				}
				System.out.println("当前的多项式为"+str_new);
				System.out.print("请按如下格式输入进行求导运算：\n");
				System.out.print("！d/d x\n");
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
			System.out.print("表达式不符合规范，请重新输入表达式：\n");
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
		System.out.println("您输入的多项式为：");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}
class OutSim{
	public static String OutSim(String str){
		System.out.println("结果为：");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}
class OutDer{
	public static String OutDer(String str){
		System.out.println("结果为：");
		System.out.print(str);
		System.out.print('\n');
		return str;
	}
}