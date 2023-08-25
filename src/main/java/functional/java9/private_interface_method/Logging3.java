package functional.java9.private_interface_method;

public interface Logging3 {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    private void log(String message,String prefix){
        getConnection();
        System.out.println("Log Message :"+prefix);
        closeConnection();
    }
    default void logInfo(String message) {
//        getConnection();
//        System.out.println("Log Message : " + "INFO");
//        closeConnection();
        log(message,"INFO");
    }
    default void logWarn(String message) {
        log(message,"WARN");
    }
    default void logError(String message) {
        log(message,"ERROR");
    }
    default void logFatal(String message) {
        log(message,"FATAL");
    }
    static void getConnection() {
        System.out.println("Open Database connection");
    }
    static void closeConnection() {
        System.out.println("Close Database connection");
    }
}
