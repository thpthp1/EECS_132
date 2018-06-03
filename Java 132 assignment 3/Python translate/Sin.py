from Calculator import Calculator
from Variable import Variable
from Number import Number
from Unary import Unary
import math

class Sin(Unary):
	
	def __init__(self,operand):
		super(Unary, self, operand)
		
	def __eq__(self,other):
		if isinstance(other, Sin):
			return self.__operand == other.__operand
		return False
	
	def __str__(self):
		return "sin[" + str(self.__operand) + "]"
		
	def value(self, input = None):
		return math.sin(self.getOperand().value(input))
		
	def derive(self):
		if isinstance(self.getOperand(), Variable):
			return Cos(self.getOperand())
		else:
			return BinaryOp(Op.Mult, self.getOperand().derive(), Cos(self.getOperand()))
	
	