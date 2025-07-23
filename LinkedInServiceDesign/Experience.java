package LinkedInServiceDesign;

public class Experience {
    private final String title;
    private final String description;
    private final String startDate;
    private final String endDate;

    public Experience(String title, String description, String startDate, String endDate){
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}