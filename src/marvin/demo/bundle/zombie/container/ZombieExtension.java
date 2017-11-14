package marvin.demo.bundle.zombie.container;

import com.marvin.component.configuration.ConfigurationInterface;
import com.marvin.component.container.ContainerBuilder;
import com.marvin.component.container.extension.Extension;
import com.marvin.component.container.xml.XMLDefinitionReader;
import com.marvin.component.resource.ResourceService;
import com.marvin.component.resource.loader.ClasspathResourceLoader;
import com.marvin.component.resource.reference.ResourceReference;
import com.marvin.component.xml.XMLReader;

import java.util.Map;
import marvin.demo.bundle.zombie.ZombieBundle;

public class ZombieExtension extends Extension {

    @Override
    public void load(Map<String, Object> configs, ContainerBuilder builder) {
        ResourceService service = ResourceService.builder()
                .with(ResourceReference.ANY_TYPE, new ClasspathResourceLoader(ZombieBundle.class))
                .build();
        XMLReader reader = new XMLDefinitionReader(service, builder);
        
        reader.read("resources/config/services.xml");
        
        ConfigurationInterface configuration = getConfiguration();
//        Map<String, Object> config = processConfiguration(configuration, configs);

//            HashMap<String, Definition> taggedDefinitions = builder.findTaggedDefinitions("event_subscriber");
//            for (Map.Entry<String, Definition> entrySet : taggedDefinitions.entrySet()) {
//                String id = entrySet.getKey();
//                Definition definition = entrySet.getValue();
//                
//            }
    }

}
