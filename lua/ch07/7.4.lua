print(os.getenv("HOME"))


local f = io.popen("ls", "r")
local dir = {}
for entry in f:lines() do
	dir[#dir + 1] = entry
end

for i = 1, #dir do print(dir[i]) end



