use strict;
use warnings;

my $x = "Nothing\n";

sub hello {
	$x = "Hello\n";
}

sub hello_world {
	$x = "Hello World!\n";
}
	
sub say{
	print $x;
}

sub exe1{
	print "execution 1 simply calls the say routine that prints the value of x using the say routine\n";
	say();
}

sub exe2{
	print "execution 2 calls hello routine then prints the value of x using the say routine\n";
	hello();
	say();
}

sub exe3{
	print"execution 3 calls hello_world routine then prints the value of x using the say routine\n";
	hello_world();
	say();
}

exe1();
exe2();
exe3();