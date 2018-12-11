class Receipt:
    def __init__(self):
        self.text = ""
        self.total = 0
        self.number_of_a = 0
        self.number_of_b = 0

    def scanned_a(self):
        self.text += "A: 50"
        self.number_of_a += 1
        self.total += 50
        if self.number_of_a % 3 == 0:
            self.total -= 20
            self.text += " - 20 (3 for 130)"
        self.text += "\n"

    def scanned_b(self):
        self.text += "B: 30"
        self.number_of_b += 1
        self.total += 30
        if self.number_of_b % 2 == 0:
            self.total -= 15
            self.text += " - 15 (2 for 45)"
        self.text += "\n"

    def scanned_c(self):
        self.text += "C: 20\n"
        self.total += 20

    def scanned_d(self):
        self.text += "D: 15\n"
        self.total += 15

    def get_text(self):
        return '{text}Total: {total}'.format(text=self.text, total=self.total)
