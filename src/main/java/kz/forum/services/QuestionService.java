package kz.forum.services;

import kz.forum.models.Questions;

import java.util.*;

public interface QuestionService {

    List<Questions> allQuestions();

    Questions addQuestion(Questions q);

    Questions updateQuestion(Questions q);

    Questions getQuestion(Long id);

    void deleteQuestion(Long id);


}
