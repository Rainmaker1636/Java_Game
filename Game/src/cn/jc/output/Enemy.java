package cn.jc.output;

class Enemy {
	private String enemyName;//怪兽名字
	private boolean isLive;//生命状态
	private int life;//生命值
	private int enemyAttack;//攻击力
	private int enemyDefend;//防御力
	private int exp;//怪兽所带经验值
	private int enemyAgile;//敏捷度
	
	//set get方法访问保护属性
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
	//怪兽攻击方法
	public void kill(Hunter hun){
		//判断enemy是否死亡
		if(life<=0){
			return;
		}
		//判断hunter是否死亡
		if(!hun.getisLive()){
			return;
		}
		//继续攻击，hunter受伤
		System.out.println(enemyName+"开始进攻");
		hun.injured(this);//this 指向自己将自己传递过去，使hunter受伤
	}
	
	//怪兽受伤方法     奥特曼攻击时调用怪兽受伤方法时，传递 奥特曼的攻击力
	public void injured(Hunter hun){//此处的Hunter hun就是传递过来的的this
		//怪兽进行闪躲
		if(GameUtil.hidden(this.enemyAgile)){
			System.out.println(enemyName+"闪避成功");
		}else{
			//怪兽受伤
				this.life = this.life - GameUtil.hurt(hun.getHunterAttack(),this.enemyDefend);
			System.out.println(enemyName+":噢呜呜呜呜呜呜呜呜~~~");
			//判断是否死亡
			if(life<=0){
				dead(hun);
				return;
			}
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
		hun.expAdd(this);
		System.out.println(this.enemyName+"已经死亡！");
		hun.show();
	}
	//怪兽状态
	public void show(){
		System.out.println("==========^===========");
		System.out.println("人物:"+enemyName);
		System.out.println("生命值:"+life);
		System.out.println("攻击力:"+enemyAttack);
		System.out.println("防御力:"+enemyDefend);
		System.out.println("生命状态:"+GameUtil.isLive(this.isLive));
		System.out.println("==========V===========");
	}
}
