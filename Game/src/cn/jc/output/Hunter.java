package cn.jc.output;
/**
 * @Function:有关Hunter操作
 * @Author:Mrdong916
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
	private int hunterAgile;//敏捷度
	private int hunterMaxAgile;
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHunterAgile() {
		return hunterAgile;
	}
	public void setHunterAgile(int hunterAgile) {
		this.hunterAgile = hunterAgile;
	}
	public int getHunterMaxAgile() {
		return hunterMaxAgile;
	}
	public void setHunterMaxAgile(int hunterMaxAgile) {
		this.hunterMaxAgile = hunterMaxAgile;
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
		this.hunterAgile = 10;//初始化敏捷度
		this.hunterMaxAgile = 100;//最高敏捷度
	}
	//使用有参构造函数对奥特曼进行初始化
	public Hunter(String hunterName,String weapon){
		this.hunterName = hunterName;
		this.isLive = true;
		this.maxLife = 50;
		this.currentLife = this.maxLife;
		this.hunterAttack = 20;//基础攻击力
		this.hunterDefend = 20;//基础防御力
		this.level = 1;//当前等级
		this.currentExperience = 0;//初始经验
		this.hunterAgile = 20;//初始化敏捷度
		this.hunterMaxAgile = 100;//最高敏捷度
		/**
		 * example:保护属性的两种赋值方法
		 * Author:Mrdong916
		 */
		//赋值给保护属性weapon的两种方法
		//方法一 >>>通过this指针来解决赋值问题
		this.weapon = weapon;
		//方法二>>>通过set方法来解决赋值问题
		//setWeapon(weapon);
	}
	//奥特曼攻击方法
	public void fight(Enemy enemy){
		
		//判断hunter是否死亡
		if(currentLife<=0){
			return;
		}
		
		//判断Monster是否死亡
		if(!enemy.isLive()){
			return;
		}
		
		//没有死亡，进行攻击,Monster受伤
		System.out.println(hunterName+"使用"+weapon+"开始进攻");
		enemy.injured(this); //调用怪兽受伤方法，将奥特曼的攻击力传递给怪兽受伤方法
	}
	//奥特曼受伤方法  怪兽攻击时调用奥特曼受伤方法时，传递 怪兽的攻击力
	public void injured(Enemy enemy){  //此处的Monster mon就是传递过来的this
		//调用闪躲如果闪躲成功直接避免伤害
		if(GameUtil.hidden(this.hunterAgile)){
			//如果闪躲成功则进行下面的操作
			System.out.println(hunterName+"闪避成功");
		}else{
			//调用公共受伤部分
			this.currentLife -= GameUtil.hurt( enemy.getEnemyAttack(), getHunterDefend());
			System.out.println(hunterName+":死怪物，居然敢打我！！！");
			//判断是否死亡
			if(currentLife<=0){
				dead(enemy);
				return;
			}
		}
		//显示状态
		show();
		//如果没有死亡则进行反击
		fight(enemy);
	}
	//奥特曼死亡方法
	public void dead( Enemy enemy){
		System.out.println(this.hunterName+"已经死亡！");
		System.out.println("我"+hunterName+"复活之时，定是你灭亡之日！！！");
		isLive = false;
		enemy.show();//显示一下敌人状态
	}
	//奥特曼状态
	public void show(){
		System.out.println("===========^===========");
		System.out.println("人物:"+hunterName);
		System.out.println("等级:"+level);
		System.out.println("攻击力:"+hunterAttack);
		System.out.println("防御力:"+hunterDefend);
		System.out.println("敏捷度:"+hunterAgile);
		System.out.println("生命状态:"+GameUtil.isLive(this.isLive));
		System.out.println("当前生命值"+currentLife+"/最大生命值"+maxLife);
		System.out.println("当前经验值"+getCurrentExperience()+"/升级经验值"+needExperience());
		System.out.println("===========V===========");
	}

	//升级经验值
	public int needExperience(){
		int needExperience = 0;
		for(int i = 1;i<=level;i++){
			needExperience = needExperience + 50 * i;
		}
		return needExperience;
	}
	//增加经验值功能
	public void expAdd(Enemy enemy){
		setCurrentExperience( getCurrentExperience() +enemy.getExp());//怪兽死后进行对当前经验增加
		System.out.println("战胜"+enemy.getEnemyName()+"获得"+enemy.getExp()+"经验！");
		//判断是否升级
		if(currentExperience>=needExperience()){
			//当现有的经验值大于升级所需经验值则进行升级
			hunterUpgrade();//调用升级方法
			return;
		}
	}
	//升级功能
	public void hunterUpgrade(){
		level ++;
		maxLife += 50;
		currentLife = maxLife;
		hunterAttack += 10;
		hunterDefend += 8;
		hunterAgile += 5;
		//当hunter敏捷度大于最大值时让其等于最大值
		if(this.hunterAgile>this.hunterMaxAgile){
			this.hunterAgile = this.hunterMaxAgile;
		}
		System.out.println(hunterName+"等级提升至"+level+"级！");
	}
}
