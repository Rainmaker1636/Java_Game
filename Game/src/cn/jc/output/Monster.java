package cn.jc.output;
/**
 * @function:有关Monster操作
 * @author:Mrdong916
 */
public class Monster {
	String monsterName;
	boolean isLive;
	int life;
	//构造函数 对怪兽进行初始化
	public Monster(int monType){
		//判断哪种类型的怪兽,并对怪兽类型进行初始化
		if(monType==1){
			this.monsterName = "小怪兽";
			this.life = 60;
			this.isLive = true;
		}else if(monType==2){
			this.monsterName = "大怪兽";
			this.life = 1000;
			this.isLive = true;
		}else if(monType==3){
			this.monsterName = "超级怪兽";
			this.life = 150;
			this.isLive = true;
		}
	}
	
	//怪兽进行攻击
	public void kill(Hunter hun){
		//判断Monster是否死亡
		if(life<=0){
			return;
		}
		//判断hunter是否死亡
		if(!hun.isLive){
			return;
		}
		//继续攻击，hunter受伤
		System.out.println(monsterName+"开始进攻");
		hun.injured();
		hun.show();
	}
	public void injured(){
		life -= 20;
		System.out.println(monsterName+":噢呜呜呜呜呜呜呜呜~~~");
		//判断是否死亡
		if(life<=0){
			dead();
		}
		//实现自动反击功能kill();
	}
	public void dead(){
		System.out.println("呜呜啊啊啊啊~~~");
		isLive = false;
	}
	public void show(){
		System.out.println("========================");
		System.out.println(monsterName+"状态");
		System.out.println("生命值："+life+"\n死亡状态："+!isLive);
		System.out.println("========================");
	}
}
