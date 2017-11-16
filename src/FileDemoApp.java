import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemoApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the File Demo App");
		displayFilesInDirectory();
		System.out.println("Bye!");
	}
	
	private static void displayFilesInDirectory() {
		String dirString = Console.getString("Enter directory name:  ");
		Path dirPath = Paths.get(dirString);
		if (Files.exists(dirPath)&&Files.isDirectory(dirPath)) {
			System.out.println("Directory: "+dirPath.toAbsolutePath());
			System.out.println("Files:");
			try {
				DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
				for (Path p: dirStream) {
					if (Files.isRegularFile(p)) {
						System.out.println("     "+p.getFileName());
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}	
		}
	}
	private static void createFileAndDir() {
		String dirString = Console.getString("Enter directory name:  ");
		String fileString = Console.getString("Enter file name:  ");
		Path dirPath = Paths.get(dirString);
		Path dirFilePath = Paths.get(dirString, fileString);
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
		if (Files.notExists(dirFilePath)) {
			try {
				Files.createFile(dirFilePath);
				System.out.println("File successfully created"+dirFilePath);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		else {
			System.out.println("Sorry... couldn't create file because it already exists.");
		}
		
		System.out.println("File name:  "+dirFilePath.getFileName());
		System.out.println("Absolute Path:  "+dirFilePath.toAbsolutePath());
		System.out.println("Is writable?:  "+Files.isWritable(dirFilePath));
		System.out.println("Is writable? (dir):  "+Files.isWritable(dirPath));

		
	}
	private static void createFile() {
		String dirString = "c:/chapter15test";
		String fileString = "demo.txt";
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File successfully created"+filePath);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		else {
			System.out.println("Sorry... couldn't create file because it already exists.");
		}
	}
	
	private static void createDirectories() {
		String dirString = Console.getString("Enter directory name:  ");
		Path dirPath = Paths.get(dirString);
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}  
