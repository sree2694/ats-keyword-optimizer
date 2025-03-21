
---

# 📝 ATS Keyword Optimizer

A Spring Boot web application that helps optimize resumes by extracting and matching keywords from job descriptions. Designed for ATS (Applicant Tracking Systems) compatibility using **Apache Tika**, **JSoup**, and **Spring AI**.

---

## 🚀 Features
✅ Upload **PDF/DOCX Resumes**  
✅ Extract text content using **Apache Tika**  
✅ Parse **Job Descriptions** and extract required skills/keywords  
✅ Keyword matching and optimization scoring  
✅ Simple **Thymeleaf UI** for interaction  
✅ Logging via **Log4j2**  
✅ **H2 Database** integration (for optional persistence)

---

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.4.4**
- **Spring Web / Thymeleaf**
- **Apache Tika**
- **JSoup**
- **Spring AI (Tika Document Reader)**
- **H2 Database (runtime)**
- **Log4j2 for logging**
- **Lombok**

---

## 📂 Project Structure
```
src/main/java/com/ats/ats_keyword_optimizer/
│
├── controller/           # REST & Web Controllers
├── service/              # Business logic
├── model/                # Data models / DTOs
├── utils/                # Tika & parsing utilities
└── AtsKeywordOptimizerApplication.java
```

---

## ⚙️ Getting Started

### ✅ Prerequisites:
- JDK 17+
- Maven 3.8+
- (Optional) Visual Studio Code / IntelliJ IDEA

### 📥 Clone the Repository:
```bash
git clone https://github.com/your-username/ats-keyword-optimizer.git
cd ats-keyword-optimizer
```

### 🧹 Clean & Build:
```bash
mvn clean install
```

### ▶️ Run the Application:
```bash
mvn spring-boot:run
```
or
```bash
java -jar target/ats-keyword-optimizer-0.0.1-SNAPSHOT.jar
```

---

## 🌐 API Endpoints (Sample)
| Method | Endpoint                 | Description                        |
|------- |--------------------------|------------------------------------|
| POST   | /uploadResume            | Upload and parse a resume file     |
| POST   | /uploadJobDescription    | Upload and parse a job description |
| GET    | /optimize                | View optimized keywords            |

---

## 📄 Example Usage
- Upload your **resume**
- Upload the **job description**
- Get an **optimization report** highlighting missing keywords

---

## 🪵 Logging
The application uses **Log4j2** for better logging and debugging:
```bash
logs/application.log
```

---

## 🗂 Sample `.env` (if needed later)
```
SPRING_PROFILES_ACTIVE=dev
LOG_LEVEL=INFO
```

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome!  
Feel free to fork and submit a pull request.

---

## 📃 License
This project is open-source and available under the [MIT License](LICENSE).

---

## ✨ Future Enhancements
- OpenAI / ChatGPT API integration for smarter keyword suggestions
- User login & storage of parsed results
- PDF/Word resume download with suggested keywords added

---
