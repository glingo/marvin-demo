package marvin.demo.bundle.todo.resources.view.todo.swing;

import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import com.marvin.component.mvc.model.Model;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import marvin.demo.bundle.todo.model.Task;

public class ListView extends SwingView  {

    Object[][] rowData=    {
                    {"101","Rama","10000"},
                    {"102","Soma","20000"},
                    {"103","Raju","30000"},
                    {"104","Moju","40000"},
                    {"105","Kotu","50000"},
                    {"106","Potu","60000"}
                    };
    String[] colNames = {"ID", "Nom", "Description"};
    
    public ListView(String name) {
        super(name);
    }

    @Override
    protected void prepare(Handler<Action, JFrame> handler, Model model, JFrame frame) throws Exception {
        Object[][] data = {};
        Optional<List<Task>> tasks = model.get("todos", List.class);
        
        if (tasks.isPresent()) {
            
        }
        
        getPanel().setLayout(new FlowLayout());
        JTable table = new JTable(data, colNames);
        JScrollPane scroll = new JScrollPane(table);
        getPanel().add(scroll);
        getPanel().setSize(400,400);
    }
    

//    @Override
//    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
//        return "Todos :";
//    }
//
//    @Override
//    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
//        Optional<List<Task>> tasks = model.get("todos", List.class);
//        
//        if (!tasks.isPresent() || tasks.get().isEmpty()) {
//            return "No Task yet ...";
//        }
//        
//        return tasks.get().stream().map((task) -> {
//                return Objects.toString(task.getId()).concat(") ").concat(task.getTitle()).concat(" : ").concat(task.getDescription());
//            }).collect(Collectors.joining("|\n|")).concat("|\n");
//    }
}
