package pro.sky.java.course2.examinerservice.domain;

public class Question {
    private final String question;
    private final String answer;
    public int number;

    public Question ( String question, String answer ){
        number++;
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return this.question; }

    public String getAnswer() {
        return this.answer;
    }

    public int getNumber(){ return number; }

    @Override
    public String toString(){
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", number=" + number + '\'' +
                '}';
    }
}