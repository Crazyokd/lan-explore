local print, sin = print, math.sin

a = 13
local a = 12
print(a)
print(_ENV.a)

print(_G.a)


_ENV = nil
print(13)
print(sin(13))
print(math.cos(13)) -- error

