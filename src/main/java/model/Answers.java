package model;

import converter.CaseConverter;

import javax.persistence.*;

@Entity
@Table(name = "answers", uniqueConstraints = {@UniqueConstraint(columnNames = "answer_id")})
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", unique = true, nullable = false)
    private int answerId;
    @Column(name = "answer")
    @Convert(converter = CaseConverter.class)
    private String answer;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "question_id")
    private int questionId;

    public Answers(int answerId, String answer, int userId, int questionId) {
        this.answerId = answerId;
        this.answer = answer;
        this.userId = userId;
        this.questionId = questionId;
    }

    public Answers() {
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

    @Override
    public String toString() {
        return questionId +"    " +  answer;
    }

}
