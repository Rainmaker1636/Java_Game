package cn.jc.output;

public class GameUtil {
	//闪躲函数
	public static boolean hidden(int agile){
		int random = (int) (Math.random() * (100-1) +1);//随机生成1-100之间的整数
		//如果随机数小于等于闪躲率则躲避成功
		if(agile*60/100>=random){
			return true;
		}else{
			return false;
		}		
	}
	//判断伤害值 当调用时则直接返回所剩生命值
	public static int hurt(int currentLife,int attack, int defend){
		//如果敌方攻击力小于我方的防御力则直接受伤10
		if(attack-defend>0){
			return  (currentLife + defend-attack-10);
		}else{
			return currentLife-10;
		}
	}
	
	//死亡输出判断
	public static String isLive( boolean isLive){
		String live;
		if(isLive){
			live = "正常";
		}else{
			live = "死亡";
		}
		return live;
	}
}
