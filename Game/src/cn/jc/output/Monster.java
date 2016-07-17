package cn.jc.output;
/**
 * @function:�й�Monster����
 * @author:Mrdong916
 */
public class Monster {
	String monsterName;
	boolean isLive;
	int life;
	//���캯�� �Թ��޽��г�ʼ��
	public Monster(int monType){
		//�ж��������͵Ĺ���,���Թ������ͽ��г�ʼ��
		if(monType==1){
			this.monsterName = "С����";
			this.life = 60;
			this.isLive = true;
		}else if(monType==2){
			this.monsterName = "�����";
			this.life = 1000;
			this.isLive = true;
		}else if(monType==3){
			this.monsterName = "��������";
			this.life = 150;
			this.isLive = true;
		}
	}
	
	//���޽��й���
	public void kill(Hunter hun){
		//�ж�Monster�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.isLive){
			return;
		}
		//����������hunter����
		System.out.println(monsterName+"��ʼ����");
		hun.injured();
		hun.show();
	}
	public void injured(){
		life -= 20;
		System.out.println(monsterName+":������������������~~~");
		//�ж��Ƿ�����
		if(life<=0){
			dead();
		}
		//ʵ���Զ���������kill();
	}
	public void dead(){
		System.out.println("���ذ�������~~~");
		isLive = false;
	}
	public void show(){
		System.out.println("========================");
		System.out.println(monsterName+"״̬");
		System.out.println("����ֵ��"+life+"\n����״̬��"+!isLive);
		System.out.println("========================");
	}
}
