package cn.jc.output;

class Enemy {
	private String enemyName;//��������
	private boolean isLive;//����״̬
	private int life;//����ֵ
	private int enemyAttack;//������
	private int enemyDefend;//������
	private int exp;//������������ֵ
	private int enemyAgile;//���ݶ�
	
	//set get�������ʱ�������
	public String getEnemyName() {
		return enemyName;
	}
	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
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
	public int getEnemyAttack() {
		return enemyAttack;
	}
	public void setEnemyAttack(int enemyAttack) {
		this.enemyAttack = enemyAttack;
	}
	public int getEnemyDefend() {
		return enemyDefend;
	}
	public void setEnemyDefend(int enemyDefend) {
		this.enemyDefend = enemyDefend;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getEnemyAgile() {
		return enemyAgile;
	}
	public void setEnemyAgile(int enemyAgile) {
		this.enemyAgile = enemyAgile;
	}
	//���޹�������
	public void kill(Hunter hun){
		//�ж�enemy�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.getisLive()){
			return;
		}
		//����������hunter����
		System.out.println(enemyName+"��ʼ����");
		hun.injured(this);//this ָ���Լ����Լ����ݹ�ȥ��ʹhunter����
	}
	
	//�������˷���     ����������ʱ���ù������˷���ʱ������ �������Ĺ�����
	public void injured(Hunter hun){//�˴���Hunter hun���Ǵ��ݹ����ĵ�this
		//���޽�������
		if(GameUtil.hidden(this.enemyAgile)){
			System.out.println(enemyName+"���ܳɹ�");
		}else{
			//��������
				this.life = this.life - GameUtil.hurt(hun.getHunterAttack(),this.enemyDefend);
			System.out.println(enemyName+":������������������~~~");
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
		System.out.println(this.enemyName+"�Ѿ�������");
		hun.show();
	}
	//����״̬
	public void show(){
		System.out.println("==========^===========");
		System.out.println("����:"+enemyName);
		System.out.println("����ֵ:"+life);
		System.out.println("������:"+enemyAttack);
		System.out.println("������:"+enemyDefend);
		System.out.println("����״̬:"+GameUtil.isLive(this.isLive));
		System.out.println("==========V===========");
	}
}
