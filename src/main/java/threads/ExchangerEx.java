package threads;

import java.util.concurrent.Exchanger;

public class ExchangerEx {

	public final Exchanger<String> exchanger=new Exchanger<>();
	
	public String sendMessage(String message) throws InterruptedException {
		System.out.println(" in sendMessage sending"+message);
		String receivedMessage =exchanger.exchange(message);
		System.out.println(" in sendMessage received"+receivedMessage);
		return receivedMessage;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExchangerEx exchangerEx=new ExchangerEx();
		Thread producer=new Thread(()->{
			String messageString="Producer Thread";
			try {
			String rec=	exchangerEx.sendMessage(messageString);
			System.out.println("Producer received"+rec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread consumer=new Thread(()->{
			String messageString="Consumer Thread";
			try {
			String rec=	exchangerEx.sendMessage(messageString);
			System.out.println("consumer received"+rec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
	
	
}
