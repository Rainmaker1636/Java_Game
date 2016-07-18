package cn.jc.output;
/**
 * @function:程序入口
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		//使用有参构造函数
		Hunter h = new Hunter("奥特曼","奥特之光");
		Monster mon1 = new Monster(1);
		Monster mon2 = new Monster(2);
		Monster mon3 = new Monster(3);
		Monster mon4 = new Monster(3);
		Monster mon5 = new Monster(3);
		
		//发起进攻
		h.fight(mon1);//奥特曼进攻
		h.fight(mon2);//奥特曼进攻
		h.fight(mon3);//奥特曼进攻
		h.fight(mon4);
		h.fight(mon5);
	}

}
