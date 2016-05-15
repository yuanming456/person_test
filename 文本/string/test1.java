package com.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

//逆转字符串——输入一个字符串，将其逆转并输出。
@SuppressWarnings("serial")
class ReverisbileArrayList<T>  extends ArrayList<T>{
	
	public ReverisbileArrayList(Collection<T> c){super(c);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterable<T> reversed(){
		return  new Iterable(){
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size()-1;
					public boolean hasNext() {
						return current>-1;
					}

					@Override
					public T next() {
						return get(current--);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
}
public class test1 {
	public static void main(String[] args) {
		String str ="you to be cuccess whith  more exercise,dd ro bb。aa";
		//第一种
		ReverisbileArrayList<String> arrayList = new ReverisbileArrayList<String>(Arrays.asList("you to be cuccess whith  more exercise,dd ro bb。aa".split(" ")));
		for(String s:arrayList){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:arrayList.reversed()){
			System.out.print(s+" ");
		}
		System.out.println();
		//第二种
		StringBuffer buffer= new StringBuffer(str);
		System.out.println(buffer.reverse());
		//第三种
		System.out.println(new JDKRevrser().reverser(str));
		//第四种
		System.out.println(new test1().reverses(str)+"???");
		//第五种
		System.out.println(new test1().reverse_2(str));
		
	}
	public String reverses(String str){
		if(str == null || str.length()<=1 ){
			return str;
		}
		char[] chars = str.toCharArray();
		int right = chars.length - 1;
		for(int left=0;left<right;left++){
			char swap = chars[left];
			chars[left] = chars[right];
			chars[right--] = swap;
			
		}
		return new String(chars);
	}
	public String reverse_2(String str){
		if(str == null || str.length()<=1 ){
			return str;
		}
		StringBuffer strs = new StringBuffer(str.length());
		for(int i= str.length()-1;i>=0;i--){
			strs.append(str.charAt(i));
		}
		return strs.toString();
	}

}
//
class JDKRevrser{
	public String reverser(String str){
		if((null == str )|| (str.length()<=1)) return str;
		return new StringBuffer(str).reverse().toString();
	}
}



