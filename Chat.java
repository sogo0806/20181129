import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat extends JFrame {
    private JButton jbt = new JButton("連");
    public Chat (){
        init();
    }
    public void init(){
        this.setBounds(100,100,300,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(jbt);
        jbt.setBounds(50,50,100,100);


        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerSocket so = new ServerSocket(2525);
                    Socket s = so.accept();
                    OutputStream out = s.getOutputStream();
                    String st = "Honor show the manyfyfyf";
                    out.write(st.getBytes());
                    out.close();
                    s.close();
                }catch (Exception exp){
                    JOptionPane.showMessageDialog(Chat.this,"發生了"+e+"例外");
                }
            }
        });
    }
}
