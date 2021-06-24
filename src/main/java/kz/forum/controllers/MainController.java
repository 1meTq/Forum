package kz.forum.controllers;


import kz.forum.models.*;
import kz.forum.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChildService childService;

    @Autowired
    private CityService cityService;


    //--------Users-----------

    @RequestMapping("/getuser/{id}")
    public ResponseEntity<Users> getUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @RequestMapping("/allusers")
    public ResponseEntity<List<Users>> allUsers() {
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> toRegister(@RequestBody Users user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping("/profile")
    public ResponseEntity<Users> profile() {
        return ResponseEntity.ok(getUser());
    }

    @PutMapping("/updateprofile")
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.updateProfile(user));
    }

    @PutMapping("updatepassword")
    public ResponseEntity<Users> updatePassword(@RequestBody Users user) {
        return ResponseEntity.ok(userService.updatePassword(user));
    }

    //--------Surveys-----------

    @PostMapping("/addsurvey")
    public ResponseEntity<Surveys> addSurvey(@RequestBody Surveys s) {
        return ResponseEntity.ok(surveyService.addSurvey(s));
    }

    @RequestMapping("/getsurvey/{id}")
    public ResponseEntity<Surveys> getSurvey(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(surveyService.getSurvey(id));
    }

    @DeleteMapping("/deletesurvey/{id}")
    public ResponseEntity<?> deleteSurvey(@PathVariable(name = "id") Long id) {

        try {
            surveyService.deleteSurvey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }

    @RequestMapping("/allsurveys")
    public ResponseEntity<List<Surveys>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.allSurveys());
    }

    @PutMapping("/updatesurvey")
    public ResponseEntity<Surveys> updateSurvey(@RequestBody Surveys s) {
        return ResponseEntity.ok(surveyService.updateSurvey(s));
    }

    //--------Questions-----------

    @PostMapping("/addquestion")
    public ResponseEntity<Questions> addQuestion(@RequestBody Questions q) {
        return ResponseEntity.ok(questionService.addQuestion(q));
    }

    @RequestMapping("/getquestion/{id}")
    public ResponseEntity<Questions> getQuestion(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @RequestMapping("/allquestions")
    public ResponseEntity<List<Questions>> allQuestions() {
        return ResponseEntity.ok(questionService.allQuestions());
    }

    @PutMapping("/updatequestion")
    public ResponseEntity<Questions> updateQuestion(@RequestBody Questions q) {
        return ResponseEntity.ok(questionService.updateQuestion(q));
    }

    @DeleteMapping("/deletequestion/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable(name = "id") Long id) {
        try {
            questionService.deleteQuestion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }

    //-------Articles---------

    @RequestMapping("/allarticles")
    public ResponseEntity<List<Articles>> allArticles() {
        return ResponseEntity.ok(articleService.allArticles());
    }

    @PostMapping("/addarticle")
    public ResponseEntity<Articles> addArticle(@RequestBody Articles a) {
        return ResponseEntity.ok(articleService.addArticle(a));
    }

    @RequestMapping("/getarticle/{id}")
    public ResponseEntity<Articles> getArticle(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(articleService.getArticle(id));
    }

    @PutMapping("/updatearticle")
    public ResponseEntity<Articles> updateArticle(@RequestBody Articles a) {
        return ResponseEntity.ok(articleService.updateArticle(a));
    }

    @DeleteMapping("/deletearticle/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(name = "id") Long id) {
        try {
            articleService.deleteArticle(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }


    //-------Categories---------

    @RequestMapping("/allcategories")
    public ResponseEntity<List<Categories>> allCategories() {
        return ResponseEntity.ok(categoryService.allCategories());
    }

    @PostMapping("/addcategory")
    public ResponseEntity<Categories> addCategory(@RequestBody Categories c) {
        return ResponseEntity.ok(categoryService.addCategory(c));
    }

    @RequestMapping("/getcategory/{id}")
    public ResponseEntity<Categories> getCategory(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PutMapping("/updatecategory")
    public ResponseEntity<Categories> updateCategory(@RequestBody Categories c) {
        return ResponseEntity.ok(categoryService.updateCategory(c));
    }

    @DeleteMapping("/deletecategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Long id) {
        try {
            categoryService.deleteCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }


    //---------Child----------

    @PostMapping("/addchild")
    public ResponseEntity<Child> addChild(@RequestBody Child c) {
        return ResponseEntity.ok(childService.addChild(c));
    }

    @PutMapping("/updatechild")
    public ResponseEntity<Child> updateChild(@RequestBody Child c) {
        return ResponseEntity.ok(childService.updateChild(c));
    }

    @RequestMapping("/allchildren")
    public ResponseEntity<List<Child>> allChildren() {
        return ResponseEntity.ok(childService.allChildren());
    }

    @RequestMapping("/getchild/{id}")
    public ResponseEntity<Child> getChild(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(childService.getChild(id));
    }

    @DeleteMapping("/deletechild/{id}")
    public ResponseEntity<?> deleteChild(@PathVariable(name = "id") Long id) {
        try {
            childService.deleteChild(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }


    //----------City------------

    @PostMapping("/addcity")
    public ResponseEntity<City> addCity(@RequestBody City c) {
        return ResponseEntity.ok(cityService.addCity(c));
    }

    @PutMapping("/updatecity")
    public ResponseEntity<City> updateCity(@RequestBody City c) {
        return ResponseEntity.ok(cityService.updateCity(c));
    }

    @RequestMapping("/getcity/{id}")
    public ResponseEntity<City> getCity(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(cityService.getCity(id));
    }

    @PostMapping("/allcities")
    public ResponseEntity<List<City>> allCities() {
        return ResponseEntity.ok(cityService.allCities());
    }

    @DeleteMapping("/deletecity/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(name = "id") Long id) {
        try {
            cityService.deleteCity(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }


    private Users getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Users user = (Users) authentication.getPrincipal();

            return user;
        }

        return null;
    }

}
