/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvin.demo.app;

import com.marvin.bundle.framework.FrameWorkBundle;
import com.marvin.component.kernel.Kernel;
import com.marvin.component.kernel.bundle.Bundle;
import marvin.demo.app.bundles.test.TestBundle;

/**
 *
 * @author Dr.Who
 */
public class AppKernel extends Kernel {

    public AppKernel(boolean debug) {
        super(debug);
    }
    
    @Override
    protected Bundle[] registerBundles() {
        return new Bundle[]{
            new FrameWorkBundle(),
            new TestBundle(),
        };
    }
    
}
