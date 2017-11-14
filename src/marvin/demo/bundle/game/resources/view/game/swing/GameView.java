package marvin.demo.bundle.game.resources.view.game.swing;

import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import com.marvin.component.mvc.model.Model;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTable;

public class GameView extends SwingView {
    public GameView(String name) {
        super(name);
    }

    @Override
    protected void prepare(Handler<Action, JFrame> handler, Model model, JFrame frame) throws Exception {
        
    }
}
