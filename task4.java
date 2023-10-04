import java.util.Scanner;

public class task4 {
    // Разработайте программу, которая выбросит Exception, когда
    // пользователь вводит пустую строку. Пользователю должно показаться
    // сообщение, что пустые строки вводить нельзя.

    public static void main(String[] args) throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Введите строку");
            String inp = input.nextLine();
            if (inp.isEmpty())
                throw new Exception("Нельзя вводить пустую строку");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
