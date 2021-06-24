package kz.forum.services;

import kz.forum.models.Surveys;

import java.util.*;

public interface SurveyService {

    List<Surveys> allSurveys();

    Surveys addSurvey(Surveys s);

    Surveys updateSurvey(Surveys s);

    Surveys getSurvey(Long id);

    void deleteSurvey(Long id);
}
