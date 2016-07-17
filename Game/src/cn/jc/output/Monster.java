package cn.jc.output;
/**
 * @function:有关Monster操作
 * @author:Mrdong916
 */
public class Monster {
	private String monsterName;
	private boolean isLive;
	private int life;
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
	
	//set get方法访问保护的属性
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


	//怪兽进行攻击
	public void kill(Hunter hun){
		//判断Monster是否死亡
		if(life<=0){
			return;
		}
		//判断hunter是否死亡
		if(!hun.isLive()){
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
			return;
		}else{
			//如果没有死亡则进行自动反击
			//kill(Hunter hun);
		}
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
