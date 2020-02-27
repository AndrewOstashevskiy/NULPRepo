public interface UserDataService {

    void registerUser(String userName);

    int getUserNameLength();

    long getUserNameLengthFactorial();

    String processDatePeriod(String startDate, String endDate);
}
