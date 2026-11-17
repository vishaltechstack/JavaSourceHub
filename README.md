# ☕ Core Java Engineering Workbench (`JDK 21+`)

[![Java](https://img.shields.io/badge/Java-21%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![IDE](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![MySQL](https://img.shields.io/badge/MySQL-JDBC-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Modules](https://img.shields.io/badge/Modules-25%20Steps-2EA44F?style=for-the-badge)](#curriculum-breakdown)

A comprehensive, modular **Core Java Engineering Repository** covering 25 structured modules—progressing from foundational syntax and Object-Oriented Programming to modern Java 21 LTS features, Project Loom Virtual Threads, JVM internals, Data Structures & Algorithms from scratch, JDBC, Cryptography, SOLID Principles, and `ServiceLoader` SPI plugin architecture.

---

## 🛠️ Tech Stack & Environment

* ☕ **Language:** Java (JDK 21 LTS / JDK 25 compatible)
* 📦 **Build & Structure:** Pure Modular Java Project (`src/` source root + `resources/` classpath configuration)
* 💻 **IDE:** IntelliJ IDEA
* 🗄️ **External Libraries:** `mysql-connector-j` (for JDBC database connectivity)

---

## 📂 Project Architecture & Module Index

```text
JavaWorkbanch/
├── 📄 README.md
└── 📁 src/
    ├── 📁 META-INF/
    │   └── 📁 services/
    │       └── ⚙️ step25_spi_plugins.DataExporterPlugin
    ├── 📁 resources/
    │   ├── ⚙️ application.properties
    │   ├── 🌐 messages.properties
    │   ├── 🌐 messages_hi_IN.properties
    │   └── 🌐 messages_fr_FR.properties
    ├── 📁 Core_Java_Fundamentals/       # 01. Variables, Operators, Control Flow, Loops
    ├── 📁 structures/             # 02. Arrays, String vs StringBuilder, Methods
    ├── 📁 Oops_Basics/                  # 03. Classes, Objects, Constructors, Encapsulation
    ├── 📁 Advanced_Oops/                # 04. Inheritance, Polymorphism, Abstraction, Interfaces
    ├── 📁 Exceptions_Collections/       # 05. Custom Exceptions, List, Set, Map
    ├── 📁 Modern_Java_IO/               # 06. Lambdas, Streams API, Optional, java.nio.file
    ├── 📁 Concurrency_Library/          # 07A. Threads, Synchronization, ExecutorService
    ├── 📁 Capstone_Library/             # 07B. Library Management Mini-Capstone
    ├── 📁 Challenges/                   # 08. Algorithmic & Stream Coding Challenges
    ├── 📁 Internals_Generics/           # 09. Stack vs Heap, GC, Custom Generics, Comparators
    ├── 📁 Design_Patterns/              # 10. Singleton, Factory, Builder, Strategy
    ├── 📁 JDBC/                         # 11. PreparedStatement CRUD, ResultSet, Transactions
    ├── 📁 Reflection_Serialization/     # 12. Custom Annotations, Reflection API, Serializable
    ├── 📁 Modern_Java17_21/             # 13. Records, Sealed Classes, Pattern Matching, Text Blocks
    ├── 📁 virtual_threads/       # 14. Project Loom Virtual Threads, ReentrantLock, Fan-Out
    ├── 📁 Advanced_Functional/          # 15. CompletableFuture Pipelines, Custom Collectors, Currying
    ├── 📁 Data_Structures/              # 16. LinkedList, Stack, Queue, BST from Scratch
    ├── 📁 Algorithms/                   # 17. Binary Search, Merge Sort, Quick Sort
    ├── 📁 Networking/                   # 18. TCP ServerSocket/Socket & Sync/Async HttpClient
    ├── 📁 Datetime_API/                 # 19. LocalDateTime, ZonedDateTime, Instant, Duration
    ├── 📁 Regex/                        # 20. Pattern, Matcher, Named Groups, Input Validators
    ├── 📁 Packaging/                    # 21. Classpath Properties Loading & Executable JAR Packaging
    ├── 📁 security_crypto/       # 22. SecureRandom, SHA-256 Salted Hashing, AES-256-GCM
    ├── 📁 Internationalization/         # 23. Locale, ResourceBundle (EN/HI/FR), NumberFormat
    ├── 📁 Memory_Tuning/                # 24. Soft/Weak References, WeakHashMap, String Interning, JMX
    ├── 📁 solid_principles/      # 25A. SRP, OCP, LSP, ISP, Dependency Inversion
    └── 📁 spi_plugins/           # 25B. Dynamic Runtime Plugin Discovery via ServiceLoader
```

---

## 📚 Curriculum Breakdown

| Step | Package | Key Concepts Covered |
| :--- | :--- | :--- |
| **01** | 🌱 `Core_Java_Fundamentals` | Primitive types, type casting, operators, switch expressions, loops |
| **02** | 🧱 `step2_structures` | 1D/2D arrays, `String` pool immutability vs `StringBuilder`, method overloading |
| **03** | 🧩 `Oops_Basics` | Constructors, `this` keyword, encapsulation, getters/setters |
| **04** | 🧬 `Advanced_Oops` | Inheritance, runtime polymorphism, abstract classes, interfaces |
| **05** | 🧺 `Exceptions_Collections` | `try-catch-finally`, custom checked exceptions, `ArrayList`, `HashSet`, `HashMap` |
| **06** | 🌊 `Modern_Java_IO` | Functional interfaces, Streams pipelines, `Optional`, `Files` & `Path` NIO.2 |
| **07** | ⚡ `Concurrency_Library` & 📖 `Capstone_Library` | `Thread`, `Runnable`, `synchronized`, `ExecutorService`, Library Management System |
| **08** | 🎯 `Challenges` | Frequency maps, polymorphic payroll, stream analytics, string parsing |
| **09** | 🧠 `Internals_Generics` | JVM Stack vs Heap memory, Garbage Collection, bounded generics, `Comparable` vs `Comparator` |
| **10** | 🏗️ `Design_Patterns` | Thread-safe Double-Checked Singleton, Factory, Builder, Strategy patterns |
| **11** | 🗄️ `JDBC` | Centralized `Connection` factory, SQL-injection-safe `PreparedStatement`, atomic commit/rollback transactions |
| **12** | 🔍 `Reflection_Serialization` | `@Retention(RUNTIME)` annotations, runtime method invocation, `Serializable` & `transient` |
| **13** | 🚀 `Modern_Java17_21` | Immutable `record`s, `sealed` interfaces, `switch` pattern matching, Text Blocks |
| **14** | 🧵 `step14_virtual_threads` | Platform vs Virtual Threads, `newVirtualThreadPerTaskExecutor()`, `ReentrantLock` pinning prevention |
| **15** | 🔄 `Advanced_Functional` | Non-blocking `CompletableFuture` chains, custom `Collector.of()`, parallel stream safety |
| **16** | 🔗 `Data_Structures` | Generic Singly `LinkedList`, LIFO `Stack`, FIFO `Queue`, recursive `BinarySearchTree` |
| **17** | 📊 `Algorithms` | Iterative/Recursive Binary Search, stable Merge Sort, in-place Quick Sort |
| **18** | 🌐 `Networking` | Bidirectional TCP `ServerSocket`/`Socket` chat, Java `HttpClient` sync & async requests |
| **19** | 🕒 `Datetime_API` | Immutable `LocalDate`, `LocalTime`, `ZonedDateTime`, UTC `Instant`, `Period` vs `Duration` |
| **20** | 🔎 `Regex` | Pre-compiled `Pattern`s, named capturing groups, lookahead password & PAN/mobile validators |
| **21** | 📦 `Packaging` | Classpath resource loading (`getResourceAsStream`) & standalone executable JAR packaging |
| **22** | 🔐 `step22_security_crypto` | `SecureRandom` tokens/OTPs, salted `SHA-256` hashing, `AES/GCM/NoPadding` encryption |
| **23** | 🌍 `Internationalization` | Multi-language `ResourceBundle` (English, Hindi, French), `MessageFormat`, regional currency formatting |
| **24** | ⚙️ `Memory_Tuning` | `Strong`, `Soft`, and `Weak` references, `WeakHashMap` caching, `.intern()`, JMX Heap/GC inspection |
| **25** | 🏛️ `step25_solid_principles` & 🔌 `step25_spi_plugins` | All 5 SOLID principles & extensible runtime plugins via `java.util.ServiceLoader` |

---

## 🚀 Setup & Execution

### 1. 📥 Clone the Repository
```bash
git clone [https://github.com/](https://github.com/)<your-username>/Core-Java-Engineering-Workbench.git
cd Core-Java-Engineering-Workbench
```

### 2. ⚙️ Configure IntelliJ IDEA Paths
1. Open the project folder in **IntelliJ IDEA**.
2. Ensure **Project SDK** is set to **JDK 21** (or higher) under **File → Project Structure → Project**.
3. Right-click `src/resources` → **Mark Directory as → Resources Root** (ensures `ResourceBundle` and `Properties` files resolve at the classpath root).

### 3. 🗄️ Database Setup (Required only for Step 11 `JDBC`)
1. Attach `mysql-connector-j` JAR under **File → Project Structure → Modules → Dependencies**.
2. Execute the following SQL in MySQL Workbench or CLI:
   ```sql
   CREATE DATABASE core_java_db;
   USE core_java_db;

   CREATE TABLE accounts (
       account_id INT PRIMARY KEY AUTO_INCREMENT,
       holder_name VARCHAR(100) NOT NULL,
       balance DOUBLE NOT NULL
   );
   ```
3. Update your database credentials in `src/JDBC/DBConnectionManager.java` and run `JDBCRunner.java`.

---

## 👨‍💻 Author

**Vishal Sharma**
