package com.scaffold;

import com.scaffold.root.FlowDefinition;

import javax.xml.bind.JAXBException;

public class test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        String configXml = PipelineUtils.getConfigXml();
        System.out.println(configXml);

        FlowDefinition flowDefinition=new FlowDefinition();
        PipelineUtils.setGitInfo(flowDefinition,"123123","master");
        PipelineUtils.setGogInfo(flowDefinition,"scrent","123");
        String str=PipelineUtils.writeXml(flowDefinition);
        System.out.println(str);
    }
}
