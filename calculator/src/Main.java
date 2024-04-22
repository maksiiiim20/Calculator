import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String[] args) {
        f = new JFrame("Calculator");
        Calculator c = new Calculator();
        l = new JTextField(16);
        l.setEditable(false);

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, bdot, breset, bequals;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bequals = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        breset = new JButton("C");
        bdot = new JButton(".");

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(l, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        p.add(ba, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        p.add(b1, gbc);
        gbc.gridy = 1;
        gbc.gridx = 2;
        p.add(b2, gbc);
        gbc.gridy = 1;
        gbc.gridx = 3;
        p.add(b3, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        p.add(bs, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        p.add(b4, gbc);
        gbc.gridy = 2;
        gbc.gridx = 2;
        p.add(b5, gbc);
        gbc.gridy = 2;
        gbc.gridx = 3;
        p.add(b6, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        p.add(bm, gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        p.add(b7, gbc);
        gbc.gridy = 3;
        gbc.gridx = 2;
        p.add(b8, gbc);
        gbc.gridy = 3;
        gbc.gridx = 3;
        p.add(b9, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        p.add(bd, gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        p.add(bdot, gbc);
        gbc.gridy = 4;
        gbc.gridx = 2;
        p.add(b0, gbc);
        gbc.gridy = 4;
        gbc.gridx = 3;
        p.add(breset, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        p.add(bequals, gbc);

        p.setBackground(Color.darkGray);

        f.add(p);
        f.setSize(250, 300);
        f.setVisible(true);

        b0.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);
        b5.addActionListener(c);
        b6.addActionListener(c);
        b7.addActionListener(c);
        b8.addActionListener(c);
        b9.addActionListener(c);
        bequals.addActionListener(c);
        ba.addActionListener(c);
        bs.addActionListener(c);
        bd.addActionListener(c);
        bm.addActionListener(c);
        breset.addActionListener(c);
        bdot.addActionListener(c);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.isEmpty())
                s2 = s2 + s;
            else
                s0 = s0 + s;
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            double te;
            if (!s0.isEmpty() && !s2.isEmpty()) {
                switch (s1) {
                    case "+":
                        te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                        break;
                    case "-":
                        te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                        break;
                    case "/":
                        te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                        break;
                    default:
                        te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                        break;
                }

                l.setText(s0 + s1 + s2 + "=" + te);

                s0 = Double.toString(te);

                s1 = s2 = "";
            } else {
                l.setText("not enough numbers");
            }
        } else {

            if (s1.isEmpty() || s2.isEmpty())
                s1 = s;
            else {
                double te;

                switch (s1) {
                    case "+":
                        te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                        break;
                    case "-":
                        te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                        break;
                    case "/":
                        te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                        break;
                    default:
                        te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                        break;
                }

                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            l.setText(s0 + s1 + s2);
        }
    }
}
