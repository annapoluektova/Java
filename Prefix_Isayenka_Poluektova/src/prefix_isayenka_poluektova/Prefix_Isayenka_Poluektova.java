/*
 * Natallia Isayenka
 * Anna Poluektova
 */

package prefix_isayenka_poluektova;

import java.util.Scanner;

public class Prefix_Isayenka_Poluektova {

	public static void main(String[] args) {
		String test;
		IEvaluator ev;
		Scanner kb = new Scanner(System.in);
		do {
		System.out.print("Please enter your expression or 'q' to exit: ");
		test = kb.nextLine();
		if (!test.equalsIgnoreCase("q")){
			ev = new ExpressionEvaluator(test);
			System.out.println("Inflix expression: "+ev.GetInfixExpression());
			System.out.println("Result: "+ev.GetValue());
		}
		}while(!test.equalsIgnoreCase("q"));
	}

}