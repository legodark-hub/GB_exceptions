package UserData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataParser {
    public static void main(String[] args) {
        // String userInput = "Петров Иван Иванович 31.12.1999 1234567890 m";
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Введите данные в формате Фамилия Имя Отчество датарождения(dd.mm.yyyy) номертелефона пол(f/m)");
        String userInput = input.nextLine();
        try {
            String[] data = userInput.split(" ");
            UserData userData = new UserData(data);

            String fileName = userData.toString().split(" ")[0] + ".txt";
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(userData.toString() + "\n");
                System.out.println("Данные успешно записаны в " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
            }

        } catch (InvalidDataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
