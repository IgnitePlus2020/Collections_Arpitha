package com.tgt.igniteplus;

import java.util.Set;

public class IgniteMembers {

    private String name;
    private int age;
    private String college;
    private Set<String> skillset;

    public IgniteMembers(String name,int age,String college,Set<String> skillset){
        this.name = name;
        this.age = age;
        this.college = college;
        this.skillset = skillset;
    }

    public IgniteMembers(IgniteMembers igniteMembers) {
        this.name = igniteMembers.name;
        this.college = igniteMembers.college;
        this.age = igniteMembers.age;
        this.skillset = igniteMembers.skillset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkillSet() {
        return skillset;
    }

    public void setSkillSet(Set<String> skillset) {
        this.skillset = skillset;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", college='" + college + '\'' +
                        ", age=" + age +
                        ", skillSet='" + skillset + '\'';
    }
}
