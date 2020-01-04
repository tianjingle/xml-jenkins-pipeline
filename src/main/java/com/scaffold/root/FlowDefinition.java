package com.scaffold.root;

import com.scaffold.action.Actions;
import com.scaffold.definition.Definition;
import com.scaffold.properties.Properties;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FlowDefinition {


    @XmlAttribute(name = "plugin")
    private String plugin="workflow-job@2.36";


    @XmlElement(name = "actions")
    private Actions actions;

    @XmlElement(name = "discription")
    private String description="";

    private boolean keepDependencies=false;

    @XmlElement(name = "properties")
    private Properties properties;

    @XmlElement(name = "definition")
    private Definition definition;

    @XmlElement(name = "triggers")
    private String triggers;

    private boolean disabled=false;
}
