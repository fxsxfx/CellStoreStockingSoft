# CellStoreStockingSoft

CellStoreStockingSoft is a backend Java application designed for comprehensive inventory and stock management in stores specializing in mobile devices and accessories. The system aims to streamline product control, optimize inventory updates, and improve the traceability of merchandise movements.

## 🎯 Objective

To develop a robust and scalable solution that manages the complete inventory cycle, from product registration to managing stock inflows and outflows, focused on a mobile phone and accessories retail store.

## 🛠️ Technologies and Tools Used

- Java 21
- Hibernate ORM for data persistence
- MySQL as the database management system
- Maven for dependency management and build automation
- JDBC for database connectivity and manipulation
- Eclipse IDE (optional)

## 🚀 Installation and Execution

1. Clone the repository:

```bash
git clone https://github.com/fxsxfx/CellStoreStockingSoft.git
```
2. Set up your local MySQL database with the necessary tables. (If you have a .sql script for schema creation, include it here.)

3. Update the database connection settings in the DB_Config.java class with your credentials.

4. Import the project into your IDE (Eclipse, IntelliJ, etc.) and build it.

5. Run the main class to start the application or use the available unit tests to validate functionality.

## ⚙️ Main Features
- Product management (create, update, delete)
- Inventory and stock control
- Logging of stock movements (inflows and outflows)
- Basic reports on stock levels and transactions
- Database integration through Hibernate

## 🔒 Security and Configuration
For security reasons, the DB_Config.java class is not included in the repository. You should create it locally and configure your database credentials.

Example:

```
public class DB_Config {
    public static final String SERVER = "jdbc:mysql://localhost/your_database";
    public static final String USER = "your_user";
    public static final String PASSWORD = "your_password";
}
```

🙋‍♀️ Author:
Fátima Aranda 
