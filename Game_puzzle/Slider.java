package Game_puzzle;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener{

 JFrame frame;
 JPanel panel;
 JLabel label;
 JSlider slider;
 
 public Slider(){
  
  frame = new JFrame("Slider");
  panel = new JPanel();
  label = new JLabel();
  slider = new JSlider(-80,0,-25);
  
  slider.setPreferredSize(new Dimension(150,100));
  
  slider.setPaintTrack(true);
  slider.setMajorTickSpacing(25);
  
  label.setText("sound = "+ slider.getValue());
  
  slider.addChangeListener(this);
  
  panel.add(slider);
  panel.add(label);
  frame.add(panel);
  frame.setSize(270,125);
  frame.setVisible(true);
 }
 
 @Override
 public void stateChanged(ChangeEvent e) {
  
    label.setText("sound = "+ slider.getValue());
  
 }

}
