package StackOverFlowLLD;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Question implements Votable, Commentable {
    private final int id;
    private String title;
    private String content;
    private User author;
    private final Date creationDate;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(User author, String title, String content, List<String> tagNames){
        this.id = generateId();
        this.author = author;
        this.title = title;
        this.content = content;
        this.creationDate = new Date();
        this.answers = new ArrayList<Answer>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for(String tagName:tagNames){
            tags.add(new Tag(tagName));
        }
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public synchronized void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            answers.add(answer);
        }
    }

    public synchronized void acceptedAnswer(Answer answer){
        if(acceptedAnswer == null){
            this.acceptedAnswer = answer;
        }
    }

   @Override
    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, type));
        author.updateReputation(5 * (type == VoteType.UPVOTE ? 1 : -1));  
    }

    @Override
    public int getVoteCount(){
        return votes.size();
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments(){
        return new ArrayList<>(comments);
    }


    //Getters
    public int getId() { return id; }
    public User getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public List<Answer> getAnswers() { return new ArrayList<>(answers); }
    public List<Tag> getTags() { return new ArrayList<>(tags); }
    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }
}
