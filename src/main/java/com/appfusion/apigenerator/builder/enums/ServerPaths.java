package com.appfusion.apigenerator.builder.enums;

public enum ServerPaths {
    JavaSRC("/src/main/java"),
    ProjectTemplateDir("C:/Api Fusion/project_template"),
    ProjectTemplateLinux("/Api Fusion/project_template"),
    ClientFolder("C:/Api Fusion/projects/"),
    ClientFolderLinux("/Api Fusion/projects/"),
    PublishFolder("C:/Api Fusion/publish_projects/"),
    PublishFolderLinux("/Api Fusion/publish_projects/");

    public String value;

    private ServerPaths(String value) {
        this.value = value;
    }

}
