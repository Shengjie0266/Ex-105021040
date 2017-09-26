import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnAdd = new Button("Add");
    private Button btnExit = new Button("Exit");
    private Button btnSub = new Button("Sub");
    private Label lab = new Label(">o<");
    private int count =0,labx=50,laby=50;
    private Timer t1;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,400,500);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        lab.setBounds(50,50,30,20);
        this.add(lab);
        btnAdd.setBounds(50,300,50,20);
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(++count));
                lab.setText(Integer.toString(count));
                t1.start();
            }
        });
        btnExit.setBounds(180,300,50,20);
        this.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSub.setBounds(310,300,50,20);
        this.add(btnSub);
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle(Integer.toString(--count));
                lab.setText(Integer.toString(count));
            }
        });
        t1 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labx += 5;
                lab.setLocation(labx,laby);
            }
        });
    }
}
