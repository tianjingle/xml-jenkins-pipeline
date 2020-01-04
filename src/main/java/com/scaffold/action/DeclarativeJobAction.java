package com.scaffold.action;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DeclarativeJobAction {

    @XmlAttribute(name = "plugin")
    private String plugin="pipeline-model-definition@1.5.0";
}
