package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import com.marvin.component.kernel.Kernel;

public class TestController extends ContainerAware {

//    @Route(name = "test.charger", path = "/test/charger")//, reponse="ressources/view/nav.view.twig"
    public void test() {
        Kernel kernel = this.get("kernel", Kernel.class);
        System.out.println(kernel);
        System.out.println("test.charger");
    }
}
