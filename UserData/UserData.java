package UserData;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public UserData(String[] data) throws InvalidDataFormatException {
        if (data.length != 6) {
            throw new InvalidDataFormatException("Неправильный формат ввода данных");
        }

        this.lastName = data[0];
        this.firstName = data[1];
        this.middleName = data[2];
        this.birthDate = validateDateFormat(data[3]);
        this.phoneNumber = Long.parseLong(data[4]);
        this.gender = data[5].charAt(0);

        if (this.gender != 'f' && this.gender != 'm') {
            throw new InvalidDataFormatException("Неправильно указан пол");
        }
    }

    private String validateDateFormat(String date) throws InvalidDataFormatException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            return date;
        } catch (ParseException e) {
            throw new InvalidDataFormatException("Неправильная дата");
        }
    }

    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
