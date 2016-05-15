package com.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

//��ת�ַ�����������һ���ַ�����������ת�������
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
		String str ="you to be cuccess whith  more exercise,dd ro bb��aa";
		//��һ��
		ReverisbileArrayList<String> arrayList = new ReverisbileArrayList<String>(Arrays.asList("you to be cuccess whith  more exercise,dd ro bb��aa".split(" ")));
		for(String s:arrayList){
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:arrayList.reversed()){
			System.out.print(s+" ");
		}
		System.out.println();
		//�ڶ���
		StringBuffer buffer= new StringBuffer(str);
		System.out.println(buffer.reverse());
		//������
		System.out.println(new JDKRevrser().reverser(str));
		//������
		System.out.println(new test1().reverses(str)+"???");
		
		
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
	

}
//
class JDKRevrser{
	public String reverser(String str){
		if((null == str )|| (str.length()<=1)) return str;
		return new StringBuffer(str).reverse().toString();
	}
}



