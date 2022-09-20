package com.projectAthena.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ThemeConcept {
    private long id;
    private String question;
    private Collection<String> answers;
}
