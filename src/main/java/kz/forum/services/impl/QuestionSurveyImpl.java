package kz.forum.services.impl;

import kz.forum.models.Questions;
import kz.forum.models.Surveys;
import kz.forum.repos.QuestionRepository;
import kz.forum.repos.SurveyRepository;
import kz.forum.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionSurveyImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public List<Questions> allQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Questions addQuestion(Questions q) {

        Surveys s = surveyRepository.findById(q.getSurvey().getId()).orElse(null);

        q.setSurvey(s);

        return questionRepository.save(q);
    }

    @Override
    public Questions updateQuestion(Questions q) {

        Surveys s = surveyRepository.findById(q.getSurvey().getId()).orElse(null);

        q.setSurvey(s);

        return questionRepository.save(q);
    }

    @Override
    public Questions getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
