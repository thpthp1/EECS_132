from Calculator import Calculator
from Variable import Variable
from Number import Number
from Unary import Unary
import math

class Cos(Unary):
	
	def __init__(self,operand):
		super(Unary, self, operand)
		
	def __eq__(self,other):
		if isinstance(other, Cos):
			return self.__operand == other.__operand
		return False
	
	def __str__(self):
		return "cos[" + str(self.__operand) + "]"
		
	def value(self, input = None):
		return math.cos(self.getOperand().value(input))
		
	def derive(self):
		if isinstance(self.getOperand(), Variable):
			return BinaryOp(Op.Mult, Number(-1), Sin(self.getOperand()))
		else:
			return BinaryOp(Op.Mult, BinaryOp(Op.Mult, Number(-1), self.getOperand().derive()), Cos(self.getOperand()))
	
	