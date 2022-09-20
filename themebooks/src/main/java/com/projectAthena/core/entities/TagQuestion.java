package com.projectAthena.core.entities;

import com.projectAthena.core.enums.TagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class TagQuestion {
    private long id;
    private TagType type;
    private String question;

    private List<String> answers;
}
