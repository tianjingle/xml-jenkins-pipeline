package com.scaffold.properties;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Triggers2 {

    @XmlElement(name = "org.jenkinsci.plugins.gogs.GogsTrigger")
    private GogsTrigger gogsTrigger;

    @XmlElement(name = "org.jenkinsci.plugins.gwt.GenericTrigger")
    private GenericTrigger genericTrigger;
}
