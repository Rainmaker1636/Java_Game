package cn.jc.output;
/**
 * @function:�й�Hunter����
 * @author:Mrdong916
 */
public class Hunter {
	String name;
	int    life;
	String weapon;
	boolean isLive;

	void fight(Monster mon){
		//�ж�hunter�Ƿ�����
		if(life<=0){
			return;
		}
		//�ж�Monster�Ƿ�����
		if(!mon.isLive){
			return;
		}
		//û�����������й���,Monster����
		System.out.println(name+"ʹ��"+weapon+"��ʼ����");
		mon.injured();
		mon.show();
	}
	void injured(){
		life-=20;
		System.out.println(name+":�������Ȼ�Ҵ��ң�����");
		//�ж��Ƿ�����
		if(life==0){
			dead();
		}
	}
	void dead(){
		System.out.println("��"+name+"����֮ʱ������������֮�գ�����");
		isLive = false;
	}
	void show(){
		System.out.println("���"+name+"\n����ֵ��"+life+"\n����״̬��"+!isLive);
		
		System.out.println("========================");
	}

}
