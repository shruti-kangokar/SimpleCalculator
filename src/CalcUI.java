import java.awt.*;
import java.awt.event.*;
import java.beans.Expression;

import javax.swing.*;

public class CalcUI extends JFrame {

	// Create the top container
	JFrame calculator = new JFrame();
	
	// Combo box
	static final String modeList[] = {"Normal", "Scientific", "Miscellaneous"};
	static final int gap = 5;
	//static final Dimension buttonSize;
	JComboBox<String> modeComboBox;
	
	// Dimensions
	static final Dimension bDim = new Dimension(30, 20);
	static final double bHeight = bDim.getHeight();
	static final double bWidth = bDim.getWidth();
	
	static String evalExpr = ""; 
	
	// Buttons
	JButton bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bZero, bSign, bDot;
	JButton bPlus, bMinus, bMult, bDiv, bPcnt, bEquals;
	JButton bSin,bCos,bTan,baSin, baCos, baTan;
	JButton bXPow2, bXpow3,bXPowY, bSqrtX, bCbRtX, bInvX, bTenPowx, bLog10, bLog2, bExp;
	
//	// Group the buttons
//	JButton[] numPanelButtons = {bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bZero, bSign, bDot};
//	String[] numButtonString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+/-", "." };
	
	// Set the layout
	GridLayout numKeysLayout = new GridLayout(0,3);
	
	public CalcUI () {
		super("Calculator");
		setResizable(false);
	}

