s, e = string.find("hello Lua users", "lua")
print(s, e)

function maximum(a)
	local mi = 1
	local m = a[mi]
	for i = 1, #a do
		if a[i] > m then
			mi = i
			m = a[i]
		end
	end
	return m, mi
end


print(maximum({8, 10, 23, 12, 5}), 5)
print(5, maximum({8, 10, 23, 12, 5}))


-- 强制返回一个值
print((maximum({8, 10, 23, 12, 5})))
