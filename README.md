# 💰 Net Salary Estimator (2025 Edition)

## 📝 Overview

Net Salary Estimator is a console-based program that helps salespeople calculate their **take-home salary** after accounting for *commissions*, *bonuses*, and U.S. 2025 tax deductions.

The program features clean console styling, box-formatted prompts, processing animations, and **robust input validation**. It incorporates federal income tax, social security, and medicare deductions using accurate U.S. 2025 formulas, making it both *realistic* and **super-handy**.

---

## ⚡ Features

- Accepts **base salary**, **total sales**, *commission rate*, *bonus eligibility*, and **bonus amount**.  
- Calculates **gross income**, **federal tax**, *social security*, *medicare*, **total deductions**, and **net salary**.  
- Allows exit anytime by typing **`e`**.  
- Provides clear and consistent **error messages** (*empty input*, *invalid numbers*, *invalid yes/no*).  
- Uses **box-style prompts** with titles for better readability.  
- Displays results in a **clean tabular format**.  
- Supports **multiple estimations** in a single session.  

---

## 🔍 How It Works

### User Inputs
- **Base salary** (must be > 0)  
- **Total sales** (≥ 0)  
- **Commission rate** (1–100%) *if sales > 0*  
- **Bonus** (*if target achieved and sales > 0*)  
- Exit anytime by typing **`e`**  

### Calculations
- **Commission** = sales × commission rate  
- **Gross income** = base salary + commission + bonus  
- **Federal tax** = progressive tax brackets (2025)  
- **Social Security** = 6.2% of gross income (*up to $176,100*)  
- **Medicare** = 1.45% on all earnings + 0.9% on income above $200,000  
- **Total deductions** = federal tax + social security + medicare  
- **Net salary** = gross income − total deductions  

### Output
- A **set of results** showing *earnings, deductions, and net salary*.  

---

## 🏃 **How to Run**

You can run the program directly in your browser using **JDoodle**: 
[Click Here](https://www.jdoodle.com/ga/LY0wLnUkNLaOKfhzsI5LFQ%3D%3D)  

---

## 📂 Repository Structure

```text
net-salary-estimator/
├── Main.java - Main Program
├── ConsoleUtils.java - Utility Methods
├── LICENSE - License File
└── README.md - Documentation
```

---

## 🔒 Reuse & Contribution

This program is provided publicly **for portfolio and demonstration purposes only**. You may **not copy, modify, redistribute, or use** this code **without my explicit permission**.

If you’d like to request permission, please contact me at: [hafizmuhammadasimofficial@gmail.com](mailto:hafizmuhammadasimofficial@gmail.com) 

---

## 👤 Author

**Asim**
