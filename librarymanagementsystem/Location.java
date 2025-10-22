package librarymanagementsystem;

public class Location {
    public String rackId;
    public String spaceId;
    public String shelfId;
    public Location(String rackId, String spaceId, String shelfId) {
        this.rackId = rackId;
        this.spaceId = spaceId;
        this.shelfId = shelfId;
    }
}
