import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GUI extends JFrame {

    private JLabel imageLabel = new JLabel(new ImageIcon("virus1.jpg"));
    private JFrame MainContentObj = new JFrame();



    public GUI() {
        super("Hello");
        this.setBounds(100,100,1000,1000);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 80));
        panel.add(imageLabel);
        this.getContentPane().add(panel);

       // ImageIcon icon = new ImageIcon("icon.png");
        //setIconImage(icon.getImage());

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                virus();
            }
        });

        /**/
    }

    public void virus(){
        if (!SystemTray.isSupported()) {
            return;
        }
        PopupMenu trayMenu = new PopupMenu();
        MenuItem item = new MenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayMenu.add(item);

        //URL imageURL = GUI.class.getResource("virus.png");


        Image icon = Toolkit.getDefaultToolkit().getImage("virus.png"); // картинка должна быть 32х32
        TrayIcon trayIcon = new TrayIcon(icon, "Hello", trayMenu);
        trayIcon.setImageAutoSize(true);

        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        trayIcon.displayMessage("Hello", "Application started!",
                TrayIcon.MessageType.INFO);
    }


    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    } }