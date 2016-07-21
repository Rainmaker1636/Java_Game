package cn.jc.output;

public class Game {
	Hunter hunter;
	Monster m1,m2,m3,m4,m5,m6;
	Vampire v1, v2,v3;
	public Game(){
		hunter = new Hunter("奥特曼","奥特之光");
		m1 = new Monster (1);
		m2 = new Monster (1);
		m3 = new Monster (1);
		m4 = new Monster (2);
		m5 = new Monster (2);
		m6 = new Monster (3);
		v1 = new Vampire (1);
		v2 = new Vampire (2);
		v3 = new Vampire (3);
	}
	public int random(){
		int ran = (int) (Math.random() * (9-1) +1);
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
			case 7:hunter.fight(v1);break;
			case 8:hunter.fight(v2);break;
			case 9:hunter.fight(v3);break;
			}
			//让程序休息3秒钟
			try{
				System.out.println("==============对手寻找中==============");
				Thread.sleep(3000);
			}
			catch(Exception e) {}
			
			//如果hunter死亡或者怪物死完就跳出执行end()
			if(!hunter.getisLive()){
				end();
				break;
			}else if(!m1.isLive()&&!m2.isLive()&&!m3.isLive()&&!m4.isLive()&&!m5.isLive()&&!m6.isLive()&&!v1.isLive()&&!v2.isLive()&&!v3.isLive()){
				end();
				break;
			}
		}
		
	}
	public void end(){
		System.out.println("++++++++Game Over+++++++");
		if(hunter.getisLive()){
			System.out.println("恭喜，世界终于得以恢复和平！");
		}else{
			System.out.println("不要灰心，世界和平全靠你了！");
		}
	}
}
/*			
 	
*/