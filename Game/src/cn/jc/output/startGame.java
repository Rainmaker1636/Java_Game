package cn.jc.output;
/**
 * @function:程序入口
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		//使用有参构造函数
		Hunter h = new Hunter();
		Monster mon = new Monster(3);
		
		//发起进攻
		h.fight(mon);//奥特曼进攻
		mon.kill(h);//怪兽进攻
		h.fight(mon);
		mon.kill(h);
		h.fight(mon);
		mon.kill(h);
		h.fight(mon);
		mon.kill(h);
		h.fight(mon);
		mon.kill(h);
		h.fight(mon);
		mon.kill(h);
	}

}
