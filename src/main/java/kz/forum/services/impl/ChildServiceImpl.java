package kz.forum.services.impl;

import kz.forum.models.Child;
import kz.forum.models.Users;
import kz.forum.repos.ChildRepository;
import kz.forum.repos.UserRepository;
import kz.forum.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Child> allChildren() {
        return childRepository.findAll();
    }

    @Override
    public Child addChild(Child c) {
        Users parent = userRepository.findById(c.getParent().getId()).orElse(null);
        c.setParent(parent);
        return childRepository.save(c);
    }

    @Override
    public Child updateChild(Child c) {
        Users parent = userRepository.findById(c.getParent().getId()).orElse(null);
        c.setParent(parent);
        return childRepository.save(c);
    }

    @Override
    public Child getChild(Long id) {
        return childRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }
}
