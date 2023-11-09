package com.appfusion.apigenerator.builder.resourceLoader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * This class implements the ApplicationRunner interface and provides a run
 * method that is executed on application startup.
 * It calls the buildProjectFolders method of the FolderHandler class to create
 * project folders.
 * 
 * @author Gabriel Reis
 */
public class StartRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    FolderHandler.buildProjectFolders();
  }
}
