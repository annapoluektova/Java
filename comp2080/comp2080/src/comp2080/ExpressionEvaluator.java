// CRN: 48381 
// Natallia Isayenka 100744884
// Poluektova Anna 100786356
package comp2080;

import java.util.ArrayList;


public class ExpressionEvaluator implements IEvaluator
{
	public static enum EXPRESSIONTYPE
	{
		Prefix, Infix, Postfix
	}
	public static enum OPERATION
	{
		Subtraction, Addition, Modulus, Multiplication, Division, Power, LeftParenthesis, RightParenthesis, Equals
	}
        private static OPERATION GetOperation(int i)
	{
		switch (i)
		{
			case 0:
				return OPERATION.Subtraction;
			case 1:
				return OPERATION.Addition;
			case 2:
				return OPERATION.Modulus;
			case 3:
				return OPERATION.Multiplication;
			case 4:
				return OPERATION.Division;
			case 5:
				return OPERATION.Power;
			case 6:
				return OPERATION.LeftParenthesis;
			case 7:
				return OPERATION.RightParenthesis;
			default:
				return OPERATION.Equals;
		}
	}
	
	static String OPERATIONS = "-+%*/^()";
	
	private ExpressionNode Root;
	
	public ExpressionEvaluator(String Expression)
	{
            this.Root = this.ConstructPrefixExpressionTree(Expression);
		
	}
	
	private ExpressionNode ConstructPrefixExpressionTree(String PrefixExpression)
	{
		String[] Terms = PrefixExpression.split(" ");
		ArrayList<ExpressionNode> Nodes = new ArrayList<ExpressionNode>();
		
		//create leaf node for each expression term
		for (String Term : Terms)
		{
			if (ExpressionEvaluator.OPERATIONS.indexOf(Term) == -1)
			{
				try
				{
					//Nodes.add(new ExpressionNode(Double.valueOf(Term)));
					Nodes.add(new ExpressionNode(Double.parseDouble(Term)));
				}
				catch (NumberFormatException e)
				{
					System.err.println("Invalid operand '" + Term + "'. Reverting to zero.");
					Nodes.add(new ExpressionNode(0));
				}
			}
			else
			{
				Nodes.add(new ExpressionNode(ExpressionEvaluator.GetOperation(ExpressionEvaluator.OPERATIONS.indexOf(Term))));
			}
		}
		
		try
		{
			int Current = Nodes.size() - 3; //first possible operation position
			while (Nodes.size() > 1)
			{
				if (Nodes.get(Current).IsOperation())
				{
					//assign children and remove them from working nodes
					Nodes.get(Current).SetChildren(Nodes.remove(Current + 1), Nodes.remove(Current + 1));
					Current = Nodes.size() - 3; //reset to first possible position
				}
				else
				{
					--Current;
				}
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			System.err.println("Too many/few operations. Reverting expression to zero.");
			Nodes.clear();
			Nodes.add(new ExpressionNode(0));
		}
		catch (Exception e)
		{
			System.err.println(e);
			System.err.println("Reverting expression to zero.");
			Nodes.clear();
			Nodes.add(new ExpressionNode(0));
		}
		
		//last node, root node
		return Nodes.get(0);
	}
	
	/* (non-Javadoc)
	 * @see comp2080.Evaluator#GetInfixExpression()
	 */
	@Override
	public String GetInfixExpression()
	{
		return this.Root.GetInfixExpression();
	}
	
	/* (non-Javadoc)
	 * @see comp2080.Evaluator#GetValue()
	 */
	@Override
	public double GetValue()
	{
		return this.Root.GetValue();
	}
	
	}
