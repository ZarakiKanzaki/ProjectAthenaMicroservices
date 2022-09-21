package com.projectAthena.core.usecases;

import com.projectAthena.core.entities.TagQuestion;
import com.projectAthena.core.entities.ThemeConcept;
import com.projectAthena.core.entities.ThemeImprovement;
import com.projectAthena.core.entities.Themebook;
import com.projectAthena.core.usecases.dto.TagQuestionDto;
import com.projectAthena.core.usecases.dto.ThemeImprovementDto;
import com.projectAthena.core.usecases.dto.ThemebookDto;
import lombok.var;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ThemebookService {
    private final IThemebookRepository themebookRepository;

    public ThemebookService(IThemebookRepository themebookRepository) {
        this.themebookRepository = themebookRepository;
    }

    public Themebook create(ThemebookDto themebookDto) throws Exception {
        if (themebookRepository.isUniqueByCode(themebookDto.getName())) {
            throw new CodeAlreadyExistException();
        }

        validation(themebookDto);

        var themebook = buildThemebook(themebookDto);

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
                .tagQuestions(buildTagQuestions(themebookDto.getTagQuestions()))
                .improvements(buildImprovements(themebookDto.getImprovements()))
                .build();
    }

    private Collection<ThemeImprovement> buildImprovements(List<ThemeImprovementDto> improvementDtos) {
        return improvementDtos.stream()
                .map(imp -> ThemeImprovement.builder()
                        .id(imp.getId())
                        .title(imp.getTitle())
                        .description(imp.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    private Collection<TagQuestion> buildTagQuestions(List<TagQuestionDto> tagQuestionDtos) {
        return tagQuestionDtos.stream()
                .map(question -> TagQuestion.builder()
                        .id(question.getId())
                        .type(question.getType())
                        .question(question.getQuestion())
                        .answers(question.getAnswers())
                        .build())
                .collect(Collectors.toList());
    }

    private void validation(ThemebookDto themebookDto) throws Exception {
        var domainExceptions = new ArrayList<DomainException>();

        if (isNullOrWhiteSpace(themebookDto.getName())) {
            domainExceptions.add(new DomainException());
        }

        if (isNullOrWhiteSpace(themebookDto.getDescription())) {
            domainExceptions.add(new DomainException());
        }

        if (themebookDto.getConcept() == null) {
            domainExceptions.add(new DomainException());
        }

        if (themebookDto.getType() == null) {
            domainExceptions.add(new DomainException());
        }

        if (areAllTagQuestionsValid(themebookDto)) {
            domainExceptions.add(new DomainException());
        }

        if(areAllImprovementsValid(themebookDto)) {
            domainExceptions.add(new DomainException());
        }

        if(domainExceptions.isEmpty() == false) {
            throw new DomainException(domainExceptions.stream().map(Throwable::getMessage).collect(Collectors.joining("\n\r")));
        }

    }

    private static boolean areAllImprovementsValid(ThemebookDto themebookDto) {
        return  themebookDto.getImprovements().stream()
                .anyMatch(improvement -> isNullOrWhiteSpace(improvement.getTitle())
                        || isNullOrWhiteSpace(improvement.getDescription()));
    }

    private static boolean areAllTagQuestionsValid(ThemebookDto themebookDto) {
        return themebookDto.getTagQuestions().stream()
                .anyMatch(question -> isNullOrWhiteSpace(question.getQuestion())
                        || areAllAnswerValid(question));
    }

    private static boolean areAllAnswerValid(TagQuestionDto question) {
        return question.getAnswers().stream().anyMatch(ThemebookService::isNullOrWhiteSpace);
    }

    private static boolean isNullOrWhiteSpace(String theString) {
        return theString.trim().isEmpty();
    }


    private static ThemeConcept getThemeConcept(ThemebookDto themebookDto) {
        return ThemeConcept.builder().id(themebookDto.getConcept().getId()).question(themebookDto.getConcept().getQuestion()).answers(themebookDto.getConcept().getAnswers()).build();
    }

}
