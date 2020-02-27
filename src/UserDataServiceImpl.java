public class UserDataServiceImpl implements UserDataService {

    private String name;
    private static int counter;

    @Override
    public void registerUser(String userName) {
        name = userName;
    }

    @Override
    public int getUserNameLength() {
        return name.length();
    }

    @Override
    public long getUserNameLengthFactorial() {
        return calculateFactorial(name.length());
    }

    @Override
    public String processDatePeriod(String startDate, String endDate) {
        CustomDate start;
        CustomDate end;
        String period = null;

        try {
            start = convertDate(startDate);

            if (endDate.equalsIgnoreCase("now")) {
                return DataCalculationServiceImpl.getTimePeriod(start);
            }

            end = convertDate(endDate);
            period = DataCalculationServiceImpl.getTimePeriod(start, end);

        } catch (NullPointerException e) {

        } catch (NumberFormatException e) {
            if (counter >= 1) {
                Printer.printMessage("Again????? Oh.. anyway... Lets try again");
                counter++;
            } else {
                Printer.printMessage("Emmmmm..... ok.....are you serious? Why I wrote date format??");
                counter++;
            }
        }
        return period;
    }

    private CustomDate convertDate(String date) throws NumberFormatException {
        String[] parsedDate = date.split("/");
        CustomDate customDate = new CustomDate(Integer.valueOf(parsedDate[0]),
                Integer.valueOf(parsedDate[1]),
                Integer.valueOf(parsedDate[2]));
        return customDate;
    }


    private long calculateFactorial(int nameLength) {
        if (nameLength == 1) {
            return 1;
        }
        return nameLength * calculateFactorial(nameLength - 1);
    }
}
