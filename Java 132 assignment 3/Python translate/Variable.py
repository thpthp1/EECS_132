from Calculator import Calculator
from Number import Number

class Variable(Calculator):
	 
	def __init__(self):
		super()
	
	#override
	def value(self, input = None):
		if input == None:
			print("Must provide a value")
			raise Exception
		else:
			return input
	
	#override
	def derive(self):
		return Number(1)
	
	def __str__(self):
		return "x"
		
	def __eq__(self, other):
		return isinstance(self, Variable)