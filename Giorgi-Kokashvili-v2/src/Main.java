import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        File location = new File("C:\\Users\\IT-PC\\Desktop\\BTU DOCUMENT");
        Scanner scanner = new Scanner(System.in);
        boolean found;

        while (true) {
            System.out.println(countFiles(location));

            System.out.println("შეიყვანეთ საძიებო სიტყვა: ");
            String fileName = scanner.nextLine();
            logger.info("შემოტანილი სიტყვა: " + fileName);
            found = searchFiles(location, fileName);

            if (!found) {
                System.out.println("სიტყვის შესაბამისი ფაილი არ მოიძებნა!");
            }

        }
    }

    public static boolean searchFiles(File location, String searchVal) throws InterruptedException {
        boolean found = false;

        for (File file : location.listFiles()) {
            if (file.getName().toLowerCase().startsWith(searchVal.toLowerCase())) {
                logger.info("მოიძებნა: " + file.getName() + "  Dir:-> " + file.getPath());
                found = true;
            }
            if (file.isDirectory()) {
                if (searchFiles(file, searchVal)) {
                    found = true;
                }
            }
        }
        return found;
    }

    public static int countFiles(File location) throws InterruptedException {
        Thread.sleep(3000);
        File[] files = location.listFiles();
        return files.length;
    }

}
