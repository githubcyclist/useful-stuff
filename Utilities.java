import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * A giant utility class.
 * @author githubcyclist
*/
public class Utilities {
	
	public static JFrame createJFrame(String name, boolean isResizable, int width, int height)
	{
		JFrame toReturn = new JFrame(name);
		toReturn.setResizable(isResizable);
		toReturn.setSize(width, height);
		toReturn.setVisible(true);
		return toReturn;
	}
	
	/**
	 * This method generates a random number.
	 * It simplifies the nextInt method of the Random class.
	 * @param min - The minimum number.
	 * @param max - The maximum number.
	 * @return The random number.
	*/
	public static int randint(int min, int max) {
		return new Random().nextInt(max) + min;
	}
	
	private static String OS = null;
	   
	   public static String getOsName() {
	      if(OS == null) {
	    	  OS = System.getProperty("os.name");
	      }
	      return OS;
	   }
	   
	   /**
	    * Check if the user's OS is Windows.
	    * @return The boolean representing this.
	    * It is true if the OS is Windows, and false otherwise.
	   */
	   public static boolean isWindows() {
	      return getOsName().startsWith("Windows");
	   }
	   
	   /**
	    * Check if the user's OS is Mac.
	    * @return The boolean representing this.
	    * It is true if the OS is Mac, and false otherwise.
	   */
	   public static boolean isMac() {

			return (getOsName().indexOf("mac") >= 0);

		}
	   
	   /**
	    * Check if the user's OS is Linux.
	    * @return The boolean representing this.
	    * It is true if the OS is Linux, and false otherwise.
	   */
	   public static boolean isLinux() {
		   return getOsName().startsWith("Linux");
	   }
	   
	/**
	 * A cross-platform method to clear the screen.
	*/
    public static void clearScreen() {
			try {
				if(isWindows()) {
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
					new ProcessBuilder("clear").inheritIO().start().waitFor();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * This method writes to a file.
	 * @param toWrite - The text to write to the file.
	 * @param filePath - The path to the file to write to.
	*/
	public static void writeToFile(String toWrite, String filePath) {
		File fout = new File(filePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(toWrite);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method reads from a file.
	 * @param filePath - The path to the file to be read.
	 * @return The contents of the file.
	*/
	public static String readFile(String filePath) throws Exception {
		String returnString = "0";
		Scanner scanner = new Scanner(new FileReader(filePath));
		while(scanner.hasNextLine()){
			returnString = scanner.nextLine();
		}
		scanner.close();
		return returnString;
	}
	
	/**
	 * This method checks if a directory exists.
	 * @param path - The path to the folder to check.
	 * @return A boolean stating whether the directory exists or not.
	*/
	public static boolean doesDirectoryExist(String path) {
		return(Files.isDirectory(Paths.get(path)));
	}
	
	/**
	 * The current working directory.
	*/
	public static final String CWD =
			Paths.get(".").toAbsolutePath().normalize().toString();
	
	/**
	 * This method creates a new directory.
	 * @param path - The path to the new directory, including its name.
	 * @return A boolean stating the success of the method.
	*/
	public static boolean createDirectory(String path) {
		File dir = new File(path);
	    // attempt to create the directory here
	    boolean successful = dir.mkdir();
	    if (successful) {
	      // creating the directory succeeded
	      return true;
	    } else {
	      // creating the directory failed
	      return false;
	    }
	}
	
}
