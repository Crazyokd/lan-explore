function traceback()
	for level = 1, math.huge do 
		local info = debug.getinfo(level, "Sl")
		if not info then break end
		if info.what == "C" then
			print(string.format("%d\tC function", level))
		else
			print(string.format("%d\t[%s]:%d", level, info.short_src, info.currentline))
		end
	end
end


traceback()


function foo(a, b)
	local x 
	do local c = a - b end
	local a = 1
	while true do
		local name, value = debug.getlocal(1, a)
		if not name then break end
		print(name, value)
		a = a + 1
	end
end

foo(10, 20)

print(debug.traceback())

function getvarvalue(name, level, isenv)
	local value
	local found = false
	level = (level or 1) + 1

	-- 尝试局部变量
	for i = 1, math.huge do
		-- level至少为2，1为getvarvalue函数
		local n, v = debug.getlocal(level, i)
		if not n then break end
		if n == name then
			value = v
			found = true
		end
	end
	if found then return "local", value end

	-- 尝试非局部变量
	local func = debug.getinfo(level, "f").func
	for i = 1, math.huge do
		local n, v = debug.getupvalue(func, i)
		if not n then break end
		if n == name then return "upvalue", v end
	end

	if isenv then return "noenv" end

	local _, env = getvarvalue("_ENV", level, true)
	if env then
		return "global", env[name]
	else
		return "noenv"
	end
end

local a = 4; print(getvarvalue("a"))
a = "xx", print(getvarvalue("a"))
