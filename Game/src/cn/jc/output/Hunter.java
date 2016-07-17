package cn.jc.output;
/**
 * @function:有关Hunter操作
 * @author:Mrdong916
 */
public class Hunter {
	String hunterName;
	int    life;
	String weapon;
	boolean isLive;
	
	//使用构造函数进行赋值
	public Hunter(String weapon){
		this.hunterName = "奥特曼";
		this.isLive = true;
		this.life = 100;
		this.weapon = weapon;
	}
	public void fight(Monster mon){
		
		//判断hunter是否死亡
		if(life<=0){
			return;
		}
		
		//判断Monster是否死亡
		if(!mon.isLive){
			return;
		}
		
		//没有死亡，进行攻击,Monster受伤
		System.out.println(hunterName+"使用"+weapon+"开始进攻");
		mon.injured();
		mon.show();
	}
	public void injured(){
		life-=20;
		System.out.println(hunterName+":死怪物，居然敢打我！！！");
		//判断是否死亡
		if(life==0){
			dead();
		}
	}
	public void dead(){
		System.out.println("我"+hunterName+"复活之时，定是你灭亡之日！！！");
		isLive = false;
	}
	public void show(){
		System.out.println("========================");
		System.out.println(hunterName+"状态");
		System.out.println("生命值："+life+"\n死亡状态："+!isLive);
		System.out.println("========================");
	}

}
