package functional.java9.private_interface_method;

public class PrivateInterfaceMethod {

    public static void main(String[] args) {
        LogOracle log = new LogOracle();
        log.logInfo("");
        log.logWarn("");
        log.logError("");
        log.logFatal("");
        LogMySql log1 = new LogMySql();
        log1.logInfo("");
        log1.logWarn("");
        log1.logError("");
        log1.logFatal("");
    }
}
