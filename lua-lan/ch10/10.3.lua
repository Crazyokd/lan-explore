pair = "name = Anna"
key, value = string.match(pair, "(%a+)%s*=%s*(%a+)")
print(key, value)


print((string.gsub("hello Lua!", "%a", "%0-%0")))
print((string.gsub("hello Lua", "(.)(.)", "%2%1")))

