N = 8
isprintonce = true
isfindresult = false

function isplaceok(a, n, c)
	for i = 1, n - 1 do
		if (a[i] == c) or
			(a[i] - i == c - n) or
			(a[i] + i == c + n) then
			return false
		end
	end
	return true
end


-- 打印棋盘
function printsolution(a)
	for i = 1, N do
		for j = 1, N do
			io.write(a[i] == j and "X" or "-", " ")
		end
		io.write("\n")
	end
	io.write("\n")
end

function addqueen(a, n)
	if n > N then
		isfindresult = true
		printsolution(a)
	else
		for c = 1, N do
			if isplaceok(a, n, c) then
				a[n] = c
				addqueen(a, n + 1)
				if isprintonce and isfindresult then
					break
				end
			end
		end
	end
end

addqueen({}, 1)
