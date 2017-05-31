package marvin.demo.app;

import com.marvin.bundle.console.ConsoleApplication;
import com.marvin.bundle.framework.Application;
import com.marvin.component.kernel.Kernel;
import java.util.Arrays;

public class DemoApplication extends ConsoleApplication {
    
    protected static final String ENV_PARAMETER_PREFIX = "-env=";

    protected DemoApplication(Kernel kernel) {
        super(kernel);
    }
    
    public static void main(String[] args) {
        String env = Arrays.stream(args)
                .filter(arg -> arg.startsWith(ENV_PARAMETER_PREFIX))
                .findFirst().orElse("-env=dev")
                .replace(ENV_PARAMETER_PREFIX, "");
        Application.launch(DemoApplication.class, new AppKernel(env, true));
    }
}
