print(table.unpack{10, 20, 30})
print(table.unpack({"s", "b", "d", "d"}, 2, 3))


function unpack_self(t, i, n)
	i = i or 1
	n = n or #t
	if i <= n then
		return t[i], unpack_self(t, i + 1, n)
	end
end


