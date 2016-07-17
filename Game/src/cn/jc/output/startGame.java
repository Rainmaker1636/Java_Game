package cn.jc.output;
/**
 * @function:程序入口
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hunter h = new Hunter();
		//对象赋值
		h.name = "奥特曼";
		h.life = 100;
		h.weapon = "短剑";
		h.isLive = true;
		//对象赋值
		Monster mon = new Monster();
		mon.type = "小怪兽";
		mon.life = 50;
		mon.isLive = true;
		//发起进攻
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
