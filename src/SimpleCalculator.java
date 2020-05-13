import java.util.*;

public class SimpleCalculator {
	private static double result = 0.0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		calcOn();
		program(input);
	}

	public static void program(Scanner input) {
		String console = input.next().toLowerCase();
		while (!console.equals("r")) {
			char symbol = console.charAt(0);
			double number = Double.parseDouble(console.substring(1));
			performCalculation(symbol, number);
			console = input.next().toLowerCase();
		}
		System.out.println("Final result = " + result);
		System.out.println("Again? (y/n)");
		String again = input.next().toLowerCase();
		if (again.equals("y")) {
			calcOn();
			result = 0.0;
			program(input);
		} else {
			System.out.println("End of Program");
		}
	}

	public static void printResult(char symbol, double number) {
		System.out.println("result " + symbol + " " + number + " = " + result);
		System.out.println("updated result = " + result);
	}

	public static void performCalculation(char symbol, double number) {
		try {
			if (symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/') {
				throw new UnknownOperatorException("Unknown operator! Try again");
			}
		} catch (UnknownOperatorException e) {
			System.out.println(e.getMessage());

		}

		if (symbol == '+') {
			result += number;
			printResult(symbol, number);
		} else if (symbol == '-') {
			result -= number;
			printResult(symbol, number);
		} else if (symbol == '*') {
			result *= number;
			printResult(symbol, number);
		} else if (symbol == '/') {
			result /= number;
			printResult(symbol, number);
		}

	}

	public static void calcOn() {
		System.out.println("Calculator is on.\nresult = 0.0");
	}
}