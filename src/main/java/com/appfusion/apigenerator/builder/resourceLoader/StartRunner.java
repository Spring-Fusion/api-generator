package com.appfusion.apigenerator.builder.resourceLoader;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.appfusion.apigenerator.builder.enums.ServerPaths;

public class StartRunner implements ApplicationRunner {

  private static Logger LOG = LoggerFactory.getLogger(StartRunner.class);

  @Override
  public void run(ApplicationArguments args) throws Exception {
    create();
  }

  public static void create() throws Exception {
    if (checkFolderExistence(ServerPaths.ClientFolder.value) && checkFolderExistence(ServerPaths.PublishFolder.value)
        && checkFolderExistence(ServerPaths.PublishFolder.value)) {
      LOG.info("Folders already created.");
    } else {
      createAllFolders();
    }
  }

  public static void createAllFolders() throws Exception {
    if (getSO().equals("windows")) {
      createClientFolderWindows();
      createProjectFolderWindows();
      createTemplateFolderWindows();
    } else {
      createClientFolderLinux();
      createProjectFolderLinux();
      createTemplateFolderLinux();
    }
    LOG.info("Project folder created.");
  }

  public static void createProjectFolderWindows() throws Exception {
    getFileInstance(ServerPaths.ClientFolder.value).mkdirs();
  }

  public static void createClientFolderWindows() throws Exception {
    getFileInstance(ServerPaths.PublishFolder.value).mkdirs();
  }

  public static void createTemplateFolderWindows() throws Exception {
    getFileInstance(ServerPaths.ProjectTemplateDir.value).mkdirs();
  }

  public static void createProjectFolderLinux() throws Exception {
    getFileInstance(ServerPaths.ClientFolderLinux.value).mkdirs();
  }

  public static void createClientFolderLinux() throws Exception {
    getFileInstance(ServerPaths.PublishFolderLinux.value).mkdirs();
  }

  public static void createTemplateFolderLinux() throws Exception {
    getFileInstance(ServerPaths.ProjectTemplateLinux.value).mkdirs();
  }

  public static boolean checkFolderExistence(String path) throws Exception {
    return getFileInstance(path).exists();
  }

  public static File getFileInstance(String folderPath) throws Exception {
    return new File(folderPath);
  }

  public static String getSO() throws Exception {
    String system = System.getProperty("os.name");
    if (system.toLowerCase().contains("windows")) {
      return "windows";
    } else if (system.toLowerCase().contains("linux")) {
      return "linux";
    } else {
      LOG.error("This is an unknown or unsupported operating system.", IllegalArgumentException.class);
    }
    return system;
  }

}
