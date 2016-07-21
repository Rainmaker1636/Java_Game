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
			this.setEnemyName("吸血鬼"); 
			this.setLife(30); 
			this.setLive(true);
			this.setEnemyAttack(15);
			this.setEnemyDefend(10);
			this.setExp(this.getLife());
			this.setEnemyAgile(10);
			this.setVampireRate(10);
		}else if(vamType==2){
			this.setEnemyName("嗜血鬼"); 
			this.setLife(50); 
			this.setLive(true);
			this.setEnemyAttack(20);
			this.setEnemyDefend(15);
			this.setExp(this.getLife());
			this.setEnemyAgile(20);
			this.setVampireRate(20);
		}else if(vamType==3){
			this.setEnemyName("吸血怪兽"); 
			this.setLife(80); 
			this.setLive(true);
			this.setEnemyAttack(30);
			this.setEnemyDefend(20);
			this.setExp(this.getLife());
			this.setEnemyAgile(30);
			this.setVampireRate(30);
		}
	}
	//重写怪兽受伤方法，加入吸血
	public void kill(Hunter hun){
		//判断enemy是否死亡
		if(getLife()<=0){
			return;
		}
		//判断hunter是否死亡
		if(!hun.getisLive()){
			return;
		}
		//继续攻击，hunter受伤
		System.out.println(this.getEnemyName()+"开始进攻");
		this.setLife(getLife(hun));
		System.out.println(this.getEnemyName()+"成功吸取生命值："+getLife(hun));
		hun.injured(this);//this 指向自己将自己传递过去，使hunter受伤
		this.show();
		
	}
	public int getLife(Hunter hun){
		
		return (int)((GameUtil.hurt(getEnemyAttack(), hun.getHunterDefend()))*this.vampireRate/100);
	}
}
