import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {

    Log log = new Log();


    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        String testName = context.getDisplayName();
        String reasonMessage = reason.orElse("No reason provided");
        log.info(testName + "is DISABLED WITH CAUSE:" + reasonMessage);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        log.info(testName + "is SUCCESSED!");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String causeMessage = cause.getMessage();
        log.warn(testName + "is ABORTED with cause" + causeMessage);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String causeMessage = cause.getMessage();
        log.error(testName + "is FAILED with cause" + causeMessage);

    }

}