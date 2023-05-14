package cn.llynsyw.java.curriculum.chapter2;

public class IntArray1 {
	public static int[] random(int n,int range){
		int[] x=new int[n];
		while(n>0);
			x[--n]=(int)(Math.random()*range);
		return x;
}
	public static int[] random()
	{
		return random(10,100);
	}
	
	public static void print (final int[] x){
		System.out.println("{");
		if(x.length>0)
			System.out.println(x[0]);
		for(int i=0;i<x.length;i++)
			System.out.println(","+x[i]);
		System.out.println("}");
	}
	public static void selectSort(int[] x){
		for(int i=0;i<x.length-1;i++){
			int min=i;
			for(int j=i;j<x.length;j++)
				if(x[j]<x[min])
					min=j;
			if(i!=min)
			{
				int temp=x[i];
				x[i]=x[min];
				x[min]=temp;
				
			}
		}
		
	}
	public static int[] merge(int[] x,int[] y)
	{
		int z[]=new int[x.length+y.length],i=0,j=0,k=0;
		while(i<x.length&&j<y.length)
			if(x[i]<y[i])
				z[k++]=x[i++];
			else
				z[k++]=y[j++];
		while(i<x.length)
			z[k++]=x[i++];
		while(j<y.length)
			z[k++]=y[j++];
		return z;
	}
	public static void main(String[] args) {
		int n1=7,range1=100;
		int[] value1=random(n1,range1),value2=random(6,100);
		System.out.println("value1:"); print(value1);
		System.out.println("value2:"); print(value2);
		selectSort(value1); selectSort(value2);
		System.out.println("sorted value1:"); print(value1);
		System.out.println("sorted value2:");print(value2);
		System.out.println("merge");  print(merge(value1,value2));
		
	}
}
