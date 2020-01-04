package com.scaffold.properties;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PipelineTriggersJobProperty {

    @XmlElement(name = "triggers")
    private Triggers2 triggers2;

}
