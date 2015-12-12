package models;

/**
 * Created by Qiyao on 12/8/15.
 */
public class Comment {
    private String postId = "";
    private String userId = "";
    private String text = "";
    private String time = "";
    private String author = "";

//    public String getPostIdS() {
//        return postId.substring(1, postId.length() - 1);
//    }
    public String getPostId() {
        return postId;
    }
    public String getUserIdS() {
        return userId.substring(1, userId.length() - 1);
    }
    public String getUserIdL() {
        return userId;
    }
    public String getTextS() {
        return text.substring(1, text.length() - 1);
    }
    public String getTextL() {
        return text;
    }
    public String getTimeS() {
        return time.substring(1, time.length() - 1);
    }
    public String getTimeL() {
        return time;
    }
    public String getAuthorS() {
        return author.substring(1, author.length() - 1);
    }
    public String getAuthorL() {
        return author;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setAuthor(String author) { this.author = author; }


}
