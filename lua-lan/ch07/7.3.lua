function fsize(file)
	local current = file:seek()
	local size = file:seek("end")
	file:seek('set', current);
	return size
end

f = io.open("7.2.lua")
print(fsize(f))
