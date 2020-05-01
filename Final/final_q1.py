import re
from errors import error
from ply.lex import lex

t_ignore = ' \t\r'

def t_FLOAT(t):
    r'\d+[eE][-+]?\d+|(\.\d+|\d+\.\d+)([eE][-+]?\d+)?'
    t.value = float(t.value)
    return t


def t_INTEGER(t):
    r'(\d+|0[Xx]\d+)'
    # Conversion to a Python int
    if t.value.startswith(('0x','0X')):
        t.value = int(t.value,16)              
    elif t.value.startswith('0'):
        t.value = int(t.value,8)
    else:
        t.value = int(t.value)
    return t

def _replace_escape_codes(t):

    literals = {
        r"\\n": "\n",
        r"\\r": "\r",
        r"\\t": "\t",
        r"\\\\": r"\\",
        r'\\"': r'"'
    }

    re_byte = r".*\\b(?P<val>[0-9a-fA-F]{2}).*"
    byte_pat = re.compile(re_byte)

    for pattern, repl in literals.items():
        t.value = re.sub(pattern, repl, t.value)

    matcher = byte_pat.match(t.value)
    if matcher:
        val = matcher.groupdict()["val"]
        val = chr(int(val, 16))
        t.value = re.sub(re_byte[2:-2], val, t.value)
    if False:
        error(t.lexer.lineno,"Bad string escape code '%s'" % escape_code)
    
def t_STRING(t):
    r'\".*?\"'
    t.value = t.value[1:-1]
    _replace_escape_codes(t)
    return t

keywords = {"var", "const", "print", "if", "else", "while", "func", "return"}
def t_ID(t):
    r'[_A-Za-z][_A-Za-z0-9]*'
    if t.value in keywords:
        t.type = t.value.upper()
    return t

def t_newline(t):
    r'\n'
    t.lexer.lineno += len(t.value)

def t_error(t):
    error(t.lexer.lineno,"Illegal character %r" % t.value[0])
    t.lexer.skip(1)

def t_STRING_UNTERM(t):
    r'\"(\.|.)*?\n'
    error(t.lexer.lineno,"Unterminated string literal")
    t.lexer.lineno += 1
    


def make_lexer():
    return lex()

if __name__ == '__main__':
    import sys
    from errors import subscribe_errors
    
    if len(sys.argv) != 2:
        sys.stderr.write("Usage: %s filename\n" % sys.argv[0])
        raise SystemExit(1)

    
    lexer = make_lexer()
    with subscribe_errors(lambda msg: sys.stderr.write(msg+"\n")):
        lexer.input(open(sys.argv[1]).read())
        for tok in iter(lexer.token,None):
            sys.stdout.write("%s\n" % tok)