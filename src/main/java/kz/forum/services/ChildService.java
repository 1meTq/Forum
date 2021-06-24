package kz.forum.services;

import kz.forum.models.Child;

import java.util.*;

public interface ChildService {

    List<Child> allChildren();

    Child addChild(Child c);

    Child updateChild(Child c);

    Child getChild(Long id);

    void deleteChild(Long id);

}
