from Calculator import Calculator

class Number(Calculator): 
	
	#note that the double underscore means dont access this (name mangling)
	#override
	def __init__(self, value):
		self.__value = value

	#override
	def value(self, input = None):
		return self.__value
		
	#override
	def derive(self):
		return Number(0)

	def __str__(self):
		return str(self.value())
	
	def __eq__(self, other):
		if isinstance(other, Number):
			return self.value() == other.value()
		return False
	
	