package StackOverFlowLLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Answer implements Votable, Commentable {
    private int id;
    private String content;
    private Question question;
    private final User author;
    private boolean isAccepted;
    private final Date creationDate;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(User author, Question question, String content){
        this.id = generateId();
        this.author = author;
        this.question = question;
        this.content = content;
        isAccepted = false;
        creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, type));
        author.updateReputation(10 * (type == VoteType.UPVOTE ? 1 : -1));  // +10 for upvote, -10 for downvote
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getType() == VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments(){
        return comments;
    }

    public void markAsAccepted(){
        if(isAccepted){
            throw new IllegalStateException("this answer already accpeted");
        }
        isAccepted = true;
        author.updateReputation(15);
    }

    // Getters
    public int getId() { return id; }
    public User getAuthor() { return author; }
    public Question getQuestion() { return question; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public boolean isAccepted() { return isAccepted; }
}
