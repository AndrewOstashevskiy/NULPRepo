import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DataCalculationServiceImpl  {

    public static String getTimePeriod(CustomDate startDate, CustomDate endDate) {
        LocalDateTime fromDateTime = null;
        LocalDateTime toDateTime = null;
        try {
            fromDateTime = LocalDateTime.of(startDate.getYears(),
                    startDate.getMonth(),
                    startDate.getDays(),
                    0,
                    0,
                    0);

            toDateTime = LocalDateTime.of(endDate.getYears(),
                    endDate.getMonth(),
                    endDate.getDays(),
                    0,
                    0,
                    0);

        }catch (DateTimeException e) {
            Printer.printMessage("You don't know date formats bro..");
        }

        return getPeriod(fromDateTime, toDateTime);
    }

    public static String getTimePeriod(CustomDate startDate) {
        LocalDateTime fromDateTime = LocalDateTime.of(startDate.getYears(),
                startDate.getMonth(),
                startDate.getDays(),
                0,
                0,
                0);

        LocalDateTime toDateTime = LocalDateTime.now();

        return getPeriod(fromDateTime, toDateTime);
    }

    private static String getPeriod(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);

        long years = tempDateTime.until(toDateTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(years);

        long months = tempDateTime.until(toDateTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(months);

        long days = tempDateTime.until(toDateTime, ChronoUnit.DAYS);

        return String.valueOf(years)
                .concat(" years/ ")
                .concat(String.valueOf(months))
                .concat(" month/ ")
                .concat(String.valueOf(days))
                .concat(" days");
    }
}
