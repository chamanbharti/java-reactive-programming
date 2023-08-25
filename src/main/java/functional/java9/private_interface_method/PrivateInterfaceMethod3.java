package functional.java9.private_interface_method;

public class PrivateInterfaceMethod3 {

    public static void main(String[] args) {
        LogOracle3 log = new LogOracle3();
        log.logInfo("");
        log.logWarn("");
        log.logError("");
        log.logFatal("");
        LogMySql3 log1 = new LogMySql3();
        log1.logInfo("");
        log1.logWarn("");
        log1.logError("");
        log1.logFatal("");
    }
}
