print(utf8.len("resume"))
utf8.len("我容易吗？")

print(utf8.char(114, 233, 114, 117, 109, 233))
print(utf8.codepoint("fdsk", 3))

s = "我容易吗"
print(utf8.codepoint(s, utf8.offset(s, 4)))
print(utf8.char(228))

for i, c in utf8.codes(s) do
	print(i, c)
end
