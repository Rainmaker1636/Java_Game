package cn.jc.output;
/**
 * @function:程序入口
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hunter h = new Hunter();
		h.name = "奥特曼";
		h.life = 100;
		h.weapon = "短剑";
		h.isLive = true;
		
		Monster mon = new Monster();
		mon.type = "小怪兽";
		mon.life = 50;
		mon.isLive = true;
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
