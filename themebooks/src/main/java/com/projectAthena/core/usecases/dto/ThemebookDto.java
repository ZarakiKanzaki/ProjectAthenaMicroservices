package com.projectAthena.core.usecases.dto;

import com.projectAthena.core.enums.ThemeType;

import java.util.List;


public class ThemebookDto {
    private long id;
    private String name;
    private String description;
    private ThemeType type;
    private ThemeConceptDto concept;

    private List<String> examplesOfApplication;
    private List<String> identityMysteryOptions;
    private List<String> titleExamples;
    private List<String> crewRelationships;
    private List<TagQuestionDto> tagQuestions;
    private List<ThemeImprovementDto> improvements;

    public ThemebookDto(long id, String name, String description, ThemeType type, ThemeConceptDto concept) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.concept = concept;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThemeType getType() {
        return type;
    }

    public void setType(ThemeType type) {
        this.type = type;
    }

    public ThemeConceptDto getConcept() {
        return concept;
    }

    public void setConcept(ThemeConceptDto concept) {
        this.concept = concept;
    }

    public List<String> getExamplesOfApplication() {
        return examplesOfApplication;
    }

    public void setExamplesOfApplication(List<String> examplesOfApplication) {
        this.examplesOfApplication = examplesOfApplication;
    }

    public List<String> getIdentityMysteryOptions() {
        return identityMysteryOptions;
    }

    public void setIdentityMysteryOptions(List<String> identityMysteryOptions) {
        this.identityMysteryOptions = identityMysteryOptions;
    }

    public List<String> getTitleExamples() {
        return titleExamples;
    }

    public void setTitleExamples(List<String> titleExamples) {
        this.titleExamples = titleExamples;
    }

    public List<String> getCrewRelationships() {
        return crewRelationships;
    }

    public void setCrewRelationships(List<String> crewRelationships) {
        this.crewRelationships = crewRelationships;
    }

    public List<TagQuestionDto> getTagQuestions() {
        return tagQuestions;
    }

    public void setTagQuestions(List<TagQuestionDto> tagQuestions) {
        this.tagQuestions = tagQuestions;
    }

    public List<ThemeImprovementDto> getImprovements() {
        return improvements;
    }

    public void setImprovements(List<ThemeImprovementDto> improvements) {
        this.improvements = improvements;
    }
}
