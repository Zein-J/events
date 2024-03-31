//Events Program - Zein Al-Jaradat
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

public class Events {

	public static void main(String[] args) {

		new Events();

	}

	JFrame window, helpFrame;
	JPanel panel;
	JLabel title, titleh, sliderinfo;
	JTextField Txfld;
	JSlider slider;
	String input;

	int x = 0;
	int y = 0;
	int s = 13;

	Events() {
		window = new JFrame("Events");
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		panel = new JPanel( new MigLayout("wrap 3, insets 20") );
		setupGUI();

		window.add(panel);

		JMenu menu = new JMenu("Menu");
		JMenuItem i1 = new JMenuItem("Reset");
		i1.addActionListener(new BtnAL());
		JMenuItem i2 = new JMenuItem("Help");
		i2.addActionListener(new BtnAL());

		JMenuBar mb = new JMenuBar();

		menu.add(i1);
		menu.add(i2);
		mb.add(menu);
		window.setJMenuBar(mb);

		window.pack();
		window.setVisible(true);
	}

	void setupGUI() {
		panel = new JPanel( new MigLayout("wrap 3, insets 20") );

		panel.setBackground(new Color(150,150,255));

		title = new JLabel("Epic Events");
		panel.add(title, "span 3, align center");

		Txfld = new JTextField("Set Title");
		Txfld.addActionListener(new TxtAL());
		panel.add(Txfld, "span 3, growx");

		JButton btn1 = new JButton("Color");
		btn1.addActionListener(new BtnAL());
		panel.add(btn1, "span 3, growx");

		sliderinfo = new JLabel("Font Size Slider");
		sliderinfo.setFont(new Font("", Font.BOLD, s));
		panel.add(sliderinfo, "span 3, align center");

		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 13);
		slider.setMinorTickSpacing(5);  
		slider.setMajorTickSpacing(10);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);
		slider.addChangeListener(new SldAL());
		panel.add(slider, "growx, span 3");

		window.validate();
	}

	public class BtnAL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Color")) {
				int r = (int) (Math.random()*255);
				int g = (int) (Math.random()*255);
				int b = (int) (Math.random()*255);
				//System.out.println(r + " " + g + " " + b);
				panel.setBackground(new Color(r,g,b));
			} else if (e.getActionCommand().equals("Help")) {
				new HelpWindow();
			} else if (e.getActionCommand().equals("Reset")) {
				panel.setBackground(new Color(150,150,255));
				title.setText("Epic Events");
				s = 13;
				sliderinfo.setFont(new Font("", Font.BOLD, s));
				slider.setValue(s);
				window.pack();
			} else if (e.getActionCommand().equals("Why")) {
				titleh.setText("It's not within my abilities");
				x = 275;
				y = 200;
				helpFrame.setSize(x, y);
			}
		}

	}

	public class SldAL implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			if (!source.getValueIsAdjusting()) {
				s = (int)source.getValue();
				sliderinfo.setFont(new Font("", Font.BOLD, s));
				window.pack();
			}
		}
	}

	public class TxtAL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			title.setText(Txfld.getText());
		}
	}

	//class
	public class HelpWindow {
		//constructor
		HelpWindow() {
			helpFrame = new JFrame("Help");
			x = 250;
			y = 200;
			helpFrame.setSize(x, y);
			helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpFrame.setTitle("Help");

			titleh = new JLabel("Unfortunately I can't");
			JPanel panelhelp = new JPanel( new MigLayout("wrap 3, insets 50") );
			helpFrame.setLocationRelativeTo(window);
			setupHelp(panelhelp);

			helpFrame.add(panelhelp);
			helpFrame.setVisible(true);
		}

	}

	void setupHelp(JPanel p) {
		p.setBackground(new Color(255,150,150));
		p.add(titleh, "growx, skip 1, align center");

		JButton btnw = new JButton("Why");
		btnw.addActionListener(new BtnAL());
		p.add(btnw, "growx, skip 2, align center");

	}

}
