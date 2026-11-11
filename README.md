# DevTrace

**A Java-Based Log Analysis and Error Tracking Tool**

DevTrace is a Java-based application designed to analyze application logs, identify errors, and generate a structured error analysis report. It demonstrates core Java programming concepts and software development techniques.

## Features

- **Log Validation:** Validates log entries with INFO, WARNING, and ERROR prefixes.
- **Log Categorization:** Categorizes messages based on severity.
- **Error Analysis:** Identifies and analyzes error messages.
- **Error Frequency Tracking:** Uses HashMap to count recurring errors.
- **Multithreading:** Performs error analysis using a separate thread.
- **Exception Handling:** Uses a custom exception to handle invalid log formats.
- **File Handling:** Reads and writes log data using Java NIO.
- **Report Generation:** Generates a structured error analysis report.

## Technologies Used

### Programming Language
- Java

### Core Java Concepts
- Inheritance
- Method Overriding
- Interfaces
- Collections Framework (ArrayList, HashMap)
- Multithreading
- Exception Handling
- Custom Exceptions
- Java NIO (File Handling)

### Development Tools
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
DevTrace/
│
├── Main.java
├── application.log
├── report.txt
├── .gitignore
└── README.md
```

## How It Works

1. Accepts log messages as input.
2. Validates the format of each log entry.
3. Categorizes messages into INFO, WARNING, and ERROR.
4. Identifies and counts recurring error messages.
5. Performs error analysis using multithreading.
6. Generates a report containing the analysis results.

## Sample Log Format

```text
INFO: Application started
WARNING: Low memory detected
ERROR: Database connection failed
ERROR: Database connection failed
INFO: Application stopped
```

## Sample Analysis

```text
Total Errors: 2

Error Frequency:
Database connection failed: 2
```

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/yalamanchilitejasvi21-dev/DevTrace.git
```

2. Navigate to the project directory:

```bash
cd DevTrace
```

3. Compile the Java program:

```bash
javac Main.java
```

4. Run the program:

```bash
java Main
```

5. Enter the log messages when prompted and view the generated report.

## Future Enhancements

- Integration with Large Language Models (LLMs).
- Retrieval-Augmented Generation (RAG) for intelligent log analysis.
- AI-powered error explanation and debugging assistance.
- Database integration for storing historical logs.
- Interactive dashboard for log visualization.

## Screenshots

### DevTrace Console Output
![DevTrace Output](Screenshot%202026-11-11%20100527.png)

### DevTrace Error Analysis Report
![DevTrace Report](Screenshot%202026-11-11%20101151.png)

## Author

**Tejasvi Yalamanchili**

B.Tech Computer Science and Engineering

GitHub: [yalamanchilitejasvi21-dev](https://github.com/yalamanchilitejasvi21-dev)

---

*DevTrace is an evolving project focused on building intelligent software debugging and log analysis capabilities using Java.*
