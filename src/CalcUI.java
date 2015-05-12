
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
	JButton bXPow2, bXPow3,bXPowY, bSqrtX, bCbRtX, bInvX, bTenPowx, bLog10, bLog2, bExp;
	JRadioButton bBin, bHex, bOct, bDec;

	JTextField textField;
	
	// Set the layout
	GridLayout numKeysLayout = new GridLayout(0,3);
	//GridLayout splKeysLayout = new GridLayout(2,0);

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
		final JPanel textModePanel = new JPanel();
		
		// Text Field
		textField = new JTextField(50);
		textField.setEditable(true);
		
		// Set Layout Type
		numPanel.setLayout(numKeysLayout);
		operandsPanel.setLayout(numKeysLayout);
		trigPanel.setLayout(numKeysLayout);
		miscPanel.setLayout(numKeysLayout);
		//calcPanel.setLayout(numKeysLayout);

		modeComboBox = new JComboBox<String>(modeList);
		
		// Set Dimension
		//numPanel.setSize(new Dimension(400,400));
		//operandsPanel.setPreferredSize(new Dimension(150,100));
		//trigPanel.setPreferredSize(new Dimension(150,100));
		//miscPanel.setPreferredSize(new Dimension(150,100));
		
//		for(int i =0; i < numPanelButtons.length; i++) {
//			numPanelButtons[i] = new JButton(numButtonString[i]);
//			numPanelButtons[i].setActionCommand(numButtonString[i]);
//			numPanel.add(numPanelButtons[i]);
//
//		}
		
		// Row 1
		bSeven = new JButton("7");
		bSeven.setActionCommand("7");
		numPanel.add(bSeven);
		bEight = new JButton("8");
		bEight.setActionCommand("8");
		numPanel.add(bEight);
		 bNine = new JButton("9");
		bNine.setActionCommand("9");
		numPanel.add(bNine);
		
		// Row 2
		 bFour = new JButton("4");
		bFour.setActionCommand("4");
		numPanel.add(bFour);
		 bFive = new JButton("5");
		bFive.setActionCommand("5");
		numPanel.add(bFive);
		 bSix = new JButton("6");
		bSix.setActionCommand("6");
		numPanel.add(bSix);
		
		// Row 3
		 bOne = new JButton("1");
		bOne.setActionCommand("1");
		numPanel.add(bOne);
		 bTwo = new JButton("2");
		bTwo.setActionCommand("2");
		numPanel.add(bTwo);
		 bThree = new JButton("3");
		bThree.setActionCommand("3");
		numPanel.add(bThree);

		// Row 4
		 bSign = new JButton("+/-");
		bSign.setActionCommand("n");
		numPanel.add(bSign);
		 bZero = new JButton("0");
		bZero.setActionCommand("0");
		numPanel.add(bZero);
		 bDot = new JButton(".");
		bDot.setActionCommand(".");
		numPanel.add(bDot);
		
		// Set button gaps for numKeysLayout
		numKeysLayout.setHgap(gap);
		numKeysLayout.setVgap(gap);
		
		// Operands Panel
		 bPlus = new JButton("+");
		bPlus.setActionCommand("+");
		operandsPanel.add(bPlus);
		 bMinus = new JButton("-");
		bMinus.setActionCommand("-");
		operandsPanel.add(bMinus);
		 bDiv = new JButton("/");
		bDiv.setActionCommand("/");
		operandsPanel.add(bDiv);
		 bMult= new JButton("*");
		bMult.setActionCommand("*");
		operandsPanel.add(bMult);
		 bPcnt= new JButton("%");
		bPcnt.setActionCommand("%");
		operandsPanel.add(bPcnt);
		 bEquals = new JButton("=");
		bEquals.setActionCommand("=");
		operandsPanel.add(bEquals);
		
		//Trig Panel		
		 bSin = new JButton("Sin");
		bSin.setActionCommand("s");
		trigPanel.add(bSin);
		 bCos = new JButton("Cos");
		bCos.setActionCommand("c");
		trigPanel.add(bCos);
		 bTan = new JButton("Tan");
		bTan.setActionCommand("t");
		trigPanel.add(bTan);
		 baSin = new JButton("aSin");
		baSin.setActionCommand("S");
		trigPanel.add(baSin);
		 baCos = new JButton("aCos");
		baCos.setActionCommand("C");
		trigPanel.add(baCos);
		 baTan = new JButton("aTan");
		baTan.setActionCommand("T");
		trigPanel.add(baTan);
		
		//Misc Panel
		 bXPow2 = new JButton("x^2");
		bXPow2.setActionCommand("d");
		miscPanel.add(bXPow2);
		 bXPow3 = new JButton("X^3");
		bXPow3.setActionCommand("e");
		miscPanel.add(bXPow3);
		 bXPowY = new JButton("X^Y");
		bXPowY.setActionCommand("f");
		miscPanel.add(bXPowY);
		 bSqrtX = new JButton("√X");
		bSqrtX.setActionCommand("g");
		miscPanel.add(bSqrtX);
		 bCbRtX = new JButton(" ³√x ");
		bCbRtX.setActionCommand("h");
		miscPanel.add(bCbRtX);
		 bInvX = new JButton(" 1/X ");
		bInvX.setActionCommand("i");
		miscPanel.add(bInvX);
		 bTenPowx = new JButton(" 10^X ");
		bTenPowx.setActionCommand("j");
		miscPanel.add(bTenPowx);	
		 bLog10 = new JButton("Log10 X");
		bLog10.setActionCommand("k");
		miscPanel.add(bLog10);
		 bLog2 = new JButton("Log2 X");
		bLog2.setActionCommand("l");
		miscPanel.add(bLog2);
		 bExp = new JButton("EXP");
		bExp.setActionCommand("m");
		miscPanel.add(bExp);
		
		// Create Sub Panel
		JButton bBin = new JButton("Bin");
		bBin.setActionCommand("o");
		controlPanel.add(bBin);
		JButton bDec = new JButton("Decimal");
		bDec.setActionCommand("p");
		controlPanel.add(bDec);
		controlPanel.add(modeComboBox);
		
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
		bSign.addActionListener(bListener);
		bPlus.addActionListener(bListener);
		bMinus.addActionListener(bListener);
		bMult.addActionListener(bListener);
		bDiv.addActionListener(bListener);
		bPcnt.addActionListener(bListener);
		bEquals.addActionListener(bListener);
		bDot.addActionListener(bListener);
		bSin.addActionListener(bListener);
		bCos.addActionListener(bListener);
		bTan.addActionListener(bListener);
		baSin.addActionListener(bListener);
		baCos.addActionListener(bListener);
		baTan.addActionListener(bListener);
		bXPow2.addActionListener(bListener);
		bXPow3.addActionListener(bListener);
		bXPowY.addActionListener(bListener);
		bSqrtX.addActionListener(bListener);
		bCbRtX.addActionListener(bListener);
		bInvX.addActionListener(bListener);
		bTenPowx.addActionListener(bListener);
		bLog10.addActionListener(bListener);
		bLog2.addActionListener(bListener);
		bExp.addActionListener(bListener);

		// Add to calcPanel
		textModePanel.add(textField, BorderLayout.NORTH);
		textModePanel.add(controlPanel, BorderLayout.SOUTH);
        pane.add(textModePanel, BorderLayout.NORTH);
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
				textField.setText(modString(evalExpr));
			} else {
				//System.out.println(evalExpr);
				double result = EvaluateString.evaluate(evalExpr);
				textField.setText("" +result);
				//System.out.println(evalExpr + " " + result);
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
	
	public static String modString(String str) {
		
		String nStr = str;
		nStr = nStr.replaceAll("d", "^2");
		nStr = nStr.replaceAll("e", "^3");
		nStr = nStr.replaceAll("f", "^");
		nStr = nStr.replaceAll("g", "√");
		nStr = nStr.replaceAll("h", "³√");
		nStr = nStr.replaceAll("i", "1/");
		nStr = nStr.replaceAll("j", "10^");
		nStr = nStr.replaceAll("k", "log10 ");
		nStr = nStr.replaceAll("l", "log2 ");
		nStr = nStr.replaceAll("m", "*10^");
		nStr = nStr.replaceAll("n", "-");
		nStr = nStr.replaceAll("s", "sin");
		nStr = nStr.replaceAll("c", "cos");
		nStr = nStr.replaceAll("t", "tan");
		nStr = nStr.replaceAll("S", "asin");
		nStr = nStr.replaceAll("C", "acos");
		nStr = nStr.replaceAll("T", "atan");
		return nStr;
	}
}
