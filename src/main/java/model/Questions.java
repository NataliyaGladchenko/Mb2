package model;

import converter.CaseConverter;

import javax.persistence.*;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = "question_id")})
public class Questions extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "question")
    @Convert(converter = CaseConverter.class)
    private String question;

    public Questions(int questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public Questions() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Number of question: " + questionId + "\n" + question;
    }
}
