// Тестовое задание с исправленным вычитанием подстрок
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int num;
    static int v;
    static char oper;
    static String res;

    public static void main(String[] args) {
        System.out.println("Введите выражение");
        String inputString = scanner.nextLine();
        char[] chars = new char[27];

        for (int i = 0; i < inputString.length(); i++) { chars[i] = inputString.charAt(i);
            if (chars[i] == '+') {
                oper = '+';
            }
            if (chars[i] == '-') {
                oper = '-';
            }
            if (chars[i] == '*') {
                oper = '*';
            }
            if (chars[i] == '/') {
                oper = '/';
            }
        }


        String[] arg = inputString.split("[+-/*\"]");
        if (arg[1].length() > 10) {
            throw new IllegalArgumentException("Исключение: превышена длина введённого значения");
        }

        if (arg.length == 5) {
            String a = arg[1];
            String b = arg[4];
            res = calculated(a, b, oper);
        } else {
            String a = arg[1];
            String b = arg[3].trim();
            num = Integer.parseInt(b);
            if (num > 0 && num <= 10) {res = calculated2(a, num, oper);
            } else {throw new IllegalArgumentException("Исключение: недопустимое значение");
            }
        }
        if (res.length() > 40) {
            String resfinal = res.substring(0, 41);
            System.out.println(resfinal + "...");
        } else {
            System.out.println(res);
        }
    }

    public static String calculated(String a, String b, char oper) {
        switch (oper) {
            case '+':
                if (b.length() > 10) {
                    throw new IllegalArgumentException("Исключение: превышена длина введённого значения");
                } else {res = a + b;}
                break;
            case '-': //!!!
                if (b.length() > 10) {
                    throw new IllegalArgumentException("Исключение: превышена длина введённого значения");
                } else {
                    if (a.contains (b)) { res = a.replace (b, "");}
                    else {res = a;}};
                break;
            case '*':
                throw new IllegalArgumentException("Исключение: недопустимая операция");
            case '/':
                throw new IllegalArgumentException("Исключение: недопустимая операция");
            default:
                throw new IllegalArgumentException("Исключение");
        }
        return res;
    }
    public static String calculated2(String a, int num, char oper) {

        switch (oper) {
            case '+':
                throw new IllegalArgumentException("Исключение: недопустимое значение");
            case '-':
                throw new IllegalArgumentException("Исключение: недопустимое значение");
            case '*':
                for (int i1 = 0; i1 < num; i1++) {
                    res = a.repeat(num);
                }
                break;
            case '/':
                try {
                    int rB = a.length() / num;
                    res = a.substring(0, rB);
                } catch (ArithmeticException | InputMismatchException e) {
                    throw new IllegalArgumentException("Исключение");
                } finally {
                    if (a.length() < num) {
                        throw new IllegalArgumentException("Исключение");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Исключение");
        }
        return res;
    }
}