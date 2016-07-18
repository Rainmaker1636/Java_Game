package cn.jc.output;
/**
 * @function:�й�Hunter����
 * @author:Mrdong916
 */
public class Hunter {
	private String hunterName;//����
	private int currentLife;//��ǰ����ֵ
	private int maxLife;//�������ֵ
	private String weapon;//����
	private boolean isLive;//����״̬
	private int hunterAttack;//������
	private int hunterDefend;//������	
	private int level;//�ȼ�
	private int currentExperience;//��ǰ����
	private int levelExperience;//�ȼ�����

	
	//set get�������ʱ���������
	public String getHunterName() {
		return hunterName;
	}
	public void setHunterName(String hunterName) {
		this.hunterName = hunterName;
	}
	public int getCurrentLife() {
		return currentLife;
	}
	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public boolean getisLive() {
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
	public int getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public int getCurrentExperience() {
		return currentExperience;
	}
	public void setCurrentExperience(int currentExperience) {
		this.currentExperience = currentExperience;
	}
	public int getLevelExperience() {
		return levelExperience;
	}
	public void setLevelExperience(int levelExperience) {
		this.levelExperience = levelExperience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	//ʹ���޲ι��캯���԰��������г�ʼ��// ��ʱ����
	public Hunter(){
		this.hunterName = "������";
		this.weapon = "ȭͷ";//����û������������й������κι������ӳ�
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//����������
		this.hunterDefend = 10;//����������
		this.level = 1;//��ǰ�ȼ�
		this.currentExperience = 0;//��ʼ����
	}
	//ʹ���вι��캯���԰��������г�ʼ��
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//����������
		this.hunterDefend = 10;//����������
		this.level = 1;//��ǰ�ȼ�
		this.currentExperience = 0;//��ʼ����
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
		if(currentLife<=0){
			return;
		}
		
		//�ж�Monster�Ƿ�����
		if(!mon.isLive()){
			return;
		}
		
		//û�����������й���,Monster����
		System.out.println(hunterName+"ʹ��"+weapon+"��ʼ����");
		mon.injured(this); //���ù������˷��������������Ĺ��������ݸ��������˷���
	}
	//���������˷���  ���޹���ʱ���ð��������˷���ʱ������ ���޵Ĺ�����
	public void injured(Monster mon){  //�˴���Monster mon���Ǵ��ݹ�����this
		//������޵Ĺ�����С�ڰ������ķ�������ֱ�Ӽ���10
		if(mon.getMonsterAttack()-this.getHunterDefend()>0){
			this.currentLife = this.currentLife + this.getHunterDefend()-mon.getMonsterAttack()-10;
		}else{
			this.currentLife-=10;
		}
		System.out.println(hunterName+":�������Ȼ�Ҵ��ң�����");
		//�ж��Ƿ�����
		if(currentLife<=0){
			dead(mon);
			return;
		}
		//��ʾ״̬
		show();
		//���û����������з���
		fight(mon);
		
	}
	//���������˷���
	public void dead( Monster mon){
		System.out.println(this.hunterName+"�Ѿ�������");
		System.out.println("��"+hunterName+"����֮ʱ������������֮�գ�����");
		isLive = false;
		mon.show();//��ʾһ�µ���״̬
	}
	//������״̬
	public void show(){
		System.out.println("===========^===========");
		System.out.println("����:"+hunterName);
		System.out.println("�ȼ�:"+level);
		System.out.println("������:"+hunterAttack);
		System.out.println("������:"+hunterDefend);
		System.out.println("����״̬:"+isLive());
		System.out.println("��ǰ����ֵ"+currentLife+"/�������ֵ"+maxLife);
		System.out.println("��ǰ����"+getCurrentExperience()+"/��һ�ȼ�����"+getLevelExperience());
		System.out.println("===========V===========");
	}
	//��������ж�
	public String isLive(){
		String live;
		if(isLive){
			live = "����";
		}else{
			live = "����";
		}
		return live;
	}
	/**
	 * Function:��������������
	 * Author:Mrdong916
	 */
	public void hunterUpdate(){
		
	}

}
