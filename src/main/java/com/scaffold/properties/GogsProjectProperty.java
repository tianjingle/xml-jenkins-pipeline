package com.scaffold.properties;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class GogsProjectProperty {

    @XmlAttribute(name = "plugin")
    private String plugin="gogs-webhook@1.0.15";

    @XmlElement(name = "gogsSecret")
    private String gogsSecret;

    private boolean gogsUsePayload=false;

    @XmlElement(name = "gogsBranchFilter")
    private String gogsBranchFilter="";
}
