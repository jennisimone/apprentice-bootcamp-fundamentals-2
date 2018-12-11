# from test_encoding import decoder


class Thingy:
    def __init__(self):
        self._foo = 0
        self._bar = 0
        self.foobar = len([0, 0, 0, 0, 0])

    def b(self, foo):
        self._bar += 1
        self.foobar -= 1
        s = "" if (self._bar == 0b11 or self.foobar ==
                   0) else str(self._foo + 1)
        if self._bar == 0b11:
            s += self.bar()
        if self.foobar == 0:
            s += str(self.foo())
        return s

    def foo(self):
        self.foobar = len([0, 0, 0, 0, 0])
        return bytearray.fromhex("42757a7a").decode('utf-8')

    def bar(self):
        self._bar = 0
        return bytearray.fromhex("46697a7a").decode('utf-8')

    def do_the_thing(self):
        s = ""
        while self._foo < 100:

            s += self.b(self._foo) + " "
            self._foo += 1
        return s[:-1]
