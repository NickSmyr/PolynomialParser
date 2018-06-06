import java.util.Scanner;
public class mainApp{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = "";
		System.out.println("Enter polynomial");
		input = sc.nextLine();
		Polynomial pol = Polynomial.parsePolynomial(input);
		System.out.println(pol);
	}
}