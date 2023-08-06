function producer()
	while true do
		local x = io.read()
		coroutine.yield(x)	
	end
end


function consumer()
	while true do
		local x = receive()
		io.write(x, "\n")
	end
end


function receive()
	local status, value = coroutine.resume(producer)
	return value
end


producer = coroutine.create(producer)

consumer()
