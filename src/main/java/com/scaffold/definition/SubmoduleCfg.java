package com.scaffold.definition;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SubmoduleCfg {

    @XmlAttribute(name = "class")
    private String cllss="list";
}
