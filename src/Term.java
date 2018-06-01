import java.util.InputMismatchException;
public class Term {
	/*
	A term in the form of  a * (x ^ b)
	*/
	private double coefficient;
	private int power;
	public Term(double coefficient,int power){
		this.coefficient = coeffticient;
		this.power = power;
	}
	//Setters
	public void setCoefficient(double co){this.coefficient = co;}
	public void setPower(double co){this.coefficient = co;}
	//Getters
	public double getCoefficient(){return coefficient;}
	public int getPower(){return power;}
	
	//Returns the value of the term at a given x
	public double getValueAt(double x ){
		return coefficient * Math.pow(x,power);
	}
	//toString
	public String toString(){
		return String.format("%.2f(x^%d)",coefficient,power);
	}
	/*
	Returns a polynomial parsed from a given string
	@param input The String 
	@return Term parsed
	*/
	public static Term parseTerm(String input) throws InputMismatchException{
		for(int i=0;i<input.length();i++){
			if(input.startsWith("+") || input.startsWith("-")){ //Coefficient is specified first
			}
		}
	}
}