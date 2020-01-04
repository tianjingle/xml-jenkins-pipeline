package com.scaffold.root;

import com.scaffold.PipelineUtils;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class test2 {


    @Test
    public void test1(){
        try {
            String str= PipelineUtils.getConfigXml();
            System.out.println(str);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
