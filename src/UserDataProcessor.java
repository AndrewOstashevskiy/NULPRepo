import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserDataProcessor {

    private UserDataService userDataService;
    private static boolean condition = true;

    public UserDataProcessor() {
        this.userDataService = new UserDataServiceImpl();
    }

    public void processUserData() throws IOException {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            Printer.printMessage("Hi user, enter Your name to login");

            String name = buffReader.readLine();
            userDataService.registerUser(name);

            Printer.printMessage("User "+ name + " is identified");
            Printer.printMessage("There are a few interesting things about your name:");

            int nameLength = userDataService.getUserNameLength();
            long nameLengthFactorial = userDataService.getUserNameLengthFactorial();

            Printer.printMessage("Your name length is - " + nameLength
                    + " symbols and name length factorial is - "
                    + nameLengthFactorial);
            Printer.printMessage("I don't know why but I believe you wand and must to know this secret info....");
            Printer.printMessage("Ok, lets go ahead..");
            Printer.printMessage("Now you can request your age to this moment or to any moment in the past or future");

            while (condition) {

                Printer.printMessage("Print your birthday date or other date in the past, in"
                        + " format: yyyy/mm/dd");
                String startDate = buffReader.readLine();
                Thread.sleep(100);
                Printer.printMessage("And current or future date in the same format... "
                        + "(If it is current date, just print - now - without '-' )");

                String endDate = buffReader.readLine();
                String datePeriod = userDataService.processDatePeriod(startDate, endDate);

                Printer.printMessage("Date period is: " + datePeriod);

                Thread.sleep(100);

                Printer.printMessage("Do you wana to input other date range? (Y/N)");

                String answer = buffReader.readLine();

                if (answer.equalsIgnoreCase("Y")) {
                    Printer.printMessage("Oh...");
                    continue;
                } else if (answer.equalsIgnoreCase("N")){
                    Printer.printMessage("Nice, at least");
                    condition = false;
                } else {
                    Printer.printMessage("Okeeeeey... I suppose it means NO? Isn't it?");
                    Printer.printMessage("Anyway bye....");
                    condition = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
