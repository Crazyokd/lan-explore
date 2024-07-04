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

function for1()
	for i = 1, math.huge do -- 还可以指定第三个step参数，默认为1
		if (0.3*i^3 - 20*i^2 - 500 >= 0) then
			print(i)
			break
		end
	end
end

function return1()
	print("return1 first statement")
	-- return --<< SYNTAX ERROR

	do return end -- OK
	-- other statements
	print("other statements")
end

function goto1()
	local i, n = 1, 5
	while i ~= n do
		i = i + 1
		if i == 2 then goto continue end
		local var = "something"
		-- some code
		::continue::
    end
end

