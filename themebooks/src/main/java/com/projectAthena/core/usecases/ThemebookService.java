package com.projectAthena.core.usecases;

import com.projectAthena.core.entities.TagQuestion;
import com.projectAthena.core.entities.ThemeConcept;
import com.projectAthena.core.entities.ThemeImprovement;
import com.projectAthena.core.entities.Themebook;
import com.projectAthena.core.enums.ThemeType;
import com.projectAthena.core.usecases.dto.TagQuestionDto;
import com.projectAthena.core.usecases.dto.ThemeImprovementDto;
import com.projectAthena.core.usecases.dto.ThemebookDto;
import lombok.val;

import java.util.Collection;
import java.util.List;

public class ThemebookService {
    private IThemebookRepository themebookRepository;

    public ThemebookService(IThemebookRepository themebookRepository) {
        this.themebookRepository = themebookRepository;
    }

    public Themebook Create(ThemebookDto themebookDto) throws CodeAlreadyExistException {
        if (themebookRepository.isUniqueByCode(themebookDto.getName())) {
            throw new CodeAlreadyExistException();
        }

        //Validation(themebookDto);

        val themebook = buildThemebook(themebookDto);

        themebookRepository.add(themebook);
        themebookRepository.saveChanges();

        return themebook;
    }

    private Themebook buildThemebook(ThemebookDto themebookDto) {
        return Themebook.builder()
                .id(themebookDto.getId())
                .name(themebookDto.getName())
                .description(themebookDto.getDescription())
                .type(themebookDto.getType())
                .concept(getThemeConcept(themebookDto))
                .examplesOfApplication(themebookDto.getExamplesOfApplication())
                .identityMysteryOptions(themebookDto.getIdentityMysteryOptions())
                .titleExamples(themebookDto.getTitleExamples())
                .crewRelationships(themebookDto.getCrewRelationships())
                .tagQuestions(builTagQuestions(themebookDto.getTagQuestions()))
                .improvements(buildImprovements(themebookDto.getImprovements()))
                .build();
    }

    private Collection<ThemeImprovement> buildImprovements(List<ThemeImprovementDto> improvements) {
        return null;
    }

    private Collection<TagQuestion> builTagQuestions(List<TagQuestionDto> tagQuestions) {
        return  null;
    }

    private void Validation(ThemebookDto themebookDto) throws Exception{
    }


    private static ThemeConcept getThemeConcept(ThemebookDto themebookDto) {
        return ThemeConcept.builder().id(themebookDto.getConcept().getId()).question(themebookDto.getConcept().getQuestion()).answers(themebookDto.getConcept().getAnswers()).build();
    }

}
