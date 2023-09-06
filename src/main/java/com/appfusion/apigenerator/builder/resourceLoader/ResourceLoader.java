package com.appfusion.apigenerator.builder.resourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.ServerPaths;
import com.squareup.javapoet.JavaFile;

public class ResourceLoader {

  public static void saveJavaFile(JavaFileDTO fileDTO) throws Exception {
    JavaFile file = JavaFile.builder(fileDTO.getJsonPackage(), fileDTO.getSpec()).build();
    file.writeTo(new File(getClientFolderProject(fileDTO.getClientID()) + ServerPaths.JavaSRC.value));
  }

  public static void generateNewProject(String clientID) throws Exception {
    FileUtils.copyDirectory(getProjectTemplateDir(), getClientFolderProject(clientID));
  }

  public static File getProjectTemplateDir() {
    return new File(ServerPaths.ProjectTemplateDir.value);
  }

  public static File getClientFolderProject(String clientID) {
    return new File(ServerPaths.ClientFolder.value + clientID);
  }

  public static File getClientPublishFolder(String clientID) {
    return new File(ServerPaths.PublishFolder.value + clientID + ".zip");
  }

  public static void publishProject(String clientID) throws Exception {
    zipFolder(getClientFolderProject(clientID), getClientPublishFolder(clientID));
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

  public static void cleanProjectContent(String clientID) throws Exception {
    getClientPublishFolder(clientID).delete();
  }
}
