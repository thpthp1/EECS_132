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
		if isinstance(other, BinaryOp):
			op = other.getOp()
			if op == self.getOp():
				if op == Op.Plus or op == Op.Minus:
					if self.getRight() == other.getLeft():
						return self.getLeft() == other.getRight()
					elif self.getRight() == other.getRight():
						return self.getLeft() == other.getLeft()
				
				elif op == Op.Minus or op == Op.Div:
					return self.getRight() == other.getRight() and self.getLeft() == other.getLeft()
		
		return False
		
	def derive(self):
		op = self.getOp()
		leftD = self.getLeft().derive()
		rightD = self.getRight().derive()
		left = self.getLeft()
		right = self.getRight()
		
		if op == Op.Plus or op == Op.Minus:
			return BinaryOp(op,leftD,rightD)
		if op == Op.Mult:
			return BinaryOp(Op.Plus, BinaryOp(op,leftD,right), BinaryOp(op, left, rightD))
		if op == Op.Div:
			top = BinaryOp(Op.Minus, BinaryOp(Op.Mult,leftD, right), BinaryOp(Op.Mult,left,rightD))
			bottom = Poly(right, 2)
			return BinaryOp(op,top,bottom)
		
		
		
						  
						  
						  
						  
						  
						  
						  