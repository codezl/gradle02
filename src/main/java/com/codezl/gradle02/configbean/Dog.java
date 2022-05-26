package com.codezl.gradle02.configbean;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/20/14:39
 * @Description:
 */
public class Dog {

    List<String> dogs;
    Integer num;
    Map<String,String> couple;
    AppPerson person;

    @Override
    public String toString() {
        return "Dog{" +
                "dogs=" + dogs +
                ", num=" + num +
                ", couple=" + couple +
                ", person=" + person +
                '}';
    }

    public AppPerson getPerson() {
        return person;
    }

    public void setPerson(AppPerson person) {
        this.person = person;
    }

    public Map<String, String> getCouple() {
        return couple;
    }

    public void setCouple(Map<String, String> couple) {
        this.couple = couple;
    }

    public List<String> getDogs() {
        return dogs;
    }

    public void setDogs(List<String> dogs) {
        this.dogs = dogs;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
