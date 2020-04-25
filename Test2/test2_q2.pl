$x = 1;

sub fun1 {
    return $x;
}

sub static {
    my $x = 2;
    return fun1();
}



$y = 3;

sub fun2 {
    return $y;
}

sub dynamic {
    local $y = 4;
    return fun2();
}

# prints 1 (static scope uses model from the global frame)
print "Static: ", static(), "\n";

# prints 4 (dynamic scope uses model from the caller's frame)
print "Dynamic: ", dynamic(), "\n";