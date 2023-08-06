mt = {__gc = function(o) print(o[1]) end}
list = nil
for i = 1, 3 do
	list = setmetatable({i, link = list}, mt)
end
list = nil

collectgarbage()


local t = {__gc = function()
	print("finish lua program")
end}
setmetatable(t, t)
_G["*AA*"] = t



