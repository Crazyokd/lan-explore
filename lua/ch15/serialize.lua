local fmt = {integer = "%d", float = "%a"}

function serialize(o)
	if type(o) == "number" then
		io.write(string.format(fmt[math.type(o)], o))
	elseif type(o) == "string" then
		io.write(string.format("%q", o))
	end
end


