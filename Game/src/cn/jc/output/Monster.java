package cn.jc.output;
/**
 * @Function:有关Monster操作
 * @Author:Mrdong916
 */
public class Monster extends Enemy {
	public Monster(int monType){
		//判断哪种类型的怪兽,并对不同的怪兽类型进行初始化
		if(monType==1){
			this.setEnemyName("小怪兽"); 
			this.setLife(30); 
			this.setLive(true);
			this.setEnemyAttack(15);
			this.setEnemyDefend(10);
			this.setExp(this.getLife());
			this.setEnemyAgile(10);
		}else if(monType==2){
			this.setEnemyName("大怪兽"); 
			this.setLife(50); 
			this.setLive(true);
			this.setEnemyAttack(20);
			this.setEnemyDefend(15);
			this.setExp(this.getLife());
			this.setEnemyAgile(20);
		}else if(monType==3){
			this.setEnemyName("超级怪兽"); 
			this.setLife(80); 
			this.setLive(true);
			this.setEnemyAttack(30);
			this.setEnemyDefend(20);
			this.setExp(this.getLife());
			this.setEnemyAgile(30);
		}
	}
}
