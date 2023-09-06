package com.appfusion.apigenerator.builder.enums;

public enum ServerPaths {
    JavaSRC("/src/main/java"),
    ProjectTemplateDir("C:/Users/Meu Computador/Documents/App Fusion/project_template"),
    ClientFolder("C:/Users/Meu Computador/Documents/App Fusion/projects/"),
    ClientZipProject("C:/Users/Meu Computador/Documents/App Fusion/publish_projects/"),
    PublishFolder("C:/Users/Meu Computador/Documents/App Fusion/publish_projects/");

    public String value;

    private ServerPaths(String value) {
        this.value = value;
    }

}
