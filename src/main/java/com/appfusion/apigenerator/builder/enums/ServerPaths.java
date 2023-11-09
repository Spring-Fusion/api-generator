package com.appfusion.apigenerator.builder.enums;

/**
 * This enum represents the server paths used in the application.
 * It contains the paths for Java source code, project templates, client
 * folders, and publish folders.
 * 
 * @author Gabriel Reis
 */
public enum ServerPaths {

    JavaSRC("/src/main/java"),
    ProjectTemplateDir("C:/Api Fusion/project_template"),
    ProjectTemplateLinux("Api Fusion/project_template"),
    ClientFolder("C:/Api Fusion/projects/"),
    ClientFolderLinux("Api Fusion/projects/"),
    PublishFolder("C:/Api Fusion/publish_projects/"),
    PublishFolderLinux("Api Fusion/publish_projects/");

    public String value;

    private ServerPaths(String value) {
        this.value = value;
    }

}
