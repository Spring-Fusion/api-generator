package com.appfusion.apigenerator.builder.resourceLoader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class StartRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ResourceLoader.buildProjectFolders();
  }
}
