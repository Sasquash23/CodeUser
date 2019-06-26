package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();


    public Forum() {
        theUserList.add(new ForumUser(1, "Happ23",'F', LocalDate.of(1995, Month.DECEMBER, 5),50));
        theUserList.add(new ForumUser(2, "Asterix",'M', LocalDate.of(1997, Month.JANUARY, 5),5));
        theUserList.add(new ForumUser(3, "Gil_19",'M', LocalDate.of(2001, Month.APRIL, 5),1));
        theUserList.add(new ForumUser(4, "Sunn18",'F', LocalDate.of(2005, Month.JULY, 5),0));
        theUserList.add(new ForumUser(5, "Lex",'M', LocalDate.of(1990, Month.DECEMBER, 5),100));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
