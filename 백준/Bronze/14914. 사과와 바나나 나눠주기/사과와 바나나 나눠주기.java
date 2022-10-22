import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int apple = Integer.parseInt(st.nextToken());
		int banana = Integer.parseInt(st.nextToken());
		int person = 1;
		
		while(person <= apple && person <= banana)
		{
			if( (apple%person == 0) && (banana%person == 0) )
			{
				int divideApple = apple/person;
				int divideBanana = banana/person;
				System.out.println(person + " " + divideApple + " " + divideBanana);
			}
			person++;
		}
	}

}