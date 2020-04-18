def main():
	x = 5;
	print(x);

	def sub1():
		y = x + 10;
		print(y);

		def sub2():
			z = (y+x) * 2;
			print(z);

			def sub3():
				sum = x + y + z;
				print(' x = '+ str(x) + '\n y = ' + str(y) +
				            '\n z = '+ str(z) +  '\n sum = ' + str(sum));
			sub3()

		sub2()

	sub1()

main()