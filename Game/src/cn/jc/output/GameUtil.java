package cn.jc.output;

public class GameUtil {
	//���㺯��
	public static boolean hidden(int agile){
		int random = (int) (Math.random() * (100-1) +1);//�������1-100֮�������
		//��������С�ڵ������������ܳɹ�
		if(agile*60/100>=random){
			return true;
		}else{
			return false;
		}		
	}
	//�ж��˺�ֵ ������ʱ��ֱ�ӷ�����ʣ����ֵ
	public static int hurt(int currentLife,int attack, int defend){
		//����з�������С���ҷ��ķ�������ֱ������10
		if(attack-defend>0){
			return  (currentLife + defend-attack-10);
		}else{
			return currentLife-10;
		}
	}
	
	//��������ж�
	public static String isLive( boolean isLive){
		String live;
		if(isLive){
			live = "����";
		}else{
			live = "����";
		}
		return live;
	}
}
