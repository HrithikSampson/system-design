package librarymanagementsystem;

import java.util.Date;

public class FineService {
    private static final double FINE_PER_DAY = 10.0;
    public double calculateFine(Date dueDate, Date returnDate) {
        long diff = returnDate.getTime() - dueDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return days > 0 ? days * FINE_PER_DAY : 0;
    }
}