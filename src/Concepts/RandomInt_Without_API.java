package Concepts;

public class RandomInt_Without_API implements Runnable{

	static int i=0;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {		
		Thread t = new Thread( new RandomInt_Without_API());
		t.start();		
		try {
			Thread.sleep(10);
			System.out.println(i);
			t.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		for(;;){
			if(i<101){
				i++;
				//System.out.println(i);
			} else{
				i=0;
			}
		}
	}
}