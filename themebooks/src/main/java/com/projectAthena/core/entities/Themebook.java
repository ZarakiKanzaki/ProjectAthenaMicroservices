package com.projectAthena.core.entities;

import com.projectAthena.core.enums.ThemeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Themebook {
    private long id;
    private String name;
    private String description;
    private ThemeType type;
    private ThemeConcept concept;

    private Collection<String> examplesOfApplication;
    private Collection<String> identityMysteryOptions;
    private Collection<String> titleExamples;
    private Collection<String> crewRelationships;
    private Collection<TagQuestion> tagQuestions;
    private Collection<ThemeImprovement> improvements;
}
