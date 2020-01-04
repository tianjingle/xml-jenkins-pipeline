package com.scaffold.definition;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Definition {

    @XmlAttribute(name = "class")
    private String CpsScmFlowDefinition="org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition";

    @XmlAttribute(name = "plugin")
    private String plugin="workflow-cps@2.78";

    @XmlElement(name = "scm")
    private Scm scm;

    private String ScriptPath="Jenkinsfile";

    private boolean lightweight=true;
}
