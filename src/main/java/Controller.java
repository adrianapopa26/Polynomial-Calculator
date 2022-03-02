import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {

    public TextField polynomial1;
    public TextField polynomial2;
    public TextField result1;
    public TextField result2;
    public Text t1;
    public Text t2;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        t1.setText("Result:");
        t2.setVisible(false);
        result2.setVisible(false);
    }


    public void handleAdditionButton() {
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations add=new Operations();
        add.getResult().getP1().clear();
        add.addition(p1,p2);
        result1.setText(add.getResult().polyToString());
        result2.setVisible(false);
        t1.setText("Result:");
        t2.setVisible(false);
    }

    public void handleSubtractionButton(){
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations subst=new Operations();
        subst.getResult().getP1().clear();
        subst.subtraction(p1,p2);
        result1.setText(subst.getResult().polyToString());
        result2.setVisible(false);
        t1.setText("Result:");
        t2.setVisible(false);
    }

    public void handleMultiplicationButton(){
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations op=new Operations();
        op.getResult().getP1().clear();
        op.multiplication(p1,p2);
        result1.setText(p1.polyToString());
        result2.setVisible(false);
        t1.setText("Result:");
        t2.setVisible(false);
    }

    public void handleDivisionButton(){
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations op=new Operations();
        op.getResult().getP1().clear();
        op.division(p1,p2);
        result1.setText(op.getResult().polyToString());

       if(!op.getReminder().getP1().isEmpty()) {
            result2.setVisible(true);
            result2.setText(op.getReminder().polyToString());
            t2.setVisible(true);
            t2.setText("Reminder:");
        }
        t1.setText("Result:");
    }

    public void handleIntegrationButton(){
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations op=new Operations();
        op.getResult().getP1().clear();
        op.integration(p1);
        result1.setText(op.getResult().polyToString());
        result2.setVisible(false);
        t1.setText("Result:");
        t2.setVisible(false);
    }

    public void handleDerivationButton(){
        String s=polynomial1.getText();
        Polynom p1=new Polynom();
        p1.readPolynomial(s);
        String s2=polynomial2.getText();
        Polynom p2=new Polynom();
        p2.readPolynomial(s2);
        Operations op=new Operations();
        op.getResult().getP1().clear();
        op.derivation(p1);
        result1.setText(op.getResult().polyToString());
        result2.setVisible(false);
        t1.setText("Result:");
        t2.setVisible(false);
    }
}
