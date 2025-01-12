package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	public static String save(File file, String path) throws IOException {
		String fileName = generateUniqueFileName(file.getName()); 
		Path targetDiretory = Paths.get(path);
		
		if(!Files.exists(targetDiretory)) Files.createDirectories(targetDiretory);
		Path targetPath = targetDiretory.resolve(fileName);
		
		Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
		
		return targetPath.toString();
	}
	
	private static String generateUniqueFileName(String originalFileName) {
		String actualDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String input = actualDate + "_" + originalFileName;
		

		return actualDate + getFileExtension(originalFileName);		
	}

	private static String getFileExtension(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		
		if(dotIndex > 0) return fileName.substring(dotIndex);
		
		return "";	
	}
}
