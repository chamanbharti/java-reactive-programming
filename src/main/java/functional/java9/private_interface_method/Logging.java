package functional.java9.private_interface_method;

public interface Logging {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    void logInfo(String message);
    void logWarn(String message);
    void logError(String message);
    void logFatal(String message);

    void getConnection();
    void closeConnection();
}
