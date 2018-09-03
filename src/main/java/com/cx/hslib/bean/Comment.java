package com.cx.hslib.bean;

/**
 * Created by cx on 18/9/2.
 */
public class Comment {

    private int commentId;
    private int personId;
    private int bookId;
    private String commentStatus;
    private String  marks;
    private String comments;
    private String ifBest;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getIfBest() {
        return ifBest;
    }

    public void setIfBest(String ifBest) {
        this.ifBest = ifBest;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", personId=" + personId +
                ", bookId=" + bookId +
                ", commentStatus='" + commentStatus + '\'' +
                ", marks=" + marks +
                ", comments='" + comments + '\'' +
                ", ifBest='" + ifBest + '\'' +
                '}';
    }
}

