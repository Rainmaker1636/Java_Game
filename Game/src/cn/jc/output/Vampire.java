package cn.jc.output;

public class Vampire extends Enemy {
	private int vampireRate;
	
	public int getVampireRate() {
		return vampireRate;
	}

	public void setVampireRate(int vampireRate) {
		this.vampireRate = vampireRate;
	}

	public Vampire( int vamType){
		if(vamType==1){
			this.setEnemyName("��Ѫ��"); 
			this.setLife(30); 
			this.setLive(true);
			this.setEnemyAttack(15);
			this.setEnemyDefend(10);
			this.setExp(this.getLife());
			this.setEnemyAgile(10);
			this.setVampireRate(10);
		}else if(vamType==2){
			this.setEnemyName("��Ѫ��"); 
			this.setLife(50); 
			this.setLive(true);
			this.setEnemyAttack(20);
			this.setEnemyDefend(15);
			this.setExp(this.getLife());
			this.setEnemyAgile(20);
			this.setVampireRate(20);
		}else if(vamType==3){
			this.setEnemyName("��Ѫ����"); 
			this.setLife(80); 
			this.setLive(true);
			this.setEnemyAttack(30);
			this.setEnemyDefend(20);
			this.setExp(this.getLife());
			this.setEnemyAgile(30);
			this.setVampireRate(30);
		}
	}
	//��д�������˷�����������Ѫ
	public void kill(Hunter hun){
		//�ж�enemy�Ƿ�����
		if(getLife()<=0){
			return;
		}
		//�ж�hunter�Ƿ�����
		if(!hun.getisLive()){
			return;
		}
		//����������hunter����
		System.out.println(this.getEnemyName()+"��ʼ����");
		this.setLife(getLife(hun));
		System.out.println(this.getEnemyName()+"�ɹ���ȡ����ֵ��"+getLife(hun));
		hun.injured(this);//this ָ���Լ����Լ����ݹ�ȥ��ʹhunter����
		this.show();
		
	}
	public int getLife(Hunter hun){
		
		return (int)((GameUtil.hurt(getEnemyAttack(), hun.getHunterDefend()))*this.vampireRate/100);
	}
}
