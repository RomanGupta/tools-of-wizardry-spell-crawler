package de.rge.tools.of.wizardry.spell.crawler.model;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;

public class Spell {
    private String name;
    private MagicSchool school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MagicSchool getSchool() {
        return school;
    }

    public void setSchool(MagicSchool school) {
        this.school = school;
    }

    public String toString() {
        return this.name + ":" + this.school;
    }
}
