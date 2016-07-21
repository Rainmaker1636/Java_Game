package cn.jc.output;
/**
 * @Function:�й�Monster����
 * @Author:Mrdong916
 */
public class Monster {
	private String monsterName;//��������
	private boolean isLive;//����״̬
	private int life;//����ֵ
	private int monsterAttack;//������
	private int monsterDefend;//������
	private int exp;//������������ֵ
	private int monsterAgile;//���ݶ�
	
	//���캯�� �Թ��޽��г�ʼ��
	public Monster(int monType){
		//�ж��������͵Ĺ���,���Բ�ͬ�Ĺ������ͽ��г�ʼ��
		if(monType==1){
			this.monsterName = "С����";
			this.life = 30;
			this.isLive = true;
			this.monsterAttack = 10;
			this.monsterDefend = 10;
			this.exp = this.life;
			this.monsterAgile = 10;
		}else if(monType==2){
			this.monsterName = "�����";
			this.life = 40;
			this.isLive = true;
			this.monsterAttack = 20;
			this.monsterDefend = 20;
			this.exp = this.life;
			this.monsterAgile = 15;
		}else if(monType==3){
			this.monsterName = "��������";
			this.life = 50;
			this.isLive = true;
			this.monsterAttack = 30;
			this.monsterDefend = 30;
			this.exp = this.life;
			this.monsterAgile = 20;
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
		return monsterDefend;
	}
	public void setMonsterrDefend(int monsterrDefend) {
		this.monsterDefend = monsterrDefend;
	}
	public int getMonsterDefend() {
		return monsterDefend;
	}
	public void setMonsterDefend(int monsterDefend) {
		this.monsterDefend = monsterDefend;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getMonsterAgile() {
		return monsterAgile;
	}
	public void setMonsterAgile(int monsterAgile) {
		this.monsterAgile = monsterAgile;
	}

	//���޹�������
	public void kill(Hunter hun){
		//�ж�Monster�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.getisLive()){
			return;
		}
		//����������hunter����
		System.out.println(monsterName+"��ʼ����");
		hun.injured(this);//this ָ���Լ����Լ����ݹ�ȥ��ʹhunter����
	}
	//�������˷���     ����������ʱ���ù������˷���ʱ������ �������Ĺ�����
	public void injured(Hunter hun){//�˴���Hunter hun���Ǵ��ݹ����ĵ�this
		//���޽�������
		if(GameUtil.hidden(this.monsterAgile)){
			System.out.println(monsterName+"���ܳɹ�");
		}else{
			//��������
				this.life = GameUtil.hurt(this.getLife(),hun.getHunterAttack(),this.monsterDefend);
			System.out.println(monsterName+":������������������~~~");
			//�ж��Ƿ�����
			if(life<=0){
				dead(hun);
				return;
			}
		}
		//��ʾ״̬
		show();
		//���û������������Զ�����
		kill(hun);
	}
	//��������
	public void dead(Hunter hun){
		System.out.println("���ذ�������~~~");
		isLive = false;
		hun.expAdd(this);
		System.out.println(this.monsterName+"�Ѿ�������");
		hun.show();
	}
	//����״̬
	public void show(){
		System.out.println("==========^===========");
		System.out.println("����:"+monsterName);
		System.out.println("����ֵ:"+life);
		System.out.println("������:"+monsterAttack);
		System.out.println("������:"+monsterDefend);
		System.out.println("����״̬:"+GameUtil.isLive(this.isLive));
		System.out.println("==========V===========");
	}
}
