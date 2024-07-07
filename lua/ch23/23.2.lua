local results = {}
setmetatable(results, {__mode = "v"})

function mem_loadstring(s)
	local res = results[s]
	if res == nil then
		res = assert(load(s))
		results[s] = res
	end
	return res
end

