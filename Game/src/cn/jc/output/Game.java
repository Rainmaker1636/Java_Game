package cn.jc.output;

public class Game {
	Hunter hunter;
	Monster m1,m2,m3,m4,m5,m6;
	public Game(){
		hunter = new Hunter("������","����֮��");
		m1 = new Monster(1);
		m2 = new Monster(1);
		m3 = new Monster(1);
		m4 = new Monster(2);
		m5 = new Monster(2);
		m6 = new Monster(3);
	}
	public int random(){
		int ran = (int) (Math.random() * (6-1) +1);
		return ran;
	}
	public void start(){
		System.out.println("++++++++Game Start+++++++");
		while(true){
			switch(random()){
			case 1:hunter.fight(m1);break;
			case 2:hunter.fight(m2);break;
			case 3:hunter.fight(m3);break;
			case 4:hunter.fight(m4);break;
			case 5:hunter.fight(m5);break;
			case 6:hunter.fight(m6);break;
			}
			//�ó�����Ϣ3����
			try{
				System.out.println("==============����Ѱ����==============");
				Thread.sleep(3000);
			}
			catch(Exception e) {}
			
			//���hunter�������߹������������ִ��end()
			if(!hunter.getisLive()){
				end();
				break;
			}else if(!m1.isLive()&&!m2.isLive()&&!m3.isLive()&&!m4.isLive()&&!m5.isLive()&&!m6.isLive()){
				end();
				break;
			}
		}
		
	}
	public void end(){
		System.out.println("++++++++Game Over+++++++");
		if(hunter.getisLive()){
			System.out.println("��ϲ���������ڵ��Իָ���ƽ��");
		}else{
			System.out.println("��Ҫ���ģ������ƽȫ�����ˣ�");
		}
	}
}
/*			
 	
*/