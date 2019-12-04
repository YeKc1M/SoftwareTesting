import java.util.Random;
import java.util.Scanner;

class Rect{
	int left; //x1
	int top;  //y1
	int right; //x2
	int bottom;	 //y2
	public static Rect randomRect(){
		Rect r=new Rect();
		Random random=new Random();
		int x1=random.nextInt(660);
		int x2=random.nextInt(660);
		int y1=random.nextInt(1000);
		int y2=random.nextInt(1000);
		if(x1>x2){
			r.left=x2;
			r.right=x1;
		}else{
			r.left=x1;
			r.right=x2;
		}
		if(y1>y2){
			r.top=y2;
			r.bottom=y1;
		}else{
			r.top=y1;
			r.bottom=y2;
		}
		return r;
	}
	public String toString(){
		return new String("("+left+","+bottom+")("+right+","+top+")");
	}
	public static void testRandomRect(){
		for(int i=0;i<10;i++){
			System.out.println(randomRect());
		}
	}
}
public class RectManager {
	float area;//Recode area
	int nFlag; //recode the relation of two rectangle
	public static void testSolve(){
		RectManager r=new RectManager();
		int arr[]=new int[6];
		Rect a,b;
		for(int i=1;i<=1000000;i++){
			a=Rect.randomRect();
			b=Rect.randomRect();
			System.out.println(i+" "+a+" "+b);
			r.solve(a,b);
			arr[r.nFlag]++;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println("arr["+i+"]:"+arr[i]);
		}
	}
	public static void main(String[] args) {
		//testSolve(Rect.randomRect(),Rect.randomRect());
		//Rect.testRandomRect();
		//testSolve();
/*
		Rect A=new Rect();
		Rect B=new Rect();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input rectangle A��Format:left top right bottom����");
		A.left = scan.nextInt();
		A.top = scan.nextInt();
		A.right = scan.nextInt();
		A.bottom = scan.nextInt();

		System.out.print("Input rectangle B��Format:left top right bottom����");
		B.left = scan.nextInt();
		B.top = scan.nextInt();
		B.right = scan.nextInt();
		B.bottom = scan.nextInt();	
		
		//Check the input
		if (!(A.left>=0 && A.right<640)|| !(A.top>=0 && A.bottom<960)
			||!(A.right>=A.left) || !(A.bottom>=A.top)){
			System.out.println("Input error in Rectangle A");
			return;
		}
		if (!(B.left>=0 && B.right<640)|| !(B.top>=0 && B.bottom<960)
			||!(B.right>=B.left) || !(B.bottom>=B.top)){
			System.out.println("Input error in Rectangle B");
			return;
		}
		
		RectManager test= new RectManager();
		test.solve(A, B);
		
		if (test.nFlag==0){
			System.out.println("���β��ཻ��");
			return;
		}else if (test.nFlag==1){
			System.out.println("�����ཻ��һ������");
		}else if (test.nFlag==2){
			System.out.println("�����ཻ��һ��������Ϊ������ϵ��");
		}else if (test.nFlag==3){
			System.out.println("�����ཻ��һ�������������غϣ�");
		}else if (test.nFlag==4){
			System.out.println("�����ཻ��һ�������ҽ���Ϊ1���㣡");
		}else if (test.nFlag==5){
			System.out.println("�����ཻ��һ�������ҽ���Ϊ1���߶Σ�");
		}
		System.out.println("�ཻ�����"+test.area);*/
	}
	
	private void solve(Rect A, Rect B){
		int nMaxLeft = 0;
		int nMaxTop = 0;
		int nMinRight = 0;
		int nMinBottom = 0;
		
	    // Get the max left.
	    if (A.left >= B.left)
	    {
	        nMaxLeft = A.left;
	    }
	    else
	    {
	        nMaxLeft = B.left;
	    } 
	    
	    // Get the max top.
	    if (A.top >= B.top)
	    {
	        nMaxTop = A.top;
	    }
	    else
	    {
	        nMaxTop = B.top;
	    } 
	    
	    // Get the min right.
	    if (A.right <= B.right)
	    {
	        nMinRight = A.right;
	    }
	    else
	    {
	        nMinRight = B.right;
	    } 
	    
	    // Get the min bottom.
	    if (A.bottom <= B.bottom)
	    {
	        nMinBottom = A.bottom;
	    }
	    else
	    {
	        nMinBottom = B.bottom;
	    } 
	    
	 // Judge whether intersects.
	    if ((nMaxLeft > nMinRight) || (nMaxTop > nMinBottom))
	    {//���ཻ
	    	nFlag=0;
	    		    	
	    }
	    else
	    {//�ཻ
	    	//B1:�ཻΪһ������
	    	nFlag = 1;
	    	area = (nMinRight - nMaxLeft   + 1 ) * (nMinBottom - nMaxTop + 1);
	    	
	    	if ((B.left==A.left) && (B.right==A.right) && (B.top==A.top) && (B.bottom==A.bottom)){
	    		//B13:��ȫ�غ�
		    	nFlag = 3;
	    	} 
	    	else if (((nMaxLeft==A.left) && (nMinRight==A.right) && (nMaxTop==A.top) && (nMinBottom==A.bottom))
	    	 ||((nMaxLeft==B.left) && (nMinRight==B.right) && (nMaxTop==B.top) && (nMinBottom==B.bottom))){
		    	//B12:����
		    	nFlag = 2;
	    	}
	    	else if ((nMaxLeft==nMinRight) && (nMaxTop == nMinBottom)){
		    	//B2:����Ϊ1����
		    	nFlag = 4;
	    	}
	    	else if (((nMaxLeft==nMinRight) && (nMaxTop < nMinBottom)) 
	    		  || ((nMaxLeft<nMinRight) && (nMaxTop == nMinBottom))){
		    	//B3:����Ϊ1���߶�
		    	nFlag = 5;
	    	}
	    } 
		
	}
	
}
