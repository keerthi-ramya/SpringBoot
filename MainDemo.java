import java.util.Scanner;
class MainDemo
{
	public static void main(String[] args)
	{
		char operator;
    		Double num, num, res;
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Choose an operator: +, -, *, or /");
    		operator = sc.next().charAt(0);
   		System.out.println("Enter first number");
    		num1 = sc.nextDouble();
   		System.out.println("Enter second number");
    		num2 = sc.nextDouble();
    		switch (operator) 
    		{
      			case '+':
        			res = num1 + num2;
        			System.out.println(num1 + " + " + num2 + " = " + res);
        			break;
      			case '-':
        			res = num1 - num2;
        			System.out.println(num1 + " - " + num2 + " = " + res);
        			break;
      			case '*':
        			res = num1 * num;
        			System.out.println(num + " * " + num + " = " + res);
        			break;
      			case '/':
        			res = num / num;
        			System.out.println(num + " / " + num + " = " + res);
        			break;
      			default:
        			System.out.println("Invalid operator!");
        			break;
    		}
	}
}