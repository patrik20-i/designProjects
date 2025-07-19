package LinkedInServiceDesign;

import java.util.List;
import java.util.ArrayList;


public class Profile{
    private String picUrl;
    private String title;
    private String description;
    private List<Experience> experiences;
    private List<Skill> skills;
    private List<Education> educations;

    public Profile(String pictureUrl, String title, String description) {
        this.picUrl = pictureUrl;
        this.title = title;
        this.description = description;
        experiences = new ArrayList<>();
        skills = new ArrayList<>();
        educations = new ArrayList<>();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill){
        for (Skill s : skills) {
            if (s.equals(skill)) {
                return;
            }
        }
        skills.add(skill);
    }

    public void addExperience(Experience experience){
        for(Experience e: experiences){
            if(e.equals(experience)){
                return;
            }
        }
        experiences.add(experience);
    }
    
    public void addEducation(Education education){
        for(Education e: educations){
            if(e.equals(education)){
                return;
            }
        }
        educations.add(education);
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}