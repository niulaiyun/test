package thread;

import java.util.Map.Entry;

public class PushThread  extends Thread{
  @Override
   public void run() {
	try {
		sleep(6000);
		while (MainThread.pushmessage.size()>0) {
			//重发消息
			for(Entry<Integer, String> hashMap:MainThread.pushmessage.entrySet()) {
				 System.out.println("消息id:"+hashMap.getKey()+"未发送成功，在此重发:"+hashMap.getValue());
			}
			sleep(1000);
		}
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
   }
}
