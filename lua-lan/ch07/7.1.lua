t = io.read("a") -- 读取整个文件
t = string.gsub(t, "bad", "good")
io.write(t)
