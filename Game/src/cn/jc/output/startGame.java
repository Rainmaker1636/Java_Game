package cn.jc.output;
/**
 * @function:�������
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hunter h = new Hunter("����֮��");
		Monster mon = new Monster(3);//���踳ֵ ʹ�ù��캯���Ѿ����и�ֵ
		
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
