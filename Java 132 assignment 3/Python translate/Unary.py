from Calculator import Calculator

class Unary(Calculator):
	
	def __init__(self,operand):
		self.__operand = operand
	
	def getOperand(self):
		return self.__operand