package cn.jc.output;
/**
 * @function:�������
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		//ʹ���вι��캯��
		Hunter h = new Hunter();
		Monster mon = new Monster(3);
		
		//�������
		h.fight(mon);//����������
		mon.kill(h);//���޽���
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
