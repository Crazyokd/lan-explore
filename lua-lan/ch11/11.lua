counter = {}

counter["abc"] = 3
counter["dfsk"] = 3
counter["fd"] = 2


local words = {}
for w in pairs(counter) do
	words[#words + 1] = w
end

for i = 1, #words do print(words[i]) end
