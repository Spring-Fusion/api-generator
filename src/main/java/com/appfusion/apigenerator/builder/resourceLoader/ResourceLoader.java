package com.appfusion.apigenerator.builder.resourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.squareup.javapoet.JavaFile;

public class ResourceLoader {

  public static void saveJavaFile(JavaFileDTO fileDTO) throws Exception {
    JavaFile file = JavaFile.builder(fileDTO.getJsonPackage(), fileDTO.getSpec()).build();
    file.writeTo(new File("C:/Users/Meu Computador/Documents/App Fusion/projects/" + fileDTO.getClientID() + "/src/main/java"));
  }

  public static void generateNewProject(String clientID) throws Exception {
    File projectTemplate = new File("C:/Users/Meu Computador/Documents/App Fusion/project_template");
    File clientProject = new File("C:/Users/Meu Computador/Documents/App Fusion/projects/" + clientID);
    FileUtils.copyDirectory(projectTemplate, clientProject);
  }

  public static void publishProject(String clientID) throws Exception {
    File clientProject = new File("C:/Users/Meu Computador/Documents/App Fusion/projects/" + clientID);
    File clientProjectDestination = new File(
        "C:/Users/Meu Computador/Documents/App Fusion/publish_projects/" + clientID + ".zip");
    zipFolder(clientProject, clientProjectDestination);
  }

  public static void zipFolder(File sourceFolder, File destinationZipFile) throws IOException {
    FileOutputStream fos = new FileOutputStream(destinationZipFile);
    ZipOutputStream zipOut = new ZipOutputStream(fos);

    for (File file : FileUtils.listFiles(sourceFolder, null, true)) {
      String entryName = sourceFolder.toURI().relativize(file.toURI()).getPath();
      ZipEntry zipEntry = new ZipEntry(entryName);
      zipOut.putNextEntry(zipEntry);

      if (!file.isDirectory()) {
        IOUtils.copy(FileUtils.openInputStream(file), zipOut);
      }
      zipOut.closeEntry();
    }
    zipOut.close();
    fos.close();
  }

}
