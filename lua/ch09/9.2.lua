Lib = {}
function Lib.foo(x, y) return x + y end
function Lib.goo(x, y) return x - y end


local fact
fact = function(n)
	if n == 0 then return 1
	else return n * fact(n - 1)
	end
end


--[[
local function foo (params) body end
]]


