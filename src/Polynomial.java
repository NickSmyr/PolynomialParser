import java.util.ArrayList;
public class Polynomial{
	private ArrayList<Term> terms;
	private Polynomial(){
		this.terms = new ArrayList<Term>();
	}
	private Polynomial(ArrayList<Term> terms){
		this.terms = terms;
	}
	/*
	Returns a polynomial parsed from a given string
	@param input The String 
	*/
	public static Polynomial parsePolynomial(String input){
		input = removeWhiteSpace(input);
		for(int i=0;i<input.length();i++){//Loops through every character
			while(input.charAt(i) != '+' &&  input.charAt(i) != '-'){ //Until we find the next term
				
			}
		}	
	}
	
	/*
	Returns string representation of the polynomial
	*/
	public String toString(){
		String res;
		for(Term term: terms) res += term.toString();
		return res
	}
	//Helper methods
	public static String removeWhiteSpace(String in){
		in = in.trim();
		String result = "";
		for(Char ch : in){
			if(ch != ' ' && ch != '\t'){
				result += ch;
			}
		}
		return result;
	}
	
}