package com.scaffold.properties;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Properties {

    @XmlElement(name = "org.jenkinsci.plugins.gogs.GogsProjectProperty")
    private GogsProjectProperty gogsProjectProperty;

    @XmlElement(name = "org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty")
    private PipelineTriggersJobProperty pipelineTriggersJobProperty;

}
