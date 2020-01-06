package com.scaffold.properties;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericTrigger {

    @XmlAttribute(name = "plugin")
    private String plugin="generic-webhook-trigger@1.66";

    private String spec="";

    private String regexpFilterText="";

    private String regexpFilterExpression="";

    private String causeString="";

    private boolean printPostContent=false;

    private boolean printContributedVariables=false;

    @XmlElement(name = "token")
    private String token;

    private boolean silentResponse=false;
}
