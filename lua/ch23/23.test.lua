-- 创建一个表
local a = {}
a[2] = {}

-- 记录创建表之后的内存使用量
local mem1 = collectgarbage("count")

-- 断开对表的引用
-- a = nil

-- 手动触发垃圾收集
print(collectgarbage("step", 100))

-- 记录触发垃圾收集之后的内存使用量
local mem2 = collectgarbage("count")

-- 输出内存使用量的变化
print("Memory usage decreased by " .. (mem1 - mem2) .. " KB")

