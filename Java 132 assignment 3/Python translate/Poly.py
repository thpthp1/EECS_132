from BinaryOp import BinaryOp
from Op import Op
from Calculator import Calculator
from Variable import Variable
from Number import Number
from Unary import Unary
import math

class Poly(Unary):
	
	def __init(self, operand, power):
		super(Unary,self,operand)
		self.__power = float(power)
	
	def __str__(self):
		if isinstance(self.__operand, BinaryOp) or isinstance(self.__operand, Unary):
			return "(" + str(self.__operand) + ")^" + str(self.__power)
		else:
			return str(self.__operand) + "^" + str(self.__power)
			
	def getPower(self):
		return self.__power
		
	def value(self,input = None):
		try:
		    return math.pow(self.__operand.value(input), self.__power)
		except Exception as e:
			print(e)
	
	def __eq__(self,other):
		if isinstance(other, Poly):
			return other.getOperand() == self.getOperand() and self.getPower() == other.getPower()
		return False
	
	def derive(self):
		if self.getPower() == 0:
			return Number(0)
		else:
			if isinstance(self.__operand, Variable):
				return BinaryOp(Op.Mult, Number(self.__power), Poly(self.__operand, self.__power - 1))
			else:
				return BinaryOp(Op.Mult, Number(self.__power), BinaryOp(Op.Mult, self.__operand.derive(), Poly(self.__operand, self.__power -1)))
				
		
			