import java.util.ArrayList;
import java.util.InputMismatchException;
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
	public static Polynomial parsePolynomial(String input) throws InputMismatchException{
		ArrayList<Term> terms = new ArrayList<Term>();
		for(int i=0;i<input.length();i++){//Loops through every character
			String termData = "";
			
			while(i <input.length() && input.charAt(i) != '+' &&  input.charAt(i) != '-'){ //Until we find the next term
				termData += input.charAt(i);
				i++;
			}
			terms.add(Term.parseTerm(termData));
			
		}
		return new Polynomial(terms);
	}
	
	/*
	Returns string representation of the polynomial
	*/
	public String toString(){
		String res = "";
		for(Term term: terms) res += term.toString();
		return res;
	}
	//Helper methods
	public static String removeWhiteSpace(String in){
		in = in.trim();
		String result = "";
		for(int i =0 ; i<in.length() ; i++){
			char ch = in.charAt(i);
			if(ch != ' ' && ch != '\t'){
				result += ch;
			}
		}
		return result;
	}
	
}