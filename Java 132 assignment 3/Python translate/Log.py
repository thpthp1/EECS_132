from Calculator import Calculator
from Variable import Variable
from Number import Number
from Unary import Unary
import math

class Log(Unary):
	
	def __init__(self,operand):
		super(Unary, self, operand)
		
	def __eq__(self,other):
		if isinstance(other, Log):
			return self.__operand == other.__operand
		return False
	
	def __str__(self):
		return "Log[" + str(self.__operand) + "]"
		
	def value(self, input = None):
		return math.log(self.getOperand().value(input))
		
	def derive(self):
		if isinstance(self.getOperand(), Variable):
			return BinaryOp(Op.Div, Number(1), self.getOperand())
		else:
			return BinaryOp(Op.Div, self.getOperand().derive(), self.getOperand())