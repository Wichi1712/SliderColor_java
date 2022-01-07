package slideColor;

import java.awt.Color;
import java.awt.Font;

//import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	javax.swing.JPanel panel;
	javax.swing.JSlider slid, slid1, slid2, slid3;
	javax.swing.JColorChooser colChoose;
	javax.swing.JLabel labelTxt = new JLabel();
	javax.swing.JLabel labelRed, labelGreen, labelBlue;
	javax.swing.JTextField txtField;
	javax.swing.JTextArea txtArea;
	
	
	private static final int MIN = 0, MAX = 255;
	
	public Main() {
		setSize(700, 700);
		setTitle("Color Slider");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		iniciaComponentes();
		//slidStateChange(null);
		
		//Inicializa el color de fondo
		txtArea.setBackground(Color.BLACK);
		txtField.setBackground(Color.BLACK);
	}
	
	public void iniciaComponentes() {
		
		panel = new JPanel();
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		
		labelTxt.setText("Este es un selector de color de prueba");
		labelTxt.setBounds(150, 10, 320, 50);
		labelTxt.setFont(new Font("comic sans MS", Font.BOLD, 16));
		panel.add(labelTxt);
		
		//Deslizador
		slid = new JSlider();
		slid.setBounds(10, 50, 500, 45);
		slid.setValue(0);//Valor inicial
		slid.setMajorTickSpacing(15);//Necesario para que muestre paintLabels
		slid.setPaintLabels(true);
		slid.setPaintTicks(true);//Marca de medida
		slid.setSnapToTicks(true);//Salta a una division
		slid.isPaintingForPrint();
		slid.setMinimum(MIN);
		slid.setMaximum(MAX);
		slid.setMinorTickSpacing(5);//Subdivisiones
		//slid.setOrientation(SwingConstants.HORIZONTAL);//0 es horizontal 1 es vertical
		slid.addChangeListener(new EventoSlid());//Escuchador de cambios
		panel.add(slid);
		
		slid1 = new JSlider();
		slid1.setBounds(10, 220, 500, 45);
		slid1.setValue(0);//Valor inicial
		slid1.setMajorTickSpacing(15);//Necesario para que muestre paintLabels
		slid1.setPaintLabels(true);
		slid1.setPaintTicks(true);//Marca de medida
		slid1.setSnapToTicks(true);//Salta a una division
		slid1.isPaintingForPrint();
		slid1.setMinimum(MIN);
		slid1.setMaximum(MAX);
		slid1.setMinorTickSpacing(5);//Subdivisiones
		//slid1.setOrientation(SwingConstants.HORIZONTAL);//0 es horizontal 1 es vertical
		slid1.addChangeListener(new EventoSlid());//Escuchador de cambios
		panel.add(slid1);
		
		slid2 = new JSlider();
		slid2.setBounds(10, 270, 500, 45);
		slid2.setValue(0);//Valor inicial
		slid2.setMajorTickSpacing(15);//Necesario para que muestre paintLabels
		slid2.setPaintLabels(true);
		slid2.setPaintTicks(true);//Marca de medida
		slid2.setSnapToTicks(true);//Salta a una division
		slid2.isPaintingForPrint();
		slid2.setMinimum(MIN);
		slid2.setMaximum(MAX);
		slid2.setMinorTickSpacing(5);//Subdivisiones
		//slid2.setOrientation(SwingConstants.HORIZONTAL);//0 es horizontal 1 es vertical
		slid2.addChangeListener(new EventoSlid());//Escuchador de cambios
		panel.add(slid2);
		
		slid3 = new JSlider();
		slid3.setBounds(10, 320, 500, 45);
		slid3.setValue(0);//Valor inicial
		slid3.setMajorTickSpacing(15);//Necesario para que muestre paintLabels
		slid3.setPaintLabels(true);
		slid3.setPaintTicks(true);//Marca de medida
		slid3.setSnapToTicks(true);//Salta a una division
		slid3.isPaintingForPrint();
		slid3.setMinimum(MIN);
		slid3.setMaximum(MAX);
		slid3.setMinorTickSpacing(5);//Subdivisiones
		//slid3.setOrientation(SwingConstants.HORIZONTAL);//0 es horizontal 1 es vertical
		slid3.addChangeListener(new EventoSlid());//Escuchador de cambios
		panel.add(slid3);
		
		
		//Muestra de Color
		txtArea = new JTextArea();
		txtArea.setBounds(10, 100, 100, 100);
		txtArea.setBackground(Color.PINK);
		panel.add(txtArea);
		
		txtField = new JTextField();
		txtField.setBounds(10, 380, 100, 100);
		txtField.setBackground(Color.cyan);
		panel.add(txtField);
		
		labelRed = new JLabel();
		labelRed.setText("R = 0");
		labelRed.setBounds(550, 220, 320, 50);
		labelRed.setFont(new Font("comic sans MS", Font.BOLD, 16));
		panel.add(labelRed);
		
		labelGreen = new JLabel();
		labelGreen.setText("G = 0");
		labelGreen.setBounds(550, 270, 320, 50);
		labelGreen.setFont(new Font("comic sans MS", Font.BOLD, 16));
		panel.add(labelGreen);
		
		labelBlue = new JLabel();
		labelBlue.setText("B = 0");
		labelBlue.setBounds(550, 320, 320, 50);
		labelBlue.setFont(new Font("comic sans MS", Font.BOLD, 16));
		panel.add(labelBlue);
		
		
	}
	
	private void changeColor() {
		int BL, R, G, B;
		BL = slid.getValue();
		R = slid1.getValue();
		G = slid2.getValue();
		B = slid3.getValue();
		
		
		txtArea.setBackground(new Color(BL,BL,BL));
		txtField.setBackground(new Color(R, G, B));
		labelRed.setText("R = "+ R);
		labelGreen.setText("G = "+ G);
		labelBlue.setText("B = "+ B);
	}
	
	private class EventoSlid implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			System.out.println("SLid ok");
			changeColor();
		}
		
	}
	
	
	//@SuppressWarnings("unused")
	//private void slidStateChange(javax.swing.event.ChangeEvent evt) {
		//changeColor();
	//}
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Main().setVisible(true);
			}
		});
	}
}

