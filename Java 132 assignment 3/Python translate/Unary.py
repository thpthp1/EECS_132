from Calculator import Calculator

class Unary(Calculator):
	
	def __init__(self,operand):
		self.__operand = operand
	
	def getOperand(self):
		return self.__operand
		
	def __eq__(self,other):
		if isinstance(other,Unary):
			return self.getOperand() == other.getOperand()
		return False