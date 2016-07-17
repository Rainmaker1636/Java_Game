package cn.jc.output;
/**
 * @function:�й�Monster����
 * @author:Mrdong916
 */
public class Monster {
	private String monsterName;//��������
	private boolean isLive;//����״̬
	private int life;//����ֵ
	private int monsterAttack;//������
	private int monsterrDefend;//������
	
	//���캯�� �Թ��޽��г�ʼ��
	public Monster(int monType){
		//�ж��������͵Ĺ���,���Բ�ͬ�Ĺ������ͽ��г�ʼ��
		if(monType==1){
			this.monsterName = "С����";
			this.life = 60;
			this.isLive = true;
			this.monsterAttack = 20;
			this.monsterrDefend = 10;
		}else if(monType==2){
			this.monsterName = "�����";
			this.life = 1000;
			this.isLive = true;
			this.monsterAttack = 30;
			this.monsterrDefend = 20;
		}else if(monType==3){
			this.monsterName = "��������";
			this.life = 150;
			this.isLive = true;
			this.monsterAttack = 50;
			this.monsterrDefend = 30;
		}
	}
	
	//set get�������ʱ�������
	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getMonsterAttack() {
		return monsterAttack;
	}

	public void setMonsterAttack(int monsterAttack) {
		this.monsterAttack = monsterAttack;
	}

	public int getMonsterrDefend() {
		return monsterrDefend;
	}

	public void setMonsterrDefend(int monsterrDefend) {
		this.monsterrDefend = monsterrDefend;
	}

	//���޹�������
	public void kill(Hunter hun){
		//�ж�Monster�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.isLive()){
			return;
		}
		//����������hunter����
		System.out.println(monsterName+"��ʼ����");
		hun.injured(this.monsterAttack);
		hun.show();
	}
	//�������˷���     ����������ʱ���ù������˷���ʱ������ �������Ĺ�����
	public void injured(int hunterAttack){
		life = life + this.monsterrDefend - hunterAttack - 20;
		System.out.println(monsterName+":������������������~~~");
		//�ж��Ƿ�����
		if(life<=0){
			dead();
			return;
		}else{
			//���û������������Զ�����
			//kill(Hunter hun);
		}
	}
	//��������
	public void dead(){
		System.out.println("���ذ�������~~~");
		isLive = false;
	}
	//����״̬
	public void show(){
		System.out.println("========================");
		System.out.println(monsterName+"״̬");
		System.out.println("����ֵ��"+life+"\n����״̬��"+!isLive);
		System.out.println("========================");
	}
}
