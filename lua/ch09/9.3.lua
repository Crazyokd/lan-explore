function newCounter()
	local count = 0
	return function ()
		count = count + 1
		return count
	end
end

c1 = newCounter()
print(c1())
print(c1())


function F(x)
	return {
		set = function(y) x = y end,
		get = function() return x end
	}
end

o1 = F(10)
o2 = F(20)
print(o1.get(), o2.get()) -- 10 20
o2.set(100)
o1.set(300)
print(o1.get(), o2.get()) -- 300 100
