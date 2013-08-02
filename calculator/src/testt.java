import java.util.Scanner;




public class testt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Calculator calc = new Calculator();
	Scanner keyboard = new Scanner(System.in);
	while(true)
	{
		System.out.print(" > ");
		String input = keyboard.nextLine();
		System.out.println( " > " + calc.calculate(input));
	}

	}

}
