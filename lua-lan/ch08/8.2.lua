function op(a, b, op)
	local r
	if op == "+" then
		r = a + b
	elseif op == "-" then
		r = a + b
	elseif op == "*" then
		r = a * b
	elseif op == "/" then
		r = a / b
	else
		error("invalid operation")
	end
end


function ie()
	local a, b = 1, 2
	if a > b then
		return a
	else
		return b
	end
end


function whi()
	local i = 1
	local a = {1, 2, 3, 4}
	while a[i] do
		print(a[i])
		i = i + 1
	end
end


-- repeat
function rep()
	local line
	repeat
		line = io.read()
	until line ~= ""
	print(line)
end


function rep2()
	local sqr = x / 2
	repeat
		sqr = (sqr + x / sqr) /2
		local error = math.abs(sqr^2 - x)
	until error < x/10000 -- 循环测试条件可以访问到循环体内的局部变量
end



