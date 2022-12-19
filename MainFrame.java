package bsu.rfe.java.droup8.Kirilenko.lab2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
private static final int WIDTH = 500;
private static final int HEIGHT = 400;
private JTextField textFieldX;
private JTextField textFieldY;
private JTextField textFieldZ;
private JTextField textFieldResult;
private ButtonGroup radioButtons = new ButtonGroup();
private ButtonGroup radioButtons1 = new ButtonGroup();
private Box hboxFormulaType = Box.createHorizontalBox();
private Box hboxFormulaType1 = Box.createHorizontalBox();
private int formulaId = 1;
private int eq = 1;
private double x1 = 0;
private double y1 = 0;
private double z1 = 0;
public Double plus(Double x) {
double a = x;
a=a+1.0;
x=a;
return x;
}
public void clear(Double x)
{
	double X=0;
	x=X;
}
public Double calculate1(Double x, Double y, Double z)
{
	
return Math.sin(Math.log(x)+Math.sin(y*y*3.14))*Math.sqrt(Math.sqrt(x*x+Math.sin(z)+Math.pow(Math.E,Math.cos(z))));
}
public Double calculate2(Double x, Double y, Double z)
{
	if (y==0)
		return (1+Math.pow(x,z)+ Math.log(1))*(1-Math.sin(x*z))/(Math.sqrt(x*x*x+1));
	else
		return (1+Math.pow(x,z)+ Math.log(y*y))*(1-Math.sin(x*z))/(Math.sqrt(x*x*x+1));
}
private void addRadioButton(String buttonName, final int formulaId) {
JRadioButton button = new JRadioButton(buttonName);
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev)
{
MainFrame.this.formulaId = formulaId;
}
});
radioButtons.add(button);
hboxFormulaType.add(button);
}
private void addRadioButton1(String buttonName, final int eq) {
JRadioButton button = new JRadioButton(buttonName);
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev)
{
MainFrame.this.eq = eq;
}
});
radioButtons1.add(button);
hboxFormulaType1.add(button);
}
public MainFrame() {
super("Вычисление формулы");
setSize(WIDTH, HEIGHT);
Toolkit kit = Toolkit.getDefaultToolkit();
setLocation((kit.getScreenSize().width - WIDTH)/2,
(kit.getScreenSize().height - HEIGHT)/2);
hboxFormulaType.add(Box.createHorizontalGlue());
addRadioButton("Формула 1", 1);
addRadioButton("Формула 2", 2);
radioButtons.setSelected(
radioButtons.getElements().nextElement().getModel(), true);
hboxFormulaType.add(Box.createHorizontalGlue());
 hboxFormulaType.setBorder( BorderFactory.createLineBorder(Color.YELLOW));
JLabel formula = new JLabel();
formula.setIcon(new ImageIcon(kit.getImage("abc.png")));
Box Func = Box.createHorizontalBox();
Func.add(Box.createHorizontalGlue());
Func.add(formula);
Func.add(Box.createHorizontalGlue());
JLabel labelForX = new JLabel("X:");
textFieldX = new JTextField("0", 10);
textFieldX.setMaximumSize(textFieldX.getPreferredSize());
JLabel labelForY = new JLabel("Y:");
textFieldY = new JTextField("0", 10);
textFieldY.setMaximumSize(textFieldY.getPreferredSize());
JLabel labelForZ = new JLabel("Z:");
textFieldZ = new JTextField("0", 10);
textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
Box hboxVariables = Box.createHorizontalBox();
hboxVariables.setBorder(
BorderFactory.createLineBorder(Color.RED));
hboxVariables.add(Box.createHorizontalGlue());
hboxVariables.add(labelForX);
hboxVariables.add(Box.createHorizontalStrut(5));
hboxVariables.add(textFieldX);
hboxVariables.add(Box.createHorizontalStrut(20));
hboxVariables.add(labelForY);
hboxVariables.add(Box.createHorizontalStrut(5));
hboxVariables.add(textFieldY);
hboxVariables.add(Box.createHorizontalStrut(20));
hboxVariables.add(labelForZ);
hboxVariables.add(Box.createHorizontalStrut(5));
hboxVariables.add(textFieldZ);
hboxVariables.add(Box.createHorizontalGlue());
hboxFormulaType1.add(Box.createHorizontalGlue());
addRadioButton1("X", 1);
addRadioButton1("Y", 2);
addRadioButton1("Z", 3);
radioButtons1.setSelected(
radioButtons1.getElements().nextElement().getModel(), true);
hboxFormulaType1.add(Box.createHorizontalGlue());
 hboxFormulaType1.setBorder( BorderFactory.createLineBorder(Color.GRAY));
JLabel labelForResult = new JLabel("Результат:");
textFieldResult = new JTextField("0", 10);
textFieldResult.setMaximumSize(
textFieldResult.getPreferredSize());
Box hboxResult = Box.createHorizontalBox();
hboxResult.add(Box.createHorizontalGlue());
hboxResult.add(labelForResult);
hboxResult.add(Box.createHorizontalStrut(10));
hboxResult.add(textFieldResult);
hboxResult.add(Box.createHorizontalGlue());
hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
/*
 * ButtonModel a = radioButtons.getElements().nextElement().getModel();
 * a.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent ev) { Boolean b = a.isSelected(); if (b)
 * formula.setIcon(new ImageIcon(kit.getImage("abc.png"))); else
 * formula.setIcon(new ImageIcon(kit.getImage("abc1.png"))); }});
 */

JButton buttonCalc = new JButton("Вычислить");
buttonCalc.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) {
try { Double x = Double.parseDouble(textFieldX.getText());
Double y = Double.parseDouble(textFieldY.getText());
Double z = Double.parseDouble(textFieldZ.getText());
Double result;
x1=x; y1=y; z1=z;
if (formulaId==1)
{
formula.setIcon(new ImageIcon(kit.getImage("abc.png")));
result = calculate1(x, y,z);
}
else
{
formula.setIcon(new ImageIcon(kit.getImage("abc1.png")));
result = calculate2(x, y,z);
}
textFieldResult.setText(result.toString());
} catch (NumberFormatException ex) {
JOptionPane.showMessageDialog(MainFrame.this,
"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
JOptionPane.WARNING_MESSAGE);
}
}
});
JButton buttonReset = new JButton("Очистить поля");
buttonReset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) {
textFieldX.setText("0");
textFieldY.setText("0");
textFieldZ.setText("0");
textFieldResult.setText("0");
}
});
Box hboxButtons = Box.createHorizontalBox();
hboxButtons.add(Box.createHorizontalGlue());
hboxButtons.add(buttonCalc);
hboxButtons.add(Box.createHorizontalStrut(30));
hboxButtons.add(buttonReset);
hboxButtons.add(Box.createHorizontalGlue());
hboxButtons.setBorder(
BorderFactory.createLineBorder(Color.GREEN));
JButton buttonMC = new JButton("MC");
buttonMC.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) {
if (eq==1)
{textFieldX.setText("0");
x1=0;}
if(eq==2)
{textFieldY.setText("0");
y1=0;}
if(eq==3)
{textFieldZ.setText("0");
z1=0;}
}
});
JButton buttonPlus = new JButton("+");
buttonPlus.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) {
if (eq==1)
{x1=plus(x1);
textFieldX.setText(String.valueOf(x1));}
if(eq==2)
{y1=plus(y1);
textFieldY.setText(String.valueOf(y1));}
if(eq==3)
{z1=plus(z1);
textFieldZ.setText(String.valueOf(z1));}
}
});
Box hboxButtons1 = Box.createHorizontalBox();
hboxButtons1.add(Box.createHorizontalGlue());
hboxButtons1.add(buttonMC);
hboxButtons1.add(Box.createHorizontalStrut(30));
hboxButtons1.add(buttonPlus);
hboxButtons1.add(Box.createHorizontalGlue());
hboxButtons1.setBorder(
BorderFactory.createLineBorder(Color.ORANGE));
Box contentBox = Box.createVerticalBox();
contentBox.add(Box.createVerticalGlue());
contentBox.add(hboxFormulaType);
contentBox.add(Func);
contentBox.add(hboxFormulaType1);
contentBox.add(hboxButtons1);
contentBox.add(hboxVariables);
contentBox.add(hboxResult);
contentBox.add(hboxButtons);
contentBox.add(Box.createVerticalGlue());
getContentPane().add(contentBox, BorderLayout.CENTER);
}

public static void main(String[] args) {
MainFrame frame = new MainFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}
