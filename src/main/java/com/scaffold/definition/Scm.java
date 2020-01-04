package com.scaffold.definition;

import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Scm {

    @XmlAttribute(name = "class")
    private String gitScm="hudson.plugins.git.GitSCM";

    @XmlAttribute(name = "plugin")
    private String plugin="git@4.0.0";

    private int configVersion=2;

    @XmlElement(name = "userRemoteConfigs")
    private UserRemoteConfigs userRemoteConfigs;

    @XmlElement(name = "branches")
    private Branches branches;

    private boolean doGenerateSubmoduleConfigurations=false;

    @XmlElement(name = "submoduleCfg")
    private SubmoduleCfg submoduleCfg;

    @XmlElement(name = "extensions")
    private String extensions="";
}
