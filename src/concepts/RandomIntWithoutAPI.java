package concepts;

public class RandomIntWithoutAPI implements Runnable{

	static int i=0;

	public static void main(String[] args) {		
		Thread t = new Thread( new RandomIntWithoutAPI());
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