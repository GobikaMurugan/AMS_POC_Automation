# AMS_POC_Automation 

POC AMS Test Automation Framework
> Built with Java, Selenium WebDriver (Chrome), TestNG, Maven, and the Page Object Model (POM).

 1. Project Overview

**AMS_POC_Automation** is a clean, reliable, test automation framework built for end-to-end regression validation of an e-commerce web platform. 

The framework is specifically architected to:
- Separate configuration (`config.properties`) and external test data (`JSON`) from test logic.
- Avoid over-engineering (no complex listeners, retry logic, or parallel runners) while strictly adhering to industry-standard Page Object Model principles.

---

 2. Technology Stack

| Technology | Purpose |
| :--- | :--- |
| **Java 11+** | Core programming language |
| **Selenium WebDriver (4.x)** | Web browser automation engine (Dedicated to Chrome) |
| **TestNG (7.x)** | Test execution framework, assertions, and test suite management |
| **Maven** | Build management and dependency resolution |
| **WebDriverManager** | Automated Chrome binary management |
| **Jackson Databind** | High-performance JSON parser for external test datasets |
| **Git & GitHub** | Version control & repository hosting |

Automated Test for -

Login Feature:
The user should be able login with valid credentials - have reCAPTCHA issue.
An inline error message should shown for empty login input.
An error message should be displayed for the invalid login input.
Verify forgot password link is visible.

Wishlist Feature:
Verify anonymous user is redirected to Login page when adding product to Wishlist

Add to cart Feature:
Verify adding product to Cart from PDP
Verify adding product to Cart from PLP
Verify viewing empty cart message

Navigation:
Verify product search navigation to PLP
Verify direct navigation via Logo

---

## Execute Tests
Run all tests:
```bash
mvn test