from Calculator import Calculator
from Variable import Variable
from Number import Number
from Unary import Unary
import math

class Exp(Unary):
	
	def __init__(self,operand):
		super(Unary, self, operand)
		
	def __eq__(self,other):
		if isinstance(other, Exp):
			return self.__operand == other.__operand
		return False
	
	def __str__(self):
		return "e^[" + str(self.__operand) + "]"
		
	def value(self, input = None):
		return math.exp(self.getOperand().value(input))
		
	def derive(self):
		if isinstance(self.getOperand(), Variable):
			return self
		else:
			return BinaryOp(Op.Mult, self.getOperand().derive(), self)