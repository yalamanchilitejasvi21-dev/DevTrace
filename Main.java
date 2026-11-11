import java.io.IOException;
import java.nio.file.*;
import java.util.*;
class InvalidFormatException extends Exception{
    InvalidFormatException(String message){
        super(message);
    }
}
interface LogAnalyzer{
    void analyze(String line);
}
class Log implements LogAnalyzer{
    String message;
    Log(String message){
        this.message=message;
    }

    public void analyze(String line){
        if(line.startsWith("INFO")){
            System.out.println("This is a Info Log");
        }
        else if(line.startsWith("WARNING")){
            System.out.println("This is a Warning Log");
        }
        else if(line.startsWith("ERROR")){
            System.out.println("This is a Error Log");
        }
    }
    void Display(){
        System.out.println("Log message: "+message);
            }
}
class ErrorLog extends Log{
    ErrorLog(String message){
        super(message);
    }
    void Display(){
    System.out.println("ERROR: "+message);
    }
}

class InfoLog extends Log {

    InfoLog(String message) {
        super(message);
    }

    void Display() {
        System.out.println("INFO: " + message);
    }
}
class WarningLog extends Log {

    WarningLog(String message) {
        super(message);
    }

    void Display() {
        System.out.println("WARNING: " + message);
    }
}

class ErrorAnalysisThread extends Thread{
    List<String>lines;
HashMap<String, Integer> errorMap = new HashMap<>();
    int errorcount=0;
    ErrorAnalysisThread(List<String> lines){
        this.lines=lines;
    }
      public void run() {

        for (String line : lines) {

            if (line.startsWith("ERROR:")) {

                errorcount++;

                String errorMessage = line.substring(6).trim();

                if (errorMap.containsKey(errorMessage)) {

                    int count = errorMap.get(errorMessage);

                    errorMap.put(errorMessage, count + 1);
                }
                else {
                    errorMap.put(errorMessage, 1);
                }
            }
        }
    }

}


class Main {
    static void validate(String line)throws InvalidFormatException{
         if (!(line.startsWith("INFO:") ||
          line.startsWith("WARNING:") ||
          line.startsWith("ERROR:"))) {

        throw new InvalidFormatException("Invalid log format: " + line);
    }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

System.out.println("Enter number of log messages:");
int n = sc.nextInt();
sc.nextLine();

ArrayList<String> input = new ArrayList<>();

for(int j = 0; j < n; j++) {
    System.out.println("Enter log message " + (j+1) + ":");
    String line = sc.nextLine();
    input.add(line);
}

try {
    Files.write(Paths.get("application.log"), input);
    System.out.println("Logs saved successfully!");
}
catch(IOException e) {
    System.out.println("Error writing log file!");
}
        int infocount=0;
        int warningcount=0;
      List<String> lines = new ArrayList<>();
        
        try{
            lines=Files.readAllLines(Paths.get("application.log"));

            for(String line:lines) {
                try{
                    validate(line);
                }
                catch(InvalidFormatException e){
                    System.out.println(e.getMessage());
                    continue;
                }
                 
                Log l = new Log(line);
                l.analyze(line);


               
                if(line.startsWith("INFO")){
                    infocount++;
                    String message=line.substring(5).trim();
                    InfoLog i=new InfoLog(message);
                    i.Display();
                }
                else if(line.startsWith("WARNING")){
                    warningcount++;
                    String message=line.substring(8).trim();
                    WarningLog w=new WarningLog(message);
                    w.Display();
                }
                else if(line.startsWith("ERROR")){
                    String errormessage=line.substring(6).trim();
                    ErrorLog e=new ErrorLog(errormessage);
                    e.Display();
                }

            }

        } catch (Exception e) {

            System.out.println("Error reading file!");
        }
        ErrorAnalysisThread t = new ErrorAnalysisThread(lines);

t.start();

try {
    t.join();
}
catch (InterruptedException e) {
    System.out.println("Thread interrupted!");
    Thread.currentThread().interrupt();
}
ArrayList<String> report = new ArrayList<>();
        System.out.println("==========Log Report==========");
        report.add("==========Log Report==========");
        System.out.println("INFO messages: "+infocount);
        report.add("INFO messages: "+infocount);
        System.out.println("WARNING messages: "+warningcount);
        report.add("WARNING messages: "+warningcount);
        System.out.println("ERROR messages: "+t.errorcount);
        report.add("ERROR messages: "+t.errorcount);

        System.out.println("==========Frequent Errors==========");
        report.add("==========Frequent Errors==========");
        for(Map.Entry<String,Integer> entry:t.errorMap.entrySet()){
            String result=entry.getKey()+":"+entry.getValue();
            System.out.println(result);
            report.add(result);
        }

        try{
            Files.write(Paths.get("report.txt"),report);
                System.out.println("Report saved successfully!");

        }
        catch(IOException e){
                System.out.println("Error writing report!");

        }
            }
}

        