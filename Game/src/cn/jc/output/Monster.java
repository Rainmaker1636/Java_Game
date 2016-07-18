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
	private int monsterDefend;//防御力
	private int exp;//怪兽所带经验值
	
	//构造函数 对怪兽进行初始化
	public Monster(int monType){
		//判断哪种类型的怪兽,并对不同的怪兽类型进行初始化
		if(monType==1){
			this.monsterName = "小怪兽";
			this.life = 30;
			this.isLive = true;
			this.monsterAttack = 10;
			this.monsterDefend = 10;
			this.exp = this.life;
		}else if(monType==2){
			this.monsterName = "大怪兽";
			this.life = 40;
			this.isLive = true;
			this.monsterAttack = 20;
			this.monsterDefend = 20;
			this.exp = this.life;
		}else if(monType==3){
			this.monsterName = "超级怪兽";
			this.life = 50;
			this.isLive = true;
			this.monsterAttack = 30;
			this.monsterDefend = 30;
			this.exp = this.life;
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
		return monsterDefend;
	}

	public void setMonsterrDefend(int monsterrDefend) {
		this.monsterDefend = monsterrDefend;
	}

	//怪兽攻击方法
	public void kill(Hunter hun){
		//判断Monster是否死亡
		if(life<=0){
			return;
		}
		//判断hunter是否死亡
		if(!hun.getisLive()){
			return;
		}
		//继续攻击，hunter受伤
		System.out.println(monsterName+"开始进攻");
		hun.injured(this);//this 指向自己将自己传递过去，使hunter受伤
	}
	//怪兽受伤方法     奥特曼攻击时调用怪兽受伤方法时，传递 奥特曼的攻击力
	public void injured(Hunter hun){//此处的Hunter hun就是传递过来的的this
		if(hun.getHunterAttack()-this.monsterDefend>0){
			life = life + this.monsterDefend - hun.getHunterAttack() - 10;
		}else{
			life-=10;
		}
		System.out.println(monsterName+":噢呜呜呜呜呜呜呜呜~~~");
		//判断是否死亡
		if(life<=0){
			dead(hun);
			return;
		}
		//显示状态
		show();
		//如果没有死亡则进行自动反击
		kill(hun);
	}
	//怪兽死亡
	public void dead(Hunter hun){
		System.out.println("呜呜啊啊啊啊~~~");
		isLive = false;
		hun.setCurrentExperience( hun.getCurrentExperience() + exp);//怪兽死后进行对当前经验增加
		System.out.println(this.monsterName+"已经死亡！");
		hun.show();
	}
	//怪兽状态
	public void show(){
		System.out.println("==========^===========");
		System.out.println("人物:"+monsterName);
		System.out.println("生命值:"+life);
		System.out.println("攻击力:"+monsterAttack);
		System.out.println("防御力:"+monsterDefend);
		System.out.println("生命状态:"+isLive2());
		System.out.println("==========V===========");
	}
	//死亡输出判断
		public String isLive2(){
			String live;
			if(this.isLive){
				live = "正常";
			}else{
				live = "死亡";
			}
			return live;
		}
}
