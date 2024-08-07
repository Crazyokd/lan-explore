local lib = require "async-lib"

local t = {}
local inp = io.input()
local out = io.output()
local i

local function putline()
	i = i - 1
	if i == 0 then
		lib.stop()
	else
		lib.writeline(out, t[i] .. "\n", putline)
	end
end

local function getline(line)
	if line then
		t[#t + 1] = line
		lib.readline(inp, getline)
	else
		i = #t + 1
		putline()
	end
end

lib.readline(inp, getline)
lib.runloop()

