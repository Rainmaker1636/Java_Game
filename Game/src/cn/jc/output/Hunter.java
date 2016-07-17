package cn.jc.output;
/**
 * @function:�й�Hunter����
 * @author:Mrdong916
 */
public class Hunter {
	String hunterName;
	int    life;
	String weapon;
	boolean isLive;
	
	//ʹ�ù��캯�����и�ֵ
	public Hunter(String weapon){
		this.hunterName = "������";
		this.isLive = true;
		this.life = 100;
		this.weapon = weapon;
	}
	public void fight(Monster mon){
		
		//�ж�hunter�Ƿ�����
		if(life<=0){
			return;
		}
		
		//�ж�Monster�Ƿ�����
		if(!mon.isLive){
			return;
		}
		
		//û�����������й���,Monster����
		System.out.println(hunterName+"ʹ��"+weapon+"��ʼ����");
		mon.injured();
		mon.show();
	}
	public void injured(){
		life-=20;
		System.out.println(hunterName+":�������Ȼ�Ҵ��ң�����");
		//�ж��Ƿ�����
		if(life==0){
			dead();
		}
	}
	public void dead(){
		System.out.println("��"+hunterName+"����֮ʱ������������֮�գ�����");
		isLive = false;
	}
	public void show(){
		System.out.println("========================");
		System.out.println(hunterName+"״̬");
		System.out.println("����ֵ��"+life+"\n����״̬��"+!isLive);
		System.out.println("========================");
	}

}
