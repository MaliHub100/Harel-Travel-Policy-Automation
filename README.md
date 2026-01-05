# Harel Travel Insurance - Automation Project 

This project is a Java-based automation suite for the **Harel Insurance** travel policy website.
It demonstrates a professional E2E (End-to-End) testing approach, specifically handling dynamic date selection and multi-page flows.

##  Key Features
* **Page Object Model (POM):** Built with clean separation between UI elements and test logic.
* **Dynamic Date Logic:** Automatically calculates dates (Current Day + 7) and handles the Date Picker across different months.
* **Cloud Integration (CI/CD):** Integrated with **GitHub Actions** to run tests automatically on every push.
* **Dual-Mode Execution:** The framework is environment-aware:
    * **Local:** Runs with a full **GUI (Graphic User Interface)**, allowing you to watch the browser actions in real-time during development.
    * **Remote/CI:** Automatically switches to **Headless Mode** when running in the cloud (GitHub Actions) to optimize performance and stability.
##  How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/MaliHub100/HarelTravelPoicy.git](https://github.com/MaliHub100/HarelTravelPoicy.git)