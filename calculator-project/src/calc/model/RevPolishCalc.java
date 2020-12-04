package calc.model;

import calc.model.visitor.Divide;
import calc.model.visitor.LeafNode;
import calc.model.visitor.Minus;
import calc.model.visitor.OperatorNode;
import calc.model.visitor.Plus;
import calc.model.visitor.SumVisitor;
import calc.model.visitor.Times;
import calc.model.visitor.TreeNode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The RevPolishCalc class is used to evaluate postfix expression strings, by implementing the 
 * Visitor design pattern to traverse a binary tree of the expression, and calculate the answer.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class RevPolishCalc implements CalcInterface {
  
  /**
   * Constructs a RevPolishCalc object. No field variables are initialised.
   */
  public RevPolishCalc() {
    
  }
  
  /**
   * This method takes an array of postfix expression tokens, and converts it into a binary tree.
   * @param tokens an array of postfix expression tokens
   * @return the root of the created binary tree
   * @throws InvalidExpressionException when the postfix expression is unbalanced
   */
  private TreeNode buildTree(String[] tokens) throws InvalidExpressionException {
    
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
    
    //used to point to the current root of the tree
    TreeNode parent;
    //used to create new LeafNodes and push them onto the TreeNode stack
    LeafNode child;
    //used for operator nodes, to pop nodes from the stack in the correct order
    TreeNode starting;
    TreeNode divisor;
    TreeNode subtracted;
    
    for (String token: tokens) {
      switch (token) {
        /*if the token is an operator, pop two LeafNodes from the stack and make them children of a 
         *new respective OperatorNode.*/
        case "+": 
          try {
            parent = new OperatorNode(Plus.getInstance(), treeNodeStack.pop(), treeNodeStack.pop());
          } catch (EmptyStackException e) {
            throw new InvalidExpressionException("Unbalanced expression.");
          }
          treeNodeStack.push(parent);
          break;
        case "-":
          try {
            subtracted = treeNodeStack.pop();
            starting = treeNodeStack.pop();
          } catch (EmptyStackException e) {
            throw new InvalidExpressionException("Unbalanced expression.");
          }
          parent = new OperatorNode(Minus.getInstance(), starting, subtracted);
          treeNodeStack.push(parent);
          break;
        case "*":
          try {
            parent = new OperatorNode(Times.getInstance(), treeNodeStack.pop(), 
                treeNodeStack.pop());
          } catch (EmptyStackException e) {
            throw new InvalidExpressionException("Unbalanced expression.");
          }
          treeNodeStack.push(parent);
          break;
        case "/":
          try {
            divisor = treeNodeStack.pop();
            starting = treeNodeStack.pop();
          } catch (EmptyStackException e) {
            throw new InvalidExpressionException("Unbalanced expression.");
          }
          parent = new OperatorNode(Divide.getInstance(), starting, divisor);
          treeNodeStack.push(parent);
          break;
        //otherwise, add the token value as a new LeafNode to the stack
        default:
          if (token.matches("^[0-9]+$|^[0-9]+.[0-9]+$")) {
            try {
              child = new LeafNode(Float.parseFloat(token));
            } catch (NumberFormatException e) {
              throw new InvalidExpressionException("Input value(s) are too large.");
            }
            treeNodeStack.push(child);
          } else {
            throw new InvalidExpressionException("Invalid expression.");
          }
          break;
      }
    }
    
    /*the only node left on the stack should be the root of the binary tree, if 
     *that is not true then the expression must have been unbalanced. Otherwise 
     *return the root.*/
    parent = treeNodeStack.pop();
    if (!treeNodeStack.isEmpty()) {
      throw new InvalidExpressionException("Unbalanced expression.");
    }
    return parent;
  }
  
  /**
   * Breaks an expression down into tokens, passes it to the buildTree() method, then uses a 
   * SumVisitor on the root node of the tree to get and return the answer.
   * @param expression the postfix expression string to be evaluated
   * @return the answer of the expression
   */
  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    
    //if the expression is not made up of the following characters, throw an exception
    String regex = "^[0-9\\-\\*\\+\\/\\.\\s+]+$";
    if (!expression.matches(regex)) {
      throw new InvalidExpressionException("Invalid expression.");
    }
    
    /*the expression string is broken down into an array of string tokens, using spaces as the 
     *delimiter. A SumVisitor object is created which will be used on the root node returned 
     *by buildTree()*/
    String[] expTokens = expression.split("\\s+");
    SumVisitor sum = new SumVisitor();
    
    TreeNode parent = buildTree(expTokens);
    parent.accept(sum);

    if (sum.getAnswer() > Float.MAX_VALUE) {
      throw new InvalidExpressionException("Answer is too large.");
    }
    
    return sum.getAnswer();
  }
}