package cn.jc.output;
/**
 * @Function:�й�Hunter����
 * @Author:Mrdong916
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
	private int hunterAgile;//���ݶ�
	private int hunterMaxAgile;
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHunterAgile() {
		return hunterAgile;
	}
	public void setHunterAgile(int hunterAgile) {
		this.hunterAgile = hunterAgile;
	}
	public int getHunterMaxAgile() {
		return hunterMaxAgile;
	}
	public void setHunterMaxAgile(int hunterMaxAgile) {
		this.hunterMaxAgile = hunterMaxAgile;
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
		this.hunterAgile = 10;//��ʼ�����ݶ�
		this.hunterMaxAgile = 100;//������ݶ�
	}
	//ʹ���вι��캯���԰��������г�ʼ��
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//����������
		this.hunterDefend = 20;//����������
		this.level = 1;//��ǰ�ȼ�
		this.currentExperience = 0;//��ʼ����
		this.hunterAgile = 20;//��ʼ�����ݶ�
		this.hunterMaxAgile = 100;//������ݶ�
		/**
		 * example:�������Ե����ָ�ֵ����
		 * Author:Mrdong916
		 */
		//��ֵ����������weapon�����ַ���
		//����һ >>>ͨ��thisָ���������ֵ����
		this.weapon = weapon;
		//������>>>ͨ��set�����������ֵ����
		//setWeapon(weapon);
	}
	//��������������
	public void fight(Enemy enemy){
		
		//�ж�hunter�Ƿ�����
		if(currentLife<=0){
			return;
		}
		
		//�ж�Monster�Ƿ�����
		if(!enemy.isLive()){
			return;
		}
		
		//û�����������й���,Monster����
		System.out.println(hunterName+"ʹ��"+weapon+"��ʼ����");
		enemy.injured(this); //���ù������˷��������������Ĺ��������ݸ��������˷���
	}
	//���������˷���  ���޹���ʱ���ð��������˷���ʱ������ ���޵Ĺ�����
	public void injured(Enemy enemy){  //�˴���Monster mon���Ǵ��ݹ�����this
		//���������������ɹ�ֱ�ӱ����˺�
		if(GameUtil.hidden(this.hunterAgile)){
			//�������ɹ����������Ĳ���
			System.out.println(hunterName+"���ܳɹ�");
		}else{
			//���ù������˲���
			this.currentLife -= GameUtil.hurt( enemy.getEnemyAttack(), getHunterDefend());
			System.out.println(hunterName+":�������Ȼ�Ҵ��ң�����");
			//�ж��Ƿ�����
			if(currentLife<=0){
				dead(enemy);
				return;
			}
		}
		//��ʾ״̬
		show();
		//���û����������з���
		fight(enemy);
	}
	//��������������
	public void dead( Enemy enemy){
		System.out.println(this.hunterName+"�Ѿ�������");
		System.out.println("��"+hunterName+"����֮ʱ������������֮�գ�����");
		isLive = false;
		enemy.show();//��ʾһ�µ���״̬
	}
	//������״̬
	public void show(){
		System.out.println("===========^===========");
		System.out.println("����:"+hunterName);
		System.out.println("�ȼ�:"+level);
		System.out.println("������:"+hunterAttack);
		System.out.println("������:"+hunterDefend);
		System.out.println("���ݶ�:"+hunterAgile);
		System.out.println("����״̬:"+GameUtil.isLive(this.isLive));
		System.out.println("��ǰ����ֵ"+currentLife+"/�������ֵ"+maxLife);
		System.out.println("��ǰ����ֵ"+getCurrentExperience()+"/��������ֵ"+needExperience());
		System.out.println("===========V===========");
	}

	//��������ֵ
	public int needExperience(){
		int needExperience = 0;
		for(int i = 1;i<=level;i++){
			needExperience = needExperience + 50 * i;
		}
		return needExperience;
	}
	//���Ӿ���ֵ����
	public void expAdd(Enemy enemy){
		setCurrentExperience( getCurrentExperience() +enemy.getExp());//����������жԵ�ǰ��������
		System.out.println("սʤ"+enemy.getEnemyName()+"���"+enemy.getExp()+"���飡");
		//�ж��Ƿ�����
		if(currentExperience>=needExperience()){
			//�����еľ���ֵ�����������辭��ֵ���������
			hunterUpgrade();//������������
			return;
		}
	}
	//��������
	public void hunterUpgrade(){
		level ++;
		maxLife += 50;
		currentLife = maxLife;
		hunterAttack += 10;
		hunterDefend += 8;
		hunterAgile += 5;
		//��hunter���ݶȴ������ֵʱ����������ֵ
		if(this.hunterAgile>this.hunterMaxAgile){
			this.hunterAgile = this.hunterMaxAgile;
		}
		System.out.println(hunterName+"�ȼ�������"+level+"����");
	}
}
