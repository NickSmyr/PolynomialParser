import java.util.InputMismatchException;
public class Term {
	/*
	A term in the form of  a * (x ^ b)  Parenthesis required
	*/
	private double coefficient;
	private int power;
	public Term(double coefficient,int power){
		this.coefficient = coefficient;
		this.power = power;
	}
	//Setters
	public void setCoefficient(double co){this.coefficient = co;}
	public void setPower(int pow){this.power = pow;}
	//Getters
	public double getCoefficient(){return coefficient;}
	public int getPower(){return power;}
	
	//Returns the value of the term at a given x
	public double getValueAt(double x ){
		return coefficient * Math.pow(x,power);
	}
	@Override
	public String toString(){
		StringBuilder coeffStr = new StringBuilder(String.format("%.2f",coefficient));
		if(coefficient > 0) coeffStr.insert(0, "+" );
		return String.format("%s * (x ^ %d) ",coeffStr.toString(),power);
	}
	/*
	Returns a polynomial parsed from a given string
	@param input The String 
	@return Term parsed
	*/
	public static Term parseTerm(String input) throws InputMismatchException{
		System.out.println(input);
		double coefficient = -1;
		int power = -1;
		boolean coefficient_found = false;
		input = input.trim();
		int i = 0;
		int temp = 1; //Spaghetii pls
		if(input.startsWith("-")) {
			temp = -1;
			i=1;
		}
		else if(input.startsWith("+")) {
			temp = 1;
			i=1;
		}
		for(;i<input.length();i++){
		
			if(Character.isDigit(input.charAt(i))){//Coefficient is specified 
				String coeff = "";						
				for(;i<input.length() && input.charAt(i) != '*';i++ ){ //Loops as long as the user hasn't entered *
					coeff += input.charAt(i);
				}
				coefficient = temp * Double.parseDouble(coeff); //saving coefficient
				coefficient_found = true;
			}
			if(i<input.length() && input.charAt(i) == '('){
				String pow="";
				for(; i<input.length() && input.charAt(i) != ')' ;i++){ //Loops until we find the power of the number x 
					if(Character.isDigit(input.charAt(i))) pow += input.charAt(i);
				}
				power = Integer.parseInt(pow); //Saving power
				
			}		
		}
		//Data check
		if(! coefficient_found) coefficient = 1;
		if(power <= -1 ) throw new InputMismatchException();
		else return new Term(coefficient,power);
	}
}