package cn.jc.output;
/**
 * @function:有关Hunter操作
 * @author:Mrdong916
 */
public class Hunter {
	private String hunterName;//名字
	private int life;//生命值
	private String weapon;//武器
	private boolean isLive;//生命状态
	private int hunterAttack;//攻击力
	private int hunterDefend;//防御力
	
	//set get方法访问保护的属性
	public String getHunterName() {
		return hunterName;
	}
	public void setHunterName(String hunterName) {
		this.hunterName = hunterName;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public boolean isLive() {
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
	//使用无参构造函数对奥特曼进行初始化// 暂时无用
	public Hunter(){
		this.hunterName = "奥特曼";
		this.isLive = true;
		this.life = 100;
		this.weapon = "拳头";//等于没有武器肉身进行攻击无任何攻击力加成
		this.hunterAttack = 30;//基础攻击力
		this.hunterDefend = 20;//基础防御力
	}
	//使用有参构造函数对奥特曼进行初始化
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.life = 100;
		this.hunterAttack = 30;//基础攻击力
		this.hunterDefend = 20;//基础防御力
		/**
		 * example:保护属性的两种赋值方法
		 * Author:Mrdong916
		 */
		//赋值给保护属性weapon的两种方法
		//方法一 >>>通过this指针来解决赋值问题
		this.weapon = weapon;
		//方法二>>>通过set方法来解决赋值问题
		//String setWeapon = weapon;
		//setWeapon(setWeapon);
	}
	//奥特曼攻击方法
	public void fight(Monster mon){
		
		//判断hunter是否死亡
		if(life<=0){
			return;
		}
		
		//判断Monster是否死亡
		if(!mon.isLive()){
			return;
		}
		
		//没有死亡，进行攻击,Monster受伤
		System.out.println(hunterName+"使用"+weapon+"开始进攻");
		mon.injured(this.hunterAttack); //调用怪兽受伤方法，将奥特曼的攻击力传递给怪兽受伤方法
		mon.show();
	}
	//奥特曼受伤方法  怪兽攻击时调用奥特曼受伤方法时，传递 怪兽的攻击力
	public void injured(int monsterAttack){
		life = life + this.getHunterDefend()-monsterAttack-20;
		System.out.println(hunterName+":死怪物，居然敢打我！！！");
		//判断是否死亡
		if(life==0){
			dead();
			return;
		}else{
			//如果没有死亡则进行反击
			//fight(Monster mon);
		}
		
	}
	//奥特曼受伤方法
	public void dead(){
		System.out.println("我"+hunterName+"复活之时，定是你灭亡之日！！！");
		isLive = false;
	}
	//奥特曼状态
	public void show(){
		System.out.println("========================");
		System.out.println(hunterName+"状态");
		System.out.println("生命值："+life+"\n死亡状态："+!isLive);
		System.out.println("========================");
	}

}