	public void addToNumPane(final Container pane) {
		
		final JPanel numPanel = new JPanel();
		final JPanel controlPanel = new JPanel();
		final JPanel operandsPanel = new JPanel();
		final JPanel trigPanel = new JPanel();
		final JPanel miscPanel = new JPanel();
		final JPanel calcPanel = new JPanel();
		
		// Set Layout Type
		numPanel.setLayout(numKeysLayout);
		operandsPanel.setLayout(numKeysLayout);
		modeComboBox = new JComboBox<String>(modeList);
		
		// Set Dimension
		numPanel.setSize(new Dimension(200,100));
		operandsPanel.setPreferredSize(new Dimension(150,100));
		trigPanel.setPreferredSize(new Dimension(150,100));
		miscPanel.setPreferredSize(new Dimension(150,100));
		
//		for(int i =0; i < numPanelButtons.length; i++) {
//			numPanelButtons[i] = new JButton(numButtonString[i]);
//			numPanelButtons[i].setActionCommand(numButtonString[i]);
//			numPanel.add(numPanelButtons[i]);
//
//		}
		
		// Create and add number buttons
		JButton bZero = new JButton("0");
		bZero.setActionCommand("0");
		numPanel.add(bZero);
		JButton bOne = new JButton("1");
		bOne.setActionCommand("1");
		numPanel.add(bOne);
		JButton bTwo = new JButton("2");
		bTwo.setActionCommand("2");
		numPanel.add(bTwo);
		JButton bThree = new JButton("3");
		bThree.setActionCommand("3");
		numPanel.add(bThree);
		JButton bFour = new JButton("4");
		bFour.setActionCommand("4");
		numPanel.add(bFour);
		JButton bFive = new JButton("5");
		bFive.setActionCommand("5");
		numPanel.add(bFive);
		JButton bSix = new JButton("6");
		bSix.setActionCommand("6");
		numPanel.add(bSix);
		JButton bSeven = new JButton("7");
		bSeven.setActionCommand("7");
		numPanel.add(bSeven);
		JButton bEight = new JButton("8");
		bEight.setActionCommand("8");
		numPanel.add(bEight);
		JButton bNine = new JButton("9");
		bNine.setActionCommand("9");
		numPanel.add(bNine);
		JButton bSign = new JButton("+/-");
		bSign.setActionCommand("-");
		numPanel.add(bSign);
		JButton bDot = new JButton(".");
		bDot.setActionCommand(".");
		numPanel.add(bDot);
	
		
		// Set button gaps for numKeysLayout
		numKeysLayout.setHgap(gap);
		numKeysLayout.setVgap(gap);
		
		// Operands Panel
		JButton bPlus = new JButton("+");
		bPlus.setActionCommand("+");
		operandsPanel.add(bPlus);
		JButton bMinus = new JButton("-");
		bMinus.setActionCommand("-");
		operandsPanel.add(bMinus);
		JButton bDiv = new JButton("/");
		bDiv.setActionCommand("/");
		operandsPanel.add(bDiv);
		JButton bMult= new JButton("*");
		bMult.setActionCommand("*");
		operandsPanel.add(bMult);
		JButton bPcnt= new JButton("%");
		bPcnt.setActionCommand("%");
		operandsPanel.add(bPcnt);
		JButton bEquals = new JButton("=");
		bEquals.setActionCommand("=");
		operandsPanel.add(bEquals);
		
		//Trig Panel		
		JButton bSin = new JButton("Sin");
		trigPanel.add(bSin);
		JButton bCos = new JButton("Cos");
		trigPanel.add(bCos);
		JButton bTan = new JButton("Tan");
		trigPanel.add(bTan);
		JButton baSin = new JButton("aSin");
		trigPanel.add(baSin);
		JButton baCos = new JButton("aCos");
		trigPanel.add(baCos);
		JButton baTan = new JButton("aTan");
		trigPanel.add(baTan);
		
		//Misc Panel
		JButton bXPow2 = new JButton("x^2");
		miscPanel.add(bXPow2);
		JButton bXpow3 = new JButton("X^3");
		miscPanel.add(bXpow3);
		JButton bXPowY = new JButton("X^Y");
		miscPanel.add(bXPowY);
		JButton bSqrtX = new JButton("√X");
		miscPanel.add(bSqrtX);
		JButton bCbRtX = new JButton(" ³√x ");
		miscPanel.add(bCbRtX);
		JButton bInvX = new JButton(" 1/X ");
		miscPanel.add(bInvX);
		JButton bTenPowx = new JButton(" 10^X ");
		miscPanel.add(bTenPowx);	
		JButton bLog10 = new JButton("Log10 X");
		miscPanel.add(bLog10);
		JButton bLog2 = new JButton("Log2 X");
		miscPanel.add(bLog2);
		JButton bExp = new JButton("EXP");
		miscPanel.add(bExp);
		
		// Add listeners
		Listener bListener = new Listener();
		bZero.addActionListener(bListener);
		bOne.addActionListener(bListener);
		bTwo.addActionListener(bListener);
		bThree.addActionListener(bListener);
		bFour.addActionListener(bListener);
		bFive.addActionListener(bListener);
		bSix.addActionListener(bListener);
		bSeven.addActionListener(bListener);
		bEight.addActionListener(bListener);
		bNine.addActionListener(bListener);
		bPlus.addActionListener(bListener);
		bMinus.addActionListener(bListener);
		bMult.addActionListener(bListener);
		bDiv.addActionListener(bListener);
		bPcnt.addActionListener(bListener);
		bEquals.addActionListener(bListener);


		
		// Add to calcPanel
        //pane.add(modeComboBox, BorderLayout.NORTH);
		calcPanel.add(numPanel, BorderLayout.CENTER);
		calcPanel.add(operandsPanel, BorderLayout.EAST);
		calcPanel.add(trigPanel, BorderLayout.SOUTH);
		calcPanel.add(miscPanel, BorderLayout.WEST);
		pane.add(calcPanel);
		
	}
	
	// Action Listener for buttons.
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
						
			String bVal = e.getActionCommand();
			//JButton src =(JButton) e.getSource();
			if (!bVal.equals("=")) {
				evalExpr = evalExpr + bVal;
			} else {
				//System.out.println(evalExpr);
				double result = EvaluateString.evaluate(evalExpr);
				System.out.println(evalExpr + " " + result);
				evalExpr = "";
			}
		}	
	}
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        CalcUI frame = new CalcUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addToNumPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}



