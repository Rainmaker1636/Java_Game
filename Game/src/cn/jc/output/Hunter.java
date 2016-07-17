package cn.jc.output;
/**
 * @function:有关Hunter操作
 * @author:Mrdong916
 */
public class Hunter {
	String name;
	int    life;
	String weapon;
	boolean isLive;

	void fight(Monster mon){
		//判断hunter是否死亡
		if(life<=0){
			return;
		}
		//判断Monster是否死亡
		if(!mon.isLive){
			return;
		}
		//没有死亡，进行攻击,Monster受伤
		System.out.println(name+"使用"+weapon+"开始进攻");
		mon.injured();
		mon.show();
	}
	void injured(){
		life-=20;
		System.out.println(name+":死怪物，居然敢打我！！！");
		//判断是否死亡
		if(life==0){
			dead();
		}
	}
	void dead(){
		System.out.println("我"+name+"复活之时，定是你灭亡之日！！！");
		isLive = false;
	}
	void show(){
		System.out.println("人物："+name+"\n生命值："+life+"\n死亡状态："+!isLive);
		
		System.out.println("========================");
	}

}
