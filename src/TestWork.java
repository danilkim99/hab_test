import java.util.Scanner;
import java.util.InputMismatchException;

public class TestWork {
	
	static Scanner scanner = new Scanner(System.in);
	static int num1, num2, res, result;
	static char oper;
	
	public static void main(String[] args) {
		String userInput = scanner.nextLine();
		char[] data = new char[20];
		for (int i = 0; i < userInput.length(); i++) {
			data[i] = userInput.charAt(i);
			if(data[i] == '+') {
				oper = '+';
			}
			else if (data[i] == '-') {
				oper = '-';
			}
			else if(data[i] == '*') {
				oper = '*';
			}
			else if(data[i] == '/') {
				oper = '/';
			}
		}

// разделение элементов в строке на оператор и 2 числа без наличия лишних элементов
		String newdata = String.valueOf(data);
		
		String[] blacks = newdata.split("[+-/*]");
        String firstdigit = blacks[0];
        String seconddigit = blacks[1];
        String updfirstdigit = firstdigit.trim();
        String updsecdigit = seconddigit.trim();
		

//проверка перед началом решения
		res = check(updfirstdigit, updsecdigit);
			if(res==0) {
				res = check1(updfirstdigit, updsecdigit);
			}
	//	System.out.println(updfirstdigit);
	//	System.out.println(updsecdigit);
	//		System.out.println(res);
		
		checkres(res, updfirstdigit, updsecdigit, oper);
}
		
		
	
//Проверка на на индентичность цифр в строке
	 public static int check(String num1, String num2) {
		int res1 = 0;
		String [] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX", "X"};
		
		for(int i = 0; i < rome.length; i++) {
				if(num1.contains(rome[i])){ 
					for(int j = 0; j < rome.length; j++)
						if(num2.contains(rome[j]))
							res1 =2;
				}
		}
	return res1;
}
	 
	 public static int check1(String num1, String num2) {
			int res1 = 0;
			String [] arab = {"1","2","3","4","5","6","7","8","9","10"};

			for(int i = 0; i < arab.length; i++) {
				if(num1.contains(arab[i])){ 
					for(int j = 0; j < arab.length; j++)
						if(num2.contains(arab[j]))
							res1 =1;
			}
		}
		return res1;
	}
		
	
	 
		public static void checkres(int res, String number1, String number2, char operation) {
			int result;
			if (res == 1) {
				int num1 = Integer.parseInt(number1);
				int num2 = Integer.parseInt(number2);
				
				result = calc(num1, num2, operation);
				System.out.println(result);
			}
			else if(res == 2) {
				int num1 = romToNum(number1);
				int num2 = romToNum(number2);
				
				result = calc(num1, num2, operation);
				String finresult = String.valueOf(result);
				finresult = numtoroma(result);
				System.out.println(finresult);
			}
			else
				System.out.println("Ошибка");
			
		}

//Смена римских на арабские
	public static int romToNum(String roman) {
		if (roman.equals("I")) {
			return 1;
		}
		else if (roman.equals("II")) {
			return 2;
		}
		else if (roman.equals("III")) {
			return 3;
		}
		else if (roman.equals("IV")) {
			return 4;
		}
		else if (roman.equals("V")) {
			return 5;
		}
		else if (roman.equals("VI")) {
			return 6;
		}
		else if (roman.equals("VII")) {
			return 7;
		}
		else if (roman.equals("VIII")) {
			return 8;
		}
		else if (roman.equals("IX")) {
			return 9;
		}
		else if (roman.equals("X")) {
			return 10;
		}
		else {
			System.out.println("Неверный ввод данных");
		}
		return -1;
	}
	
	public static String numtoroma(int roman) {
		String res;
		String [] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C",};
		res = rome[roman];
		return res;
	}
	
	
//финальный расчет
	public static int calc (int num1, int num2, char oper) {
		int res = 0;
		switch(oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			if(num1 / num2 < 0) {
                System.out.println("На 0 делить нельзя");
                break;}
            else 
            	res = num1 / num2;
				break;
	
		default:
			System.out.println("Ошибка в вводе знака");
			break;
		}
		return res;
	}

}


