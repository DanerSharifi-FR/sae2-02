import unittest
def RLE(s):
    if not s:return""
    o,c="",1
    for i in range(1,len(s)):o,c=(o+str(c)+s[i-1],1)if s[i]!=s[i-1]or c==9else(o,c+1)
    return o+str(c)+s[-1]

class TestRLE(unittest.TestCase):
    def test_RLE(self):
        self.assertEqual("", RLE(""))
        self.assertEqual("1a1b1c", RLE("abc"))
        self.assertEqual("1a2b3c", RLE("abbccc"))
        self.assertEqual("3a1b2a", RLE("aaabaa"))
        self.assertEqual("1a1A1a", RLE("aAa"))
        self.assertEqual("9W4W", RLE("WWWWWWWWWWWWW"))


if __name__ == '__main__':
    unittest.main()
