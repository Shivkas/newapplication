package Test;
import java.util.Random;
public class passwordgenerator {
public static int generate() {
int c=(getRandomNumberInRange(1000,9999));
return c;
}
private static int getRandomNumberInRange(int min,int max) {
	Random r=new Random();
	return r.nextInt((max-min)+1)+min;
}
}
