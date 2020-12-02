import java.awt.event.*;

class A4Handler implements ActionListener{
    A4 a4;
    A4Handler(A4 t4){
        this.a4 = t4;
    }
    public void actionPerformed(ActionEvent e){
        a4.b.setText("Button Clicked!!( by Third Class )");
    }
}
