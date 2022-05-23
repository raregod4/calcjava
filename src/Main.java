import java.util.Scanner;

public class Main {

    static int convertFromRoman(String number)
    {
        switch (number)
        {
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case("VI"):
                return 6;
            case("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;
            default:
                return 0;
        }
    }
    static String convertToRoman(int number)
    {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[number - 1];
    }
    public static String Calc(String input) throws CalcException
    {
        String [] strings = input.split(" ");
        if (strings.length != 3) // разделяем строку на 3 части
            throw new CalcException("Некорректный ввод?");
        for (String element: strings)
            element.trim();
        boolean isRoman = false;
        int number1, number2;
        try {
            number1 = Integer.parseInt(strings[0]); // пытаемся перевести первую и третью строки в инт
            number2 = Integer.parseInt(strings[2]);
            if ((number1 < 0 ) || (number1 > 10)) // два ифа чтобы легче читалось
                throw new CalcException("Некорректный ввод?");
            if ((number2 < 0 ) || (number2 > 10))
                throw new CalcException("Некорректный ввод?");
        }
        catch (NumberFormatException ex) { // если не получается, пытаемся перевести строки из римской в инт
            isRoman = true;
            number1 = convertFromRoman(strings[0]);
            number2 = convertFromRoman(strings[2]);
            if ((number1 == 0) || (number2 == 0)) // если метод возвращает ноль, то выкидываем исключение
                throw new CalcException("Некорректный ввод?");
        }
        int result;
        switch (strings[1]) // ищем знак, считаем результат
        {
            case ("+"):
                result = number1 + number2;
                break;
            case ("-"):
                result = number1 - number2;
                break;
            case("*"):
                result = number1 * number2;
                break;
            case ("/"):
                result = number1 / number2;
                break;
            default:
                throw new CalcException("Некорректный ввод?");
        }
        if (!isRoman) // если флаг isRoman не был включён, тогда возвращаем результат
            return Integer.toString(result);
        else
        {
            if (result <= 0) // в противном случае проверяем на корректность результат и возвращаем его
                throw new CalcException("Некорректный ввод?");
            return convertToRoman(result);
        }
    }

    public static void main(String[] args) throws CalcException
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Calc(input));
    }

}
