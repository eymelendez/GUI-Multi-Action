package edu.pupr.practicegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class The_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField R1_txtfld;
	private JTextField R2_txtfld;
	private JTextField result_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					The_GUI frame = new The_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public The_GUI() {
		setTitle("Exam 2 GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel Ohms_Panel = new JPanel();
		
		JPanel Cmbox_Panel = new JPanel();
		
		JPanel radio_Panel = new JPanel();
		
		JList checkboxList = new JList();
		
		JPanel Checkbox_Panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Ohms_Panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(radio_Panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(Checkbox_Panel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(Cmbox_Panel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Cmbox_Panel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(Ohms_Panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(radio_Panel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addComponent(Checkbox_Panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		DefaultListModel DLM = new DefaultListModel(); // Funcion putted here to avoid instancing everytime. if you put it inside of
														//	each itemStateChanged method, it will OVERWRITE IT instead of adding to the list
		
		JLabel Items2_Label = new JLabel("Items #2");
		Items2_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox check1 = new JCheckBox("Item #1");
		JCheckBox check2 = new JCheckBox("Item #2");
		JCheckBox check3 = new JCheckBox("Item #3");
		
		check1.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent event) 
			{
				if(check1.isSelected()) 
				{
					check2.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
					check3.setSelected(false); 
					
					DLM.addElement("Item #1");
					checkboxList.setModel(DLM);
				}
			}
		});
		
		check1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		check2.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				if(check2.isSelected()) 
				{
					check1.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
					check3.setSelected(false); 
				
					DLM.addElement("Item #2");
					checkboxList.setModel(DLM);
				}
			}
		});
		check2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		check3.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				if(check3.isSelected()) 
				{
					check1.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
					check2.setSelected(false); 
					
					DLM.addElement("Item #3");
					checkboxList.setModel(DLM);
				}
			}
		});
		
		check3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		GroupLayout gl_Checkbox_Panel = new GroupLayout(Checkbox_Panel);
		gl_Checkbox_Panel.setHorizontalGroup(
			gl_Checkbox_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Checkbox_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Checkbox_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Checkbox_Panel.createSequentialGroup()
							.addGroup(gl_Checkbox_Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(check3)
								.addComponent(check2)
								.addComponent(check1))
							.addGap(89)
							.addComponent(checkboxList, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(Items2_Label))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_Checkbox_Panel.setVerticalGroup(
			gl_Checkbox_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Checkbox_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Checkbox_Panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(checkboxList, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Checkbox_Panel.createSequentialGroup()
							.addComponent(Items2_Label)
							.addGap(18)
							.addComponent(check1)
							.addGap(18)
							.addComponent(check2)
							.addGap(18)
							.addComponent(check3)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		Checkbox_Panel.setLayout(gl_Checkbox_Panel);
		
		JLabel Items_Label = new JLabel("Items");
		Items_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton radio1 = new JRadioButton("Item #1");
		JRadioButton radio2 = new JRadioButton("Item #2");
		JRadioButton radio3 = new JRadioButton("Item #3");
		
		radio1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				radio2.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
				radio3.setSelected(false); 
				
				JOptionPane.showMessageDialog(The_GUI.this,String.format("You selected Item #1", event.getActionCommand() )); // This is for the pop up message!
				
			}
		});
		
		radio1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		radio2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				radio1.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
				radio3.setSelected(false); 
				JOptionPane.showMessageDialog(The_GUI.this,String.format("You selected Item #2", event.getActionCommand() )); // This is for the pop up message!
			}
		});
		
		radio2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		radio3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				radio1.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
				radio2.setSelected(false); 
				
				JOptionPane.showMessageDialog(The_GUI.this,String.format("You selected Item #3", event.getActionCommand() )); // This is for the pop up message!
			}
		});
		
		radio3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		GroupLayout gl_radio_Panel = new GroupLayout(radio_Panel);
		gl_radio_Panel.setHorizontalGroup(
			gl_radio_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radio_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_radio_Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(radio3)
						.addComponent(radio2)
						.addComponent(Items_Label, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(radio1))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_radio_Panel.setVerticalGroup(
			gl_radio_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radio_Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(Items_Label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(radio1)
					.addGap(18)
					.addComponent(radio2)
					.addGap(18)
					.addComponent(radio3)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		radio_Panel.setLayout(gl_radio_Panel);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addItemListener(new ItemListener() // -----------------------------------------------------------------------------------------
		{
			Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
			
			public void itemStateChanged(ItemEvent event)
			{
				Cmbox_Panel.setBackground(colors[comboBox.getSelectedIndex()]); // This changes the background when the user selects the item.
			}
		}); // ---------------------------------------------------------------------------------------------------------------------------------
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Red", "Green", "Blue"}));

		
		GroupLayout gl_Cmbox_Panel = new GroupLayout(Cmbox_Panel);
		gl_Cmbox_Panel.setHorizontalGroup(
			gl_Cmbox_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cmbox_Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		gl_Cmbox_Panel.setVerticalGroup(
			gl_Cmbox_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Cmbox_Panel.createSequentialGroup()
					.addGap(30)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		Cmbox_Panel.setLayout(gl_Cmbox_Panel);
		
		JLabel R1_Label = new JLabel("R1");
		R1_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel R2_Label = new JLabel("R2");
		R2_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		R1_txtfld = new JTextField();
		R1_txtfld.setColumns(10);
		
		R2_txtfld = new JTextField();
		R2_txtfld.setColumns(10);
		
		JLabel Ohms_Label1 = new JLabel("Ohms");
		Ohms_Label1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel Ohms_Label2 = new JLabel("Ohms");
		Ohms_Label2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton calc_Button = new JButton("Calc"); // --------------------------------------------------
		calc_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				double R1Num = (Double.parseDouble(R1_txtfld.getText()));
				double R2Num = (Double.parseDouble(R2_txtfld.getText()));
				
				double R3Num = (R1Num * R2Num) / (R1Num + R2Num);
				
				/*DecimalFormat dc = new DecimalFormat("0.00");
				String formattedText = dc.format(R3Num);*/
				
				result_label.setText(Double.toString(R3Num));
				
			}										// --------------------------------------------------
		});
		
		JLabel R1_R2_Label = new JLabel("R1||R2 :");
		R1_R2_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		result_label = new JTextField();
		result_label.setEditable(false);
		result_label.setColumns(10);
		
		JLabel Ohms_Label3 = new JLabel("Ohms");
		Ohms_Label3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_Ohms_Panel = new GroupLayout(Ohms_Panel);
		gl_Ohms_Panel.setHorizontalGroup(
			gl_Ohms_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Ohms_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Ohms_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Ohms_Panel.createSequentialGroup()
							.addComponent(R1_Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(R1_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Ohms_Label1))
						.addGroup(gl_Ohms_Panel.createSequentialGroup()
							.addComponent(R2_Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(R2_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Ohms_Label2)
							.addGap(18)
							.addComponent(calc_Button))
						.addGroup(gl_Ohms_Panel.createSequentialGroup()
							.addComponent(R1_R2_Label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(result_label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Ohms_Label3)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_Ohms_Panel.setVerticalGroup(
			gl_Ohms_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Ohms_Panel.createSequentialGroup()
					.addGroup(gl_Ohms_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Ohms_Panel.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_Ohms_Panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(R1_Label)
								.addComponent(R1_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Ohms_Label1))
							.addGap(18)
							.addGroup(gl_Ohms_Panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(R2_Label)
								.addComponent(R2_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Ohms_Label2)))
						.addGroup(gl_Ohms_Panel.createSequentialGroup()
							.addGap(41)
							.addComponent(calc_Button)))
					.addGap(30)
					.addGroup(gl_Ohms_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(R1_R2_Label)
						.addComponent(result_label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Ohms_Label3))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		Ohms_Panel.setLayout(gl_Ohms_Panel);
		contentPane.setLayout(gl_contentPane);
	}
}
