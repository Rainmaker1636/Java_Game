package cn.jc.output;
/**
 * @function:�������
 * @author:Mrdong916
 */
public class startGame {

	public static void main(String[] args) {
		//ʹ���вι��캯��
		Hunter h = new Hunter("������","����֮��");
		Monster mon1 = new Monster(1);
		Monster mon2 = new Monster(2);
		Monster mon3 = new Monster(3);
		Monster mon4 = new Monster(3);
		Monster mon5 = new Monster(3);
		
		//�������
		h.fight(mon1);//����������
		h.fight(mon2);//����������
		h.fight(mon3);//����������
		h.fight(mon4);
		h.fight(mon5);
	}

}
