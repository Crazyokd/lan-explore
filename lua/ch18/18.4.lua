lines = {
	["fdj"] = 10,
	["dfksaf"] = 234,
	["fdkfs"] = 23,
}


a = {}
for n in pairs(lines) do a[#a + 1] = n; print(n) end
table.sort(a)
for _, n in ipairs(a) do print(n) end
