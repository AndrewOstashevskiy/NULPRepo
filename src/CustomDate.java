public class CustomDate {
    private final int years;
    private final int month;
    private final int days;

    public CustomDate(int years, int month, int days) {
        this.years = years;
        this.month = month;
        this.days = days;
    }

    public int getYears() {
        return years;
    }

    public int getMonth() {
        return month;
    }

    public int getDays() {
        return days;
    }
}
