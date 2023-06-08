import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String primer = s.nextLine();
        String[] actions = {"+", "-", "/", "*"};       //Задаем массив типа стринг из 4 арифм. действий
        int index = -1;
        for (int i = 0; i < actions.length; i++) {
            if (primer.contains(actions[i])) {
                index = i;                             //Выделяем это действие переменной index
            }
        }

        if (index == -1) {
            throw new RuntimeException();
        }
        String[] ekranActions = {"\\+", "-", "/", "\\*"};         //Задаем массив с экранированными арифм. действиями
        String[] chisla = primer.split(ekranActions[index]);      //Получаем массив типа стринг из двух введённых чисел,
                                                                  // этот массив в  переменной chisla




        if (isArabian(chisla[0]) && isArabian(chisla[1])) {                       //если оба числа арабские
            System.out.println(calc(primer));

        } else if (isRoman(chisla[0]) && isRoman(chisla[1]))  {                   //если оба числа римские

            if(primer.contains("+")) {
                int c = convToArab(chisla[0]) + convToArab(chisla[1]);
                System.out.println(convToRim(c));
            } else if (primer.contains("-")) {
                int c = convToArab(chisla[0]) - convToArab(chisla[1]);
                System.out.println(convToRim(c));
            } else if (primer.contains("/")) {
                int c = convToArab(chisla[0]) / convToArab(chisla[1]);
                System.out.println(convToRim(c));
            } else if (primer.contains("*")) {
                int c = convToArab(chisla[0]) * convToArab(chisla[1]);
                System.out.println(convToRim(c));
            }

        } else if (isRoman(chisla[0]) && isArabian(chisla[1])) {                  //если первое римское, а второе арабское
            throw new RuntimeException();

        } else if (isArabian(chisla[0]) && isRoman(chisla[1])) {                  //если первое арабское, а второе римское
            throw new RuntimeException();
        } else {
            throw new RuntimeException();
        }


    }

    public static String convToRim(int k) {
        String[] romanAll = {"в римской системе нет нуля", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        for(int i = 0; i<= romanAll.length; i++) {
            if (k == Arrays.asList(romanAll).indexOf(romanAll[i])) {
                String str = romanAll[i];                                                          //метод возвращает римское число
                if (str == romanAll[0]) {
                    throw new RuntimeException();
                }
                return str;                                                                        //если его применить к арабскому числу от 1 до 100

            }
        }
        String str = "";
        return str;

    }

    public static  int convToArab(String str){                                                     // метод возвращает арабское число
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};       // если его применить к римскому числу <= X
        for( int i = 0; i<=roman.length; i++) {
            if (roman[i].equals(str)) {
                return i;
            }

        }
        return -1;

    }

    public static boolean isRoman(String str){                                                    //метод возвращает true если число римское
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};      //и false если нет
        for (int i = 0; i<roman.length; i++) {
            if(roman[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArabian(String str){                                                  //метод возвращает true если число арабское
        String[] arabian = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};              // и false если нет
        for( int i = 0; i<arabian.length; i++) {
            if(arabian[i].equals(str)) {
                return true;
            }

        }
        return false;


    }





    public static String calc(String primer) throws RuntimeException{                //метод берет на вход строку, выдает результат арифм. действия.
        String[] actions = {"+", "-", "/", "*"};                                    //Задаем массив типа стринг из 4 арифм. действий
        String str = new String();
        int index = -1;
        for (int i = 0; i < actions.length; i++) {
            if (primer.contains(actions[i])) {
                index = i;                                   //Выделяем это действие переменной index
            }

        }
        String[] ekranActions = {"\\+", "-", "/", "\\*"};
        String[] chisla = primer.split(ekranActions[index]);
        if (chisla.length>2) {
            throw new RuntimeException();                    //добавил забытое исключение
        }

        if (index == 0) {
            int a = Integer.parseInt(chisla[0]) + Integer.parseInt(chisla[1]);
            str = "" + a;
            return str;

        } else if (index == 1) {
            int a = Integer.parseInt(chisla[0]) - Integer.parseInt(chisla[1]);
            str = "" + a;
            return str;

        } else if (index == 2) {
            int a = Integer.parseInt(chisla[0]) / Integer.parseInt(chisla[1]);
            str = "" + a;

        } else if (index == 3) {
            int a = Integer.parseInt(chisla[0]) * Integer.parseInt(chisla[1]);
            str = "" + a;
        } else {
            System.out.println("ошибка");
        }
        return str;
    }

}