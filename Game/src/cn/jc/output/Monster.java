package cn.jc.output;
/**
 * @function:�й�Monster����
 * @author:Mrdong916
 */
public class Monster {
	String type;
	boolean isLive;
	int life;
	
	void kill(Hunter hun){
		//�ж�Monster�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.isLive){
			return;
		}
		//����������hunter����
		System.out.println(type+"��ʼ����");
		hun.injured();
		hun.show();
	}
	void injured(){
		life -= 20;
		System.out.println(type+":������������������~~~");
		//�ж��Ƿ�����
		if(life<=0){
			dead();
		}
	}
	void dead(){
		System.out.println("���ذ�������~~~");
		isLive = false;
	}
	void show(){
		System.out.println(type+"\n����ֵ��"+life+"\n����״̬��"+!isLive);
		System.out.println("========================");
	}
}
