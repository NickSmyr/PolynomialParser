public class mainApp{
	public static void main(String[] args){
		String input = "";
		for(String in : args){
			input += in;
		}
		Polynomial pol = Polynomial.parsePolynomial(input);
		System.out.println(pol);
	}
}