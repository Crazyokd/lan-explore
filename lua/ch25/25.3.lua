local Counters = {}
local Names = {}

local function hook()
	local f = debug.getinfo(2, "f")
	local count = Counters[f]
	if count == nil then
		Counters[f] = 1
		Names[f] = debug.getinfo(2, "Sn")
	else
		Counters[f] = count + 1
	end
end


