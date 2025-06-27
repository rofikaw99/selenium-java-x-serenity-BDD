# selenium-java-x-serenity-BDD

Automated web testing suite using **Selenium**, **Java**, and **Serenity BDD**—engineered to validate UI and functional workflows for the CubeForAll platform.

## 📁 Project Structure

- `ccn-web-automation-master/` — Main test suite and page object models
- `.idea/` — IntelliJ configuration files (can be ignored for build purposes)
- `.gitignore` — Standard exclusions (e.g., `.class`, `.log`)
- `azure-pipelines.yml` — Azure DevOps pipeline setup

## ⚙️ Tech Stack

- **Selenium WebDriver**
- **Java 11+**
- **Serenity BDD** (with JUnit)
- **Maven** for dependency management and build

## 🧪 Current Focus

- Automated script to test the **registration flow** for impacted users due to new CubeForAll system behavior
- Ensures correct page redirection, field validations, and access control

## 🚀 Getting Started

```bash
git clone https://github.com/your-org/selenium-java-x-serenity-BDD.git
cd selenium-java-x-serenity-BDD/ccn-web-automation-master
mvn clean verify
