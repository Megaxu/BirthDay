import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите дату своего рождения в формате дд.мм.гггг: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] date = input.split("\\p{P}");

        if (date.length == 3) {
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            int i = 0;

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E");
            Calendar birthDay = new GregorianCalendar(year, month - 1, day);
            Calendar today = Calendar.getInstance();

            while (today.after(birthDay)) {

                System.out.println(i + " - " + dateFormat.format(birthDay.getTime()));
                birthDay.add(Calendar.YEAR, 1);
                i++;
            }

        } else {
            System.out.println("Данные указаны неверно. ");
        }
    }
}