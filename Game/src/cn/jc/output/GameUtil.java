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
