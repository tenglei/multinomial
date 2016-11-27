package control;

import java.util.Vector;

import model.way1;

import java.util.Scanner;

public class view {
	public Vector <Element> ele= new Vector <Element>();
	way1 w=new way1();
	public String inp(String str){
		int len;
		if(str.length()==0||str=="")
			return " ";
		char ch=str.charAt(0);

		if(ch<48&&ch!=32&&ch!=9||ch>57&&ch<65||ch>90&&ch<97||ch>122)
			return " ";//可为数字，可为空格制表符，可为大小写字母
		str.trim();
		len=str.length();
		char A[]=str.toCharArray();

		for(int j=0;j<len;j++)
		{
			while(A[j]==32)//消除空格
			{
				len-=1;
				for(int k=j;k<len;k++)
				{
					A[k]=A[k+1];
				}
			}
			while(A[j]==9)//消除tab
			{
				len-=1;
				for(int k=j;k<len;k++)
				{
					A[k]=A[k+1];
				}
			}
			if(A[j]==94)//对于^的前后限制
			{
				if(A[j-1]<65||(A[j-1]>90&&A[j-1]<97)||A[j-1]>122)
					return " ";
				if(A[j+1]>57||A[j+1]<48)
					return " ";
		
			}
			if((A[j]<48&&A[j]!=42&&A[j]!=43&&A[j]!=45)||(A[j]>57&&A[j]<65)
					||(A[j]>90&&A[j]<97&&A[j]!=94)||A[j]>122)
				return " ";//除了数字+-*^以及大小写字母
			if(j+1<len)
			{
				if(A[j]>47&&A[j]<58&&(A[j+1]>64&&A[j+1]<91||A[j+1]>96&&A[j+1]<123)
					||(A[j]>64&&A[j]<91||A[j]>96&&A[j]<123)&&A[j+1]>47&&A[j+1]<58)

					return " ";	//除了9x，x9这样的字符串

			}
		}
		String str1 =String.valueOf(A);
		String str_new=str1.substring(0,len);
		System.out.println("您输入的多项式为：");
		System.out.print(str_new);
		System.out.print('\n');
		return str_new;
		}
		
		

	
	
	public int  simplify(String str_in){
		
		int flag=0;//等于1时不用计算
		Scanner c=new Scanner(System.in);
		String str;
		str=c.nextLine();
		String str_0="!simplify";
		if(str.length()<13)
		{
			flag=1;
			//System.out.println("格式不正确，无法进行计算1");
		}
		else
		{
			String str_1=str.substring(0,9);
			String str_new=str.substring(10);
			if(str_0.equals(str_1)==true)
			{
				if(str.length()==9)
				{
					System.out.println(str_in);
					flag=2;
				}
				else
				{
					String A[]=str_new.split(" ");
					int lea=A.length;
					for(int i=0;i<lea;i++)
					{

						String B[]=A[i].split("=");
						if(B.length!=2)
						{
							flag=1;
							//System.out.println("格式不正确，无法进行计算2");
						}
						else
						{
							if(str_in.indexOf(B[0])==-1)
							{
								flag=1;
								//System.out.println("变量不在表达式中或格式不正确，无法进行计算");
							}
							else
							{
								for(int j=0;j<B[1].length();j++)
								{
									if(B[1].charAt(j)<48||B[1].charAt(j)>57)
									{
										flag=1;
										//System.out.println("格式不正确，无法进行计算3");
									}
									else
									{
										Element e_temp=new Element();
										e_temp.e=B[0];
										e_temp.value=Integer.parseInt(B[1]);	
										ele.addElement(e_temp);
										//System.out.print(ele.get(i).e);
										//System.out.print(ele.get(i).value);
										
									}
								}
							}
						}
					}
				}
			}
			else
			{
				//System.out.println("格式不正确，无法进行计算555");
				flag=1;
			}
		}
		return flag;
		//if(flag==0)
		//	{
				//计算
			//}
	}
	
	public String derivative(String str_in)
	{
		Scanner c=new Scanner(System.in);
		String str;
		int flag=0;
		str=c.nextLine();
		String str_0="!d/d";
		String A[]=str.split(" ");
		if(A.length==2)
		{
		if(str_0.equals(A[0])==true)
		{
			if(str_in.indexOf(A[1])==-1)
			{
				return " ";
			}
			else
				return A[1];
		}
		else
			return " ";		
		}
		else
			
			return " ";
			
	}

}

