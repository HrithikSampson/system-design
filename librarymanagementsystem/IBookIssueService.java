package librarymanagementsystem;

public interface IBookIssueService {
    public BookReservationDetail getReservationDetail();
    public void setFineService(FineService fineService);
}
