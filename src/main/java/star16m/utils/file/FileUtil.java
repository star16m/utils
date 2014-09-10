package star16m.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import star16m.utils.string.StringUtil;

public class FileUtil {

    public static String getBaseName(String fileFullName) {
        if (fileFullName == null) {
            return null;
        }
        String fileName = getFileName(fileFullName);
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
    public static String getFileName(String fileFullName) {
        if (fileFullName == null) {
            return null;
        }
        int windowIndex = fileFullName.lastIndexOf("\\");
        int unixIndex = fileFullName.lastIndexOf("/");
        return fileFullName.substring(Math.max(windowIndex, unixIndex)+1);
    }
    public static String getFileExtension(File file) {
        return getFileExtension(file.getName());
    }
    public static String getFileExtension(String fileName) {
    	return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
    public static File[] find(final File rootDirectory, final FileFilter fileFilter) throws Exception {
        List<File> fileList = new ArrayList<File>();
        walk(rootDirectory, fileList, fileFilter);
        return fileList.toArray(new File[0]);
    }
    public static FileFilter getFileFilter(final boolean isFile) {
        return new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile()) && isFile || (file.isDirectory() && !isFile);
            }
        };
    }
    public static FileFilter getFileFilter(final String extension) {
        return new FileFilter() {
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(extension.toLowerCase());
            }
        };
    }
    public static FileFilter getFileFilter(final Matcher fileNameMatcher) {
        return new FileFilter() {
            public boolean accept(File file) {
                fileNameMatcher.reset(file.getName());
                return fileNameMatcher.find();
            }
        };
    }
    public static String[] getFileAbsolutePath(final File[] fileList) {
        List<String> fileAbsolutePathList = new ArrayList<String>();
        if (fileList != null && fileList.length > 0) {
            for (File file : fileList) {
                fileAbsolutePathList.add(file.getAbsolutePath());
            }
        }
        return fileAbsolutePathList.toArray(new String[0]);
    }
    public static void replaceFile(File sourceFile, String destFilePath, Map<String, String> replaceMapInfo) throws IOException {
        File destFile = new File(destFilePath);
        if (destFile.exists()) {
            throw new IOException("already exists dest file.");
        }
        BufferedReader inputReader  = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(destFile));
        String line = null;
        while ((line = inputReader.readLine()) != null) {
            outputWriter.write(StringUtil.getReplaceLine(line, replaceMapInfo));
        }
        outputWriter.flush();
        inputReader.close();
        outputWriter.close();
    }

    private static void walk(final File rootDirectory, final List<File> searchedFiles, final FileFilter fileFilter) {
        File[] fileList = rootDirectory.listFiles(fileFilter);
        if (fileList != null && fileList.length > 0) {
            for (File file : fileList) {
                searchedFiles.add(file);
            }
        }
        File[] directoryList = rootDirectory.listFiles(getFileFilter(false));
        if (directoryList != null && directoryList.length > 0) {
            for (File directory : directoryList) {
                walk(directory, searchedFiles, fileFilter);
            }
        }
    }
}
