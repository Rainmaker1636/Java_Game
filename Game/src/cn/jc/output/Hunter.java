package cn.jc.output;
/**
 * @function:�й�Hunter����
 * @author:Mrdong916
 */
public class Hunter {
	private String hunterName;//����
	private int life;//����ֵ
	private String weapon;//����
	private boolean isLive;//����״̬
	private int hunterAttack;//������
	private int hunterDefend;//������
	
	//set get�������ʱ���������
	public String getHunterName() {
		return hunterName;
	}
	public void setHunterName(String hunterName) {
		this.hunterName = hunterName;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	public int getHunterAttack() {
		return hunterAttack;
	}
	
	public void setHunterAttack(int hunterAttack) {
		this.hunterAttack = hunterAttack;
	}
	
	public int getHunterDefend() {
		return hunterDefend;
	}
	
	public void setHunterDefend(int hunterDefend) {
		this.hunterDefend = hunterDefend;
	}
	//ʹ���޲ι��캯���԰��������г�ʼ��// ��ʱ����
	public Hunter(){
		this.hunterName = "������";
		this.isLive = true;
		this.life = 100;
		this.weapon = "ȭͷ";//����û������������й������κι������ӳ�
		this.hunterAttack = 30;//����������
		this.hunterDefend = 20;//����������
	}
	//ʹ���вι��캯���԰��������г�ʼ��
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.life = 100;
		this.hunterAttack = 30;//����������
		this.hunterDefend = 20;//����������
		/**
		 * example:�������Ե����ָ�ֵ����
		 * Author:Mrdong916
		 */
		//��ֵ����������weapon�����ַ���
		//����һ >>>ͨ��thisָ���������ֵ����
		this.weapon = weapon;
		//������>>>ͨ��set�����������ֵ����
		//String setWeapon = weapon;
		//setWeapon(setWeapon);
	}
	//��������������
	public void fight(Monster mon){
		
		//�ж�hunter�Ƿ�����
		if(life<=0){
			return;
		}
		
		//�ж�Monster�Ƿ�����
		if(!mon.isLive()){
			return;
		}
		
		//û�����������й���,Monster����
		System.out.println(hunterName+"ʹ��"+weapon+"��ʼ����");
		mon.injured(this.hunterAttack); //���ù������˷��������������Ĺ��������ݸ��������˷���
		mon.show();
	}
	//���������˷���  ���޹���ʱ���ð��������˷���ʱ������ ���޵Ĺ�����
	public void injured(int monsterAttack){
		life = life + this.getHunterDefend()-monsterAttack-20;
		System.out.println(hunterName+":�������Ȼ�Ҵ��ң�����");
		//�ж��Ƿ�����
		if(life==0){
			dead();
			return;
		}else{
			//���û����������з���
			//fight(Monster mon);
		}
		
	}
	//���������˷���
	public void dead(){
		System.out.println("��"+hunterName+"����֮ʱ������������֮�գ�����");
		isLive = false;
	}
	//������״̬
	public void show(){
		System.out.println("========================");
		System.out.println(hunterName+"״̬");
		System.out.println("����ֵ��"+life+"\n����״̬��"+!isLive);
		System.out.println("========================");
	}

}
