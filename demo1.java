package ex1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class demo1 {
public static void main(String[] args) {
	String text;
	Scanner sc = new Scanner(System.in);
	Map<String,Integer> maps = new HashMap<String,Integer>();
	while(true) {
		text = sc.nextLine();
		if (text == null || text.trim().length() == 0) {
            System.out.println("empty, break.");
            break;
		}
		String[] info = text.split(" ");
		if(info[0].equals("整数")&&info[2].equals("等于")){
			maps.put(info[1],trans(info[3]));
		}
		else if(info[0].equals("看看")){
			System.out.println(retrans(maps.get(info[1])));
		}
		else if(info[0].equals("如果")) {
			if(info[2].equals("大于")) {
				if(judgment1(maps.get(info[1]),trans(info[3]))) {
					if(info[5].equals("看看")) {
						System.out.println(info[6]);
					}
					else {
						maps.put(info[5],Calculation(info[6],maps.get(info[5]),trans(info[7])));
					}
				}
				else {
					if(info[8].equals("看看")) {
						System.out.println(info[9]);
					}
					else {
						maps.put(info[9],Calculation(info[10],maps.get(info[9]),trans(info[11])));
					}
				}
			}
			else if(info[2].equals("小于")) {
				if(judgment2(maps.get(info[1]),trans(info[3]))) {
					if(info[5].equals("看看")) {
						System.out.println(info[6]);
					}
					else {
						maps.put(info[5],Calculation(info[6],maps.get(info[5]),trans(info[7])));
					}
				}
				else {
					if(info[8].equals("看看")) {
						System.out.println(info[9]);
					}
					else {
						maps.put(info[5],Calculation(info[6],maps.get(info[5]),trans(info[7])));
					}
				}
			}
		}
		else {
			if(info[1].equals("增加")||info[1].equals("减少")) {
				maps.put(info[0],Calculation(info[1],maps.get(info[0]),trans(info[2])));
				}
			}
		}
	sc.close();
}
static boolean judgment1(int in,int temp) {
	if(in>temp)
		return true;
	else
		return false;
}
static boolean judgment2(int in,int temp) {
	if(in<temp)
		return true;
	else
		return false;
}
static int Calculation(String symbol,int in,int temp) {
	int num=in;
	if(symbol.equals("增加")) {
		num=in+temp;
	}
	if(symbol.equals("减少")) {
		num=in-temp;
	}
	return num;
}
static int trans(String in) {
	int num = 0;
	if(in.length()>1) {
		String i1s = "";
		for(int i = 0;i<in.length();i++) {
			char temp = in.charAt(i);
			i1s=String.valueOf(temp);
			num=num*10+trans1(i1s);
		}
		return num;
	}
	else {
		num=trans1(in);
		return num;
	}
}
static String retrans(int in) {
	String num = null;
	if(in<0) {
		num="负";
		if(in<-9) {
			int temp=0;
			int number=Math.abs(in);
			while(number>0) {
				temp=temp*10+(number%10);
				number=number/10;
			}
			while(temp>0) {
				num=num+trans2(temp%10);
			}
			return num;
		}
		else {
			return num+trans2(Math.abs(in));
		}
	}
	else {
		int temp=0;
		if(in>10) {
			while(in>0) {
				temp=temp*10+(in%10);
				in=in/10;
			}
			while(temp>0) {
				num=num+trans2(temp%10);
			}
			return num;
		}
		else {
			return trans2(in);
		}
	}
}
static int trans1(String in){
	int num = 0;
	if(in.equals("零")) {
		num = 0;
	}
	else if(in.equals("一")) {
		num = 1;
	}
	else if(in.equals("二")) {
		num = 2;
	}
	else if(in.equals("三")) {
		num = 3;
	}
	else if(in.equals("四")) {
		num = 4;
	}
	else if(in.equals("五")) {
		num = 5;
	}
	else if(in.equals("六")) {
		num = 6;
	}
	else if(in.equals("七")) {
		num = 7;
	}
	else if(in.equals("八")) {
		num = 8;
	}
	else if(in.equals("九")) {
		num = 9;
	}
	else if(in.equals("十")) {
		num = 10;
	}
	return num;
}
static String trans2(int in){
	String num = null;
	if(in==0) {
		num = "零";
	}
	else if(in==1) {
		num = "一";
	}
	else if(in==2) {
		num = "二";
	}
	else if(in==3) {
		num = "三";
	}
	else if(in==4) {
		num = "四";
	}
	else if(in==5) {
		num = "五";
	}
	else if(in==6) {
		num = "六";
	}
	else if(in==7) {
		num = "七";
	}
	else if(in==8) {
		num = "八";
	}
	else if(in==9) {
		num = "九";
	}
	else if(in==10) {
		num = "十";
	}
	return num;
}
}