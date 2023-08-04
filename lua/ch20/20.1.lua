t = {}
print(getmetatable(t))


t1 = {}
setmetatable(t, t1)
print(getmetatable(t) == t1)


print(getmetatable("hi"))
print(getmetatable("xuxu"))
print(getmetatable(10))
print(getmetatable(print))



