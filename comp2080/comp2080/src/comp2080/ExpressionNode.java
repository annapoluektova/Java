// CRN: 48381 
// Natallia Isayenka 100744884
// Poluektova Anna 100786356
package comp2080;

import comp2080.ExpressionEvaluator.OPERATION;

public class ExpressionNode
{
	private double Value;
	private OPERATION Operation;
	private ExpressionNode Left;
	private ExpressionNode Right;
	
	public ExpressionNode(double Value)
	{
		this.Value = Value;
		this.Operation = OPERATION.Equals;
		this.Left = null;
		this.Right = null;
	}
	public ExpressionNode(OPERATION Operation)
	{
		this(Operation, null, null);
	}
	public ExpressionNode(OPERATION Operation, ExpressionNode Left, ExpressionNode Right)
	{
		this.Value = 0;
		if (Operation == OPERATION.Equals)
		{
			System.err.println("You cannot explicitly define an Equals node.");
			System.exit(1);
			
		}
		this.Operation = Operation;
		this.Left = Left;
		this.Right = Right;
	}
	
	public void SetChildren(ExpressionNode Left, ExpressionNode Right)
	{
		this.Left = Left;
		this.Right = Right;
	}
	public double GetValue()
	{
		//determine and perform operation on children
		switch (this.Operation)
		{
			case Equals:
				break;
			case Power:
				this.Value = Math.pow(this.Left.GetValue(), this.Right.GetValue());
				break;
			case Division:
				this.Value = this.Left.GetValue() / this.Right.GetValue();
				break;
			case Multiplication:
				this.Value = this.Left.GetValue() * this.Right.GetValue();
				break;
			case Modulus:
				this.Value = (int)this.Left.GetValue() % (int)this.Right.GetValue();
				break;
			case Addition:
				this.Value = this.Left.GetValue() + this.Right.GetValue();
				break;
			case Subtraction:
				this.Value = this.Left.GetValue() - this.Right.GetValue();
				break;
			default:
				this.Value = 0;
				//error
		}
		return this.Value;
	}
	private String GetOperation()
	{
		return String.valueOf(ExpressionEvaluator.OPERATIONS.charAt(this.Operation.ordinal()));
	}
	
	public String GetInfixExpression()
	{
		if (this.Operation == OPERATION.Equals)
		{
			return String.valueOf(this.Value);
		}
		else
		{
			//fully parenthesized
			return "(" + this.Left.GetInfixExpression()  + " " + this.GetOperation() + " " + this.Right.GetInfixExpression() + ")";
		}
	}
	
	public boolean IsOperation()
	{
		//if the node is not a value and the children are not assigned then we are a stand-alone operation
		return (this.Operation != OPERATION.Equals) && (this.Left == null);
	}
	public String toString()
	{
		return (this.Operation != OPERATION.Equals) ? this.GetOperation() : String.valueOf(this.Value);
	}
}
