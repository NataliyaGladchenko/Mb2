package model;

public class Answers {
    private int answerId;
    private String answer;
    private int userId;
    private int questionId;

    public Answers(int answerId, String answer, int userId, int questionId) {
        this.answerId = answerId;
        this.answer = answer;
        this.userId = userId;
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
