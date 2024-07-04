local key = {}
local mt = {__index = function (t) return t[key] end}
function setDefault (t, d)
	t[key] = d -- 表也可以作为键，而且每一个表都是新对象，所以外部无法引用这个键
	setmetatable(t, mt)
end


function track(t)
	local proxy = {}

	-- 为代理创建元素
	local mt = {
		__index = function(_, k)
			print("*access to element " .. tostring(k))
			return t[k]
		end,

		__newindex = function(_, k, v)
			print("*update of element " .. tostring(k) ..	" to " .. tostring(v))
		end,

		__pairs = function()
			return function (_, k)
				local nextkey, nextv = next(t, k)
				if nextkey ~= nil then
					print("*traversing element " .. tostring(nextkey))
				end
				return nextkey, nextv
			end
		end,

			__len = function() return #t end
	}

	setmetatable(proxy, mt)
	return proxy
end


t = {}
t = track(t)
t[2] = "hello"
print(t[2])


function readOnly(t)
	local proxy = {}
	local mt = {
		__index = t,
		__newindex = function(t, k, v)
			error("attempt to update a read-only table", 2)
		end
	}
	setmetatable(proxy, mt)
	return proxy
end


days = readOnly{"sun", "mon", "tues", "wed", "thur", "fri", "sat"}
print(days[1])
days[2] = "noday"
