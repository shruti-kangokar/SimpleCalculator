import java.util.Stack;
 
public class EvaluateString
{
    public static double evaluate(String expression)
    {

        char[] tokens = expression.toCharArray();
        
         // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
            {
                continue;
            }
            
            // Current token is a number, push it to stack for numbers
            if ((tokens[i] >= '0' && tokens[i] <= '9') || (tokens[i] == '.'))
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9')||  (tokens[i] == '.')))
                {
                    sbuf.append(tokens[i++]);
                }
                values.push(Double.parseDouble(sbuf.toString()));
                i--;
            
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp2(ops, values));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/' ||
                     tokens[i] == 's' || tokens[i] == 'S' ||
                     tokens[i] == 'c' || tokens[i] == 'C' ||
                     tokens[i] == 't' || tokens[i] == 'T' ||
                     tokens[i] == 'n'|| tokens[i] == 'd' ||
                     tokens[i] == 'e' || tokens[i] == 'f' ||
                     tokens[i] == 'g' || tokens[i] == 'h' ||
                     tokens[i] == 'i' || tokens[i] == 'j' ||
                     tokens[i] == 'k' || tokens[i] == 'l' ||
                     tokens[i] == 'm' )
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                {
                  values.push(applyOp2(ops,values));
                } 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty()) {
            values.push(applyOp2(ops, values));
        }
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == 's' || op1 == 'c' || op1 == 't' ||
    		op1 == 'S' || op1 == 'C' || op1 == 'T' || op1 == 'n') &&
    		(op2 == '*' || op2 == '/' || op2 == '+' || op2 == '-'))
        	return false;
        if ((op1 == 'd' || op1 == 'e' || op1 == 'f' ||
    		op1 == 'g' || op1 == 'h' || op1 == 'i' ||
    		op1 == 'j' || op1 == 'k' || op1 == 'l' || 
    		op1 == 'm') && (op2 == '*' || op2 == '/' || op2 == '+' || op2 == '-'))
        	return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
        		return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    
    // Given the operator stack and operand stack, pops the top of the operator stack 
    //Pops required number of operands and returns a value
    public static double applyOp2(Stack<Character> ops, Stack<Double> values)
    {
    	char op=ops.pop();
    	
        switch (op)
        {
        case '+':
            return values.pop() + values.pop();
        case '-':
        	double x = values.pop();
        	double y = values.pop();
            return y - x;
        case '*':
            return values.pop() * values.pop();
        case '/':
        	double b = values.pop();
        	double a = values.pop();
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        case 's':
        	return Math.sin(values.pop());
        case 'c':
        	return Math.cos(values.pop());
        case 't':
        	return Math.tan(values.pop());
        case 'S':
        	return Math.asin(values.pop());
        case 'C':
        	return Math.acos(values.pop());
        case 'T':
        	return Math.atan(values.pop());
        case 'n':
        	return (-1 * values.pop());
        case 'd':
        	return Math.pow(values.pop(), 2);
        case 'e':
        	return Math.pow(values.pop(), 3);
        case 'f':
        	double c = values.pop();
        	double d = values.pop();
        	return Math.pow(d, c);
        case 'g':
        	return Math.sqrt(values.pop());
        case 'h':
        	return Math.cbrt(values.pop());
        case 'i':
        	return 1/(values.pop());
        case 'j':
        	return Math.pow(10,values.pop());
        case 'k':
        	return Math.log10(values.pop());
        case 'l':
        	return (Math.log(values.pop())) / (Math.log(2));
        case 'm':
        	double e = values.pop();
        	double f = values.pop();
        	return (f * Math.pow(10,e));
        	
        	
        }
        return 0;
    }
}