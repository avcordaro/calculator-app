package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * This is the generic interface for a binary operator that evaluates a
 * pair of integers.
 * @author Dave Cohen
 */
public interface Operator {
  float eval(float saveleft, float answer) throws InvalidExpressionException;
}
