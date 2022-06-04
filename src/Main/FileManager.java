package Main;

public class FileManager {
    public static void CreatingFile(){
        try{
            File myFile = new File("Scores.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException ioexception) {
            System.out.println("Error has been found while creating a file.");
            ioexception.printStackTrace();
        }
    }
    public static void AddingScores(String username,int score){
        try{
            BufferedWriter bfwriter = new BufferedWriter(new FileWriter(("Scores.txt"), true));
            bfwriter.write(username + " "+ score);
            System.out.println("Player name and score has been successfully written.");
            bfwriter.newLine();
            bfwriter.close();
        }catch(IOException exception){
            System.out.println("Error has been found while writing information through file.");
            exception.printStackTrace();
        }
    }
    public static void ReadingScores(){
        try{
            String myScores = "Scores.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(myScores));
            String ReadingLines;
            while ((ReadingLines = bufferedReader.readLine()) != null) {
                System.out.println(ReadingLines);
            }
            bufferedReader.close();
        } catch(IOException e){
            System.out.println("Error has been found while reading information from file.");
            e.printStackTrace();
        }
    }

    public static void removeLineFromFile(String FileOfTheScores, String RemovingLine) {
        try {
            File myFile = new File(FileOfTheScores);

            if (!myFile.isFile()) {
                System.out.println("The file which entered as a parameter cannot be found.");
                return;
            }

            File tempFile = new File(myFile.getAbsolutePath() + ".tmp");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(FileOfTheScores));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

            String Readline = null;

            while ((Readline = bufferedReader.readLine()) != null) {
                if (!Readline.trim().equals(RemovingLine)) {
                    printWriter.println(Readline);
                    printWriter.flush();
                }
            }
            printWriter.close();
            bufferedReader.close();

            if (!myFile.delete()) {
                System.out.println("Error has been found while deleting. ");
                return;
            }
            if (!tempFile.renameTo(myFile))
                System.out.println("Error has been found while renaming a file. ");
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
