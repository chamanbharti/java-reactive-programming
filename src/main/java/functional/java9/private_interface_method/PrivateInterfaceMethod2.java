package functional.java9.private_interface_method;

public class PrivateInterfaceMethod2 {

    public static void main(String[] args) {
        LogOracle2 log = new LogOracle2();
        log.logInfo("");
        log.logWarn("");
        log.logError("");
        log.logFatal("");
        LogMySql2 log1 = new LogMySql2();
        log1.logInfo("");
        log1.logWarn("");
        log1.logError("");
        log1.logFatal("");
    }
}
