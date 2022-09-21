package com.projectAthena.core.usecases.dto;

import com.projectAthena.core.enums.TagType;

import java.util.List;


public class TagQuestionDto {
    private long id;
    private TagType type;
    private String question;
    private List<String> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TagType getType() {
        return type;
    }

    public void setType(TagType type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public TagQuestionDto(long id, TagType type, String question, List<String> answers) {
        this.id = id;
        this.type = type;
        this.question = question;
        this.answers = answers;
    }

}
