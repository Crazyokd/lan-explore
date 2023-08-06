local debug = require "debug"
local steplimit = 1000
local memlimit = 1000

local function checkmem()
	if collectgarbage("count") > memlimit then
		error("script uses too much memory")
	end
end


local count = 0

local function step()
	checkmem()
	count = count + 1
	if count > steplimit then
		error("script uses too much CPU")
	end
end

local f = asset(loadfile(arg[1], "t", {})) -- t表示以文本模式打开

debug.sethook(step, "", 100) -- 每执行100条指令就运行钩子函数


