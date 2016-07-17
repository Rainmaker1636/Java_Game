package cn.jc.output;
/**
 * @function:程序入口
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hunter h = new Hunter("奥特之光");
		Monster mon = new Monster(3);//无需赋值 使用构造函数已经进行赋值
		
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
