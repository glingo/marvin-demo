package marvin.demo.app.resources.view.swing;

import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import com.marvin.component.mvc.model.Model;
import java.util.Objects;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorView extends SwingView {

    public ErrorView(String name) {
        super(name);
    }
    

    @Override
    protected void prepare(Handler<Action, JFrame> handler, Model model, JFrame frame) throws Exception {
        JOptionPane.showMessageDialog(null, Objects.toString(model.get("exception"), "null"));
    }

//    @Override
//    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
//        return "Error";
//    }
//    
//    @Override
//    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal terminal) throws Exception {
//        AttributedStringBuilder builder = new AttributedStringBuilder()
//                .style(AttributedStyle.DEFAULT.underline())
//                .append("Exception : ")
//                .style(AttributedStyle.DEFAULT.underlineOff())
//                .append(Objects.toString(model.get("exception"), "null"))
//                .append(AttributedString.NEWLINE)
//                .style(AttributedStyle.DEFAULT.underline())
//                .append("Message : ")
//                .style(AttributedStyle.DEFAULT.underlineOff())
//                .append(Objects.toString(model.get("message"), "null"))
//                .append(AttributedString.NEWLINE)
//                .style(AttributedStyle.DEFAULT.underline())
//                .append("Result : ")
//                .style(AttributedStyle.DEFAULT.underlineOff())
//                .append(Objects.toString(model.get("result"), "null"))
//                .append(AttributedString.NEWLINE)
//                .style(AttributedStyle.DEFAULT.underline())
//                .append("Request : ")
//                .style(AttributedStyle.DEFAULT.underlineOff());
//        return builder.toAnsi(terminal);
//    }
}
