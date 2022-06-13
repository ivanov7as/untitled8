import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonActionLister implements ActionListener  {

    private JTextField inputField;

    public ClearButtonActionLister(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputField.setText("");

    }
}
