package kz.forum.services.impl;

import kz.forum.models.Surveys;
import kz.forum.repos.SurveyRepository;
import kz.forum.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public List<Surveys> allSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Surveys addSurvey(Surveys s) {
        return surveyRepository.save(s);
    }

    @Override
    public Surveys updateSurvey(Surveys s) {
        return surveyRepository.save(s);
    }

    @Override
    public Surveys getSurvey(Long id) {
        return surveyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}
