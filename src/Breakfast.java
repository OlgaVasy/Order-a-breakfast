import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Project 6: Order a breakfast
 */
public class Breakfast extends JFrame {

   JCheckBox omelet;
   JCheckBox taco;
   JCheckBox waffles;
   JTextArea order;
   JTextArea selection;
   double cost=0;
   JButton submit;
   JButton clear;
   JTextArea mouseEvent;

   public static void main(String args[]){
      JFrame aFrame = new Breakfast();
      aFrame.setVisible(true);

   }
   public Breakfast(){
      setTitle("Breakfast order");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel aPanel = new JPanel();
      aPanel.setLayout(new BoxLayout(aPanel,BoxLayout.Y_AXIS));

      Border blackBorder = BorderFactory.createMatteBorder(5,10,5,10,Color.BLACK);
      aPanel.setBorder(blackBorder);

      Color brown = new Color(128,64,0);

      JPanel menuPanel = new JPanel();
      menuPanel.add(new JLabel("<html><span style='font-size:20px'><font color='white'>Menu</span></html>"));
      aPanel.add(menuPanel);
      menuPanel.setBackground(brown);

      JPanel omeletPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      omelet = new JCheckBox("<html><span style='font-size:12px'>Omelet</span></html>");
      omelet.setBackground(Color.ORANGE);
      omelet.addActionListener(new OmeletChanged());
      omeletPanel.add(omelet);
      ImageIcon imageOmelet = new ImageIcon("Omelet.jpg");
      omeletPanel.add(new JLabel(imageOmelet));
      omeletPanel.add(new JLabel("Omelet with red and green bell peppers, caramelized onions and cheddar cheese. "));
      omeletPanel.add(new JLabel("<html><span style='font-size:12px'>$ 10.00</span></html>"));
      omeletPanel.setBackground(Color.ORANGE);
      aPanel.add(omeletPanel);

      JPanel tacoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      taco = new JCheckBox("<html><span style='font-size:12px'>Taco</span></html>");
      taco.setBackground(Color.ORANGE);
      taco.addActionListener(new TacoChanged());
      tacoPanel.add(taco);
      ImageIcon imageTaco = new ImageIcon("Taco.jpg");
      tacoPanel.add(new JLabel(imageTaco));
      tacoPanel.add(new JLabel("Hickory-smoked bacon, sausage, roasted potatoes and eggs in corn tortillas."));
      tacoPanel.add(new JLabel("<html><span style='font-size:12px'>$ 13.00</span></html>"));
      tacoPanel.setBackground(Color.ORANGE);
      aPanel.add(tacoPanel);

      JPanel wafflesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      waffles = new JCheckBox("<html><span style='font-size:12px'>Waffles</span></html>");
      waffles.setBackground(Color.ORANGE);
      waffles.addActionListener(new WafflesChanged());
      wafflesPanel.add(waffles);
      ImageIcon imageWaffles = new ImageIcon("Waffles.jpg");
      wafflesPanel.add(new JLabel(imageWaffles));
      wafflesPanel.add(new JLabel("Buttermilk-malt waffles with strawberry and vanilla-bean cream sauce."));
      wafflesPanel.add(new JLabel("<html><span style='font-size:12px'>$ 9.00</span></html>"));
      wafflesPanel.setBackground(Color.ORANGE);
      aPanel.add(wafflesPanel);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setBackground(brown);
      submit = new JButton("Submit");
      submit.addActionListener(new SubmitButton());
      buttonPanel.add(submit);

      clear = new JButton("Clear");
      clear.addActionListener(new ClearButton());
      buttonPanel.add(clear);

      aPanel.add(buttonPanel);

      order = new JTextArea(8,1);
      aPanel.add(order);
      order.setMargin(new Insets(10,10,10,10));
      selection = new JTextArea();
      aPanel.add(selection,BorderLayout.EAST);
      selection.setMargin(new Insets(10,10,10,10));
      order.setFont(new Font("Times Roman", Font.BOLD, 14));

      mouseEvent = new JTextArea();
      aPanel.add(mouseEvent);
      mouseEvent.setMargin(new Insets(10,10,10,10));
      mouseEvent.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

      addMouseListener(new MouseAdapter() {

         public void mousePressed(MouseEvent e) {

            mouseEvent.setText("Mouse pressed");
         }
         public void mouseReleased(MouseEvent e) {
            mouseEvent.setText("Mouse released");
         }
         public void mouseEntered(MouseEvent e){mouseEvent.setText("Mouse entered");}
      });

      setContentPane(aPanel);
      pack();

       }
   private class SubmitButton implements ActionListener{
      public void actionPerformed(ActionEvent e){
         selection.setText("");
         order.setText("Your order: ");
         if(omelet.isSelected()){
            order.append("\nOmelet\t\t $10.00");
      }
         if(taco.isSelected()){
            order.append("\nTaco\t\t $13.00");
         }
         if(waffles.isSelected()){
            order.append("\nWaffles\t\t $9.00");
         }
         order.append("\n\nTotal cost:\t\t" + "$"+cost);}}

   private class ClearButton implements ActionListener{
      public void actionPerformed(ActionEvent e){
         selection.setText("");
         order.setText("");
        }}

   private class OmeletChanged implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (omelet.isSelected()){
            selection.setText("\nOmelet is selected");
            cost=cost+10.00;
         }
         else{
            selection.setText("\nOmelet is deselected");
            cost=cost-10.00;
         }
      }}
   private class TacoChanged implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (taco.isSelected()){
            selection.setText("\nTaco is selected");
            cost=cost+13.00;
            }
            else{
            selection.setText("\nTaco is deselected");
            cost=cost-13.00;
         }
         }}
   private class WafflesChanged implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (waffles.isSelected()){
            selection.setText("\nWaffles are selected");
            cost=cost+9.00;
               }
               else{
            selection.setText("\nWaffles are deselected");
            cost=cost-9.00;
         }
            }
   }

   }


