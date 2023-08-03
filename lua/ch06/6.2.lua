function add(...)
	local s = 0
	for _, v in ipairs{...} do
		s = s + v
	end
	return s
end

print(add(3, 4, 10, 25, 12))


function nonils (...)
	local arg = table.pack(...)
	for i = 1, arg.n do
		if args[i] == nil then return false end
	end
	return true
end


print(nonils(2, 3, nil))
print(nonils(2, 3))
print(nonils())
print(nonils(nil))


-- select
print(select(1, 'a', 'b', 'c'))
print(select("#", "a", "b", "c")) -- 3
print(select(2, 'a', 'b', 'c'))


function add2(...)
	local s = 0
	for i = 1, select("#", ...) do
		s = s + select(i, ...)
	end
	return s
end


