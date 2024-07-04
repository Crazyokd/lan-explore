local function search(k, plist)
	for i = 1, #plist do
		local v = plist[i][k]
		if v then return v end
	end
end


function createClass(...)
	local c = {}
	local parents = {...}

	setmetatable(c, {__index = function(t, k)
		return search(k, parents)
	end})
	-- 相比上面这种方式性能更好
	setmetatable(c, {__index = function(t, k)
		local v = search(k, parents)
		t[k] = v -- 保存下来用于下次访问
		return v
	end})

	c.__index = c

	function c:new(o)
		o = o or {}
		setmetatable(o, c)
		return o
	end

	return c
end



Named = {}
function Named:getname()
	return self.name
end

function Named:setname(n)
	self.name = n
end


Account = {balance = 0}
function Account:new(o)
	o = o or {}
	self.__index = self
	setmetatable(o, self)
	return o
end

function Account:deposit(v)
	self.balance = self.balance + v
end

function Account:withdraw(v)
	if v > self.balance then error"insufficient funds" end
	self.balance = self.balance - v
end




-- user case
NamedAccount = createClass(Account, Named)
account = NamedAccount:new{name = "Paul"}
print(account:getname())
