import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
	ArrayList<String> operators;
	ArrayList<Double> numbers;
	Map <String, Double> variables;
	
	public double assign(String variable, String value)
	{
		double val = evalulate(value);
		variables.put(variable, val);
		return val;
	}
	public Calculator()
	{
		operators = new ArrayList<String>();
		numbers = new ArrayList <Double> ();
		variables = new HashMap <String, Double>();
	}
	public double calculate(String expr){
		String[] parts = expr.split(" ");
		if (parts.length > 2 && parts[1].equals("="))
		{
			String value = expr.substring(expr.indexOf("=") + 1); 
			return assign(parts[0],value);
		}
		else
		{
			return evalulate(expr);
		}
	}
	/**
	 * This method takes a string and calculates it.
	 * @param expr
	 * @return
	 */
	public double evalulate(String expr)
	{
		numbers.clear();
		operators.clear();
		
		String[] parts = expr.split("((?=(\\+|\\-|\\*|\\/|\\(|\\)))|(?<=(\\+|\\-|\\*|\\/|\\(|\\))))");
		for (String part : parts){
			part = part.trim();
			if(part.length()==0){
				continue;
			}
			if(part.equals("("))
			{
				addOperator(part);
			}
			else if(part.equals(")"))
			{
				while( ! operators.get(operators.size()-1).equals("("))
				{
					reduce();
				}
				operators.remove(operators.size()-1);
			}
			else if(variables.containsKey(part)){
				addNumber(variables.get(part));
			}
			else if(isNumber(part)){
				addNumber(part);
			}
			else
			{
				addOperator(part);
			}
		}
		while(numbers.size()>1){
			reduce();
		}
		return numbers.get(0);
	}
	private void reduce()
	{
		double num2 = numbers.remove(numbers.size()-1);
		double num1 = numbers.remove(numbers.size()-1);
		String op = operators.remove(operators.size()-1);;
		if (op.equals("+"))
		{
			numbers.add(num1 + num2);
		}
		if (op.equals("-"))
		{
			numbers.add(num1 - num2);
		}
		if (op.equals("*"))
		{
			numbers.add(num1 * num2);
		}
		if (op.equals("/"))
		{
			numbers.add(num1 / num2);
		}
	}
	private void addNumber(String number)
	{
		double value = Double.parseDouble(number);
		numbers.add(value);
	}
	private void addNumber(double number)
	{
		numbers.add(number);
	}
	private boolean isNumber(String str){
		return str.matches("\\d+(|\\.\\d*)");
	}
	private void addOperator(String op)
	{
		if(operators.size() > 0 && ! op.equals("(")){
			while (getPrecedence(operators.get(operators.size()-1)) >=
					getPrecedence(op)) {
				reduce();
			}
		}
		operators.add(op);
	}
	private double getPrecedence(String op)
	{
		if(op.equals("+"))
		{
			return 1;
		}
		if(op.equals("-"))
		{
			return 1;
		}
		if(op.equals("*"))
		{
			return 2;
		}
		if(op.equals("/"))
		{
			return 2;
		}
		return 0;
	}
}
