package com.appfusion.apigenerator.builder.resourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appfusion.apigenerator.builder.DTOs.JavaFileDTO;
import com.appfusion.apigenerator.builder.enums.ServerPaths;
import com.squareup.javapoet.JavaFile;

public class ResourceLoader {

  private static Logger LOG = LoggerFactory.getLogger(ResourceLoader.class);

  public static void saveJavaFile(JavaFileDTO fileDTO) throws Exception {
    JavaFile file = JavaFile.builder(fileDTO.getJsonPackage(), fileDTO.getSpec()).build();
    file.writeTo(new File(getClientFolderProject(fileDTO.getClientID()) + ServerPaths.JavaSRC.value));
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

  public static void generateNewProject(String clientID) throws Exception {
    FileUtils.copyDirectory(getProjectTemplateDir(), getClientFolderProject(clientID));
  }

  public static File getProjectTemplateDir() throws Exception {
    if (getSO().equals("windows")) {
      return new File(ServerPaths.ProjectTemplateDir.value);
    }
    return new File(ServerPaths.ProjectTemplateLinux.value);
  }

  public static File getClientFolderProject(String clientID) throws Exception {
    if (getSO().equals("windows")) {
      return new File(ServerPaths.ClientFolder.value + clientID);
    }
    return new File(ServerPaths.ClientFolderLinux.value + clientID);
  }

  public static File getClientPublishFolder(String clientID) throws Exception {
    if (getSO().equals("windows")) {
      return new File(ServerPaths.PublishFolder.value + clientID + ".zip");
    }
    return new File(ServerPaths.PublishFolderLinux.value + clientID + ".zip");
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
