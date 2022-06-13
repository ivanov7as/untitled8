import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(1700, 1500, 250, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        //  testListener();
        //  button.addActionListener(e -> System.out.println("Событие"));

        setJMenuBar(createMenu());
        setLayout(new BorderLayout());
        add(createTopPanel(), new Button("1"), Integer.parseInt(BorderLayout.NORTH));
        add(createCenterPanel(),new Button("5"), Integer.parseInt(BorderLayout.CENTER));


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar =  new JMenuBar();
        JMenu menuFile = new JMenu("File");


        menuBar.add(menuFile);

        menuBar.add(new JMenuItem("About"));
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("Exit"));


        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);
       /* exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
*/
        exitItem.addActionListener(new ExitButtonListener());
        return null;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputField = new JTextField();
        top.add(inputField);

        inputField.setText("(1 + 5) * 2 = 12");

        return top;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener),BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener),BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiple = new OperatorJButton("*");
        multiple.addActionListener(buttonListener);
        panel.add(multiple);

        JButton divide = new OperatorJButton(":");
        divide.addActionListener(buttonListener);
        panel.add(divide);

        return panel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4,3 ));
        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);

        }
        JButton calc = new OperatorJButton("=");
        digitsPanel.add(calc);

        JButton clear = new OperatorJButton("C");

        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionLister(inputField));


        return digitsPanel;
    }

    private void testListener() {
        Button button = new Button("Кнопка");
        button.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           System.out.println("Событие");

       }
   });
        super.add(button);
    }
}
