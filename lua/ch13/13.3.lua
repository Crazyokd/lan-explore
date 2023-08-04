local s = string.pack("iii", 2, -23, 432)
print(#s)
print(string.unpack("iii", s))


s = "hello\0Lua\0World\0"
local i = 1
while i <= #s do
	local res
	res, i = string.unpack("z", s, i)
	print(res)
end


s = "\xFF"
print(string.unpack("b", s))
print(string.unpack("B", s))


-- 将字符串长度打包进去
s = string.pack("s1", "hello")
for i = 1, #s do print((string.unpack("B", s, i))) end
