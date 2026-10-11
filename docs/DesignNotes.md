# Design Notes — Learner Management System

## 1. Why did I use ArrayList instead of an array?

I used `ArrayList` to store students, courses, and enrollments because the number of records can change dynamically while the application is running.

An array has a fixed size once it is created. If more records need to be added, a new array must be created and the existing elements copied into it.

An `ArrayList` grows automatically when elements are added and provides useful methods such as `add()`, `remove()`, `get()`, and `size()`.

Example:

```java
List<Student> students = new ArrayList<>();

students.add(student);
```

Here, `List` is the interface and `ArrayList` is the implementation.

**Benefits:**
- Dynamic size.
- Easy addition and removal of records.
- Convenient iteration and searching.
- Less manual array-management code.

For this small console application, `ArrayList` is a simple and suitable choice. Searching by ID still requires iteration unless an additional data structure, such as a `Map`, is introduced.

## 2. Where did I use static members and why?

Static members belong to the class rather than to an individual object.

In this project, static members can be used in the following places:

### Main method

```java
public static void main(String[] args);
```

The `main()` method is static because the Java Virtual Machine must be able to start the application without creating an instance of `MainMethod`.

### ID Generator

The `IdGenerator` utility can use static counters and methods to generate IDs without requiring an object of `IdGenerator` to be created.

Example:

```java
public class IdGenerator {

    private static int studentIdCounter = 1;

    public static int generateStudentId() {
        return studentIdCounter++;
    }
}
```

The method can be called as follows:

```java
int studentId = IdGenerator.generateStudentId();
```

A static counter is shared across instances of `IdGenerator` within the same running application. Separate counters can be maintained for students, courses, and enrollments.

The example above is illustrative; the actual names and ID types should match the project's implementation.

### Shared Scanner or constants

If `MainMethod` declares a shared scanner as:

```java
private static final Scanner SCANNER =
        new Scanner(System.in);
```

the scanner can be shared by static UI methods. The `final` keyword prevents the scanner reference from being reassigned; it does not make the scanner itself immutable.

Static members should be used only when class-level sharing is appropriate. Ordinary student and course details should remain instance fields because they differ from object to object.

## 3. Where did I use inheritance and what did I gain from it?

Inheritance is used when one class extends another class.

In this project, `Student` extends `Person`.

Example:

```java
public class Student extends Person {

    public Student(/* constructor parameters */) {
        super(/* parent constructor arguments */);
    }
}
```

`Person` can contain common attributes such as name and email, while `Student` can contain student-specific attributes such as batch and active status.

The `super(...)` call initializes the parent-class portion of a `Student` object by invoking the appropriate `Person` constructor.

**Benefits of inheritance:**

- Reuses common fields and methods.
- Reduces duplicated code.
- Makes the class hierarchy easier to understand.
- Allows common behaviour to be defined in the parent class.
- Supports method overriding and runtime polymorphism where appropriate.

For example, if `Person` defines a method such as `displayDetails()`, `Student` can override it to display student-specific information.

Inheritance is appropriate when the relationship represents an "is-a" relationship: a student is a person.

## 4. Clean Code Practices

The project follows, or should follow, these simple clean-code principles:

### Meaningful method names

Use names that describe the operation:

- `addStudent()`
- `findStudentById()`
- `findCourseById()`
- `updateStudentBatch()`
- `enrollStudent()`

Avoid unclear names such as `fun1()` or `doWork()` .

### Short, focused methods

Each method should have one clear responsibility. 
For example, input reading, student lookup,
and student creation should be separated when doing so improves clarity.

### Meaningful variables

Use names such as `studentId`, `courseId`, and `enrollmentStatus` instead of vague names such as `x`, `a`, or `temp` when the purpose is not obvious.

### Encapsulation

Keep entity fields `private` and expose access through suitable constructors, getters, and setters.

### Avoid duplicated logic

Reuse common validation and lookup methods instead of copying the same loops and checks into multiple methods.

### Handle errors clearly

Report missing students, missing courses, and invalid input with understandable messages. Do not display a success message if the requested operation failed.

### Consistent formatting

Use consistent indentation, spacing, class naming, and method naming throughout the project.

## 5. Conclusion

The design uses `ArrayList` for dynamically changing collections, static members for class-level functionality such as application entry and ID generation, and inheritance to reuse common person-related behaviour.

The package structure separates entity models, business logic, console interaction, utilities, and exceptions. Meaningful names, focused methods, encapsulation, and clear error handling make the application easier to understand, maintain, and extend.