# Learner Management System

## 1. Project Description

The Learner Management System is a console-based Java application developed to manage students, courses, and enrollments.

The application provides a menu-driven interface that allows users to add, view, search, update, and manage student records, maintain course information, and enroll students in courses.

The project demonstrates core Java concepts, including Object-Oriented Programming (OOP), inheritance, encapsulation, polymorphism, collections, enums, and exception handling.

## 2. Technologies Used

- Java
- Java Collections Framework
- Object-Oriented Programming
- Exception Handling
- Java Enum
- Console input using `Scanner`

## 3. Project Structure

```text
LearnerManagementSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── airtribe/
│                   └── learntrack/
│                       ├── entity/
│                       ├── service/
│                       ├── ui/
│                       ├── exception/
│                       └── util/
├── docs/
│   └── Design_Notes.md
└── README.md
```

## 4. Features

- Add and list students.
- Search for students by ID.
- Update student batch information.
- Deactivate students.
- Add and list courses.
- Enroll students in courses.
- Validate student and course details during enrollment.
- Manage enrollment statuses.
- Handle invalid input and missing entities where implemented.

## 5. Prerequisites

- Java Development Kit (JDK) installed.
- A terminal or Java IDE such as IntelliJ IDEA or Eclipse.

Verify the Java installation:

```bash
java -version
javac -version
```

## 6. How to Compile and Run

### Option A: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Configure the project SDK to use an installed JDK.
3. Open `MainMethod.java` under the `ui` package.
4. Click the Run icon beside the `main()` method.
5. Follow the menu displayed in the console.

### Option B: Using the Command Line

Run these commands from the project root, assuming the source files are under `src/main/java` and the package names match the directory structure.

Compile all Java source files:

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
```

Run the application:

```bash
java -cp out ui.com.learnerManagement.MainMethod
```

On Windows Command Prompt, compile using a source-file list:

```bat
dir /s /b src\main\java\*.java > sources.txt
mkdir out
javac -d out @sources.txt
```

Then run:

```bat
java -cp out ui.com.learnerManagement.MainMethod
```

### Example Menu

```text
=== Learner Management System ===
1. Student Management
2. Course Management
3. Enrollment Management
4. Exit

Enter your choice:
```

## 7. Data Storage

The application uses in-memory collections to store records. Data is lost when the application terminates because database or file persistence is not implemented.

## 8. Future Enhancements

- Add database integration.
- Improve input validation.
- Add automated unit tests.
- Prevent duplicate records and enrollments.
- Extend course and enrollment management operations.