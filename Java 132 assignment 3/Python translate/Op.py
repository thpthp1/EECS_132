from enum import Enum

class Op(Enum):
	#self.value gives out the assigned value down here |
	Plus = '+'    #<----------------------------------|
	Mult = '*'
	Minus = '-'
	Div = '/'
	
	def __str__(self):
		if self == Op.Plus:
			return str("+")
		elif self == Op.Minus:
			return str("-")
		elif self == Op.Mult:
			return str("-")
		elif self == Op.Div:
			return str("/")
	
	def __eq__(self, other):
		if isinstance(other, Op):
			return self.value == other.value
		else: return false
		
	