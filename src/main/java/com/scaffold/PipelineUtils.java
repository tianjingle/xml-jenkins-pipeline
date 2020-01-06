package com.scaffold;

import com.scaffold.action.Actions;
import com.scaffold.action.DeclarativeJobAction;
import com.scaffold.action.DeclarativeJobPropertyTrackerAction;
import com.scaffold.action.Triggers;
import com.scaffold.definition.*;
import com.scaffold.properties.*;
import com.scaffold.root.FlowDefinition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;

public class PipelineUtils {


    public static Object getRoot(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * class.forName是不调用构造函数的
         */
        Class clz = Class.forName(className);
        System.out.println(className);
        Object object = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields){
            if (!field.isAnnotationPresent(XmlElement.class)){
                continue;
            }
            String fieldName = field.getType().getName();
            Object fieldObj = getRoot(fieldName);
            field.setAccessible(true);
            field.set(object,fieldObj);
        }
        return object;
    }

    /**
     * 获取基本的configXml框架接口
     *
     * @return xml字符串
     * @throws JAXBException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */

    public static String getConfigXml() throws JAXBException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class project = FlowDefinition.class;
        String projectName = project.getName();
        Object root = getRoot(projectName);
        return writeXml(root);
    }

    public static String writeXml(Object root) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(root.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Writer writer = new StringWriter();
        marshaller.marshal(root, writer);
        return String.valueOf(writer);
    }

    public static void setGitInfo(FlowDefinition definition,String gitUrl,String branch){

        Actions actions=new Actions();
        DeclarativeJobAction declarativeJobAction=new DeclarativeJobAction();
        actions.setDeclarativeJobAction(declarativeJobAction);
        DeclarativeJobPropertyTrackerAction declarativeJobPropertyTrackerAction=new DeclarativeJobPropertyTrackerAction();
        Triggers triggers=new Triggers();
        triggers.setStr("org.jenkinsci.plugins.gwt.GenericTrigger");
        declarativeJobPropertyTrackerAction.setTriggers(triggers);
        actions.setDeclarativeJobPropertyTrackerAction(declarativeJobPropertyTrackerAction);
        definition.setActions(actions);
        UserRemoteConfig userRemoteConfig=new UserRemoteConfig();
        userRemoteConfig.setUrl(gitUrl);
        UserRemoteConfigs parent=new UserRemoteConfigs();
        parent.setUserRemoteConfig(userRemoteConfig);
        BranchSpec branchSpec=new BranchSpec();
        if (branch==null||"".equals(branch)){
            branch="master";
        }
        branchSpec.setName("*/"+branch);
        Branches branches=new Branches();
        branches.setBranchSpec(branchSpec);
        Scm scm=new Scm();
        scm.setBranches(branches);
        scm.setUserRemoteConfigs(parent);
        Definition definition1=new Definition();
        definition1.setScm(scm);
        definition.setDefinition(definition1);
    }


    public static void setGogInfo(FlowDefinition definition,String secret,String token){
        GogsProjectProperty gogsProjectProperty=new GogsProjectProperty();
        gogsProjectProperty.setGogsSecret(secret);
        Triggers2 triggers2=new Triggers2();
        GenericTrigger genericTrigger=new GenericTrigger();
        genericTrigger.setToken(token);
        triggers2.setGogsTrigger(new GogsTrigger());
        triggers2.setGenericTrigger(genericTrigger);
        Properties properties=new Properties();
        properties.setGogsProjectProperty(gogsProjectProperty);
        PipelineTriggersJobProperty pipelineTriggersJobProperty=new PipelineTriggersJobProperty();
        pipelineTriggersJobProperty.setTriggers2(triggers2);
        properties.setPipelineTriggersJobProperty(pipelineTriggersJobProperty);
        definition.setProperties(properties);
    }
}
