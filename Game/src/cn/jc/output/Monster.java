package cn.jc.output;
/**
 * @function:ÓĞ¹ØMonster²Ù×÷
 * @author:Mrdong916
 */
public class Monster {
	String type;
	boolean isLive;
	int life;
	
	void kill(Hunter hun){
		//ÅĞ¶ÏMonsterÊÇ·ñËÀÍö
		if(life<=0){
			return;
		}
		//ÅĞ¶ÏhunterÊÇ·ñËÀÍö
		if(!hun.isLive){
			return;
		}
		//¼ÌĞø¹¥»÷£¬hunterÊÜÉË
		System.out.println(type+"¿ªÊ¼½ø¹¥");
		hun.injured();
		hun.show();
	}
	void injured(){
		life -= 20;
		System.out.println(type+":àŞÎØÎØÎØÎØÎØÎØÎØÎØ~~~");
		//ÅĞ¶ÏÊÇ·ñËÀÍö
		if(life<=0){
			dead();
		}
	}
	void dead(){
		System.out.println("ÎØÎØ°¡°¡°¡°¡~~~");
		isLive = false;
	}
	void show(){
		System.out.println(type+"\nÉúÃüÖµ£º"+life+"\nËÀÍö×´Ì¬£º"+!isLive);
		System.out.println("========================");
	}
}
