local defaults = {}
setmetatable(defaults, {__mode = "k"})

local mt = {__index = function(t) return defaults[t] end}
function setDefault(t, d)
	defaults[t] = d
	setmetatable(t, mt)
end


local metas = {}
setmetatable(metas, {__mode = "v"})
function setDefault(t, d)
	local mt = metas[d]
	if mt == nil then
		mt = {__index = function() return d end}
		meatas[d] = mt -- 记忆
	end
	setmetatable(t, mt)
end



