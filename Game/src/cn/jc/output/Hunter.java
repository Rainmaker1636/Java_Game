package cn.jc.output;
/**
 * @function:有关Hunter操作
 * @author:Mrdong916
 */
public class Hunter {
	private String hunterName;//名字
	private int currentLife;//当前生命值
	private int maxLife;//最大生命值
	private String weapon;//武器
	private boolean isLive;//生命状态
	private int hunterAttack;//攻击力
	private int hunterDefend;//防御力	
	private int level;//等级
	private int currentExperience;//当前经验
	private int levelExperience;//等级经验

	
	//set get方法访问保护的属性
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
	public int getLevelExperience() {
		return levelExperience;
	}
	public void setLevelExperience(int levelExperience) {
		this.levelExperience = levelExperience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	//使用无参构造函数对奥特曼进行初始化// 暂时无用
	public Hunter(){
		this.hunterName = "奥特曼";
		this.weapon = "拳头";//等于没有武器肉身进行攻击无任何攻击力加成
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//基础攻击力
		this.hunterDefend = 10;//基础防御力
		this.level = 1;//当前等级
		this.currentExperience = 0;//初始经验
	}
	//使用有参构造函数对奥特曼进行初始化
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//基础攻击力
		this.hunterDefend = 10;//基础防御力
		this.level = 1;//当前等级
		this.currentExperience = 0;//初始经验
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
		if(currentLife<=0){
			return;
		}
		
		//判断Monster是否死亡
		if(!mon.isLive()){
			return;
		}
		
		//没有死亡，进行攻击,Monster受伤
		System.out.println(hunterName+"使用"+weapon+"开始进攻");
		mon.injured(this); //调用怪兽受伤方法，将奥特曼的攻击力传递给怪兽受伤方法
	}
	//奥特曼受伤方法  怪兽攻击时调用奥特曼受伤方法时，传递 怪兽的攻击力
	public void injured(Monster mon){  //此处的Monster mon就是传递过来的this
		//如果怪兽的攻击力小于奥特曼的防御力则直接减少10
		if(mon.getMonsterAttack()-this.getHunterDefend()>0){
			this.currentLife = this.currentLife + this.getHunterDefend()-mon.getMonsterAttack()-10;
		}else{
			this.currentLife-=10;
		}
		System.out.println(hunterName+":死怪物，居然敢打我！！！");
		//判断是否死亡
		if(currentLife<=0){
			dead(mon);
			return;
		}
		//显示状态
		show();
		//如果没有死亡则进行反击
		fight(mon);
		
	}
	//奥特曼受伤方法
	public void dead( Monster mon){
		System.out.println(this.hunterName+"已经死亡！");
		System.out.println("我"+hunterName+"复活之时，定是你灭亡之日！！！");
		isLive = false;
		mon.show();//显示一下敌人状态
	}
	//奥特曼状态
	public void show(){
		System.out.println("===========^===========");
		System.out.println("人物:"+hunterName);
		System.out.println("等级:"+level);
		System.out.println("攻击力:"+hunterAttack);
		System.out.println("防御力:"+hunterDefend);
		System.out.println("生命状态:"+isLive());
		System.out.println("当前生命值"+currentLife+"/最大生命值"+maxLife);
		System.out.println("当前经验"+getCurrentExperience()+"/下一等级经验"+getLevelExperience());
		System.out.println("===========V===========");
	}
	//死亡输出判断
	public String isLive(){
		String live;
		if(isLive){
			live = "正常";
		}else{
			live = "死亡";
		}
		return live;
	}
	/**
	 * Function:奥特曼升级功能
	 * Author:Mrdong916
	 */
	public void hunterUpdate(){
		
	}

}
