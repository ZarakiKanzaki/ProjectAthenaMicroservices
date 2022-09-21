package com.projectAthena.core.usecases.dto;


import java.util.Collection;


public class ThemeConceptDto {


    private long id;
    private String question;
    private Collection<String> answers;

    public ThemeConceptDto(long id, String question, Collection<String> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<String> answers) {
        this.answers = answers;
    }
}
