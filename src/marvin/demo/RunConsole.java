package marvin.demo;

import com.marvin.bundle.framework.shell.KernelShell;
import com.marvin.component.kernel.Kernel;
import marvin.demo.app.AppKernel;

public class RunConsole {
    
    public static void main(String[] args) throws Exception {
        Kernel kernel   = new AppKernel(true);
        
        KernelShell console = new KernelShell(kernel);
        console.start();

    }
}
