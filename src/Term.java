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
	//toString
	public String toString(){
		return String.format("%.2f*(x^%d)",coefficient,power);
	}
	/*
	Returns a polynomial parsed from a given string
	@param input The String 
	@return Term parsed
	*/
	public static Term parseTerm(String input) throws InputMismatchException{
		double coefficient = -1;
		int power = -1;
		for(int i=0;i<input.length();i++){
			
			if(input.startsWith("+") || input.startsWith("-")||Character.isDigit(input.charAt(i))){//Coefficient is specified 
				String coeff = "";
				for(;i<input.length() && input.charAt(i) != '*';i++ ){ //Loops as long as the user hasn't entered *
					coeff += input.charAt(i);
				}
				coefficient = Double.parseDouble(coeff); //saving coefficient
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
		if(power == -1 || coefficient == -1) throw new InputMismatchException();
		else return new Term(coefficient,power);
	}
}