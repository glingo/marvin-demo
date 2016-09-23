package marvin.demo.app;

import com.marvin.bundle.debug.DebugBundle;
import com.marvin.bundle.framework.FrameworkBundle;
import com.marvin.component.kernel.Kernel;
import com.marvin.component.kernel.bundle.Bundle;
import marvin.demo.app.bundles.nn.NeuralNetworkBundle;
import marvin.demo.app.bundles.test.TestBundle;

public class AppKernel extends Kernel {

    public AppKernel(boolean debug) {
        super(debug);
    }
    
    @Override
    protected Bundle[] registerBundles() {
        return new Bundle[]{
            new DebugBundle(),
            new FrameworkBundle(),
            new TestBundle(),
            new NeuralNetworkBundle()
        };
    }
    
    public static void main(String[] args) {
        Kernel kernel = new AppKernel(true);
        
        kernel.boot();
    }
    
}
