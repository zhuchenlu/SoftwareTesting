package cn.tju.scs;

public class Caculator {
	public static int isTriangle(int a, int b, int c){
		int max = Math.max(a,b);
		max = Math.max(max, c);
		double sum;
		double  quadraticSum;
		double  quadraticMax = Math.pow(max, 2);
		if(max == a){
			sum = b + c;
			quadraticSum = Math.pow(b, 2) + Math.pow(c,2);
		}
		else if(max == b){
			sum = a + c;
			quadraticSum = Math.pow(a, 2) + Math.pow(c, 2);
		}
		else{
			sum = a + b;
			quadraticSum = Math.pow(b, 2) + Math.pow(a, 2);
		}
		
		if(sum < max || sum == max){
			return -1;
			//����������
		}
		else{
			if( quadraticMax ==  quadraticSum)
			{
				return 0;
				//ֱ��������
				//��ֱ�������ξ���б��������
			}
			else if(a == b && b == c){
				return 1;
				//�ȱ�������
			}
			else if(a == b || b == c){
				return 2;
				//����������
			}
			else{
				return 3;
				//��ͨ������
			}
		}
	}
}
