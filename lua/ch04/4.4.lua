-- 字符串标准库
string.rep("abc", 3)
string.reverse("A long Line!")
string.lower("A long Line!")
string.upper("A long Line!")


s = "[in brackets]"
string.sub(s, 2, -2)
string.sub(s, 1, 1)
string.sub(s, -1, -1)

print(string.char(97))
i = 99
print(string.char(i, i + 1, i + 2))

print(string.byte("abc"))
print(string.byte("abc", 2))
print(string.byte("abc", -1))

print(string.byte("abc", 1, 2))

string.format("x = %d y = %d", 10, 20)
string.format("x = %f", 200)

tag, title = "h1", "a title"
string.format("<%s>%s</%s>", tag, title, tag)

print(string.format("pi = %.4f", math.pi))


print(string.find("hello world", "wor"))
print(string.find("hello", "wod"))


string.gsub("hello world", "l", ".")
