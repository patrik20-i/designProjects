package LinkedInServiceDesign;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JobPosting{
    private final String id;
    private final String title;
    private final String company;
    private final String description;
    private final Date postdate;
    private final Map<String, User> applicants;

    public JobPosting(String title, String company, String description){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.company = company;
        this.description = description;
        this.applicants = new ConcurrentHashMap<>();
        this.postdate = new Date();
    }

    public void apply(User user){
        if(applicants.containsKey(user.getId())){
            throw new IllegalArgumentException("Already applied");
        }
        applicants.put(user.getId(), user);

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public Date getPostdate() {
        return new Date(postdate.getTime());
    }

    public Map<String, User> getApplicants() {
        return applicants;
    }
}