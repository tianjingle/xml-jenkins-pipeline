## what is xml-jenkins-pipeline?
jenkins2.0之后，提供了jenkinsfile的可编程的构建流程。我们只需要在我们的项目中放入jenkinsfile文件即可。jenkins构建项目的时候会自动去读取这里的jenkinsFile，但是jenkins众多模式中如何去采用这种模式呐？通过config.xml。
这里就是提供一种config生成器，专门用来生成jenkins pipeline模式的config。这对第三方系统控制CI有比较大的作用，可以使得jenkins等工具变成整个系统网的一个组件。

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<flowDefinition plugin="workflow-job@2.36">
    <actions>
        <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction plugin="pipeline-model-definition@1.5.0"/>
        <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction plugin="pipeline-model-definition@1.5.0">
            <triggers>
                <string>org.jenkinsci.plugins.gwt.GenericTrigger</string>
            </triggers>
        </org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction>
    </actions>
    <discription></discription>
    <keepDependencies>false</keepDependencies>
    <properties>
        <org.jenkinsci.plugins.gogs.GogsProjectProperty plugin="gogs-webhook@1.0.15">
            <gogsSecret>scrent</gogsSecret>
            <gogsUsePayload>false</gogsUsePayload>
            <gogsBranchFilter></gogsBranchFilter>
        </org.jenkinsci.plugins.gogs.GogsProjectProperty>
        <org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
            <triggers>
                <org.jenkinsci.plugins.gwt.GenericTrigger plugin="generic-webhook-trigger@1.66">
                    <spec></spec>
                    <printPostContent>false</printPostContent>
                    <printContributedVariables>false</printContributedVariables>
                    <token>123</token>
                    <silentResponse>false</silentResponse>
                </org.jenkinsci.plugins.gwt.GenericTrigger>
            </triggers>
        </org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
    </properties>
    <definition class="org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition" plugin="workflow-cps@2.78">
        <scm class="hudson.plugins.git.GitSCM" plugin="git@4.0.0">
            <configVersion>2</configVersion>
            <userRemoteConfigs>
                <hudson.plugins.git.UserRemoteConfig>
                    <url>123123</url>
                </hudson.plugins.git.UserRemoteConfig>
            </userRemoteConfigs>
            <branches>
                <hudson.plugins.git.BranchSpec>
                    <name>*/master</name>
                </hudson.plugins.git.BranchSpec>
            </branches>
            <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
            <extensions></extensions>
        </scm>
        <ScriptPath>Jenkinsfile</ScriptPath>
        <lightweight>true</lightweight>
    </definition>
    <disabled>false</disabled>
</flowDefinition>
```