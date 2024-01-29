import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class calculator extends JFrame
{
    JButton add,subtract,multiply,divide;
    JTextField num1,num2;
    JLabel result,enter1,enter2;

    calculator()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        enter1 = new JLabel("1st: ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(enter1,constraints);

        num1 = new JTextField(10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        add(num1,constraints);

        enter2 = new JLabel("2nd: ");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=0;
        constraints.gridy=1;
        add(enter2,constraints);

        num2 = new JTextField(10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=1;
        constraints.gridy=1;
        add(num2,constraints);

        add = new JButton("+");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth = 1;
        add(add,constraints);

        subtract = new JButton("-");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=1;
        constraints.gridy=2;
        add(subtract,constraints);

        multiply = new JButton("*");
        constraints.fill= GridBagConstraints.HORIZONTAL;
        constraints.gridx=2;
        constraints.gridy=2;
        add(multiply,constraints);

        divide = new JButton("/");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=3;
        constraints.gridy=2;
        add(divide,constraints);

        result = new JLabel("");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=4;
        add(result,constraints);

        event a = new event();
        add.addActionListener(a);
        subtract.addActionListener(a);
        multiply.addActionListener(a);
        divide.addActionListener(a);
    }

    class event implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            double number1,number2;

            try
            {
                number1=Double.parseDouble(num1.getText());
            }
            catch(NumberFormatException e)
            {
                result.setText("Incorrect 1st Field");
                result.setForeground(Color.RED);
                return;
            }
            try
            {
                number2 = Double.parseDouble(num2.getText());
            }
            catch(NumberFormatException e)
            {
                result.setText("Incorrect 2nd Field");
                result.setForeground(Color.RED);
                return;
            }
            String operator = a.getActionCommand();


            if(operator.equals("+"))
            {
                double sum = number1+number2;
                result.setText(number1+"+"+number2+"="+sum);
                result.setForeground(Color.BLACK);
            }
            if(operator.equals("-"))
            {
                double diff = number1-number2;
                result.setText(number1+"-"+number2+"="+diff);
                result.setForeground(Color.BLACK);
            }
            if(operator.equals("*"))
            {
                double product = number1*number2;
                result.setText(number1+"*"+number2+"="+product);
                result.setForeground(Color.BLACK);
            }
            if(operator.equals("/"))
            {
                if(number2==0)
                {
                    result.setText("Cannot divide by zero");
                    result.setForeground(Color.RED);
                }
                else
                {
                    double quo = number1/number2;
                    result.setText(number1+"/"+number2+"="+quo);
                    result.setForeground(Color.BLACK);
                }
            }
        }
    }
}