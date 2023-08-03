t = {10, 20, 30}

table.insert(t, 1, 5)
table.insert(t, 40)

for i = 1, #t do
	print(t[i])
end

table.insert(t, 50)
table.remove(t)

table.move(t, 1, #t, 2)
t[1] = 0

-- table.move(t, 2, #t, 1)
-- t[#t] = nil


for i = 1, #t do
	print(t[i])
end

b = table.move(t, 1, #t, 1, {})

for i = 1, #b do
	print(b[i])
end
