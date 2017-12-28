package de.rge.tools.of.wizardry.spell.crawler.model;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool;

import java.util.ArrayList;
import java.util.List;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.Connector.AND;

public class Spell {
    private String name;
    private MagicSchool school;
    private MagicSubschool subschool;
    private List<MagicDescriptor> descriptors = new ArrayList<>();
    private MagicDescriptor.Connector descriptorsConnector = AND;

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

    public MagicSubschool getSubschool() {
        return subschool;
    }

    public void setSubschool(MagicSubschool subschool) {
        this.subschool = subschool;
    }

    public List<MagicDescriptor> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<MagicDescriptor> descriptors) {
        this.descriptors = descriptors;
    }

    public MagicDescriptor.Connector getDescriptorsConnector() {
        return descriptorsConnector;
    }

    public void setDescriptorsConnector(MagicDescriptor.Connector descriptorsConnector) {
        this.descriptorsConnector = descriptorsConnector;
    }

    public String toString() {
        return this.name + ":" + this.school;
    }
}
