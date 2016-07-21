package cn.jc.output;
/**
 * @Function:�й�Monster����
 * @Author:Mrdong916
 */
public class Monster extends Enemy {
	public Monster(int monType){
		//�ж��������͵Ĺ���,���Բ�ͬ�Ĺ������ͽ��г�ʼ��
		if(monType==1){
			this.setEnemyName("С����"); 
			this.setLife(30); 
			this.setLive(true);
			this.setEnemyAttack(15);
			this.setEnemyDefend(10);
			this.setExp(this.getLife());
			this.setEnemyAgile(10);
		}else if(monType==2){
			this.setEnemyName("�����"); 
			this.setLife(50); 
			this.setLive(true);
			this.setEnemyAttack(20);
			this.setEnemyDefend(15);
			this.setExp(this.getLife());
			this.setEnemyAgile(20);
		}else if(monType==3){
			this.setEnemyName("��������"); 
			this.setLife(80); 
			this.setLive(true);
			this.setEnemyAttack(30);
			this.setEnemyDefend(20);
			this.setExp(this.getLife());
			this.setEnemyAgile(30);
		}
	}
}
