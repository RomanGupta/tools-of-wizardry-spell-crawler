package de.rge.tools.of.wizardry.spell.crawler.model;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;

public class Spell {
    private String name;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String toString() {
        return this.name + ":" + this.school;
    }
}
