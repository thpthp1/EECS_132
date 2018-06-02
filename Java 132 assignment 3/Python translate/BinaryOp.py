from Calculator import Calculator
from Number import Number
from Op import Op

class BinaryOp(Calculator):
	
	def __init__(self, Operator, leftOp, rightOp):
		self.__leftOp = leftOp
		self.__rightOp = rightOp
		self.__Operator = Operator
	
	def getOp(self):
		return self.__Operator
		
	def getLeft(self):
		return self.__leftOp
		
	def getRight(self):
		return self.__rightOp
		
	def __str__(self):
		if isinstance(self.getRight(), BinaryOp) and isinstance(self.getLeft(), BinaryOp):
		  return "("+str(self.getLeft()) +") "+ str(self.getOp()) + " (" + str(self.getRight()) + ")"
		
		elif isinstance(self.getRight(), BinaryOp) and not isinstance(self.getLeft(), BinaryOp):
		  return "("+str(self.getLeft()) +") "+ str(self.getOp()) + " " + str(self.getRight())
		
		elif not isinstance(self.getRight(), BinaryOp) and isinstance(self.getLeft(), BinaryOp):
		  return str(self.getLeft()) +" "+ str(self.getOp()) + " (" + str(self.getRight()) + ")"
		
		else:
		  return str(self.getLeft()) +" "+ str(self.getOp()) + " " + str(self.getRight())
		  

	def value(self, input = None):
		operator = self.getOp()
		try:
			choices = { 
							Op.Plus : (self.getLeft().value(input) + self.getRight().value(input)),
							Op.Minus :(self.getLeft().value(input) - self.getRight().value(input)),
							Op.Mult : (self.getLeft().value(input) * self.getRight().value(input)),
							Op.Div : (self.getLeft().value(input) / self.getRight().value(input))
						  }
			return choices.get(operator, "No operator? How did you do it ?")
		except Exception as e:
			print(e)
			print('no values found')

	
	def __eq__(self, other):
		
		
		
						  
						  
						  
						  
						  
						  
						  