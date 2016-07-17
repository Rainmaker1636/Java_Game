package cn.jc.output;
/**
 * @function:有关Monster操作
 * @author:Mrdong916
 */
public class Monster {
	private String monsterName;//怪兽名字
	private boolean isLive;//生命状态
	private int life;//生命值
	private int monsterAttack;//攻击力
	private int monsterrDefend;//防御力
	
	//构造函数 对怪兽进行初始化
	public Monster(int monType){
		//判断哪种类型的怪兽,并对不同的怪兽类型进行初始化
		if(monType==1){
			this.monsterName = "小怪兽";
			this.life = 60;
			this.isLive = true;
			this.monsterAttack = 20;
			this.monsterrDefend = 10;
		}else if(monType==2){
			this.monsterName = "大怪兽";
			this.life = 1000;
			this.isLive = true;
			this.monsterAttack = 30;
			this.monsterrDefend = 20;
		}else if(monType==3){
			this.monsterName = "超级怪兽";
			this.life = 150;
			this.isLive = true;
			this.monsterAttack = 50;
			this.monsterrDefend = 30;
		}
	}
	
	//set get方法访问保护属性
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
		return monsterrDefend;
	}

	public void setMonsterrDefend(int monsterrDefend) {
		this.monsterrDefend = monsterrDefend;
	}

	//怪兽攻击方法
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
		hun.injured(this.monsterAttack);
		hun.show();
	}
	//怪兽受伤方法     奥特曼攻击时调用怪兽受伤方法时，传递 奥特曼的攻击力
	public void injured(int hunterAttack){
		life = life + this.monsterrDefend - hunterAttack - 20;
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
	//怪兽死亡
	public void dead(){
		System.out.println("呜呜啊啊啊啊~~~");
		isLive = false;
	}
	//怪兽状态
	public void show(){
		System.out.println("========================");
		System.out.println(monsterName+"状态");
		System.out.println("生命值："+life+"\n死亡状态："+!isLive);
		System.out.println("========================");
	}
}
