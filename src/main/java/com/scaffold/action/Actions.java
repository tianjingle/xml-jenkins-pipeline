package com.scaffold.action;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Actions {

    @XmlElement(name = "org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction")
    private DeclarativeJobAction declarativeJobAction;

    @XmlElement(name = "org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction")
    private DeclarativeJobPropertyTrackerAction declarativeJobPropertyTrackerAction;
}
