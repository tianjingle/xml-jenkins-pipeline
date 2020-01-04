package com.scaffold.action;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DeclarativeJobPropertyTrackerAction {

    @XmlAttribute(name = "plugin")
    private String plugin="pipeline-model-definition@1.5.0";

    @XmlElement(name = "jobProperties")
    private String jobProperties;

    @XmlElement(name = "triggers")
    private Triggers triggers;

    @XmlElement(name = "parameters")
    private String parameters;

    @XmlElement(name = "options")
    private String options;
}
