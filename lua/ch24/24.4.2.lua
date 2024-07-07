local lib = require "async-lib"

function run(code)
	local co = coroutine.wrap(function()
		code()
		lib.stop()
	end)
	co()
	lib.runloop()
end

function putline(stream, line)
	local co = coroutine.running()
	print("putline: ", co)
	local callback = (function() coroutine.resume(co) end)
	lib.writeline(stream, line, callback)
	coroutine.yield()
end

function getline(stream, line)
	local co = coroutine.running()
	print("getline: ", co)
	local callback = (function(l) print("read callback") coroutine.resume(co, l) end)
	lib.readline(stream, callback)
	local line = coroutine.yield()
	print("getline: ", line)
	return line
end

run(function()
	local t = {}
	local inp = io.input()
	local out = io.output()

	while true do
		local line = getline(inp)
		print("run: ", line)
		if not line then break end
		t[#t+1] = line
	end

	for i = #t, 1, -1 do
		putline(out, t[i] .. "\n")
	end
end)


--[[
程序执行流程：
1. 执行run方法
2. 执行code()函数
3. 执行getline()函数
4. 阻塞输入
5. yield返回code协程
6. 执行mainloop()，并执行read callback
7. 唤醒code协程，return line到code函数

上述流程循环进行，直到输入EOF
此时t表已经存在一定数据
1. 调用putline()函数
2. 输出t表中最后一条数据
3. 往队列中加入写出事件
4. yield返回code协程
5. 执行mainloop()，并执行write callback
6. 唤醒code协程

上述流程循环进行，直到t表中没有数据
]]
