package com.scaffold.action;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Triggers {

    @XmlElement(name = "string")
    private String str="org.jenkinsci.plugins.gwt.GenericTrigger";
}
