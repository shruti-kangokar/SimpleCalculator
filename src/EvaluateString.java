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
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
            	
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
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
                     tokens[i] == 't' || tokens[i] == 'T' )
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp2(ops,values));
 
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
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'|| 
        		op2 == 's' || op2 == 'c' || op2 == 't' ||
        		op2 == 'S' || op2 == 'C' || op2 == 'T'))
            return false;
        if(op2 == 's')
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
            return values.pop() - values.pop();
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
        }
        return 0;
    }
}