package cn.jc.output;
/**
 * @function:�������
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hunter h = new Hunter();
		//����ֵ
		h.name = "������";
		h.life = 100;
		h.weapon = "�̽�";
		h.isLive = true;
		//����ֵ
		Monster mon = new Monster();
		mon.type = "С����";
		mon.life = 50;
		mon.isLive = true;
		//�������
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
