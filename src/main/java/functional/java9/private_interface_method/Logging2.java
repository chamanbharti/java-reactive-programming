package functional.java9.private_interface_method;

public interface Logging2 {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    default void logInfo(String message) {
        getConnection();
        System.out.println("Log Message : " + "INFO");
        closeConnection();
    }
    default void logWarn(String message) {
        getConnection();
        System.out.println("Log Message : " + "WARN");
        closeConnection();
    }
    default void logError(String message) {
        getConnection();
        System.out.println("Log Message : " + "ERROR");
        closeConnection();
    }
    default void logFatal(String message) {
        getConnection();
        System.out.println("Log Message : " + "FATAL");
        closeConnection();
    }
    static void getConnection() {
        System.out.println("Open Database connection");
    }
    static void closeConnection() {
        System.out.println("Close Database connection");
    }
}
