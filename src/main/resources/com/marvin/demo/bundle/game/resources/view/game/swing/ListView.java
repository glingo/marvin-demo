package com.marvin.demo.bundle.game.resources.view.game.swing;

import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import com.marvin.bundle.framework.mvc.model.Model;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTable;

public class ListView extends SwingView  {

    String[][] rowData=    {
                    {"101","Rama","10000"},
                    {"102","Soma","20000"},
                    {"103","Raju","30000"},
                    {"104","Moju","40000"},
                    {"105","Kotu","50000"},
                    {"106","Potu","60000"}
                    };
    String[] colNames=    {"ID Number","Name","Salary"};
    
    public ListView(String name) {
        super(name);
    }

    @Override
    protected void prepare(Handler<Action, JFrame> handler, Model model, JFrame frame) throws Exception {
        JTable table = new JTable(rowData, colNames);
        getPanel().add(table);
    }

}
